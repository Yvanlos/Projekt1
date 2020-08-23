package controller;

import model.*;

import java.time.LocalDateTime;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * ths class allows to add, delete start, drop or finish tasks as well as add notes to a task
 */
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

	/**
	 * The TaskController constructor.
	 * @param virtualKanbanController reference to the main-controller
	 */
    public TaskController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController= virtualKanbanController;
    }

    /**
 	 * delete an existing task from a project
 	 * @param project The Project we delete the Task from
 	 * @param task The Task tu delete
 	 * @throws NoSuchElementException
 	 *	 	 	is thrown if a task should be deleted which does not exist in tha given project
 	 */
    public void deleteTask(Project project, Task task) throws NoSuchElementException {
		for(StageList list : project.getStageList()){
			if(list.getTask().contains(task)) {
				StageList taskList = project.getStageFromTask(task);
				task.setDeveloper(null);
				taskList.removeTask(task);
				return ;
			}
		}
		throw new NoSuchElementException("task do not found");
	}

    /**
 	 * add a new task in a Project
 	 * @param project The Project where the task will be add
 	 * @param name the name of the Task
 	 * @param description The description of The Task
 	 * @param deadline the Time for The Task to be done
 	 * @throws IllegalArgumentException
 	 *	 	 	is thrown if a task should be added which already exists inside the project
 	 */
    public void addTask(Project project, String name, String description, LocalDateTime deadline) throws IllegalArgumentException {
    	Task task= new Task(name,description,deadline);
//		for(StageList list : project.getStageList())
//		{
//			if(list.getStage()== Stage.NEW && !list.getTask().contains(t))
//			{
//				list.addTask(t);
//				return ;
//			}
//			else {
//				throw new IllegalArgumentException("Task already exist or Stage not found");
//			}
//		}
		for(StageList list : project.getStageList()){
			boolean containsTask = false;
			for(Task listTask : list.getTask()){
				if(listTask.getName().equals(name)) {
					containsTask = true;
					break;
				}
			}
			if(list.getStage()== Stage.NEW && !containsTask){
				list.addTask(task);
				return;
			}
		}
		throw new IllegalArgumentException("Task already exist or Stage not found");
    }

    /**
 	 * add a new Note to an existing Task
 	 * @param task where the Note will be add
 	 * @param note to add
 	 * @throws IllegalArgumentException
 	 *	 	 	is thrown if a note should be added to a task which already has such note
 	 */
    public void addNote(Task task, Note note) throws IllegalArgumentException {
    	if(!task.getNote().contains(note)){
    		task.getNote().add(note);
		}
    	else {
			throw new IllegalArgumentException("Note already exist");
		}
    }

    /**
 	 *  start a new Task
 	 * @param task to start
 	 * @param project The project where the Task  start
 	 * @param developer The developer who start the Task
 	 * @throws IllegalArgumentException
 	 *	 	 	is thrown if a task which is already in work should be started
 	 */
    public void startTask(Task task, Project project, Developer developer) throws IllegalArgumentException {
    	if(!task.isInProgress())
		{
			task.setDeveloper(developer);
			developer.setAtWork(true);
			CompletedStage cs = new CompletedStage(task,getStageFromTask(task,project).next());
			developer.setCurrentTaskStage(cs);
			project.moveTaskForeward(task);
		} else {
			throw new IllegalArgumentException("task already in work");
		}
    }

	/**
	 *
	 * @param task the task for which the Stage is searched
	 * @param project the project which contains the task
	 * @return Stage the enum of the Stage which contains the task
	 * @throws NoSuchElementException
	 * 			is thrown if the task is not part of any Stagelist
	 */
	public Stage getStageFromTask(Task task,Project project) throws NoSuchElementException{
    	for(StageList stageList : project.getStageList()) {
    		if(stageList.getTask().contains(task)){
    			return stageList.getStage();
    		}
		}
		throw new NoSuchElementException("Task is not part of any StageList");
	}

    /**
 	 *task to finish
 	 * @param task The task to be finish
 	 * @param project the Project of the Task
 	 * @throws IllegalArgumentException
 	 *	 	 	is thrown if task which is not in work should be finished
 	 */
    public void finishTask(Task task, Project project) throws IllegalArgumentException {
    	if(task.isInProgress())
		{
			task.getDeveloper().addCompletedStage();
			task.getDeveloper().setCurrentTaskStage(null);
			task.getDeveloper().setAtWork(false);
			task.setDeveloper(null);
			project.moveTaskForeward(task);
		}
    	else {
			throw new IllegalArgumentException("task can't be finished");
		}
    }

    /**
 	 * drop The Task back
 	 * @param task The Task to be drop
 	 * @param project The Project of the Task
 	 * @throws NoSuchElementException
 	 *	 	 	is thrown if task which is not in work should be droped
 	 */
    public void dropTask(Task task, Project project) throws NoSuchElementException {
    	if(task.isInProgress())
		{
			project.moveTaskBackward(task);
			task.getDeveloper().setAtWork(false);
			task.getDeveloper().setCurrentTaskStage(null);
			task.setDeveloper(null);
		}
    	else
    		{
			throw new NoSuchElementException("the Task ist not in progress");
		}
    }

    /**
 	 * show all notes from a Task
 	 * @param task The task with Notes
	 * @return ArrayList of notes
 	 */
    public ArrayList<Note> showNotes(Task task) {
    	 return task.getNote();
    }
}
