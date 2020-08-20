package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class models a task and manages its assigned developer and notes
 */
public class Task {

	/**
	 * Name of the task
	 */
	private String name;

	/**
	 * Description of the task
	 */
	private String description;

	/**
	 * Deadline of the task
	 */
	private LocalDateTime deadline;

	/**
	 * Time at which the task was created
	 */
	private LocalDateTime creationDate;

	/**
	 * Collection of the notes of the task
	 */
	private ArrayList<Note> notes;

	/**
	 * Developer which is assigned to the task
	 */
	private Developer developer;

	/**
	 * constructs a new task
	 *
	 * @param name the name of the task
	 * @param description the description of the task
	 * @param deadline the deadline of the task
	 */
	public Task(String name, String description, LocalDateTime deadline) {
		this.name = name;
		this.description = description;
		this.deadline = deadline;
		this.creationDate = LocalDateTime.now();
		this.notes = new ArrayList<>();
		this.developer = null;
	}

	/**
	 *
	 * @return String the name of the task
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @return String the description of the task
	 */
	public String getDescription() {
		return description;
	}

	/**
	 *
	 * @return LocalDateTime the deadline of the task
	 */
	public LocalDateTime getDeadline() {
		return deadline;
	}

	/**
	 *
	 * @return LocalDateTime the time at which the task was created
	 */
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 *
	 * @return ArrayList<Note> the collection of notes attached to the task
	 */
	public ArrayList<Note> getNote() {
		return notes;
	}

	/**
	 *
	 * @return the developer which is currently assigned to the task
	 */
	public Developer getDeveloper() {
		return developer;
	}

	/**
	 *
	 * @param developer to be assigned to the task
	 */
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	/**
	 * Returns whether the task is currently assigned to a developer
	 *
	 * @return boolean true if the task is currently assigned to a developer
	 */
	public boolean isInProgress(){
		return developer != null;
	}

	/**
	 * Adds a note to the collection of notes of the task
	 *
	 * @param note the note to be add
	 */
	public void addNote(Note note){
		notes.add(note);
	}

	/**
	 * Removes a note from the collection of notes of the task
	 *
	 * @param note the note to be removed
	 */
	public void removeNote(Note note){
		notes.remove(note);
	}
}
