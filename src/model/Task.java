package model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.lang.UnsupportedOperationException;

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
    private Collection<Note> note;

    /**
 	 * Developer which is assigned to the task
 	 */
    private Developer developer;

    /**
 	 * Returns whether the task is currently assigned to a developer
 	 *
 	 * @return boolean true if the task is currently assigned to a developer
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public boolean isInProgress() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Adds a note to the collection of notes of the task
 	 *
 	 * @param note the note to be add
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public void addNote(Note note) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Removes a note from the collection of notes of the task
	 *
 	 * @param note the note to be removed
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public void removeNote(Note note) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
