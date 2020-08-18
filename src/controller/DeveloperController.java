package controller;

import model.Team;
import model.Developer;
import java.net.URI;
import java.lang.UnsupportedOperationException;

public class DeveloperController {

    /**
 	 * 
 	 */
    private VirtualKanbanController virtualKanbanController;

    public DeveloperController(VirtualKanbanController virtualKanbanController) {
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param team
 	 * @param name
 	 * @param picture
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void createDeveloper(Team team, String name, URI picture) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param developer
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void deleteDeveloper(Developer developer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param developer
 	 * @param newTeam
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void changeTeam(Developer developer, Team newTeam) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
