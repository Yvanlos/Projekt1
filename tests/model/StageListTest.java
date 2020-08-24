package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests the StageList class
 */
public class StageListTest {

    private StageList testClass;

    /**
     * Sets up a clean testing environment before every test.
     */
    @Before
    public void setUp() {
        testClass = new StageList(Stage.NEW);
    }

    /**
     * Tests the constructor and getStage() method
     */
    @Test
    public void testConstructorAndGetStage() {
        assertEquals(Stage.NEW, testClass.getStage());
        assertEquals(new ArrayList<Task>(), testClass.getTask());
    }

    /**
     * Tests the addTask() and getTask() method
     */
    @Test
    public void addAndGetTask() {
        Task t = new Task("Test", "TestDescription", LocalDateTime.now());
        testClass.addTask(t);
        assertTrue(testClass.getTask().contains(t));
    }

    /**
     * Tests the removeTask() method
     */
    @Test
    public void testRemoveTask() {
        Task t = new Task("Test", "TestDescription", LocalDateTime.now());
        testClass.addTask(t);
        testClass.removeTask(t);
        assertEquals(0, testClass.getTask().size());
    }

    /**
     * Tests the setTask() method
     */
    @Test
    public void testSetTask() {
        ArrayList<Task> c = new ArrayList<>();
        testClass.setTask(c);
        assertEquals(c, testClass.getTask());
    }

}