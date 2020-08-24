package view;

import controller.VirtualKanbanController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

public class RankingViewController extends BorderPane {

    @FXML
    private Button backButton;

    @FXML
    private TableView<RankingViewData> tableViewRanking;

    @FXML
    private TableColumn<RankingViewData, String> tableColumnName;

    @FXML
    private TableColumn<RankingViewData, Integer> tableColumnLast7Days;

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

    public class RankingViewData {
        public SimpleStringProperty name;
        public SimpleIntegerProperty completedTasks;
        public RankingViewData(String name, int completedTasks) {
            this.name = new SimpleStringProperty(name);
            this.completedTasks = new SimpleIntegerProperty(completedTasks);
        }
        public int getCompletedTasks() {return completedTasks.get();}
        public String getName() {return name.get();}
        public void setCompletedTasks(int completedTasks) {
            this.completedTasks.set(completedTasks);
        }
        public void setName(String name) {
            this.name.set(name);
        }
    }

    @FXML
    void initialize() {
        this.minWidthProperty().bind(stackPane.widthProperty());
        this.minHeightProperty().bind(stackPane.heightProperty());
        HashMap<String, Integer> map = virtualKanbanController.getStatisticController().showRanking();
        RankingViewData[] data = new RankingViewData[map.keySet().size()];
        int index = 0;
        for(String name : map.keySet()) {
            data[index] = new RankingViewData(name, map.get(name));
            index++;
            //System.out.println(name + " " + map.get(name));
        }
        ObservableList<RankingViewData> list = FXCollections.observableArrayList(data);
        tableColumnName.setCellValueFactory(new PropertyValueFactory<RankingViewData, String>("name"));
        tableColumnLast7Days.setCellValueFactory(new PropertyValueFactory<RankingViewData, Integer>("completedTasks"));
        tableViewRanking.setItems(list);
        tableViewRanking.refresh();
    }

    @FXML
    void onBackButtonEvent(MouseEvent event) {
        stackPane.getChildren().removeIf(child -> child.equals(this));
        stackPane.getChildren().get(0).setVisible(true);
    }

}
