package view;

import controller.VirtualKanbanController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Team;

import java.util.HashMap;

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

    public ShowStatisticsViewController(StackPane stackPane, VirtualKanbanController virtualKanbanController, Team team){
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

    public class StatisticViewData {
        public SimpleStringProperty name;
        public SimpleIntegerProperty min;
        public SimpleIntegerProperty avg;
        public SimpleIntegerProperty max;
        public StatisticViewData(String name, int min, int avg, int max) {
            this.name = new SimpleStringProperty(name);
            this.min = new SimpleIntegerProperty(min);
            this.min = new SimpleIntegerProperty(avg);
            this.min = new SimpleIntegerProperty(max);
        }
    }

    @FXML
    void initialize() {
        this.minWidthProperty().bind(stackPane.widthProperty());
        this.minHeightProperty().bind(stackPane.heightProperty());

        /*HashMap<String, double[]> map = virtualKanbanController.getStatisticController().showStats();
        RankingViewController.RankingViewData[] data = new RankingViewController.RankingViewData[map.keySet().size()];
        int index = 0;
        for(String name : map.keySet()) {
            data[index] = new RankingViewController.RankingViewData(name, map.get(name));
            index++;
            //System.out.println(name + " " + map.get(name));
        }
        ObservableList<RankingViewController.RankingViewData> list = FXCollections.observableArrayList(data);
        tableColumnName.setCellValueFactory(new PropertyValueFactory<RankingViewController.RankingViewData, String>("name"));
        tableColumnLast7Days.setCellValueFactory(new PropertyValueFactory<RankingViewController.RankingViewData, Integer>("completedTasks"));
        tableViewRanking.setItems(list);
        tableViewRanking.refresh();*/
    }

    @FXML
    void onBackButtonEvent(MouseEvent event) {
        stackPane.getChildren().removeIf(child -> child.equals(this));
        stackPane.getChildren().get(0).setVisible(true);
    }

}
