package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.lang.UnsupportedOperationException;

import application.Main;
import controller.VirtualKanbanController;

public class DeveloperListViewController {

    /**
 	 * 
 	 */
    @FXML
    private Button addDeveloperButton;
    
    /**
     * 
     */
    @FXML
    private Button exitButton;
    
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

    public DeveloperListViewController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeveloperListView.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = new BorderPane();
    	try {
    	    root = fxmlLoader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}

    	// TODO hier kann die View weiter initialisiert werden (äquivalent zu initialize-Methode bei Komponenten)
    	newDeveloperViewController = new NewDeveloperViewController(virtualKanbanController);
    	

    	// init Scene and Stage
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    	stage = new Stage();
    	//stage.initModality(Modality.APPLICATION_MODAL); // Blockiert alle anderen Fenster im Hintergrund.
    	stage.setScene(scene);
	}
    
    
    /**
 	 *
 	 * Shows the NewDeveloperView when the button addDeveloper is clicked.
 	 * @param event the mouse event.
 	 */
    @FXML
    void onAddDeveloperButtonClicked(MouseEvent event){
        newDeveloperViewController.showView();
    }
    
    
    /**
     * Closes this window.
     * @param event the mouse event.
     */
    @FXML
    void onExitButtonClicked(MouseEvent event) throws UnsupportedOperationException {
    	 closeView();
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
