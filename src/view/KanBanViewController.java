package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class KanBanViewController {

    @FXML
    private Button infoButton;

    @FXML
    private Button addTaskButton;

    @FXML
    private Button archiveButton;

    @FXML
    private ScrollPane newTaskPane;

    @FXML
    private ScrollPane taskFinishedPane;

    @FXML
    private ScrollPane analysisProcessPane;

    @FXML
    private ScrollPane implementationProcessPane;

    @FXML
    private ScrollPane testProcessPane;

    @FXML
    private ScrollPane analysisFinishedPane;

    @FXML
    private ScrollPane implementationFinishedPane;

    @FXML
    private ScrollPane testFinishedPane;

    @FXML
    private HBox unassignedList;

    @FXML
    void onAddTaskButtonMouseClick(MouseEvent event) {

    }

    @FXML
    void onArchiveButtonMouseClick(MouseEvent event) {

    }

    @FXML
    void onInfoButtonMouseClick(MouseEvent event) {

    }


}
