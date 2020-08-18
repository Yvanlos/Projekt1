package model;

import java.time.LocalDateTime;
import java.util.Collection;

public class Project {

	private String name;

	private LocalDateTime startdate;

	private String description;

	private LocalDateTime deadline;

	private boolean readOnly;

	private Team team;

	private Collection<StageList> stageList;

	public void moveTaskForeward(Task task) {

	}

	public void moveTaskBackward(Task task) {

	}

	public StageList getStageFromTask(Task task) {
		return null;
	}

	public StageList getNextStage(StageList stageList) {
		return null;
	}

	public StageList getPreviousStage(StageList stageList) {
		return null;
	}

}
