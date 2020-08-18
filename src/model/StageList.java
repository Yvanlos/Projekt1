package model;

import java.util.Collection;
import java.lang.UnsupportedOperationException;

/**
 * This class models a specific stage a task is in.
 */
public class StageList {

    /**
 	 * The list of tasks that currently belong to this stage.
 	 */
    private Collection<Task> task;

    /**
 	 * The enum that defines the stage.
 	 */
    private Stage stage;

    /**
 	 * Adds the task to the stage, if the task not already in it and does not currently belong to a stage that is not previous or next one.
 	 *
 	 * @param task the task that is added to the stage
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public void addTask(Task task) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Removes the task from the stage, if the task is currently in it.
 	 *
 	 * @param task the task that is removed from the stage
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public void removeTask(Task task) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
