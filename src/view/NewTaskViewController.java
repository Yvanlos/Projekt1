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

import java.lang.UnsupportedOperationException;
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
     *
     * TODO: create JavaDoc.
     * @param event
     * @throws UnsupportedOperationException
     *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist.
     */
    @FXML
    void onCancelButtonEvent(MouseEvent event){
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
    void onSaveButtonEvent(MouseEvent event) throws UnsupportedOperationException {
        LocalDateTime date = null;
        if(dateInputField.getValue() != null){
            date = dateInputField.getValue().atStartOfDay();
        }
        virtualKanbanController.getTaskController().addTask(kanBanViewController.getProject(),nameInputField.getText(),descriptionInputField.getText(),date);
        System.out.println("Added Task: "+nameInputField.getText());
        closeView();
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
