package view;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.lang.UnsupportedOperationException;

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

    //private StackPane stackPane;

    ToggleGroup group = new ToggleGroup();

    private Stage stage;

    private VirtualKanbanController virtualKanbanController;

    public PdfViewController(VirtualKanbanController virtualKanbanController) {
        //this.stackPane = stackPane;
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

        ObservableList<Project> observableProjectList = FXCollections.observableArrayList(virtualKanbanController.getVirtualKanban().getProject());
        projectComboBox.setItems(observableProjectList);

        // TODO hier kann die View weiter initialisiert werden (�quivalent zu initialize-Methode bei Komponenten)


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

    }

    public void showView() {
        stage.show();
    }
//
    public void closeView() {
        stage.hide();
    }
}
