package view;

import com.sun.javafx.animation.KeyValueType;
import controller.VirtualKanbanController;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
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


    public KanBanViewController(StackPane stackPane, VirtualKanbanController virtualKanbanController, Project project) {
        this.stackPane = stackPane;
        this.virtualKanbanController = virtualKanbanController;
        this.project = project;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/KanbanView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        this.minWidthProperty().bind(stackPane.widthProperty());
        this.minHeightProperty().bind(stackPane.heightProperty());

        Project project = virtualKanbanController.getVirtualKanban().getProject().get(0);
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
        }

        StageList stageList = null;
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.NEW){
                stageList = list;
            }
        }

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
                ReadCommentController readCommentController = new ReadCommentController(virtualKanbanController);
                readCommentController.showView();
            });
            menuButton.getItems().get(5).setOnAction(event -> {
                NewCommentController newCommentController = new NewCommentController(virtualKanbanController);
                newCommentController.showView();
            });
            box.getChildren().add(menuButton);
        });
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onAddTaskButtonMouseClick(MouseEvent event) throws UnsupportedOperationException {
        NewTaskViewController newTaskViewController = new NewTaskViewController(virtualKanbanController);
        newTaskViewController.showView();
        //throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onArchiveButtonMouseClick(MouseEvent event) throws UnsupportedOperationException {
        ControlQuestionViewController controlQuestionViewController = new ControlQuestionViewController(virtualKanbanController);
        controlQuestionViewController.showView();
        //throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onInfoButtonMouseClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    @FXML
    void returnButtonClicked(MouseEvent event) {
        stackPane.getChildren().removeIf(child -> child.equals(this));
    }

}
