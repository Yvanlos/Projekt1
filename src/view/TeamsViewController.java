package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import application.Main;
import controller.VirtualKanbanController;
import model.Developer;
import model.Project;
import model.Team;

public class TeamsViewController {

    /**
 	 * 
 	 */
    @FXML
    private ListView<Team> teamListView;

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
    	newTeamsViewController = new NewTeamsViewController(virtualKanbanController, this);
    	

    	// init Scene and Stage
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    	stage = new Stage();
    	//stage.initModality(Modality.APPLICATION_MODAL); // Blockiert alle anderen Fenster im Hintergrund.
    	stage.setScene(scene);
    	stage.setTitle("Teamliste");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("ressources/team.png")));
        stage.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                refreshTeamList();
            }
        });
	}

    @FXML
    void initialize() {
        teamListView.setPlaceholder(new Label("Keine Teams vorhanden"));
        teamListView.setCellFactory(e -> new ListCell<Team>() {
            @Override
            protected void updateItem(Team team, boolean empty) {
                super.updateItem(team, empty);

                if (empty || team == null) {
                    setGraphic(null);
                } else {
                    Text name = new Text(team.getName());
                    name.setStyle("-fx-font: 20 arial; ");

                    Button deleteButton = new Button("");
                    deleteButton.setPrefHeight(20);
                    deleteButton.setPrefWidth(20);
                    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("ressources/x-mark.png")));
                    deleteButton.setGraphic(imageView);
                    deleteButton.setCenterShape(true);
                    deleteButton.setOnMouseClicked(e -> {
                        //TODO: Sicherheitsabfrage
                        //Deleting the team
                        virtualKanbanController.getTeamController().deleteTeam(team);
                        refreshTeamList();
                    });

                    Circle circle = new Circle();
                    circle.setRadius(12);
                    boolean hasProject = false;
                    for(Project project : virtualKanbanController.getVirtualKanban().getProject()) {
                        if(project.getTeam() == team) {
                            hasProject = true;
                        }
                    }

                    if(hasProject) {
                        circle.setFill(new Color(0,1,0,1));
                    } else {
                        circle.setFill(new Color(1,0,0,1));
                    }
                    BorderPane display = new BorderPane(name, null, deleteButton, null, circle);
                    setGraphic(display);
                }
            }
        });

        refreshTeamList();
    }

    /**
     * Sets the current teamList to a list of all current teams
     */
    public void refreshTeamList() {
        ArrayList<Team> teamList = virtualKanbanController.getTeamController().getTeamsList();
        ObservableList<Team> observableTeamList = FXCollections.observableArrayList(teamList);
        teamListView.setItems(observableTeamList);
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
