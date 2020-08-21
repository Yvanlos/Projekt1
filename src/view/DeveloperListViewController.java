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

    private NewDeveloperViewController newDeveloperViewController;

    /**
     *
     * @param virtualKanbanController
     */
    public DeveloperListViewController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;

    	//Load view
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeveloperListView.fxml"));
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
    	stage.setScene(scene);

    	//Generate ViewController
         newDeveloperViewController = new NewDeveloperViewController(virtualKanbanController);

	}
    
    
    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 */
    @FXML
    void onAddDeveloperButtonClicked(MouseEvent event){
        newDeveloperViewController.showView();
    }
    
    
    /**
     * Closes this window.
     * @param event
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
