package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Developer;
import model.Team;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TeamControlQuestionViewController extends VBox {

    @FXML
    private Text teamName;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private final VirtualKanbanController virtualKanbanController;

    private final TeamsViewController teamsViewController;

    private final Team team;

    private final Stage stage;

    public TeamControlQuestionViewController(VirtualKanbanController virtualKanbanController, TeamsViewController teamsViewController, Team team){
        this.virtualKanbanController = virtualKanbanController;
        this.teamsViewController = teamsViewController;
        this.team = team;

        //Load view
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TeamControlQuestionView.fxml"));
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
        teamName = new Text(team.getName());
    }

    @FXML
    void initialize() {
        //Display name of the developer
        teamName.setText(team.getName());
    }

    @FXML
    void onCancelButtonClicked(MouseEvent event) {
        closeView();
    }

    @FXML
    void onOkButtonClicked(MouseEvent event) {
        virtualKanbanController.getTeamController().deleteTeam(team);
        teamsViewController.refreshTeamList();
        for(Team t : virtualKanbanController.getVirtualKanban().getTeam()) {
            if(t.equals(team)) {
                for(Developer d : t.getDevelopers()) {
                    virtualKanbanController.getDeveloperController().deleteDeveloper(d);
                }
            }
        }
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
