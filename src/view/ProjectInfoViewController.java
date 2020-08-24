package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Project;

import java.time.format.DateTimeFormatter;

public class ProjectInfoViewController extends VBox {

    /**
     * Label for the name of the project
     */
    @FXML
    private Label projectNameLabel;

    /**
     * Label for the assigned team
     */
    @FXML
    private Label assignedTeamLabel = new Label();

    /**
     * Label for the creationdate of the project
     */
    @FXML
    private Label creationdateLabel;

    /**
     * Label for the deadline of the project
     */
    @FXML
    private Label deadlineLabel;

    /**
     * Label for the archived attribute of the project
     */
    @FXML
    private Label projectArchivedLabel = new Label();

    /**
     * TextArea for the description of the project
     */
    @FXML
    private TextArea projectDescriptionLabel;

    /**
     * The OKButton to close the window
     */
    @FXML
    private Button okButton;

    /**
     * The VirtualKanbanController to get access to the model
     */
    private VirtualKanbanController virtualKanbanController;

    /**
     *
     */
    private Stage stage;

    /**
     * The currently selected project
     */
    private Project project;

    /**
     * The constructor of the ProjectInfoViewController
     * @param virtualKanbanController
     */
    public ProjectInfoViewController(VirtualKanbanController virtualKanbanController, Project project){
        this.virtualKanbanController = virtualKanbanController;
        this.project = project;


        //Load view
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjectInfoView.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        projectNameLabel.setText(project.getName());
        if(project.getTeam()==null) {
            assignedTeamLabel.setText("gel\u00f6schtes Team");
            assignedTeamLabel.setFont(Font.font("Arial", FontPosture.ITALIC, 16));
        } else {
            assignedTeamLabel.setText(project.getTeam().getName());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        creationdateLabel.setText(project.getStartDate().format(formatter));
        deadlineLabel.setText(project.getDeadline().format(formatter));
        if(project.isReadOnly()) {
            projectArchivedLabel.setText("Ja");
        } else {
            projectArchivedLabel.setText("Nein");
        }
        projectDescriptionLabel.setText(project.getDescription());

        //init Scene and Stage
        Scene scene = new Scene(this);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // Blocks all windows in the background
        stage.setScene(scene);
    }

    /**
     *
     * @param event
     */
    @FXML
    void onOKButtonMouseClick(MouseEvent event) { closeView(); }

    /**
     *
     */
    public void showView() {
        stage.show();
    }

    /**
     *
     */
    public void closeView() {
        stage.hide();
    }
}
