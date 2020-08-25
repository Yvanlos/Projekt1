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

public class NameAlreadyAssignedViewController extends VBox {

    /**
 	 * 
 	 */
    @FXML
    private Button okButton;

    private VirtualKanbanController virtualKanbanController;

    private Stage stage;

    public NameAlreadyAssignedViewController(VirtualKanbanController virtualKanbanController) {
        this.virtualKanbanController = virtualKanbanController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NameAlreadyAssignedView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        Parent root = new BorderPane();
        try {
            root = fxmlLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // init Scene and Stage
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // Blocks all windows in the background
        stage.setTitle("Meldung");
        stage.setScene(scene);
    }

        /**
          *
          * TODO: create JavaDoc.
          * @param event
          * @throws UnsupportedOperationException
          *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist.
          */
    @FXML
    void onOKButtonMouseClick(MouseEvent event) throws UnsupportedOperationException {
        closeView();
        //throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    public void showView() {
        stage.show();
    }

    /**
     * Hides this View.
     */
    public void closeView() {
        stage.hide();
    }
}
