package view;

import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.Project;

import java.lang.UnsupportedOperationException;

public class KanBanViewController extends BorderPane {

    /**
 	 * 
 	 */
    @FXML
    private Button infoButton;

    /**
 	 * 
 	 */
    @FXML
    private Button addTaskButton;

    /**
 	 * 
 	 */
    @FXML
    private Button archiveButton;

    @FXML
    private Button returnButton;


    /**
 	 * 
 	 */
    @FXML
    private ScrollPane newTaskPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane taskFinishedPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane analysisProcessPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane implementationProcessPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane testProcessPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane analysisFinishedPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane implementationFinishedPane;

    /**
 	 * 
 	 */
    @FXML
    private ScrollPane testFinishedPane;

    /**
 	 * 
 	 */
    @FXML
    private HBox unassignedList;

    @FXML
    private StackPane stackPane;

    private VirtualKanbanController virtualKanbanController;

    private Project project;


    public KanBanViewController(StackPane stackPane, VirtualKanbanController virtualKanbanController, Project project) {
        this.stackPane = stackPane;
        this.virtualKanbanController = virtualKanbanController;
        this.project = project;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/KanbanView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
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
    void onAddTaskButtonMouseClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onArchiveButtonMouseClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onInfoButtonMouseClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    @FXML
    void returnButtonClicked(MouseEvent event) {
        stackPane.getChildren().removeIf(child -> child.equals(this));
    }

}
