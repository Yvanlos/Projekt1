package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.lang.UnsupportedOperationException;

import application.Main;
import controller.VirtualKanbanController;

public class TeamsViewController {

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
    private NewTeamsViewController newTeamsViewController;
    
    public TeamsViewController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TeamsView.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = new BorderPane();
    	try {
    	    root = fxmlLoader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}

    	// TODO hier kann die View weiter initialisiert werden (aequivalent zu initialize-Methode bei Komponenten)
    	newTeamsViewController = new NewTeamsViewController(virtualKanbanController);
    	

    	// init Scene and Stage
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    	stage = new Stage();
    	//stage.initModality(Modality.APPLICATION_MODAL); // Blockiert alle anderen Fenster im Hintergrund.
    	stage.setScene(scene);
	}

    /**
 	 *
 	 * Shows the NewTeamsView when the button addTeam is clicked.
 	 * @param event
 	 */
    @FXML
    void onAddTeamButtonClick(MouseEvent event){
        newTeamsViewController.showView();
    }
    
    /**
     * Hides this Window
     * @param event
     */
    @FXML
    void onExitButtonClicked(MouseEvent event) {
    	stage.hide();
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
