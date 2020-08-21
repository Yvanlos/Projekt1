package view;

import controller.VirtualKanbanController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.*;

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class KanBanViewController extends BorderPane {

    @FXML
    private Label projectNameLabel;

    @FXML
    private Button infoButton;

    @FXML
    private Button addTaskButton;

    @FXML
    private Button archiveButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button returnButton;

    @FXML
    private VBox newStageBox;

    @FXML
    private VBox finishedStageBox;

    @FXML
    private VBox analysisInProgressBox;

    @FXML
    private VBox implementationInProgressBox;

    @FXML
    private VBox testInProgressBox;

    @FXML
    private VBox analysisFinishedBox;

    @FXML
    private VBox implementationFinishedBox;

    @FXML
    private VBox testFinishedBox;

    @FXML
    private HBox unassignedList;

    @FXML
    private StackPane stackPane;

    private Project project;

    private VirtualKanbanController virtualKanbanController;

    private ReadCommentController readCommentController;

    private NewCommentController newCommentController;

    private NewTaskViewController newTaskViewController;

    private ControlQuestionViewController controlQuestionViewController;

    private ProjectInfoViewController projectInfoViewController;

    public KanBanViewController(StackPane stackPane, VirtualKanbanController virtualKanbanController, Project project) {
        this.stackPane = stackPane;
        this.virtualKanbanController = virtualKanbanController;
        this.project = project;

        //Load view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/KanbanView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Generate the ViewController
        newTaskViewController = new NewTaskViewController(virtualKanbanController, this);
        //controlQuestionViewController = new ControlQuestionViewController(virtualKanbanController);
        projectInfoViewController = new ProjectInfoViewController(virtualKanbanController, project);
    }

    /**
     *
     */
    @FXML
    void initialize() {
        //Binding
        this.minWidthProperty().bind(stackPane.widthProperty());
        this.minHeightProperty().bind(stackPane.heightProperty());

        //Show project name
        projectNameLabel.setText(project.getName());

        //Getting the first stageList
        StageList stageList = null;
        for (StageList list : project.getStageList()) {
            if (list.getStage() == Stage.NEW) {
                stageList = list;
            }
        }

        //Adds all tasks in a stageList in the specific Box, starting from new
        addTasksToStageBox(newStageBox, stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(analysisInProgressBox, stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(analysisFinishedBox, stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(implementationInProgressBox, stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(implementationFinishedBox, stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(testInProgressBox, stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(testFinishedBox, stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(finishedStageBox, stageList);

        //Adds all unassigned developers to the unassigned List
        //TODO: use something else than a label
        project.getTeam().getDevelopers().forEach(developer -> {
            if (!developer.isAtWork()) {
                Label label = new Label(developer.getName());
                unassignedList.getChildren().add(label);
            }
        });
    }


    /**
     * Adds all tasks in the given stageList to the given VBox
     *
     * @param box       the VBox the tasks should be added to
     * @param stageList the stageList that holds the to be added tasks
     */
    public void addTasksToStageBox(VBox box, StageList stageList) {
        stageList.getTask().forEach(task -> {
            //A MenuButton with 6 MenuItems for managing tasks is added for each task in this stage
            MenuButton menuButton = new MenuButton();
            if(task.getDeveloper() != null) {
                menuButton.setText(task.getName() + "\n" + task.getDescription() + "\nDeadline: " + task.getDeadline().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "\nEntwickler: " + task.getDeveloper().getName());
            }else{
                menuButton.setText(task.getName() + "\n" + task.getDescription() + "\nDeadline: " + task.getDeadline().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "\nEntwickler: nicht zugewiesen");
            }
            menuButton.getItems().add(new MenuItem("Aufgabe anfangen"));
            menuButton.getItems().add(new MenuItem("Aufgabe abbrechen"));
            menuButton.getItems().add(new MenuItem("Aufgabe beenden"));
            menuButton.getItems().add(new MenuItem("Aufgabe l\u00f6schen"));
            menuButton.getItems().add(new MenuItem("Kommentare anzeigen"));
            menuButton.getItems().add(new MenuItem("Kommentar hinzuf\u00fcgen"));
            //TODO refresh if task is moved

            //If the task is worked on, the button for starting a task is disabled but finishing and droping a task can be chosen
            if (stageList.getStage() == Stage.ANALYSE_IN_PROGRESS || stageList.getStage() == Stage.IMPLEMENTATION_IN_PROGRESS || stageList.getStage() == Stage.TEST_IN_PROGRESS) {
                menuButton.getItems().get(0).setDisable(true);
                menuButton.getItems().get(1).setOnAction(event -> {
                    virtualKanbanController.getTaskController().dropTask(task, project);
                });
                menuButton.getItems().get(2).setOnAction(event -> {
                    virtualKanbanController.getTaskController().finishTask(task, project);
                });
            }
            //If the task is not currently worked on, the buttons for finishing and droping are disabled but start task can be chosen
            else {
                menuButton.getItems().get(0).setOnAction(event -> {
                    //Get a ComboBox with all developers
                    ArrayList<Developer> devList = project.getTeam().getDevelopers();
                    //TODO Filter all assigned developer
                    ObservableList<Developer> observableDevList = FXCollections.observableArrayList(devList);

                    ComboBox<Developer> comboBox = new ComboBox<Developer>(observableDevList);
                    comboBox.setPromptText("Bitte Entwickler auswählen");
                    box.getChildren().add(comboBox);
                    //TODO Choose developer
                    //comboBox.on

                    virtualKanbanController.getTaskController().startTask(task, project, new Developer("TestDev", null));
                    box.getChildren().remove(comboBox);
                });
                menuButton.getItems().get(1).setDisable(true);
                menuButton.getItems().get(2).setDisable(true);
                //If the task is completed, all buttons for actions are disabled
                if (stageList.getStage() == Stage.COMPLETED) {
                    menuButton.getItems().get(0).setDisable(true);
                }
            }
            //If deleteComment is chosen...
            menuButton.getItems().get(3).setOnAction(event -> {
                controlQuestionViewController = new ControlQuestionViewController(virtualKanbanController, "deleteTaskButton", project, task);
                controlQuestionViewController.showView();

                //TODO ControlQuestion
            });
            //If readComment is chosen all other comment windows are closed and the readCommentView is shown
            menuButton.getItems().get(4).setOnAction(event -> {
                if (readCommentController != null) {
                    readCommentController.closeView();
                }
                if (newCommentController != null) {
                    newCommentController.closeView();
                }
                readCommentController = new ReadCommentController(virtualKanbanController, task);
                readCommentController.showView();
            });
            //If newComment is chosen all other comment windows are closed and the newCommentView is shown
            menuButton.getItems().get(5).setOnAction(event -> {
                if (newCommentController != null) {
                    newCommentController.closeView();
                }
                if (readCommentController != null) {
                    readCommentController.closeView();
                }
                newCommentController = new NewCommentController(virtualKanbanController, task);
                newCommentController.showView();
            });
            //the menuButton is added to the VBox
            box.getChildren().add(menuButton);
        });
    }

    /**
     * Opens the newTask window
     *
     * @param event the MouseEvent triggered when clicked
     */
    @FXML
    void onAddTaskButtonMouseClick(MouseEvent event) {
        newTaskViewController.showView();
    }

    /**
     * Opens the ControlQuestion window
     *
     * @param event the MouseEvent triggered when clicked
     */
    @FXML
    void onArchiveButtonMouseClick(MouseEvent event) {
        controlQuestionViewController = new ControlQuestionViewController(virtualKanbanController, "archiveButton", project, null);
        controlQuestionViewController.showView();
    }

    /**
     * Opens the Info Window
     *
     * @param event the MouseEvent triggered when clicked
     * @throws UnsupportedOperationException Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist.
     */
    @FXML
    void onInfoButtonMouseClick(MouseEvent event) {
        projectInfoViewController.showView();
    }

    @FXML
    void onDeleteButtonClicked(MouseEvent event) {
        controlQuestionViewController = new ControlQuestionViewController(virtualKanbanController, "deleteProjectButton", project, null);
        controlQuestionViewController.showView();
    }

    /**
     * Closes the KanbanView and returns to the MainView
     *
     * @param event the MouseEvent triggered when clicked
     */
    @FXML
    void returnButtonClicked(MouseEvent event) {
        stackPane.getChildren().removeIf(child -> child.equals(this));
        stackPane.getChildren().get(0).setVisible(true);
    }

    public Project getProject() {
        return project;
    }
}
