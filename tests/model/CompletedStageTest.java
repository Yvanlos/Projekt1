package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * tests the CompletedStage Class
 */
public class CompletedStageTest {

    /**
     * tests the constructor
     */
    @Test
    public void testConstructor() {
        Task testTask = new Task("test", "this is a testtask", LocalDateTime.MIN);
        CompletedStage testCompletedStage = new CompletedStage(testTask , Stage.ANALYSE_IN_PROGRESS);
        assertEquals(testCompletedStage.getTask(),testTask);
        assertEquals(testCompletedStage.getStage(),Stage.ANALYSE_IN_PROGRESS);
        assertNotEquals(testCompletedStage.getStartDate(), null);
    }

    /**
     * tests the method getStartDate
     */
    @Test
    public void getStartDate() {
        Task testTask = new Task("test", "this is a testtask", LocalDateTime.MIN);
        CompletedStage testCompletedStage = new CompletedStage(testTask , null);
        assertNotEquals(testCompletedStage.getStartDate(), null);
    }

    /**
     *tests the method getCompletionDate()
     */
    @Test
    public void getCompletionDate() {
        CompletedStage testCompletedStage = new CompletedStage(null , null);
        testCompletedStage.setCompletionDate(LocalDateTime.now());
        assertNotEquals(testCompletedStage.getCompletionDate(), null);
    }

    /**
     *tests the method setCompletionDate()
     */
    @Test
    public void testSetCompletionDate() {
        CompletedStage testCompletedStage = new CompletedStage(null , null);
        testCompletedStage.setCompletionDate();
        assertNotEquals(testCompletedStage.getCompletionDate(), null);
    }

    /**
     *test the method setCompletionDate(date)
     */
    @Test
    public void testSetCompletionDate2() {
        CompletedStage testCompletedStage = new CompletedStage(null , null);
        testCompletedStage.setCompletionDate(LocalDateTime.MAX);
        assertEquals(testCompletedStage.getCompletionDate(), LocalDateTime.MAX);
    }

    /**
     * tests the method getTask()
     */
    @Test
    public void getTask() {
        Task testTask = new Task("test", "this is a testtask", LocalDateTime.MIN);
        CompletedStage testCompletedStage = new CompletedStage(testTask , null);
        assertEquals(testCompletedStage.getTask(),testTask);
    }

    /**
     *tests the getStage() method
     */
    @Test
    public void testGetStage() {
        Stage testStage = Stage.TEST_IN_PROGRESS;
        Task testTask = new Task("test", "this is a testtask", LocalDateTime.MIN);
        CompletedStage testCompletedStage = new CompletedStage(testTask , testStage);
        assertEquals(testCompletedStage.getStage(),testStage);
    }

}