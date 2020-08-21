package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.skin.SplitMenuButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.lang.UnsupportedOperationException;

public class pdfViewController extends AnchorPane {

    @FXML
    private Button exportButton;

    @FXML
    private Button cancelButton;

    /**
 	 * 
 	 */
    @FXML
    private CheckBox allTable;

    /**
 	 * 
 	 */
    @FXML
    private CheckBox oneTable;

    /**
 	 * 
 	 */
    @FXML
    private SplitMenuButtonSkin chooseTable;


    private VirtualKanbanController virtualKanbanController;

    private Stage stage;

    public pdfViewController(VirtualKanbanController virtualKanbanController){
        this.virtualKanbanController = virtualKanbanController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pdfView.fxml"));
        fxmlLoader.setController(this);
        Parent root = new BorderPane();
        fxmlLoader.setRoot(this);
        try {
            root = fxmlLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // TODO hier kann die View weiter initialisiert werden (�quivalent zu initialize-Methode bei Komponenten)

        // init Scene and Stage
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        stage = new Stage();
        //stage.initModality(Modality.APPLICATION_MODAL); // Blockiert alle anderen Fenster im Hintergrund.
        stage.setScene(scene);
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void theAllTabelEvent(ActionEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void theOneTablelEvent(ActionEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void theChooseTableEvent(ActionEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    @FXML
    void onCancelButtonClicked(MouseEvent event) {
        closeView();
    }

    @FXML
    void onExportButtonClicked(MouseEvent event) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    public void showView() {
        stage.show();
    }

    public void closeView() {
        stage.hide();
    }
}
