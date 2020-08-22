package view;

import javafx.scene.image.Image;
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
    private Button cancelButton;

    /**
 	 * 
 	 */
    @FXML
    private Button confirmButton;
    
    
    /**
     * The VirtualKanbanController object.
     */
    private VirtualKanbanController virtualKanbanController;
    
    /**
     * The Stage object that represents this view.
     */
    private Stage stage;

	/**
	 *
	 */
	private TeamsViewController teamsViewController;

	public NewTeamsViewController(VirtualKanbanController virtualKanbanController, TeamsViewController teamsViewController) {
    	this.virtualKanbanController = virtualKanbanController;
    	this.teamsViewController = teamsViewController;
    	
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
    	stage.setTitle("Neues Team anlegen");
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("ressources/team.png")));
	}

    /**
 	 * Handles a MouseClick on the cancelButton
	 * Closes the view and clears the input field
 	 *
 	 * @param event the cause of the method-call
 	 */
    @FXML
    void onCancelButtonEvent(MouseEvent event){
    	closeView();
    	nameInputField.clear();
		nameInputField.setPromptText("");
    }

    /**
	 * Handles a MouseClick on the confirmButton
	 * creates a team, closes the view and clears the input field
 	 *
 	 * @param event the cause of the method-call
 	 */
    @FXML
    void onConfirmButtonEvent(MouseEvent event){
		String name = nameInputField.getText();
		if(name.equals(""))
		{
			nameInputField.setPromptText("Bitte geben Sie einen Namen ein");
		} else {
			virtualKanbanController.getTeamController().createTeam(name);
			nameInputField.setPromptText("");
			nameInputField.clear();
			closeView();
			teamsViewController.refreshTeamList();
		}
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
