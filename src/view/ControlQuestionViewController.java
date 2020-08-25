package view;

import application.Main;
import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Project;
import model.Task;

public class ControlQuestionViewController extends VBox {

    /**
 	 * 
 	 */
    @FXML
    private Button continueButton;

    /**
 	 * 
 	 */
    @FXML
    private Button cancelButton;

    private final VirtualKanbanController virtualKanbanController;

    private final Stage stage;

    private final String event;

    private final Project project;

    private final Task task;

    private final StackPane stackPane;

    private final KanBanViewController kanBanViewController;

    /**
     *
     */
    public ControlQuestionViewController(VirtualKanbanController virtualKanbanController, String event, Project project, Task task, StackPane stackPane, KanBanViewController kanBanViewController){
        this.virtualKanbanController = virtualKanbanController;
        this.event = event;
        this.project = project;
        this.task = task;
        this.stackPane = stackPane;
        this.kanBanViewController = kanBanViewController;

        //Load view
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ControlQuestionView.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //init Scene and Stage
        Scene scene = new Scene(this);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // Blocks all windows in the background
        stage.setTitle("Sicherheitsabfrage");
        stage.setScene(scene);
        cancelButton.requestFocus();
    }


    /**
 	 * Cancels the action
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onCancelButtonEvent(MouseEvent event){
        closeView();
    }

    /**
 	 * Continues the action
 	 * @param event the MouseEvent triggered when clicked
 	 */
    @FXML
    void onContinueButtonEvent(MouseEvent event){
        if(this.event.equals("archiveButton")){
            virtualKanbanController.getProjectController().archiveProject(project);
            closeView();
            stackPane.getChildren().remove(1);
            stackPane.getChildren().get(0).setVisible(true);
        }
        if(this.event.equals("deleteProjectButton")){
            virtualKanbanController.getProjectController().deleteProject(project);
            closeView();
            stackPane.getChildren().remove(1);
            stackPane.getChildren().get(0).setVisible(true);
        }
        if(this.event.equals("deleteTaskButton")){
            virtualKanbanController.getTaskController().deleteTask(project, task);
            closeView();
            kanBanViewController.refreshKanbanBoard();
        }
        if(this.event.equals("finishTaskButton")){
            project.moveTaskForeward(task);
            closeView();
            kanBanViewController.refreshKanbanBoard();
        }
    }

    /**
     *
     */
    public void showView() {
        stage.show();
    }

    /**
     *
     */
    public void closeView() {
        stage.hide();
    }
}
