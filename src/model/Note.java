package model;

import java.time.LocalDateTime;

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

    /**
     * Constructs a note with the specified name, content and date.
     * @param name name of the note
     * @param content content of the note
     * @param creationDate creation date of the note
     */
    public Note(String name, String content, LocalDateTime creationDate) {
        this.name = name;
        this.content = content;
        this.creationDate = creationDate;
    }

    /**
     * Returns the name of the note.
     * @return name of the note
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the content of the note.
     * @return content of the note
     */
    public String getContent() {
        return content;
    }

    /**
     * Returns the creation date of the note.
     * @return creation date of the note
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Replaces the current name of the note with the specified one.
     * @param name new name of the note
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Replaces the current content of the note with the specified one.
     * @param content new content of the note
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * Replaces the current creation date of the note with the specified one.
     * @param creationDate new creation date of the note
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
