package view;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import controller.VirtualKanbanController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.*;


public class MainViewController extends BorderPane {

    public static class HBoxCell extends HBox {
        Label label = new Label();
        Button button = new Button();

        HBoxCell(String labelText, String buttonText) {
            super();

            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);

            button.setText(buttonText);

            this.getChildren().addAll(label, button);
        }
    }

    /**
     *
     */
    @FXML
    private Button createProjectButton;

    /**
     *
     */
    @FXML
    private Button teamsButton;

    /**
     *
     */
    @FXML
    private Button developersButton;

    /**
     *
     */
    @FXML
    private MenuItem showRankingButton;

    /**
     *
     */
    @FXML
    private MenuItem showStatisticButton;

    /**
     *
     */
    @FXML
    private Button exportPDFButton;

    /**
     *
     */
    @FXML
    private Button exitButton;

    @FXML
    private ListView<Project> activeProjectsList;

    @FXML
    private ListView<Project> archivedProjectsList;


    /**
     * The VirtualKanbanController object.
     */
    private VirtualKanbanController virtualKanbanController;

    /**
     * The Stackpane object.
     */
    @FXML
    private StackPane stackPane;


    /**
     * A DeveloperListViewController object for showing the DeveloperListView
     */
    private DeveloperListViewController developerListViewController;

    /**
     * A NewProjectViewController object for showing the NewProjectView
     */
    private NewProjectViewController newProjectViewController;

    /**
     * A TeamsViewController object for showing the TeamsView
     */
    private TeamsViewController teamsViewController;

    private PdfViewController pdfViewController;


    /**
     * @param virtualKanbanController the actual current KanbanController
     */
    public MainViewController(VirtualKanbanController virtualKanbanController) {
        this.virtualKanbanController = virtualKanbanController;

        //Load view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Generate the ViewController
        developerListViewController = new DeveloperListViewController(virtualKanbanController);
        newProjectViewController = new NewProjectViewController(virtualKanbanController);
        teamsViewController = new TeamsViewController(virtualKanbanController);
        pdfViewController = new PdfViewController(virtualKanbanController);


    }

    /**
     *
     */
    @FXML
    public void initialize() {
        //Test project
        virtualKanbanController.getVirtualKanban().addProject(new Project("Testprojekt", "Testbeschreibung", LocalDateTime.now(), new Team("Testteam")));

        //Test tasks
        Project testProject = virtualKanbanController.getVirtualKanban().getProject().get(0);
        for (StageList list : testProject.getStageList()){
            if (list.getStage() == Stage.NEW){
                list.addTask(new Task("testName","testDescription",LocalDateTime.now()));
            }
        }
        for (StageList list : testProject.getStageList()){
            if (list.getStage() == Stage.IMPLEMENTATION_FINISHED){
                list.addTask(new Task("testName1","testDescription1",LocalDateTime.now()));
            }
        }
        for (StageList list : testProject.getStageList()){
            if (list.getStage() == Stage.COMPLETED){
                list.addTask(new Task("testName2","testDescription2",LocalDateTime.now()));
            }
        }

        //Test developer
        testProject.getTeam().addDeveloper(new Developer("TestDev",null));

        //list of active projects
        activeProjectsList.setPlaceholder(new Label("Keine aktiven Projekte vorhanden"));
        activeProjectsList.setCellFactory(e -> new ListCell<>() {
            @Override
            protected void updateItem(Project project, boolean empty) {
                super.updateItem(project, empty);

                if (empty || project == null) {
                    setGraphic(null);
                } else {
                    Text name = new Text(project.getName());
                    name.setStyle("-fx-font: 20 arial; ");

                    Button showButton = new Button("Projekt anzeigen");
                    showButton.setPrefHeight(20);
                    showButton.setPrefWidth(200);
                    showButton.setCenterShape(true);
                    showButton.setOnMouseClicked(e -> {
                        KanBanViewController kanBanViewController = new KanBanViewController(stackPane, virtualKanbanController, project);
                        stackPane.getChildren().get(0).setVisible(false);
                        stackPane.getChildren().add(kanBanViewController);

                    });
                    Text deadline = new Text("Deadline: "+project.getDeadline().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
                    deadline.setStyle("-fx-font: 20 arial; ");
                    BorderPane display = new BorderPane(name, null, showButton, null, deadline);

                    setGraphic(display);
                }
            }
        });

        refreshActiveProjectsList();

        //list of archived projects
        archivedProjectsList.setPlaceholder(new Label("Keine archivierten Projekte vorhanden"));
        archivedProjectsList.setCellFactory(e -> new ListCell<>() {
            @Override
            protected void updateItem(Project project, boolean empty) {
                super.updateItem(project, empty);

                if (empty || project == null) {
                    setGraphic(null);
                } else {
                    Text name = new Text(project.getName());
                    name.setStyle("-fx-font: 20 arial; ");

                    Button showButton = new Button("Projekt anzeigen");
                    showButton.setPrefHeight(20);
                    showButton.setPrefWidth(200);
                    showButton.setCenterShape(true);
                    showButton.setOnMouseClicked(e -> {
                        KanBanViewController kanBanViewController = new KanBanViewController(stackPane, virtualKanbanController, project);
                        stackPane.getChildren().get(0).setVisible(false);
                        stackPane.getChildren().add(kanBanViewController);

                    });
                    BorderPane display = new BorderPane(name, null, showButton, null, null);
                    setGraphic(display);
                }
            }
        });

        refreshArchivedProjectsList();


        //Binding
        IntegerBinding sizeProperty = Bindings.size(stackPane.getChildren());
        BooleanBinding multipleElemsProperty = sizeProperty.greaterThan(1);
    }

    public void refreshActiveProjectsList() {
        ArrayList<Project> activeProjects = new ArrayList<>();
        for(Project project : virtualKanbanController.getVirtualKanban().getProject())
            if(!project.isReadOnly()){
                activeProjects.add(project);
            }
        ObservableList<Project> observableActiveProjectsList =
                FXCollections.observableArrayList(activeProjects);
        activeProjectsList.setItems(observableActiveProjectsList);
    }

    public void refreshArchivedProjectsList() {
        ArrayList<Project> archivedProjects = new ArrayList<>();
        for(Project project : virtualKanbanController.getVirtualKanban().getProject())
            if(project.isReadOnly()){
                archivedProjects.add(project);
            }
        ObservableList<Project> observableArchivedProjectsList =
                FXCollections.observableArrayList(archivedProjects);
        archivedProjectsList.setItems(observableArchivedProjectsList);
    }

    /**
     * Opens the NewProject window
     *
     * @param event the MouseEvent triggered when clicked
     */
    @FXML
    void onCreateProjectButtonClick(MouseEvent event) {
    	newProjectViewController.updateTeamCombobox();
        newProjectViewController.showView();
    }

    /**
     * Opens the Developer overview window
     *
     * @param event the MouseEvent triggered when clicked
     */
    @FXML
    void onDevelopersButtonClick(MouseEvent event) {
        developerListViewController.showView();
    }

    /**
     * Executed when the exit button is clicked. Saves the current state and exits the program.
     *
     * @param event the MouseEvent when the button is clicked.
     */
    @FXML
    void onExitButtonClick(MouseEvent event) {
        //TODO: Saving data
        System.exit(0);
    }

    /**
     * Opens the exportPDF view in a stackPane
     *
     * @param event the MouseEvent triggered when clicked
     */
    @FXML
    void onExportPDFButtonClick(MouseEvent event) {
        pdfViewController.showView();
//        pdfViewController pdfViewController = new pdfViewController(stackPane, virtualKanbanController);
//        stackPane.getChildren().add(pdfViewController);
    }

    /**
     * Opens the showRanking view in a stackPane
     *
     * @param event the ActionEvent triggered when clicked
     */
    @FXML
    void onShowRankingAction(ActionEvent event) {
        RankingViewController rankingViewController = new RankingViewController(stackPane, virtualKanbanController);
        stackPane.getChildren().get(0).setVisible(false);
        stackPane.getChildren().add(rankingViewController);
    }

    /**
     * Opens the showStatistic view in a stackPane
     *
     * @param event the ActionEvent triggered when clicked
     */
    @FXML
    void onShowStatistikAction(ActionEvent event) {
        ShowStatisticsViewController showStatisticsViewController = new ShowStatisticsViewController(stackPane, virtualKanbanController);
        stackPane.getChildren().get(0).setVisible(false);
        stackPane.getChildren().add(showStatisticsViewController);
    }

    /**
     * Opens the teams overview in a window
     *
     * @param event the MouseEvent triggered when clicked
     */
    @FXML
    void onTeamsButtonClick(MouseEvent event) {
        teamsViewController.showView();
    }

}
