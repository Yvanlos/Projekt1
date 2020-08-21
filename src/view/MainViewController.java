package view;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.time.LocalDateTime;

import controller.VirtualKanbanController;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import model.Project;
import model.Team;


public class MainViewController extends BorderPane {

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

    /**
     *
     */
    @FXML
    private GridPane showProjectPane;

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


    /**
     * @param virtualKanbanController
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


    }

    /**
     *
     */
    @FXML
    public void initialize() {
        //Test project
        virtualKanbanController.getVirtualKanban().addProject(new Project("Testprojekt", "Testbeschreibung", LocalDateTime.now(), new Team("Testteam")));

        //Add all Projects as Buttons to the MainView
        showProjectPane.getChildren().clear();
        virtualKanbanController.getVirtualKanban().getProject().forEach(project -> {
            Button projectButton = new Button(project.getName());
            projectButton.setPrefSize(50,50);
            projectButton.setOnAction(evt -> {
                KanBanViewController kanBanViewController = new KanBanViewController(stackPane, virtualKanbanController, project);
                stackPane.getChildren().add(kanBanViewController);
            });
            //showProjectPane.add(projectButton,0,0);
            showProjectPane.getChildren().add(projectButton);
        });

        //Binding
        IntegerBinding sizeProperty = Bindings.size(stackPane.getChildren());
        BooleanBinding multipleElemsProperty = sizeProperty.greaterThan(1);
    }


    /**
     * Opens the NewProject window
     *
     * @param event the MouseEvent triggered when clicked
     */
    @FXML
    void onCreateProjectButtonClick(MouseEvent event) {
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
        pdfViewController pdfViewController = new pdfViewController(virtualKanbanController);
        stackPane.getChildren().add(pdfViewController);
    }

    /**
     * Opens the showRanking view in a stackPane
     *
     * @param event the ActionEvent triggered when clicked
     */
    @FXML
    void onShowRankingAction(ActionEvent event) {
        RankingViewController rankingViewController = new RankingViewController(stackPane, virtualKanbanController);
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
