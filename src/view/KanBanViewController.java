package view;

import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.*;

import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;

public class KanBanViewController extends BorderPane {

    @FXML
    private Button infoButton;

    @FXML
    private Button addTaskButton;

    @FXML
    private Button archiveButton;

    @FXML
    private Button returnButton;

    @FXML
    private ScrollPane newTaskPane;

    @FXML
    private VBox newStageBox;

    @FXML
    private ScrollPane taskFinishedPane;

    @FXML
    private VBox finishedStageBox;

    @FXML
    private ScrollPane analysisProcessPane;

    @FXML
    private VBox analysisInProgressBox;

    @FXML
    private ScrollPane implementationProcessPane;

    @FXML
    private VBox implementationInProgressBox;

    @FXML
    private ScrollPane testProcessPane;

    @FXML
    private VBox testInProgressBox;

    @FXML
    private ScrollPane analysisFinishedPane;

    @FXML
    private VBox analysisFinishedBox;

    @FXML
    private ScrollPane implementationFinishedPane;

    @FXML
    private VBox implementationFinishedBox;

    @FXML
    private ScrollPane testFinishedPane;

    @FXML
    private VBox testFinishedBox;

    @FXML
    private HBox unassignedList;


    @FXML
    private StackPane stackPane;

    private VirtualKanbanController virtualKanbanController;

    private Project project;

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
         readCommentController = new ReadCommentController(virtualKanbanController);
         newCommentController = new NewCommentController(virtualKanbanController);
         newTaskViewController = new NewTaskViewController(virtualKanbanController);
         controlQuestionViewController = new ControlQuestionViewController(virtualKanbanController);
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

        //Example of tasks for the board
        /*Project project = virtualKanbanController.getVirtualKanban().getProject().get(0);
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.NEW){
                list.addTask(new Task("testName","testDescription",LocalDateTime.now()));
            }
        }
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.IMPLEMENTATION_FINISHED){
                list.addTask(new Task("testName1","testDescription1",LocalDateTime.now()));
            }
        }
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.COMPLETED){
                list.addTask(new Task("testName2","testDescription2",LocalDateTime.now()));
            }
        }*/

        //Getting the first stageList
        StageList stageList = null;
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.NEW){
                stageList = list;
            }
        }

        //Adds all tasks in a stageList in the specific Box, starting from new
        addTasksToStageBox(newStageBox, stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(analysisInProgressBox,stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(analysisFinishedBox,stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(implementationInProgressBox,stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(implementationFinishedBox,stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(testInProgressBox,stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(testFinishedBox,stageList);
        stageList = project.getNextStage(stageList);
        addTasksToStageBox(finishedStageBox,stageList);
    }


    /**
     * Adds all tasks in the given stageList to the given VBox
     * @param box the VBox the tasks should be added to
     * @param stageList the stageList that holds the to be added tasks
     */
    public void addTasksToStageBox(VBox box, StageList stageList){
        stageList.getTask().forEach(task -> {
            MenuButton menuButton = new MenuButton();
            menuButton.setText(task.getName()+"\n"+task.getDescription()+"\nDeadline: "+task.getDeadline());
            menuButton.getItems().add(new MenuItem("Aufgabe anfangen"));
            menuButton.getItems().add(new MenuItem("Aufgabe zuruecklegen"));
            menuButton.getItems().add(new MenuItem("Aufgabe beenden"));
            menuButton.getItems().add(new MenuItem("Aufgabe bearbeiten?"));
            menuButton.getItems().add(new MenuItem("Kommentare anzeigen"));
            menuButton.getItems().add(new MenuItem("Kommentar hinzufuegen"));
            //TODO refresh if task is moved
            //menuButton.getItems().get(0).setOnAction(event -> );
            //menuButton.getItems().get(1).setOnAction(event -> );
            //menuButton.getItems().get(2).setOnAction(event -> );
            //menuButton.getItems().get(3).setOnAction(event -> );
            menuButton.getItems().get(4).setOnAction(event -> {
                readCommentController.showView();
            });
            menuButton.getItems().get(5).setOnAction(event -> {
                newCommentController.showView();
            });
            box.getChildren().add(menuButton);
        });
    }

    /**
 	 * Opens the newTask window
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onAddTaskButtonMouseClick(MouseEvent event){
        newTaskViewController.showView();
    }

    /**
 	 * Opens the ControlQuestion window
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onArchiveButtonMouseClick(MouseEvent event){
        controlQuestionViewController.showView();
    }

    /**
 	 * Opens the Info Window
 	 * @param event the MouseEvent triggered when clicked
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onInfoButtonMouseClick(MouseEvent event) { projectInfoViewController.showView(); }

    /**
     * Closes the KanbanView and returns to the MainView
     * @param event the MouseEvent triggered when clicked
     */
    @FXML
    void returnButtonClicked(MouseEvent event) {
        stackPane.getChildren().removeIf(child -> child.equals(this));
    }

}
