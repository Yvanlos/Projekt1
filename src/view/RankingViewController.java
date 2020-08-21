package view;

import controller.VirtualKanbanController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import model.Project;


import java.lang.UnsupportedOperationException;

public class RankingViewController extends BorderPane {

    private StackPane stackPane;

    private VirtualKanbanController virtualKanbanController;

    public RankingViewController(StackPane stackPane, VirtualKanbanController virtualKanbanController){
        this.stackPane = stackPane;
        this.virtualKanbanController = virtualKanbanController;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RankingView.fxml"));
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
    private TableView<?> tableViewaRanking;

    @FXML
    private TableColumn<?, ?> tableColumnName;

    @FXML
    private TableColumn<?, ?> tableColumnLast7Days;

    @FXML
    private Button backButton;

    @FXML
    void onBackButtonEvent(MouseEvent event) {

    }

}
