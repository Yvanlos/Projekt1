package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.lang.UnsupportedOperationException;

import application.Main;
import controller.VirtualKanbanController;

public class NewDeveloperViewController {

    /**
 	 * 
 	 */
    @FXML
    private TextField nameInputField;

    /**
 	 * 
 	 */
    @FXML
    private ComboBox<?> developerTeamComboBox;

    /**
 	 * 
 	 */
    @FXML
    private Button fileChooserButton;

    /**
 	 * 
 	 */
    @FXML
    private ImageView selectedImage;

    /**
 	 * 
 	 */
    @FXML
    private Button saveButton;

    /**
 	 * 
 	 */
    @FXML
    private Button cancelButton;
    
    /**
     * The ViratualKanbanControlle object.
     */
    private VirtualKanbanController virtualKanbanController;
    
    /**
     * The Stage object that represents this view.
     */
    private Stage stage;

    public NewDeveloperViewController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewDeveloperView.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = new BorderPane();
    	try {
    	    root = fxmlLoader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}

    	// TODO hier kann die View weiter initialisiert werden (äquivalent zu initialize-Methode bei Komponenten)
    	

    	// init Scene and Stage
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    	stage = new Stage();
    	//stage.initModality(Modality.APPLICATION_MODAL); // Blockiert alle anderen Fenster im Hintergrund.
    	stage.setScene(scene);
	}

    /**
 	 *
 	 * Closes this Window.
 	 * @param event the mouse event
 	 */
    @FXML
    void onCancelButtonEvent(MouseEvent event){
    	//TODO: Clear textfields, combobox and image
    	
    	
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
    void onFileChooserButtonEvent(MouseEvent event) throws UnsupportedOperationException {
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
    void onSaveButtonEvent(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
    
    /**
     * Shows this View.
     */
    
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
