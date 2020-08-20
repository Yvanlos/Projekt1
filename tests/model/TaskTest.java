package model;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TaskTest {
    Task task;
    private URI profilePicture;


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
        assertEquals(LocalDateTime.now(),task.getDeadline());
    }

    /**
     * test getCreationdate()
     */

    @Test
    public void testGetCreationDate() {
    }

    /**
     * test getNote()
     */

    @Test
    public void testGetNote() {
        Note not = new Note("test", "TestContent", LocalDateTime.now());
        task.addNote(not);
        assertEquals(not ,task.getNote());
    }

    @Test
    public void testGetDeveloper() {
        Developer dev= new Developer("yo",URI.create("testURI"));
        task.setDeveloper(dev);
        assertEquals(dev,task.getDeveloper());
    }

    @Test
    public void setDeveloper() {
    }

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

    @Test
    public void addNote() {
        Note note = new Note("testAddNote", "TestContent", LocalDateTime.now());
        task.addNote(note);
        assertTrue(task.getNote().contains(note));
    }

    @Test
    public void removeNote() {
        Note note = new Note("test", "TestContent", LocalDateTime.now());
        task.addNote(note);
        task.removeNote(note);
        assertTrue(!task.getNote().contains(note));
    }
}