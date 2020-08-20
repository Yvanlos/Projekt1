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

    /**
 	 * 
 	 */
    @FXML
    private Button infoButton;

    /**
 	 * 
 	 */
    @FXML
    private Button addTaskButton;

    /**
 	 * 
 	 */
    @FXML
    private Button archiveButton;

    @FXML
    private Button returnButton;


    /**
 	 * 
 	 */
    @FXML
    private ScrollPane newTaskPane;

    @FXML
    private VBox newStageBox;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane taskFinishedPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane analysisProcessPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane implementationProcessPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane testProcessPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane analysisFinishedPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane implementationFinishedPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane testFinishedPane;

    /**
 	 * 
 	 */
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

        project.getStageList().forEach(stageList -> {
            stageList.getTask().forEach(task -> {
                MenuButton menuButton = new MenuButton();
                menuButton.setText("Hier sollte Taskname stehen");
                menuButton.getItems().add(new MenuItem("Aufgabe anfangen"));
                menuButton.getItems().add(new MenuItem("Aufgabe zurücklegen"));
                menuButton.getItems().add(new MenuItem("Aufgabe beenden"));
                menuButton.getItems().add(new MenuItem("Aufgabe bearbeiten?"));
                menuButton.getItems().add(new MenuItem("Kommentare anzeigen"));
                menuButton.getItems().add(new MenuItem("Kommentar hinzufügen"));
                //menuButton.getItems().get(0).setOnAction(event -> );
                //menuButton.getItems().get(1).setOnAction(event -> );
                //menuButton.getItems().get(2).setOnAction(event -> );
                //menuButton.getItems().get(3).setOnAction(event -> );
                //menuButton.getItems().get(4).setOnAction(event -> );
                menuButton.getItems().get(5).setOnAction(event -> {
                    NewCommentController newCommentController = new NewCommentController(virtualKanbanController);
                    newCommentController.showView();
                });
                newStageBox.getChildren().add(menuButton);
            });
        });




        //virtualKanbanController.getVirtualKanban().getProject().forEach(project -> {
        //    Button projectButton = new Button(project.getName());
        //    projectButton.setOnAction(evt -> {
        //        KanBanViewController kanBanViewController = new KanBanViewController(stackPane, virtualKanbanController, project);
        //        stackPane.getChildren().add(kanBanViewController);
        //    });
        //        showProjectPane.getChildren().add(projectButton);
        //});


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
        throw new UnsupportedOperationException("Not Yet Implemented!");
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
