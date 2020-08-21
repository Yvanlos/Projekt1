package model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class models a specific stage a task is in.
 */
public class StageList implements Serializable {

    /**
 	 * The list of tasks that currently belong to this stage.
 	 */
    private ArrayList<Task> task;

    /**
 	 * The enum that defines the stage.
 	 */
    private Stage stage;

	/**
	 * Constructs a stage list with the specified task collection and stage.
	 * @param stage the stage of the stage list
	 */
	public StageList(Stage stage) {
		this.task = new ArrayList<>();
		this.stage = stage;
	}

	/**
 	 * Adds the task to the stage, if the task not already in it and does not currently belong to a stage that is not previous or next one.
 	 *
 	 * @param task the task that is added to the stage
 	 */
    public void addTask(Task task) {
        this.task.add(task);
    }

    /**
 	 * Removes the task from the stage, if the task is currently in it.
 	 *
 	 * @param task the task that is removed from the stage
 	 */
    public void removeTask(Task task) {
        this.task.remove(task);
    }

	/**
	 * Returns the collections of tasks.
	 * @return collection of tasks
	 */
	public ArrayList<Task> getTask() {
		return task;
	}

	/**
	 * Returns the stage of the stage list.
	 * @return the stage of the stage list
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * Replaces the current collection of tasks with the specified collection.
	 * @param task collection to be saved
	 */
	public void setTask(ArrayList<Task> task) {
		this.task = task;
	}

	/**
	 * Replaces the the current stage with the specified stage.
	 * @param stage stage to be set to
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
