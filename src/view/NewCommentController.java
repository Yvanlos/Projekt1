package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Note;
import model.Task;

import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;

public class NewCommentController extends BorderPane {

    @FXML
    private TextField inputNameField;

    @FXML
    private Button okayButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextArea inputContentField;

    private VirtualKanbanController virtualKanbanController;

    private Stage stage;

    private Task task;

    public NewCommentController(VirtualKanbanController virtualKanbanController, Task task) {
        this.virtualKanbanController = virtualKanbanController;
        this.task = task;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewComment.fxml"));
        fxmlLoader.setController(this);
        Parent root = new VBox();
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
        stage.setTitle("Neuer Kommentar zu Aufgabe: " + task.getName());
        stage.setScene(scene);
    }


    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 */
    @FXML
    void OnCancelButtonClicked(MouseEvent event){
        closeView();
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 */
    @FXML
    void onOkayButtonClicked(MouseEvent event){
        virtualKanbanController.getTaskController().addNote(task, new Note(inputNameField.getText(), inputContentField.getText(), LocalDateTime.now()));
        closeView();
    }

    public void showView() {
        stage.show();
    }

    public void closeView() {
        inputNameField.setText("");
        inputContentField.setText("");

        stage.hide();
    }
}
