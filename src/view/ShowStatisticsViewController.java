package view;

import controller.VirtualKanbanController;
import javafx.beans.property.SimpleDoubleProperty;
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

    private Team team;

    @FXML
    private TableView<StatisticViewData> tableViewStatsTable;

    @FXML
    private TableColumn<StatisticViewData, String> tableColumnName;

    @FXML
    private TableColumn<StatisticViewData, Double> tableColumnMin;

    @FXML
    private TableColumn<StatisticViewData, Double> tableColumnMax;

    @FXML
    private TableColumn<StatisticViewData, Double> tableColumnAvg;

    @FXML
    private Button backButton;

    private StackPane stackPane;

    private VirtualKanbanController virtualKanbanController;

    public ShowStatisticsViewController(StackPane stackPane, VirtualKanbanController virtualKanbanController, Team team){
        this.team = team;
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
        public SimpleDoubleProperty min;
        public SimpleDoubleProperty avg;
        public SimpleDoubleProperty max;
        public StatisticViewData(String name, double min, double avg, double max) {
            this.name = new SimpleStringProperty(name);
            this.min = new SimpleDoubleProperty(min);
            this.avg = new SimpleDoubleProperty(avg);
            this.max = new SimpleDoubleProperty(max);
        }

        public String getName() {return name.get();}
        public double getMin() {return min.get();}
        public double getMax() {return max.get();}
        public double getAvg() {return avg.get();}

        public void setName(String name) {this.name.set(name);}
        public void setMin(double min) {this.min.set(min);}
        public void setMax(double max) {this.min.set(max);}
        public void setAvg(double avg) {this.min.set(avg);}
    }

    @FXML
    void initialize() {
        this.minWidthProperty().bind(stackPane.widthProperty());
        this.minHeightProperty().bind(stackPane.heightProperty());

        HashMap<String, double[]> map = virtualKanbanController.getStatisticController().showStats(team);
        StatisticViewData[] data = new StatisticViewData[map.keySet().size()];
        int index = 0;
        for(String name : map.keySet()) {
            data[index] = new StatisticViewData(name, map.get(name)[0], map.get(name)[1], map.get(name)[2]);
            index++;
        }
        ObservableList<StatisticViewData> list = FXCollections.observableArrayList(data);
        tableColumnName.setCellValueFactory(new PropertyValueFactory<StatisticViewData, String>("name"));
        tableColumnMin.setCellValueFactory(new PropertyValueFactory<StatisticViewData, Double>("min"));
        tableColumnAvg.setCellValueFactory(new PropertyValueFactory<StatisticViewData, Double>("avg"));
        tableColumnMax.setCellValueFactory(new PropertyValueFactory<StatisticViewData, Double>("max"));
        tableViewStatsTable.setItems(list);
        tableViewStatsTable.refresh();
    }

    @FXML
    void onBackButtonEvent(MouseEvent event) {
        stackPane.getChildren().removeIf(child -> child.equals(this));
        stackPane.getChildren().get(0).setVisible(true);
    }

}
