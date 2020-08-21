package view;

import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.lang.UnsupportedOperationException;

public class ShowStatisticsViewController extends BorderPane {

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

}
