package view;

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
    
    
    /**
     * A NewDeveloperViewController object for showing the NewDeveloperView
     */
    private NewDeveloperViewController newDeveloperViewController;

    public DeveloperListViewController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    	
    	//Test
    	
    	virtualKanbanController.getTeamController().createTeam("Test Team");
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeveloperListView.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = new BorderPane();
    	try {
    	    root = fxmlLoader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}

    	// TODO hier kann die View weiter initialisiert werden (äquivalent zu initialize-Methode bei Komponenten)
    	newDeveloperViewController = new NewDeveloperViewController(virtualKanbanController, this);
    	

    	// init Scene and Stage
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    	stage = new Stage();
    	//stage.initModality(Modality.APPLICATION_MODAL); // Blockiert alle anderen Fenster im Hintergrund.
    	stage.setScene(scene);
    	
    	
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
    	        	
    	        	Button deleteButton = new Button("Löschen");
    	        	deleteButton.setPrefHeight(20);
    	        	deleteButton.setPrefWidth(80);
    	        	deleteButton.setCenterShape(true);
    	        	deleteButton.setOnMouseClicked(e -> {
    	        		//TODO: Sicherheitsabfrage
    	        		
    	        		
    	        		//Deleting the developer
    	        		virtualKanbanController.getDeveloperController().deleteDeveloper(developer);
    	        		refreshDeveloperList();
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
    
    
//    public void addDeveloperToListView(ListView box, StageList stageList){
//        stageList.getTask().forEach(task -> {
//            MenuButton menuButton = new MenuButton();
//            menuButton.setText(task.getName()+"\n"+task.getDescription()+"\nDeadline: "+task.getDeadline());
//            menuButton.getItems().add(new MenuItem("Aufgabe anfangen"));
//            menuButton.getItems().add(new MenuItem("Aufgabe zuruecklegen"));
//            menuButton.getItems().add(new MenuItem("Aufgabe beenden"));
//            menuButton.getItems().add(new MenuItem("Aufgabe bearbeiten?"));
//            menuButton.getItems().add(new MenuItem("Kommentare anzeigen"));
//            menuButton.getItems().add(new MenuItem("Kommentar hinzufuegen"));
//            //TODO refresh if task is moved
//            //menuButton.getItems().get(0).setOnAction(event -> );
//            //menuButton.getItems().get(1).setOnAction(event -> );
//            //menuButton.getItems().get(2).setOnAction(event -> );
//            //menuButton.getItems().get(3).setOnAction(event -> );
//            menuButton.getItems().get(4).setOnAction(event -> {
//                readCommentController.showView();
//            });
//            menuButton.getItems().get(5).setOnAction(event -> {
//                newCommentController.showView();
//            });
//            box.getChildren().add(menuButton);
//        });
//    }
    
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
