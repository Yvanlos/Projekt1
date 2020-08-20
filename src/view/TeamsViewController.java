package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.lang.UnsupportedOperationException;

public class TeamsViewController extends BorderPane{

    /**
 	 * 
 	 */
    @FXML
    private ListView<?> teamListView;

    /**
 	 * 
 	 */
    @FXML
    private Button addTeamButton;

    private VirtualKanbanController virtualKanbanController;

    private Stage stage;

    public TeamsViewController(VirtualKanbanController virtualKanbanController){
        this.virtualKanbanController = virtualKanbanController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TeamsView.fxml"));
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
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onAddTeamButtonClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    public void showView() {
        stage.show();
    }

    public void closeView() {
        stage.hide();
    }
}
