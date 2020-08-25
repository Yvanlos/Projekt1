package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Team;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;

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
    private ComboBox<Team> developerTeamComboBox;

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
    
    private URI selectedURI;
    
    /**
     * The ViratualKanbanController object.
     */
    private VirtualKanbanController virtualKanbanController;
    
    /**
     * The DeveloperListViewController object.
     */
    private DeveloperListViewController developerListViewController;
    
    /**
     * The Stage object that represents this view.
     */
    private Stage stage;

    public NewDeveloperViewController(VirtualKanbanController virtualKanbanController, DeveloperListViewController developerListViewController) {
    	this.virtualKanbanController = virtualKanbanController;
    	this.developerListViewController = developerListViewController;
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewDeveloperView.fxml"));
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
	}
    
	@FXML
	void initialize() {
		
		updateTeamCombobox();
		
		developerTeamComboBox.setCellFactory(e -> new ListCell<Team>() {
    		@Override
    		protected void updateItem(Team team, boolean empty) {
    	        super.updateItem(team, empty);
    	        
    	        if (empty || team == null) {
    	            setText(null);
    	        } 
    	        else{
    	        	setText(team.getName());
    	        }
    	    }
    	});
		developerTeamComboBox.setButtonCell(developerTeamComboBox.getCellFactory().call(null));
		
	}
	
	/**
	 * Updates the team list for the team combobox.
	 */
	public void updateTeamCombobox() {
		ArrayList<Team> teamList = virtualKanbanController.getTeamController().getTeamsList();
		ObservableList<Team> observableTeamList = FXCollections.observableArrayList(teamList);
		developerTeamComboBox.setItems(observableTeamList);
	}

    /**
 	 *
 	 * Closes this Window.
 	 * @param event the mouse event
 	 */
    @FXML
    void onCancelButtonEvent(MouseEvent event){
    	//Reset all fields
    	nameInputField.setText("");
    	selectedURI = null;
    	selectedImage.setImage(null);
    	developerTeamComboBox.setValue(null);
    	
        closeView();
    }

    /**
 	 * Opens a FileChooser to select a picture.
 	 * @param event the mouse event
 	 */
    @FXML
    void onFileChooserButtonEvent(MouseEvent event){
    	
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().add(
    			new FileChooser.ExtensionFilter("Images", "*.png",
    					"*.jpg", "*.gif", "*.tiff", "*.bmp", "*.swf", "*.svg"));
    	
    	try {
        	
        	File selectedFile = fileChooser.showOpenDialog(stage);
        	if (selectedFile != null){
        		InputStream imageStream = new FileInputStream(selectedFile);
        	
        		Image image = new Image(imageStream);
        	
        		selectedImage.setImage(image);
        	
        		selectedURI = selectedFile.toURI();
        	}
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
    	
    }

    /**
 	 * Creates a new developer based on the users input.
 	 * @param event the mouse event
 	 */
    @FXML
    void onSaveButtonEvent(MouseEvent event){
    	
    	String name = nameInputField.getText();
    	Team selectedTeam = developerTeamComboBox.getValue();
    	if(selectedTeam != null && !name.equals("")) {
	    	virtualKanbanController.getDeveloperController().createDeveloper(selectedTeam, name, selectedURI);
	    	
	    	developerListViewController.refreshDeveloperList();
	    	
	    	//Reset all fields
	    	nameInputField.setText("");
	    	selectedURI = null;
	    	selectedImage.setImage(null);
	    	developerTeamComboBox.setValue(null);
	    	
	    	closeView();
    	}
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
