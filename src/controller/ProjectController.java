package controller;

import model.Project;
import model.Team;

import java.time.LocalDateTime;

public class ProjectController {

	private VirtualKanbanController virtualKanbanController;

	public ProjectController(VirtualKanbanController virtualKanbanController) {

	}

	public Project createProject(String name, LocalDateTime deadline, Team team, String description) {
		return null;
	}

	public void archiveProject(Project project) {

	}

	public void deleteProject(Project project) {

	}

}
