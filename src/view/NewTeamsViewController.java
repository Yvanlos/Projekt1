package view;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import java.lang.UnsupportedOperationException;

import application.Main;
import controller.VirtualKanbanController;

public class NewTeamsViewController {

    /**
 	 * 
 	 */
    @FXML
    private TextField nameInputField;

    /**
 	 * 
 	 */
    @FXML
    private TextField numberInputField;

    /**
 	 * 
 	 */
    @FXML
    private TextField descriptionInputField;

    /**
 	 * 
 	 */
    @FXML
    private ComboBox<?> projectInputField;

    /**
 	 * 
 	 */
    @FXML
    private Button cancelButton;

    /**
 	 * 
 	 */
    @FXML
    private Button confirmButton;
    
    
    /**
     * The ViratualKanbanControlle object.
     */
    private VirtualKanbanController virtualKanbanController;
    
    /**
     * The Stage object that represents this view.
     */
    private Stage stage;

    
    public NewTeamsViewController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTeamsView.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = new BorderPane();
    	try {
    	    root = fxmlLoader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}

    	// TODO hier kann die View weiter initialisiert werden (aequivalent zu initialize-Methode bei Komponenten)
    	

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
    void onCancelButtonEvent(MouseEvent event) throws UnsupportedOperationException {
        //Clear textfield
    	
    	
    	closeView();
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onConfirmButtonEvent(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
    
    /**
     * Shows this Window.
     */
    
    public void showView() {
    	stage.show();
    }
    
    /**
     * Hides this Window.
     */
    public void closeView() {
    	stage.hide();
    }
}
