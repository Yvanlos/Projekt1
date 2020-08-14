package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NewProjectViewController {

    @FXML
    private DatePicker deadlineInputField;

    @FXML
    private TextField nameInputField;

    @FXML
    private TextField descriptionInputField;

    @FXML
    private ComboBox<?> teamInputField;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    void onCancelButtonClick(MouseEvent event) {

    }

    @FXML
    void onConfirmButtonClick(MouseEvent event) {

    }

}
