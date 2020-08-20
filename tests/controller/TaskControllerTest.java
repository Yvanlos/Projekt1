package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TaskControllerTest {
    TaskController tc;

    @Before
    public void setUp() throws Exception {
        tc = new TaskController(new VirtualKanbanController() );
    }

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

    @Test
    public void addTask() {
        Project p = new Project("testController","descriptionController", LocalDateTime.now(), new Team("testname"));
        String n= "name";
        String d= "description";
        LocalDateTime dateTime= LocalDateTime.now();
        Task t = new Task(n,d,dateTime);
        tc.addTask(p,n,d,dateTime);
        for(StageList list : p.getStageList())
        {
            if(list.getTask().contains(t))
            {
                assertTrue(list.getTask().contains(t));
            }
        }
    }

    @Test
    public void addNote() {
        Task t= new Task("testController","descriptionController",LocalDateTime.now());
        Note n= new Note("testnama","testcontent",LocalDateTime.now());
        tc.addNote(t,n);
        assertTrue(t.getNote().contains(n));
    }

    @Test
    public void startTask() {
        Project p = new Project("testController","descriptionController", LocalDateTime.now(), new Team("testname"));
        Task t= new Task("testController","descriptionController",LocalDateTime.now());
        Developer d= new Developer("testname", URI.create("image"));
        tc.startTask(t,p,d);
        assertTrue(t.isInProgress());
    }

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

    @Test
    public void showNotes() {
    }
}