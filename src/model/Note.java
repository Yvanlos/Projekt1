package model;

import java.time.LocalDateTime;
import java.lang.UnsupportedOperationException;

/**
 * This class models a note that can be added to a task as a comment.
 */
public class Note {

    /**
 	 * The name or subject of the note.
 	 */
    private String name;

    /**
 	 * The content of the note.
 	 */
    private String content;

    /**
 	 * The time the note was created at.
 	 */
    private LocalDateTime creationDate;
}
