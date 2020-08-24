package model;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Tests the Task class
 */
public class TaskTest {
    Task task;
    private URI profilePicture;

    /**
     * Sets up a clean testing environment before every test.
     * @throws Exception Gets thrown if setting up clean environment was unsuccessful.
     */
    @Before
    public void setUp() throws Exception {
        task = new Task("testTask","testDescription", LocalDateTime.now());

       // task.getNote()= new Note("test", "TestContent", LocalDateTime.now());
    }

    /**
     * test getName()
     */

    @Test
    public void testGetName() {
        assertEquals("testTask",task.getName());
    }

    /**
     * test getDescription()
     */

    @Test
    public void testGetDescription() {
        assertEquals("testDescription", task.getDescription());
    }

    /**
     * test getDeadline()
     */

    @Test
    public void testGetDeadline() {
    	LocalDateTime creationDate = task.getDeadline();
    	Duration duration = Duration.between(creationDate, LocalDateTime.now());
    	assertTrue(duration.getSeconds() < 2);
    }

    /**
     * test getCreationdate()
     */

    @Test
    public void testGetCreationDate() {
    	LocalDateTime creationDate = task.getCreationDate();
    	Duration duration = Duration.between(creationDate, LocalDateTime.now());
    	assertTrue(duration.getSeconds() < 2);
    }

    /**
     * test getNote()
     */

    @Test
    public void testGetNote() {
        Note note = new Note("test", "TestContent", LocalDateTime.now());
        task.addNote(note);
        assertEquals(note, task.getNote().get(0));
    }

    /**
     * Tests the getDeveloper() method
     */
    @Test
    public void testGetDeveloper() {
        Developer dev= new Developer("yo",URI.create("testURI"));
        task.setDeveloper(dev);
        assertEquals(dev,task.getDeveloper());
    }

    /**
     * Tests the setDeveloper() method
     */
    @Test
    public void setDeveloper() {
    }

    /**
     * Tests the isInProgress() method
     */
    @Test
    public void isInProgress() {
        Developer dev = new Developer("TestIsAtWork", profilePicture);
        task.setDeveloper(dev);
        dev.setAtWork(true);
        assertEquals(task.isInProgress(), true);
        task.setDeveloper(null);
        dev.setAtWork(false);
        assertEquals(task.isInProgress(), false);
    }

    /**
     * Tests the addNote() method
     */
    @Test
    public void addNote() {
        Note note = new Note("testAddNote", "TestContent", LocalDateTime.now());
        task.addNote(note);
        assertTrue(task.getNote().contains(note));
    }

    /**
     * Tests the removeNote() method
     */
    @Test
    public void removeNote() {
        Note note = new Note("test", "TestContent", LocalDateTime.now());
        task.addNote(note);
        task.removeNote(note);
        assertTrue(!task.getNote().contains(note));
    }
}