package view;
import javafx.scene.input.MouseEvent;
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
    void onCancelButtonEvent(MouseEvent event) {

    }

    @FXML
    void onConfirmButtonEvent(MouseEvent event) {

    }
}
