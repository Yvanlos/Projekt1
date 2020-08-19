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
	 * Constructs a new project with a name, a description, a deadline and an assigned team.
	 * @param name name of the project
	 * @param description description of the project
	 * @param deadline deadline of the project
	 * @param team assigned team of the project
	 */
	public Project(String name, String description, LocalDateTime deadline, Team team) {
		this.name = name;
		this.description = description;
		this.deadline = deadline;
		this.team = team;
	}

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

	/**
	 * Returns the name of the project.
	 * @return name of the project
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the start date of the project.
	 * @return start date of the project
	 */
	public LocalDateTime getStartdate() {
		return startdate;
	}

	/**
	 * Returns the description of the project.
	 * @return description of the project
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the deadline of the project.
	 * @return deadline of the project
	 */
	public LocalDateTime getDeadline() {
		return deadline;
	}

	/**
	 * Returns if the project can be worked on.
	 * @return false, if the project is editable; true, if the project is not editable
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * Returns the assigned team of the project.
	 * @return assigned team of the project
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Returns all stage lists of the project in a collection.
	 * @return collection of the stage lists
	 */
	public Collection<StageList> getStageList() {
		return stageList;
	}

	/**
	 * Replaces the name of the project with the specified one.
	 * @param name new name of the project
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Replaces the start date of the project with the specified one.
	 * @param startdate new start date of the project
	 */
	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}

	/**
	 * Replaces the description of the project with the specified one.
	 * @param description new description of the project
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Replaces the deadline of the project with the specified one.
	 * @param deadline new deadline of the project
	 */
	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	/**
	 * Edits the status of the project.
	 * @param readOnly new status of the project
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * Replaces the assigned team of the project with the specified one.
	 * @param team new assigned team of the project
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * Replaces the collection of stage lists of the project with the specified collection.
	 * @param stageList new stage lists of the project
	 */
	public void setStageList(Collection<StageList> stageList) {
		this.stageList = stageList;
	}
}
