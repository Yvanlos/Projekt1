package view;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class NewTeamsViewController {
    @FXML
    private TextField nameInputField;

    @FXML
    private TextField numberInputField;

    @FXML
    private TextField descriptionInputField;

    @FXML
    private ComboBox<?> projectInputField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button confirmButton;

    @FXML
    void onCancelButtonEvent(ActionEvent event) {

    }

    @FXML
    void onConfirmButtonEvent(ActionEvent event) {

    }
}
