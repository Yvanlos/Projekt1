package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class NewProjectViewController {

    @FXML
    private DatePicker deadlineInputField;

    @FXML
    private TextField nameInputField;

    @FXML
    private TextField teamInputField;

    @FXML
    private TextField descriptionInputField;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    void onCancelButtonEvent(ActionEvent event) {

    }

    @FXML
    void onConfirmButtonEvent(ActionEvent event) {

    }

}
