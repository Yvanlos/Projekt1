package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class NewProjectViewController {

    @FXML
    private DatePicker deadlineInputField;

    @FXML
    private TextField nameInputField;

    @FXML
    private TextArea descriptionInputField;

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
