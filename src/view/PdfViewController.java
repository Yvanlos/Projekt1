package view;

import com.itextpdf.text.DocumentException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import application.Main;
import controller.VirtualKanbanController;
import model.Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


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

    @FXML
    private Label fileErrorLabel;

    @FXML
    private Label fileChosenLabel;

    @FXML
    private Button fileChooserButton;


    ToggleGroup group = new ToggleGroup();

    private Stage stage;

    private VirtualKanbanController virtualKanbanController;

    private File DEST;

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
    void initialize() {
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

    @FXML
    void onCancelButtonClicked(MouseEvent event) {
        closeView();
    }

    @FXML
    void onExportButtonClicked(MouseEvent event) throws IOException, DocumentException {
        if(oneProjectButton.isSelected() && projectComboBox.getValue() == null) {
            errorLabel.setVisible(true);
        }
        else {
            if (DEST != null) {
                errorLabel.setVisible(false);
                if (allProjectsButton.isSelected()) {
                    virtualKanbanController.getIOController().exportAllTable(DEST, virtualKanbanController.getVirtualKanban().getProject());
                    closeView();
                } else if(oneProjectButton.isSelected()){
                    virtualKanbanController.getIOController().exportATable(DEST, projectComboBox.getValue());
                    closeView();
                }
            }
        }
    }

    @FXML
    void onFileChooserButtonClicked(MouseEvent event) {
        fileChosenLabel.setText(null);
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", ".pdf"));
        DEST = fileChooser.showSaveDialog(stage);
        try {
            fileChosenLabel.setText(DEST.getAbsolutePath());
            fileErrorLabel.setVisible(false);
            fileChosenLabel.setVisible(true);
        }
        catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    public void showView() {
        stage.show();
        errorLabel.setVisible(false);
        fileErrorLabel.setVisible(true);
        fileChosenLabel.setText(null);
        fileChosenLabel.setVisible(false);
        DEST = null;
        refreshProjects();
    }

    //
    public void closeView() {
        projectComboBox.setValue(null);
        stage.hide();
    }

    public void refreshProjects() {
        ObservableList<Project> observableProjectList =
                FXCollections.observableArrayList(virtualKanbanController.getVirtualKanban().getProject());
        projectComboBox.setItems(observableProjectList);
    }
}
