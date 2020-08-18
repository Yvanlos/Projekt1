package model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.lang.UnsupportedOperationException;

public class Task {

    /**
 	 * 
 	 */
    private String name;

    /**
 	 * 
 	 */
    private String description;

    /**
 	 * 
 	 */
    private LocalDateTime deadline;

    /**
 	 * 
 	 */
    private LocalDateTime creationDate;

    /**
 	 * 
 	 */
    private Collection<Note> note;

    /**
 	 * 
 	 */
    private Developer developer;

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @return boolean
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public boolean isInProgress() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param note
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addNote(Note note) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param note
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void removeNote(Note note) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
