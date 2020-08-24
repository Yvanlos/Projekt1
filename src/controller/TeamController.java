package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import model.Project;
import model.Team;

/**
 * The Teamcontroller class is used for adding and deleting teams from the VirtualKanban class.
 * 
 */
public class TeamController {

    /**
 	 * The VirtualKanbanController object.
 	 */
    private VirtualKanbanController virtualKanbanController;

    /**
     * The TeamController constructor.
     * @param virtualKanbanController reference to the main-controller
     */
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
    	ArrayList<Team> teamList = getTeamsList();
    	ArrayList<Project> projectList = virtualKanbanController.getVirtualKanban().getProject();
        if(teamList.contains(team)) {
			for(Project project : projectList) {
				if(team.equals(project.getTeam())) {
					project.setTeam(null);
				}
			}
        	teamList.remove(team);
        }
        else {
        	throw new NoSuchElementException("The team that should be deleted does not exist in teams.");
        }
    }
    
    /**
     * Returns an ArrayList object including all teams.
     * @return ArrayList of all teams
     */
    public ArrayList<Team> getTeamsList(){
    	return virtualKanbanController.getVirtualKanban().getTeam();
    }
    
}
