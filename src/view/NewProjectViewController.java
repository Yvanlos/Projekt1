package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.lang.UnsupportedOperationException;

import application.Main;
import controller.VirtualKanbanController;

public class NewProjectViewController {

    /**
 	 * 
 	 */
    @FXML
    private DatePicker deadlineInputField;

    /**
 	 * 
 	 */
    @FXML
    private TextField nameInputField;

    /**
 	 * 
 	 */
    @FXML
    private TextArea descriptionInputField;

    /**
 	 * 
 	 */
    @FXML
    private ComboBox<?> teamInputField;

    /**
 	 * 
 	 */
    @FXML
    private Button confirmButton;

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
    
    
    /**
     * A NewDeveloperViewController object for showing the NewDeveloperView
     */
    private NewDeveloperViewController newDeveloperViewController;

    public NewProjectViewController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewProjectView.fxml"));
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
 	 * Closes this window.
 	 * @param event the mouse event
 
 	 */
    @FXML
    void onCancelButtonClick(MouseEvent event) throws UnsupportedOperationException {
    	//TODO: Clear TextAreas, Dates and Team
    	
    	
    	
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
    void onConfirmButtonClick(MouseEvent event) throws UnsupportedOperationException {
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
