package controller;

import model.Project;
import model.Task;
import model.Note;
import model.Developer;

import java.time.LocalDateTime;

public class TaskController {

	private VirtualKanbanController virtualKanbanController;

	public TaskController(VirtualKanbanController VirtualKanbanController) {

	}

	public void deleteTask(Project project, Task task) {

	}

	public void addTask(Project project, String name, String description, LocalDateTime deadline) {

	}

	public void addNote(Task task, Note note) {

	}

	public void startTask(Task task, Project project, Developer developer) {

	}

	public void finishTask(Task task, Project project) {

	}

	public void dropTask(Task task, Project project) {

	}

	public void showNotes(Task task) {

	}

}
