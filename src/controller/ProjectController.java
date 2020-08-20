package controller;

import model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class allows it to create, remove and archive projects
 */
public class ProjectController {

	/**
	 * the VirtualKanbanController which knows and is known by every other controller
	 */
    private VirtualKanbanController virtualKanbanController;

    public ProjectController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    }

    /**
	 * Creates a new project and assigns it to a team
	 *
 	 * @param name the name of the project
 	 * @param deadline the deadline of the project
 	 * @param team the team assigned to the project
 	 * @param description a description of the project
 	 * @return Project the newly created project
 	 * @throws IllegalArgumentException if a project with the same name already exists or if the name is empty
 	 */
    public Project createProject(String name, LocalDateTime deadline, Team team, String description) throws IllegalArgumentException {
        if (name != null){
			for (Project project : virtualKanbanController.getVirtualKanban().getProject()) {
				if (project.getName().equals(name)) {
					throw new IllegalArgumentException("There is already a project called: " + name + ".");
				}
			}
			Project project = new Project(name, description, deadline, team);
			virtualKanbanController.getVirtualKanban().addProject(project);
			return project;
		}
		throw new IllegalArgumentException("The project must have a name!");
    }

    /**
 	 * Archives the specified project and releases the team which was assigned to the project
 	 *
 	 * @param project the project to be archived
 	 */
    public void archiveProject(Project project) {
		ArrayList<Task> tasksAnalysis = null;
		ArrayList<Task> tasksImplementation = null;
		ArrayList<Task> tasksTests = null;
		for (StageList list : project.getStageList()){
			if(list.getStage()== Stage.ANALYSE_IN_PROGRESS){
				tasksAnalysis = list.getTask();
			}
			if(list.getStage()==Stage.IMPLEMENTATION_IN_PROGRESS){
				tasksImplementation = list.getTask();
			}
			if(list.getStage()==Stage.TEST_IN_PROGRESS){
				tasksTests = list.getTask();
			}
		}
		//tasksAnalysis.forEach((task) -> task.getDeveloper().cancelTask());
		//moveTaskBackward is not failsafe for removing in a loop
		//TODO make the removing failsafe
		for (Task task: tasksAnalysis) {
			project.moveTaskBackward(task);
			task.getDeveloper().cancelTask();
		}
		for (Task task: tasksImplementation) {
			project.moveTaskBackward(task);
			task.getDeveloper().cancelTask();
		}
		for (Task task: tasksTests) {
			project.moveTaskBackward(task);
			task.getDeveloper().cancelTask();
		}
		project.setReadOnly(true);
    }

    /**
 	 * Deletes the specified project and releases the team which was assigned to the project
 	 *
 	 * @param project the project to be deleted
 	 */
    public void deleteProject(Project project) {
		virtualKanbanController.getVirtualKanban().getProject().remove(project);
    }

	/**
	 * Returns the VirtualKanban controller
	 * @return VirtualKanban controller
	 */
	public VirtualKanbanController getVirtualKanbanController() {
		return virtualKanbanController;
	}
}
