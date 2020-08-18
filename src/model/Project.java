package model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.lang.UnsupportedOperationException;

/**
 * This class models a project with a deadline, an assigned team and a number of tasks in different stages.
 */
public class Project {

    /**
 	 * Name of the project.
 	 */
    private String name;

    /**
 	 * Time the project was started.
 	 */
    private LocalDateTime startdate;

    /**
 	 * Description of the project.
 	 */
    private String description;

    /**
 	 * Deadline of the project.
 	 */
    private LocalDateTime deadline;

    /**
 	 * Status of the project. When set to true the project cannot be edited anymore.
 	 */
    private boolean readOnly;

    /**
 	 * Assigned team to work on the project.
 	 */
    private Team team;

    /**
 	 * Collection of the eight stages a task can belong to.
 	 */
    private Collection<StageList> stageList;

    /**
 	 * Adds the task to the next stage and deletes it in the current stage.
	 * If the task is already in the last stage nothing happens.
 	 *
 	 * @param task the task to be moved
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public void moveTaskForeward(Task task) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Adds the task to the previous stage and deletes it in the current stage.
	 * If the task is already in the first or last stage nothing happens.
 	 *
 	 * @param task the task to be moved
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public void moveTaskBackward(Task task) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Returns the StageList the task is currently saved in.
 	 *
 	 * @param task the task that belongs to the associated StageList
 	 * @return StageList the StageList the task belongs to
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public StageList getStageFromTask(Task task) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Returns the StageList that follows after the current one.
 	 *
 	 * @param stageList the current StageList
 	 * @return StageList the following StageList
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public StageList getNextStage(StageList stageList) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Returns the StageList that is processed before the current one.
 	 *
 	 * @param stageList the current StageList
 	 * @return StageList the previous StageList
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public StageList getPreviousStage(StageList stageList) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
