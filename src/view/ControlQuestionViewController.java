package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Project;
import model.Task;

import java.awt.*;
import java.lang.UnsupportedOperationException;

public class ControlQuestionViewController extends VBox {

    /**
 	 * 
 	 */
    @FXML
    private Button continueButton;

    /**
 	 * 
 	 */
    @FXML
    private Button cancelButton;

    /**
     *
     */
    private VirtualKanbanController virtualKanbanController;

    /**
     *
     */
    private Stage stage;

    private String event;

    private Project project;

    private Task task;

    /**
     *
     * @param virtualKanbanController
     */
    public ControlQuestionViewController(VirtualKanbanController virtualKanbanController, String event, Project project, Task task){
        this.virtualKanbanController = virtualKanbanController;
        this.event = event;
        this.project = project;
        this.task = task;

        //Load view
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ControlQuestionView.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //init Scene and Stage
        Scene scene = new Scene(this);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // Blocks all windows in the background
        stage.setScene(scene);
        cancelButton.requestFocus();
    }


    /**
 	 * Cancels the action
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onCancelButtonEvent(MouseEvent event){
        closeView();
    }

    /**
 	 * Continues the action
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onContinueButtonEvent(MouseEvent event){
        //TODO when refreshing is working, test if it works
        if(this.event.equals("archiveButton")){
            //System.out.println("Archivieren");
            virtualKanbanController.getProjectController().archiveProject(project);
            closeView();
        }
        if(this.event.equals("deleteProjectButton")){
            //System.out.println("Löschen");
            virtualKanbanController.getProjectController().deleteProject(project);
            closeView();
        }
        if(this.event.equals("deleteTaskButton")){
            virtualKanbanController.getTaskController().deleteTask(project, task);
            closeView();
        }
    }

    /**
     *
     */
    public void showView() {
        stage.show();
    }

    /**
     *
     */
    public void closeView() {
        stage.hide();
    }
}
