package controller;

import model.*;

import java.time.LocalDateTime;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;

public class TaskController {
	/**
	 * get this VirtualKanbanController
	 * @return virtualKanbanController
	 */
	public VirtualKanbanController getVirtualKanbanController() {
		return virtualKanbanController;
	}

	/**
	 * set this VirtualKanbanController to something else
	 * @param virtualKanbanController virtualKanbanController to be change
	 */

	public void setVirtualKanbanController(VirtualKanbanController virtualKanbanController) {
		this.virtualKanbanController = virtualKanbanController;
	}

	/**
 	 * The VirtualKanbanController object
 	 */
    private VirtualKanbanController virtualKanbanController;

    public TaskController(VirtualKanbanController VirtualKanbanController) {
    	this.virtualKanbanController= VirtualKanbanController;
    }

    /**
 	 * delete an existing task from a project
 	 * TODO: create JavaDoc. 
 	 * @param project The Project we delete the Task from
 	 * @param task The Task tu delete
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void deleteTask(Project project, Task task) throws UnsupportedOperationException {
		for(StageList list : project.getStageList()){
			if(list.getTask().contains(task)) {
				StageList taskList = project.getStageFromTask(task);
				task.setDeveloper(null);
				taskList.removeTask(task);
				return ;
			}
		}				throw new UnsupportedOperationException("task do not found");

	}

    /**
 	 * add a new task in a Project
 	 * TODO: create JavaDoc. 
 	 * @param project The Project where the task will be add
 	 * @param name the name of the Task
 	 * @param description The description of The Task
 	 * @param deadline the Time for The Task to be done
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addTask(Project project, String name, String description, LocalDateTime deadline) throws UnsupportedOperationException {
    	Task t= new Task(name,description,deadline);
		for(StageList list : project.getStageList())
		{
			if(list.getStage()== Stage.NEW && list.getTask().contains(t))
			{
				list.addTask(t);
			}else{
				throw new UnsupportedOperationException("Task already exist or Stage not found");
			}
		}
    }

    /**
 	 * add a new Note to an existing Task
 	 * TODO: create JavaDoc. 
 	 * @param task where the Note will be add
 	 * @param note to add
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addNote(Task task, Note note) throws UnsupportedOperationException {
    	if(!task.getNote().contains(note)){
    		task.getNote().add(note);
		}
    	else {
			throw new UnsupportedOperationException("Note already exist");
		}
    }

    /**
 	 *  start a new Task
 	 * TODO: create JavaDoc. 
 	 * @param task to start
 	 * @param project The project where the Task  start
 	 * @param developer The developer who start the Task
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void startTask(Task task, Project project, Developer developer) throws UnsupportedOperationException {
    	if(!task.isInProgress())
		{
			task.setDeveloper(developer);
			developer.setAtWork(true);
			CompletedStage cs = new CompletedStage(task,Stage.NEW);
			developer.setCurrentTaskStage(cs);
			//project.moveTaskForeward(task);
		} else {
			throw new UnsupportedOperationException("task already start");
		}
    }

    /**
 	 *task to finish
 	 * TODO: create JavaDoc. 
 	 * @param task The task to be finish
 	 * @param project the Project of the Task
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void finishTask(Task task, Project project) throws UnsupportedOperationException {
    	if(task.isInProgress())
		{
			task.getDeveloper().addCompletedStage();
			task.setDeveloper(null);
			project.moveTaskForeward(task);
		}
    	else {
			throw new UnsupportedOperationException("task can't be finished");
		}
    }

    /**
 	 * drop The Task back
 	 * TODO: create JavaDoc. 
 	 * @param task The Task to be drop
 	 * @param project The Project of the Task
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void dropTask(Task task, Project project) throws UnsupportedOperationException {
    	if(task.isInProgress())
		{
			project.moveTaskBackward(task);
			task.getDeveloper().setAtWork(false);
			task.getDeveloper().setCurrentTaskStage(null);
			task.setDeveloper(null);
		}
    	else
    		{
			throw new UnsupportedOperationException("the Task ist not in progress");
		}
    }

    /**
 	 * show all notes from a Task
 	 * TODO: create JavaDoc. 
 	 * @param task The task with Notes
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public ArrayList<Note> showNotes(Task task) throws UnsupportedOperationException {

    	 return task.getNote();
    }
}
