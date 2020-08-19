package controller;

import model.Team;
import java.lang.UnsupportedOperationException;

public class TeamController {

    /**
 	 * The VirtualKanbanController object.
 	 */
    private VirtualKanbanController virtualKanbanController;

    public TeamController(VirtualKanbanController virtualKanbanController) {
    	
    }

    /**
 	 * Creates a new team.
 	 * 
 	 * @param name The name of the new team.
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void createTeam(String name) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Deletes an existing team.
 	 * 
 	 * @param team The team to be deleted.
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void deleteTeam(Team team) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
