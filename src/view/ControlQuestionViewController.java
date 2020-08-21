package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    /**
     *
     * @param virtualKanbanController
     */
    public ControlQuestionViewController(VirtualKanbanController virtualKanbanController){
        this.virtualKanbanController = virtualKanbanController;

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
    }


    /**
 	 * Cancels the action
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onCancelButtonClick(MouseEvent event){
        closeView();
    }

    /**
 	 * Continues the action
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onContinueButtonClick(MouseEvent event) throws UnsupportedOperationException {
        //TODO
        throw new UnsupportedOperationException("Not Yet Implemented!");
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
