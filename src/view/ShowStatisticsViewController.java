package view;

import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.lang.UnsupportedOperationException;

public class ShowStatisticsViewController extends BorderPane {

    @FXML
    private TableView<?> tableViewStatsTable;

    @FXML
    private TableColumn<?, ?> tableColumnName;

    @FXML
    private TableColumn<?, ?> tableColumnMin;

    @FXML
    private TableColumn<?, ?> tableColumnMax;

    @FXML
    private TableColumn<?, ?> tableColumnAvg;

    @FXML
    private Button backButton;

    private StackPane stackPane;

    private VirtualKanbanController virtualKanbanController;

    public ShowStatisticsViewController(StackPane stackPane, VirtualKanbanController virtualKanbanController){
        this.stackPane = stackPane;
        this.virtualKanbanController = virtualKanbanController;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ShowStatisticsView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        this.minWidthProperty().bind(stackPane.widthProperty());
        this.minHeightProperty().bind(stackPane.heightProperty());
    }

    @FXML
    void onBackButtonEvent(MouseEvent event) {
        stackPane.getChildren().removeIf(child -> child.equals(this));
        stackPane.getChildren().get(0).setVisible(true);
    }

}
