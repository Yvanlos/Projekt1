package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class NewDeveloperViewController {

    @FXML
    private TextField nameInputField;

    @FXML
    private ComboBox<?> developerTeamComboBox;

    @FXML
    private Button fileChooserButton;

    @FXML
    private ImageView selectedImage;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    void onCancelButtonEvent(MouseEvent event) {

    }

    @FXML
    void onFileChooserButtonEvent(MouseEvent event) {

    }

    @FXML
    void onSaveButtonEvent(MouseEvent event) {

    }

}
