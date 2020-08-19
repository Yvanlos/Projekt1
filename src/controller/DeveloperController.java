package controller;

import model.Team;
import model.Developer;
import java.net.URI;
import java.lang.UnsupportedOperationException;

public class DeveloperController {

    /**
 	 * the virtualKanbanController which knows and is known by every other controller
 	 */
    private VirtualKanbanController virtualKanbanController;

	/**
	 * creates a DeveloperController and sets it VirtualKanbanController
	 * @param virtualKanbanController the VirtualKanbanController
	 */
	public DeveloperController(VirtualKanbanController virtualKanbanController) {
    }

	/**
	 * returns the virtualKanbanController
	 * @return virtualKanbanController the requested controller
	 */
	public VirtualKanbanController getVirtualKanbanController() {
		return virtualKanbanController;
	}

	/**
	 * sets the virtualKanbanController
	 * @param virtualKanbanController  the VirtualKanbanController
	 */
	public void setVirtualKanbanController(VirtualKanbanController virtualKanbanController) {
		this.virtualKanbanController = virtualKanbanController;
	}

	/**
 	 * creates a developer which is then assigned to a team
	 *
 	 * @param team the team for which the developer is created
 	 * @param name the name of the developer
 	 * @param picture a picture of the devloper
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void createDeveloper(Team team, String name, URI picture) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * deletes a developer and removes him from his team
	 *
 	 * @param developer developer which should be deleted
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void deleteDeveloper(Developer developer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * removes the developer from his current and adds him to the new team
 	 *
 	 * @param developer teh developer who is changing the team
 	 * @param newTeam the team, which the developer is changing to
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void changeTeam(Developer developer, Team newTeam) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
