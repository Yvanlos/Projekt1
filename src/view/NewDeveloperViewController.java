package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class NewDeveloperViewController {

    @FXML
    private TextField nameInputField;

    @FXML
    private ChoiceBox<?> developerTeamChoiceBox;

    @FXML
    private Button fileChooserButton;

    @FXML
    private ImageView selectedImage;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @FXML
    void onCancelButtonEvent(ActionEvent event) {

    }

    @FXML
    void onFileChooserButtonEvent(ActionEvent event) {

    }

    @FXML
    void onSaveButtonEvent(ActionEvent event) {

    }

}
