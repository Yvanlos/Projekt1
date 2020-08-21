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

    private MouseEvent event;

    private Project project;

    /**
     *
     * @param virtualKanbanController
     */
    public ControlQuestionViewController(VirtualKanbanController virtualKanbanController, MouseEvent event, Project project){
        this.virtualKanbanController = virtualKanbanController;
        this.event = event;
        this.project = project;

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
        if(((Control)this.event.getSource()).getId().equals("archiveButton")){
            //System.out.println("Archivieren");
            virtualKanbanController.getProjectController().archiveProject(project);
            closeView();
        }
        if(((Control)this.event.getSource()).getId().equals("deleteButton")){
            //System.out.println("Löschen");
            virtualKanbanController.getProjectController().deleteProject(project);
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
