package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    	try {
    	    fxmlLoader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}

    	// init Scene and Stage
    	Scene scene = new Scene(this);
    	scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
    	stage = new Stage();
    	stage.setScene(scene);

    	//Generate the ViewController
        nameAlreadyAssignedViewController = new NameAlreadyAssignedViewController(virtualKanbanController);

        //Link the combobox with all existing teams
        updateTeamCombobox();

        teamInputField.setCellFactory(e -> new ListCell<Team>() {
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
        teamInputField.setButtonCell(teamInputField.getCellFactory().call(null));
	}
    
    public void updateTeamCombobox() {
    	ArrayList<Team> teamList = new ArrayList<>();
    	boolean isAlreadyAssigned = false;

        for(Team team : virtualKanbanController.getVirtualKanban().getTeam()){
            for(Project project : virtualKanbanController.getVirtualKanban().getProject()){
                if(project.getTeam().equals(team) && !project.isReadOnly()){
                    isAlreadyAssigned = true;
                }
            }
            if(!isAlreadyAssigned){
                teamList.add(team);
            }
            isAlreadyAssigned = false;
        }
        ObservableList<Team> observableTeamList = FXCollections.observableArrayList(teamList);
        teamInputField.setItems(observableTeamList);
    }

    /**
 	 *
 	 * Closes this window, clears all inputFields
 	 * @param event the mouse event
 	 */
    @FXML
    void onCancelButtonClick(MouseEvent event) {
        closeView();
    }

    /**
 	 * Creates a new project, if not another project with the same name exists
 	 * @param event
 	 */
    @FXML
    void onConfirmButtonClick(MouseEvent event) {
        try{//create a new project with the given data
            if(nameInputField.getText().equals("")){
                nameInputField.setPromptText("Bitte geben Sie einen Namen ein");
                return;
            }
            if(deadlineInputField.getValue() == null){
                deadlineInputField.setPromptText("Bitte geben Sie eine Deadline ein");
                return;
            }
            if(deadlineInputField.getValue() == null){
                deadlineInputField.setPromptText("Bitte geben Sie eine Deadline ein");
                return;
            }
            if(teamInputField.getValue() == null){
                teamInputField.setPromptText("Bitte w\u00E4hlen Sie ein Team aus");
                return;
            }
            LocalDateTime deadline= deadlineInputField.getValue().atStartOfDay();
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
        //Clears all InputFields, if opened
        nameInputField.setText("");
        descriptionInputField.setText("");
        deadlineInputField.getEditor().clear();
        teamInputField.getSelectionModel().clearSelection();

        stage.hide();
    }
}
