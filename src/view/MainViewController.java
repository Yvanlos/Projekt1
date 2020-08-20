package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.lang.UnsupportedOperationException;

import controller.VirtualKanbanController;

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

    /**
 	 * 
 	 */
    @FXML
    private Button showStatisticsButton;

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
    
    
    private VirtualKanbanController virtualKanbanController;
    
    
    public MainViewController(VirtualKanbanController virtualKanbanController){
    	this.virtualKanbanController = virtualKanbanController;
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
    	loader.setRoot(this);
    	loader.setController(this);
    	try {
    	    loader.load();
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}
    	
    	
    }
    
    

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onCreateProjectButtonClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onDevelopersButtonClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onExitButtonClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperation Exception
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
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onShowStatisticsButtonClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param event
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    @FXML
    void onTeamsButtonClick(MouseEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
