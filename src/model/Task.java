package model;

import java.time.LocalDateTime;
import java.util.Collection;

public class Task {

	private String name;

	private String description;

	private LocalDateTime deadline;

	private LocalDateTime creationDate;

	private Collection<Note> note;

	private Developer developer;

	public boolean isInProgress() {
		return false;
	}

	public void addNote(Note note) {

	}

	public void removeNote(Note note) {

	}

}
