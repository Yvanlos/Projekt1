package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Note;
import model.Task;

import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReadCommentController extends SplitPane {

    /**
 	 * 
 	 */
    @FXML
    private Button OkayButtonReadComment;

    @FXML
    private TextArea showCommentField;

    private VirtualKanbanController virtualKanbanController;

    private Stage stage;

    private Task task;

    public ReadCommentController(VirtualKanbanController virtualKanbanController, Task task) {
        this.virtualKanbanController = virtualKanbanController;
        this.task = task;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReadComment.fxml"));
        fxmlLoader.setController(this);
        //Parent root = new VBox();
        fxmlLoader.setRoot(this);
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
        stage.setTitle("Kommentare zu: " + task.getName());
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        showCommentField.setText("");

        //Show all notes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        if(!task.getNote().isEmpty()) {
            task.getNote().forEach(note -> {
                showCommentField.setText(showCommentField.getText() + "Betreff: " + note.getName() + "\nErstellt am: " + note.getCreationDate().format(formatter) + "\nInhalt: " + note.getContent()+"\n\n");
            });
        }
    }


    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onOkayButtonReadCommentClicked(MouseEvent event) throws UnsupportedOperationException {
        closeView();
    }

    public void showView() {
        stage.show();
    }

    public void closeView() {
        stage.hide();
    }
}
