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

import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;
import java.util.Stack;

import controller.VirtualKanbanController;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import model.Project;
import model.Team;


public class MainViewController extends BorderPane{

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

	@FXML
	private MenuItem showRankingButton;

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
	private GridPane showProjectPane;
    
    /**
     * The VirtualKanbanController object.
     */
    private VirtualKanbanController virtualKanbanController;

    @FXML
    private StackPane stackPane;
    
    
    /**
     * A DeveloperListViewController object for showing the DeveloperListView
     */
    private DeveloperListViewController developerListViewController;
    
    
    public MainViewController(VirtualKanbanController virtualKanbanController){
    	this.virtualKanbanController = virtualKanbanController;
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
    	loader.setRoot(this);
    	loader.setController(this);
    	try {
    	    loader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}
    	
    	developerListViewController = new DeveloperListViewController(virtualKanbanController);

    	
    }

	@FXML
	public void initialize() {
		virtualKanbanController.getVirtualKanban().addProject(new Project("Testprojekt", "Testbeschreibung", LocalDateTime.now(), new Team("Testteam")));
    	virtualKanbanController.getVirtualKanban().getProject().forEach(project -> {
    		Button projectButton = new Button(project.getName());
    		projectButton.setOnAction(evt -> {
    			KanBanViewController kanBanViewController = new KanBanViewController(stackPane, virtualKanbanController, project);
    			stackPane.getChildren().add(kanBanViewController);
			});
    		showProjectPane.getChildren().add(projectButton);
		});

    	//Binding
		IntegerBinding sizeProperty = Bindings.size(stackPane.getChildren());
		BooleanBinding multipleElemsProperty = sizeProperty.greaterThan(1);
	}
    

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onCreateProjectButtonClick(MouseEvent event) throws UnsupportedOperationException {
		NewProjectViewController newProjectViewController = new NewProjectViewController(virtualKanbanController);
    	newProjectViewController.showView();
    	//throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onDevelopersButtonClick(MouseEvent event) throws UnsupportedOperationException {
    	//Show DeveloperListView
    	developerListViewController.showView();
    	
        //throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Executed when the exit button is clicked. Saves the current state and exits the program.
 	 * @param event the MouseEvent when the button is clicked.
 	 */
    @FXML
    void onExitButtonClick(MouseEvent event){
        //TODO: Saving data
    	
    	
    	
    	System.exit(0);
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onExportPDFButtonClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
	void onShowRankingAction(ActionEvent event) {

		RankingViewController rankingViewController = new RankingViewController(stackPane, virtualKanbanController);
		stackPane.getChildren().add(rankingViewController);
	}

	@FXML
	void onShowStatistikAction(ActionEvent event) {
		ShowStatisticsViewController showStatisticsViewController = new ShowStatisticsViewController(stackPane, virtualKanbanController);
		stackPane.getChildren().add(showStatisticsViewController);
	}

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onTeamsButtonClick(MouseEvent event) throws UnsupportedOperationException {
        TeamsViewController TeamsViewController = new TeamsViewController(virtualKanbanController);
        TeamsViewController.showView();
    	//throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
