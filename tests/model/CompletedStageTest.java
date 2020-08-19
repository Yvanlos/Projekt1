package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CompletedStageTest {


    @Test
    public void testConstructor() {
        Task testTask = new Task("test", "this is a testtask", LocalDateTime.MIN);
        CompletedStage testCompletedStage = new CompletedStage(testTask , null);
        assertEquals(testCompletedStage.getTask(),testTask);
        assertEquals(testCompletedStage.getStage(),null);
        assertEquals(testCompletedStage.getStartDate(), LocalDateTime.now());
    }

    @Test
    public void getStartDate() {
        Task testTask = new Task("test", "this is a testtask", LocalDateTime.MIN);
        CompletedStage testCompletedStage = new CompletedStage(testTask , null);
        assertEquals(testCompletedStage.getStartDate(), LocalDateTime.now());
    }

    @Test
    public void getCompletionDate() {
        CompletedStage testCompletedStage = new CompletedStage(null , null);
        testCompletedStage.setCompletionDate(LocalDateTime.now());
        assertEquals(testCompletedStage.getCompletionDate(), LocalDateTime.now());
    }

    @Test
    public void testSetCompletionDate() {
        CompletedStage testCompletedStage = new CompletedStage(null , null);
        testCompletedStage.setCompletionDate();
        assertEquals(testCompletedStage.getCompletionDate(), LocalDateTime.now());
    }

    @Test
    public void testSetCompletionDate2() {
        CompletedStage testCompletedStage = new CompletedStage(null , null);
        testCompletedStage.setCompletionDate(LocalDateTime.MAX);
        assertEquals(testCompletedStage.getCompletionDate(), LocalDateTime.MAX);
    }

    @Test
    public void getTask() {
        Task testTask = new Task("test", "this is a testtask", LocalDateTime.MIN);
        CompletedStage testCompletedStage = new CompletedStage(testTask , null);
        assertEquals(testCompletedStage.getTask(),testTask);
    }

    /*@Test
    public void testGetStage() {
        Stage testStage =
        CompletedStage testCompletedStage = new CompletedStage(testTask , testStage);
        assertEquals(testCompletedStage.getStage(),testStage);
    }*/

}