package model;

import java.time.LocalDateTime;
import java.lang.UnsupportedOperationException;

public class CompletedStage {

    /**
 	 * time at which the devloper started the task
 	 */
    private LocalDateTime startDate;

    /**
 	 * time at which the developer finished the task
 	 */
    private LocalDateTime completionDate;

    /**
 	 * the task the developer is/was working on
 	 */
    private Task task;

    /**
 	 * the stage of Kanban in which the task was while the developer worked on it
 	 */
    private Stage stage;

	/**
	 * creates a CompletedStage, sets the startDate to the actual Date
	 * @param task the task the developer is going to work on
	 * @param stage the stage in which the that task is
	 */
	public CompletedStage(Task task, Stage stage) {
		this.task = task;
		this.stage = stage;
		this.startDate = LocalDateTime.now();
	}

	/**
	 * returns the startdate
	 * @return startDate the date of begin of the task progress
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}

	/**
	 * returns the completiondate
	 * @return completionDate the date of end of the task progress
	 */
	public LocalDateTime getCompletionDate() {
		return completionDate;
	}

	/**
	 * sets the CompletionDate to the actual date
	 *
	 */
	public void setCompletionDate() {
		this.completionDate = LocalDateTime.now();
	}

	/**
	 * sets teh completiondate to a given date
	 * @param completionDate the date of end of the task progress
	 */
	public void setCompletionDate(LocalDateTime completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * returns the task of the progress
	 * @return task the task which is or was in progress
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * returns the stage
	 * @return the stage in which the developer worked on the task
	 */
	public Stage getStage() {return stage;}

}
