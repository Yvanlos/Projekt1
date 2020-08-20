package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StageListTest {

    private StageList testClass;

    @Before
    public void setUp() {
        testClass = new StageList(Stage.NEW);
    }

    @Test
    public void testConstructorAndGetStage() {
        assertEquals(Stage.NEW, testClass.getStage());
        assertEquals(new ArrayList<Task>(), testClass.getTask());
    }

    @Test
    public void addAndGetTask() {
        Task t = new Task("Test", "TestDescription", LocalDateTime.now());
        testClass.addTask(t);
        assertTrue(testClass.getTask().contains(t));
    }

    @Test
    public void testRemoveTask() {
        Task t = new Task("Test", "TestDescription", LocalDateTime.now());
        testClass.addTask(t);
        testClass.removeTask(t);
        assertEquals(0, testClass.getTask().size());
    }

    @Test
    public void testSetTask() {
        ArrayList<Task> c = new ArrayList<>();
        testClass.setTask(c);
        assertEquals(c, testClass.getTask());
    }

}