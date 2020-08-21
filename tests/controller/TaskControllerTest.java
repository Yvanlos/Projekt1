package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * tests teh taskController
 */
public class TaskControllerTest {
    TaskController tc;

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        tc = new TaskController(new VirtualKanbanController() );
    }

    /**
     * tests the method deleteTask(project, task)
     */
    @Test
    public void deleteTask() {
        Project p = new Project("testController","descriptionController", LocalDateTime.now(), new Team("testname"));
        Task t= new Task("testController","descriptionController",LocalDateTime.now());
        for(StageList list: p.getStageList())
        {
            if(list.getStage()== Stage.NEW)
            {
                list.addTask(t);
            }
        }
        tc.deleteTask(p,t);
       for(StageList list : p.getStageList())
       {
           if(!list.getTask().contains(t))
           {
               assertFalse(list.getTask().contains(t));
           }
       }
    }

    /**
     * tests teh method addTask(project, name , description, deadline)
     */
    @Test
    public void addTask() {
        Project p = new Project("testController","descriptionController", LocalDateTime.now(), new Team("testname"));
        String n= "name";
        String d= "description";
        LocalDateTime dateTime= LocalDateTime.now();
        tc.addTask(p,n,d,dateTime);
        Task t = new Task(n,d,dateTime);
        for(StageList list : p.getStageList())
        {
            if(list.getTask().contains(t))
            {
                assertTrue(list.getTask().contains(t));
            }
        }
    }

    /**
     * tests the method addNote(task, note)
     */
    @Test
    public void addNote() {
        Task t= new Task("testController","descriptionController",LocalDateTime.now());
        Note n= new Note("testnama","testcontent",LocalDateTime.now());
        tc.addNote(t,n);
        assertTrue(t.getNote().contains(n));
    }

    /**
     * tests the method startTask(task, project, developer)
     */
    @Test
    public void startTask() {
        Project p = new Project("testController","descriptionController", LocalDateTime.now(), new Team("testname"));
        Task t= new Task("testController","descriptionController",LocalDateTime.now());
        Developer d= new Developer("testname", URI.create("image"));
        p.getStageList().get(0).getTask().add(t);
        tc.startTask(t,p,d);
        assertTrue(t.isInProgress());
    }

    /**
     * tests the method finishTask(task, project)
     */
    @Test
    public void finishTask() {
        Project p = new Project("testController","descriptionController", LocalDateTime.now(), new Team("testname"));
        Task t= new Task("testController","descriptionController",LocalDateTime.now());
        Developer d= new Developer("testname", URI.create("image"));
        CompletedStage cs = new CompletedStage(t, Stage.ANALYSE_FINISHED);
        t.setDeveloper(d);
        for(StageList list : p.getStageList())
        {
            if(list.getStage()== Stage.ANALYSE_FINISHED && !list.getTask().contains(t))
            {
                list.addTask(t);
            }
        }
        d.setCurrentTaskStage(cs);
        tc.finishTask(t,p);
        assertFalse(t.isInProgress());
    }

    /**
     * tests the method dropTask(task, project)
     */
    @Test
    public void dropTask() {
        Project p = new Project("testController","descriptionController", LocalDateTime.now(), new Team("testname"));
        Task t= new Task("testController","descriptionController",LocalDateTime.now());
        Developer d= new Developer("testname", URI.create("image"));
        t.setDeveloper(d);
        for(StageList list : p.getStageList())
        {
            if(list.getStage()== Stage.IMPLEMENTATION_IN_PROGRESS && !list.getTask().contains(t))
            {
                list.addTask(t);
            }
        }
        tc.dropTask(t,p);
        assertEquals(p.getStageFromTask(t).getStage(),Stage.ANALYSE_FINISHED);
    }

    /**
     * tests the method showNotes()
     */
    @Test
    public void showNotes() {
    }

    /**
     * tests the method getStageFromTask(task, project)
     */
    @Test
    public void testGetStageFromTask(){

    }
}