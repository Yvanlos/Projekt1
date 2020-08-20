package controller;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import model.Team;

public class TeamController {

    /**
 	 * The VirtualKanbanController object.
 	 */
    private VirtualKanbanController virtualKanbanController;

    public TeamController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    }

    /**
 	 * Creates a new team.
 	 * 
 	 * @param name The name of the new team.
 	 */
    public void createTeam(String name){
        Team newTeam = new Team(name);
        virtualKanbanController.getVirtualKanban().getTeam().add(newTeam);
    }

    /**
 	 * Deletes an existing team.
 	 * 
 	 * @param team The team to be deleted.
 	 * @throws NoSuchElementException Gets thrown if the team does not exist in the team list.
 	 */
    public void deleteTeam(Team team) throws NoSuchElementException{
    	ArrayList<Team> teamList = (ArrayList<Team>) virtualKanbanController.getVirtualKanban().getTeam();
        if(teamList.contains(team)) {
        	teamList.remove(team);
        }
        else {
        	throw new NoSuchElementException("The team that should be deleted does not exist in teams.");
        }
    }
}
