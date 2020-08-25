package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import application.Main;
import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Developer;
import model.Team;

public class DeveloperControlQuestionViewController extends VBox {

	@FXML
    private Text developerName;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ImageView developerPicture;

    private final VirtualKanbanController virtualKanbanController;
    
    private final DeveloperListViewController developerListViewController;
    
    private Developer developer;

    private Stage stage;

    /**
     *
     */
    public DeveloperControlQuestionViewController(VirtualKanbanController virtualKanbanController, DeveloperListViewController developerListViewController, Developer developer){
        this.virtualKanbanController = virtualKanbanController;
        this.developerListViewController = developerListViewController;
        this.developer = developer;
        
        //Load view
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeveloperControlQuestionView.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        

        //init Scene and Stage
        Scene scene = new Scene(this);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // Blocks all windows in the background
        stage.setTitle("Sicherheitsabfrage");
        stage.setScene(scene);
        cancelButton.requestFocus();
    }

    
    @FXML
	void initialize() {
    	//Display name of the developer
		developerName.setText(developer.getName());
		
		//Load the developers profile picture
		if(developer.getPicture() != null) {
        	try {
            	File imageFile = new File(developer.getPicture());
            	InputStream imageStream = new FileInputStream(imageFile);
            	Image image = new Image(imageStream);
            	developerPicture.setImage(image);
            }
            catch(IOException e) {
            	System.out.println("Could not load picture.");
            }
    	}
	}
    
    /**
 	 * Cancels the action
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onCancelButtonClicked(MouseEvent event) {
    	closeView();
    }

    
    /**
 	 * Deletes the developer
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onOkButtonClicked(MouseEvent event) {
    	virtualKanbanController.getDeveloperController().deleteDeveloper(developer);
    	developerListViewController.refreshDeveloperList();
    	
    	closeView();
    }
    

    /**
     * Shows this view.
     */
    public void showView() {
        stage.show();
    }

    /**
     * Closes this view.
     */
    public void closeView() {
        stage.hide();
    }
}
