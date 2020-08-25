package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Developer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;

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
    private ListView<Developer> developerListView;
    
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
    
    private DeveloperListViewController instance;
    
    
    /**
     * A NewDeveloperViewController object for showing the NewDeveloperView
     */
    private NewDeveloperViewController newDeveloperViewController;

    public DeveloperListViewController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    	this.instance = this;
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeveloperListView.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = new BorderPane();
    	try {
    	    root = fxmlLoader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}

    	newDeveloperViewController = new NewDeveloperViewController(virtualKanbanController, this);

    	// init Scene and Stage
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    	stage = new Stage();
    	//stage.initModality(Modality.APPLICATION_MODAL); // Blockiert alle anderen Fenster im Hintergrund.
    	stage.setScene(scene);

		stage.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				refreshDeveloperList();
			}
		});
	}
    
    @FXML
    void initialize() {
    	developerListView.setCellFactory(e -> new ListCell<Developer>() {
    		@Override
    		protected void updateItem(Developer developer, boolean empty) {
    	        super.updateItem(developer, empty);
    	        
    	        if (empty || developer == null) {
    	            setGraphic(null);
    	        } 
    	        else{
    	        	
    	        	ImageView imageView = new ImageView();
    	        	if(developer.getPicture() != null) {
	    	        	try {
	    	            	File imageFile = new File(developer.getPicture());
	    	            	InputStream imageStream = new FileInputStream(imageFile);
	    	            	Image image = new Image(imageStream);
	    	            	imageView.setImage(image);
	    	            }
	    	            catch(IOException e) {
	    	            	System.out.println("Could not load picture.");
	    	            }
    	        	}
    	        	
    	        	imageView.setFitHeight(40);
	            	imageView.setFitWidth(40);
    	        	
    	        	Text name = new Text(developer.getName());
    	        	name.setStyle("-fx-font: 20 arial; ");
    	        	
    	        	Button deleteButton = new Button("L\u00f6schen");
    	        	deleteButton.setPrefHeight(20);
    	        	deleteButton.setPrefWidth(80);
    	        	deleteButton.setCenterShape(true);
    	        	deleteButton.setOnMouseClicked(e -> {
    	        		//Sicherheitsabfrage
    	        		DeveloperControlQuestionViewController controlQuestionView = new DeveloperControlQuestionViewController(virtualKanbanController, instance, developer);
    	        		controlQuestionView.showView();
    	        	});
    	        	
    	        	BorderPane display = new BorderPane(name, null, deleteButton, null, imageView);
    	        	
    	            setGraphic(display);
    	        }
    	    }
    		
    		
    	}
    	);


		refreshDeveloperList();
    }
    
    /**
     * Sets the current developerList to a list of all current developers.
     */
    public void refreshDeveloperList() {
    	ArrayList<Developer> developerList = virtualKanbanController.getDeveloperController().getDeveloperList();
		ObservableList<Developer> observableDeveloperList = FXCollections.observableArrayList(developerList);
		developerListView.setItems(observableDeveloperList);
    }
    
    /**
 	 *
 	 * Shows the NewDeveloperView when the button addDeveloper is clicked.
 	 * @param event the mouse event.
 	 */
    @FXML
    void onAddDeveloperButtonClicked(MouseEvent event){
    	newDeveloperViewController.updateTeamCombobox();
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
