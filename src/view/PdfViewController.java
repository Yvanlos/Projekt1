package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import application.Main;
import controller.VirtualKanbanController;
import model.Project;


public class PdfViewController extends BorderPane {

    @FXML
    private Button exportButton;

    @FXML
    private Button cancelButton;

    @FXML
    private RadioButton allProjectsButton;

    @FXML
    private RadioButton oneProjectButton;

    @FXML
    private ComboBox<Project> projectComboBox;

    @FXML
    private Label errorLabel;


    ToggleGroup group = new ToggleGroup();

    private Stage stage;

    private VirtualKanbanController virtualKanbanController;

    public PdfViewController(VirtualKanbanController virtualKanbanController) {
        this.virtualKanbanController = virtualKanbanController;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PdfView.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        Parent root = new BorderPane();
        try {
            root = fxmlLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        allProjectsButton.setToggleGroup(group);
        oneProjectButton.setToggleGroup(group);

        // init Scene and Stage
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
        stage = new Stage();
        //stage.initModality(Modality.APPLICATION_MODAL); // Blockiert alle anderen Fenster im Hintergrund.
        stage.setScene(scene);
    }

    @FXML
    void onCancelButtonClicked(MouseEvent event) {
        closeView();
    }

    @FXML
    void onExportButtonClicked(MouseEvent event) {
        errorLabel.setVisible(false);
        if(allProjectsButton.isSelected()) {
            //virtualKanbanController.getIOController().exportPdf(virtualKanbanController.getVirtualKanban().getProject());
        }
        else if(projectComboBox.getValue()==null) {
            errorLabel.setVisible(true);
        } else {
            //virtualKanbanController.getIOController().exportPdf(projectComboBox.getValue());
        }
    }

    public void showView() {
        stage.show();
        errorLabel.setVisible(false);
        getData();
    }

    //
    public void closeView() {
        projectComboBox.setValue(null);
        stage.hide();
    }

    public void getData() {
        ObservableList<Project> observableProjectList =
                FXCollections.observableArrayList(virtualKanbanController.getVirtualKanban().getProject());
        projectComboBox.setItems(observableProjectList);
        projectComboBox.setCellFactory(e -> new ListCell<Project>() {
            @Override
            protected void updateItem(Project project, boolean empty) {
                super.updateItem(project, empty);

                if (empty || project == null) {
                    setText(null);
                } else {
                    setText(project.getName());
                }
            }
        });
        projectComboBox.setButtonCell(projectComboBox.getCellFactory().call(null));
    }
}
