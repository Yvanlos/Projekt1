package controller;

import model.*;

import java.net.URI;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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
		this.virtualKanbanController = virtualKanbanController;
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
	 * @throws IllegalArgumentException if the name is empty
	 */
	public void createDeveloper(Team team, String name, URI picture) throws IllegalArgumentException {
		if (name!=null) {
			int i = 0;
			for (Developer dev : team.getDevelopers()) {
				if (dev.getName().equals(name)) {
					i++;
				}
			}
			if(i>0){
				name = name + i;
			}
			Developer developer = new Developer(name, picture);
			team.addDeveloper(developer);
		}
		else {
			throw new IllegalArgumentException("The developer must have a name!");
		}
	}

	/**
	 * deletes a developer and removes him from his team
	 *
	 * @param developer developer which should be deleted
	 */
	public void deleteDeveloper(Developer developer){
		if(developer.isAtWork()) {
			Task currentTask = developer.getCurrentTaskStage().getTask();
			Project project = getProjectFromTask(currentTask);
			virtualKanbanController.getTaskController().dropTask(currentTask, project);
		}
		ArrayList<Team> teams= virtualKanbanController.getVirtualKanban().getTeam();
		for( Team team : teams) {
			if (team.getDevelopers().contains(developer)) {
				team.removeDeveloper(developer);
			}
		}
	}

	/**
	 * removes the developer from his current and adds him to the new team
	 *
	 * @param developer teh developer who is changing the team
	 * @param newTeam the team, which the developer is changing to
	 */
	public void changeTeam(Developer developer, Team newTeam) {
		if(developer.isAtWork()) {
			Task currentTask = developer.getCurrentTaskStage().getTask();
			Project project = getProjectFromTask(currentTask);
			virtualKanbanController.getTaskController().dropTask(currentTask, project);
		}
		ArrayList<Team> teams= virtualKanbanController.getVirtualKanban().getTeam();
		for( Team team : teams) {
			if (team.getDevelopers().contains(developer)) {
				team.removeDeveloper(developer);
			}
		}
		newTeam.addDeveloper(developer);

	}

	/**
	 *
	 * @param task the task for which the project it is in is asked
	 * @return project the project which contains the task
	 * @throws NoSuchElementException if the task is not found in any project
	 */
	public Project getProjectFromTask(Task task) throws NoSuchElementException{
		for(Project project : virtualKanbanController.getVirtualKanban().getProject()) {
			for (StageList list : project.getStageList()){
				if (list.getTask().contains(task)){
					return project;
				}
			}
		}
		throw new NoSuchElementException("Task is not part of any Project");
	}

}
