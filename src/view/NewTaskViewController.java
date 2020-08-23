package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class NewTaskViewController extends VBox {

    @FXML
    private TextField nameInputField;

    @FXML
    private DatePicker dateInputField;

    @FXML
    private TextArea descriptionInputField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;


    private VirtualKanbanController virtualKanbanController;

    private KanBanViewController kanBanViewController;

    private Stage stage;

    public NewTaskViewController(VirtualKanbanController virtualKanbanController, KanBanViewController kanBanViewController){
        this.virtualKanbanController = virtualKanbanController;
        this.kanBanViewController = kanBanViewController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTaskView.fxml"));
        fxmlLoader.setController(this);
        Parent root = new BorderPane();
        fxmlLoader.setRoot(this);
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

    /**
     * Cancels the adding of a new task
     * @param event
     */
    @FXML
    void onCancelButtonEvent(MouseEvent event){
        closeView();
    }

    /**
     * Adds a new task to the project
     * @param event
     */
    @FXML
    void onSaveButtonEvent(MouseEvent event){
        if(nameInputField.getText().equals("")) {
            nameInputField.setPromptText("Bitte geben Sie einen Namen ein");
        } else {
            LocalDateTime date = null;
            if (dateInputField.getValue() != null) {
                date = dateInputField.getValue().atStartOfDay();
            }
            virtualKanbanController.getTaskController().addTask(kanBanViewController.getProject(), nameInputField.getText(), descriptionInputField.getText(), date);
            closeView();
            kanBanViewController.refreshKanbanBoard();
        }
    }

    /**
     * Shows this View.
     */

    public void showView() {
        nameInputField.setText("");
        descriptionInputField.setText("");
        dateInputField.getEditor().clear();

        stage.show();
    }

    /**
     * Hides this View.
     */
    public void closeView() {
        stage.hide();
    }
}
