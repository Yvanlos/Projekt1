package controller;

import model.Project;
import java.lang.UnsupportedOperationException;

public class IOController {

    /**
 	 * Reference to the VirtualKanbanController, that every controller has
 	 */
    private VirtualKanbanController virtualKanbanController;

    public IOController(VirtualKanbanController virtualKanbanController) {
    }

    /**
 	 *
 	 * loads the last state of the Program after launching VirtualKanban
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void load() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * saves the current state of the program when it gets closed
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void save() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * creates an PDF-File from all existing projects
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void exportPdf() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * creates an PDF-File from the selected project
 	 * @param project the selected project
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void exportPdf(Project project) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
