package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import application.Main;
import controller.VirtualKanbanController;
import model.Project;
import model.Team;

public class NewProjectViewController extends VBox {

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
    private ComboBox<Team> teamInputField;

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

    private NameAlreadyAssignedViewController nameAlreadyAssignedViewController;

    public NewProjectViewController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewProjectView.fxml"));
        fxmlLoader.setRoot(this);
    	fxmlLoader.setController(this);
    	//Parent root = new BorderPane();
    	try {
    	    //root =
                    fxmlLoader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}

    	// init Scene and Stage
    	Scene scene = new Scene(this);
    	scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    	stage = new Stage();
    	//stage.initModality(Modality.APPLICATION_MODAL); // Blockiert alle anderen Fenster im Hintergrund.
    	stage.setScene(scene);

    	//Generate the ViewController
        nameAlreadyAssignedViewController = new NameAlreadyAssignedViewController(virtualKanbanController);


    	//TODO alignment of the textarea
        //TODO combobox link with team:

        //Testteam
        //virtualKanbanController.getVirtualKanban().addTeam(new Team("testTeam"));

        teamInputField.setPromptText("Bitte ein Team auswaehlen");
        ArrayList<Team> teamList = virtualKanbanController.getTeamController().getTeamsList();
        ObservableList<Team> observableTeamList = FXCollections.observableArrayList(teamList);
        teamInputField.setItems(observableTeamList);
        //cellFactory?
	}

    /**
 	 *
 	 * Closes this window.
 	 * @param event the mouse event
 	 */
    @FXML
    void onCancelButtonClick(MouseEvent event) {
        //Clears all InputFields, if opened
        nameInputField.setText("");
        descriptionInputField.setText("");
        deadlineInputField.getEditor().clear();

        closeView();
    }

    /**
 	 *
 	 * TODO: create JavaDoc.
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist.
 	 */
    @FXML
    void onConfirmButtonClick(MouseEvent event) throws UnsupportedOperationException {
        if(nameInputField.getText()==""){
            //TODO
        }
        try{
            //TODO teamInputField.getValue()
            LocalDateTime deadline = null;
            if(deadlineInputField.getValue() != null){
                deadline= deadlineInputField.getValue().atStartOfDay();
            }
            virtualKanbanController.getProjectController().createProject(nameInputField.getText(), deadline , teamInputField.getValue(),descriptionInputField.getText());
            closeView();
        }
        catch(IllegalArgumentException e){
            //showView NameAlreadyExists
            nameAlreadyAssignedViewController.showView();
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
