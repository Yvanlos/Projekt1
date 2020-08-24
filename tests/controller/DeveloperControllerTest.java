package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * tests the DeveloperController
 */
public class DeveloperControllerTest {

    /**
     * tests the createDeveloper(team, name, URI) method
     */
    @Test
    public void testCreateDeveloper() {
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        Team testTeam = new Team("testTeam");
        vkc.getVirtualKanban().getTeam().add(testTeam);
        developerController.createDeveloper(testTeam, "testdev", null);
        developerController.createDeveloper(testTeam, "testdev", null);
        developerController.createDeveloper(testTeam, "testdev", null);
        developerController.createDeveloper(testTeam, "testdev1", null);
        developerController.createDeveloper(testTeam, "testdev1", null);
        developerController.createDeveloper(testTeam, "difftestdev", null);
        assertFalse(testTeam.getDevelopers().isEmpty());
        assertNotEquals(testTeam.getDevelopers().get(0).getName(),testTeam.getDevelopers().get(1).getName());
        assertNotEquals(testTeam.getDevelopers().get(0).getName(),testTeam.getDevelopers().get(2).getName());
        assertNotEquals(testTeam.getDevelopers().get(1).getName(),testTeam.getDevelopers().get(3).getName());
    }

    /**
     * tests createDeveloper with empty name
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCreateDeveloper2() {
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        Team testTeam = new Team("testTeam");
        vkc.getVirtualKanban().getTeam().add(testTeam);
        developerController.createDeveloper(testTeam, "", null);
    }

    /**
     * tests the method nameAlreadyExists
     */
    @Test
    public void testNameAlreadyExists() {
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        Team testTeam = new Team("testTeam");
        assertFalse(developerController.nameAlreadyExists(testTeam,"testdev"));
        developerController.createDeveloper(testTeam, "testdev", null);
        assertTrue(developerController.nameAlreadyExists(testTeam,"testdev"));
        assertFalse(developerController.nameAlreadyExists(testTeam,"testdev1"));
    }

    /**
     * tests the deleteDeveloper(developer) method
     */
    @Test
    public void testDeleteDeveloper() {
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        TaskController taskController = new TaskController(vkc);
        Team testTeam = new Team("testTeam");
        Team testTeam2 = new Team("testTeam2");
        Project testProj = new Project("testProj", "this is at test", LocalDateTime.MAX, testTeam);
        Task testTask = new Task("testTask", "this is a test",LocalDateTime.MAX);
        Developer testDev = new Developer("testDev", null);
        Developer testDev2 = new Developer("testDev2", null);
        CompletedStage testStage = new CompletedStage(testTask, Stage.ANALYSE_IN_PROGRESS);
        testDev.setCurrentTaskStage(testStage);
        testTeam.getDevelopers().add(testDev);
        testTeam2.getDevelopers().add(testDev2);
        vkc.getVirtualKanban().getProject().add(testProj);
        vkc.getVirtualKanban().getTeam().add(testTeam);
        vkc.getVirtualKanban().getTeam().add(testTeam2);
        testProj.getStageList().get(1).addTask(testTask);
        testTask.setDeveloper(testDev);
        testDev.setAtWork(true);
        developerController.deleteDeveloper(testDev2);
        developerController.deleteDeveloper(testDev);

        assertFalse(testTeam.getDevelopers().contains(testDev));
        assertFalse(testTeam2.getDevelopers().contains(testDev2));
        assertFalse(testProj.getStageList().get(1).getTask().contains(testTask));
        assertTrue(testProj.getStageList().get(0).getTask().contains(testTask));

    }

    /**
     * tests the changeTeam(developer, team) method
     */
    @Test
    public void testChangeTeam() {
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        TaskController taskController = new TaskController(vkc);
        Team testTeam1 = new Team("testTeam1");
        Team testTeam2 = new Team("testTeam2");
        Project testProj = new Project("testProj", "this is at test", LocalDateTime.MAX, testTeam1);
        Task testTask = new Task("testTask", "this is a test",LocalDateTime.MAX);
        Developer testDev = new Developer("testDev", null);
        Developer testDev2 = new Developer("testDev2", null);
        CompletedStage testStage = new CompletedStage(testTask, Stage.ANALYSE_IN_PROGRESS);
        testDev.setCurrentTaskStage(testStage);
        testTeam1.getDevelopers().add(testDev);
        testTeam2.getDevelopers().add(testDev2);
        vkc.getVirtualKanban().getProject().add(testProj);
        vkc.getVirtualKanban().getTeam().add(testTeam1);
        vkc.getVirtualKanban().getTeam().add(testTeam2);
        testProj.getStageList().get(1).addTask(testTask);
        testTask.setDeveloper(testDev);
        testDev.setAtWork(true);
        developerController.changeTeam(testDev, testTeam2);
        developerController.changeTeam(testDev2, testTeam1);

        assertFalse(testTeam1.getDevelopers().contains(testDev));
        assertTrue(testTeam2.getDevelopers().contains(testDev));
        assertFalse(testTeam2.getDevelopers().contains(testDev2));
        assertTrue(testTeam1.getDevelopers().contains(testDev2));
        assertFalse(testProj.getStageList().get(1).getTask().contains(testTask));
        assertTrue(testProj.getStageList().get(0).getTask().contains(testTask));
    }

    /**
     * tests the help method getProjectFromTask(task)
     */
    @Test
    public void testGetProjectFromTask() {
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        ProjectController pc = vkc.getProjectController();
        TeamController tc = vkc.getTeamController();
        TaskController taskController = vkc.getTaskController();
        Team testTeam1 = new Team("testTeam1");
        Team testTeam2 = new Team("testTeam2");
        Project testProj1 = new Project("testProj", "this is at test", LocalDateTime.MAX, testTeam1);
        Project testProj2 = new Project("testProj", "this is at test", LocalDateTime.MAX, testTeam2);
        Task testTask = new Task("testTask", "this is a test",LocalDateTime.MAX);
        vkc.getVirtualKanban().getProject().add(testProj1);
        vkc.getVirtualKanban().getProject().add(testProj2);
        vkc.getVirtualKanban().getTeam().add(testTeam1);
        vkc.getVirtualKanban().getTeam().add(testTeam2);
        testProj1.getStageList().get(1).addTask(testTask);

        assertEquals(developerController.getProjectFromTask(testTask), testProj1);
    }

    /**
     * tests the getProjectFromTask method with a unallowed task
     */
    @Test (expected = NoSuchElementException.class)
    public void testGetProjectFromTask2(){
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        ProjectController pc = vkc.getProjectController();
        TeamController tc = vkc.getTeamController();
        TaskController taskController = vkc.getTaskController();
        Task testTask = new Task("testTask", "this is a test",LocalDateTime.MAX);
        Team testTeam1 = new Team("testTeam1");
        Project testProj1 = new Project("testProj", "this is at test", LocalDateTime.MAX, testTeam1);
        vkc.getVirtualKanban().getProject().add(testProj1);
        vkc.getVirtualKanban().getTeam().add(testTeam1);
        developerController.getProjectFromTask(testTask);
    }


    /**
     * tests the method getDeveloperList()
     */
    @Test
    public void testgetDeveloperList(){
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        TaskController taskController = new TaskController(vkc);
        Team testTeam1 = new Team("testTeam1");
        Team testTeam2 = new Team("testTeam2");
        Developer testDev = new Developer("testDev", null);
        Developer testDev2 = new Developer("testDev2", null);
        testTeam1.getDevelopers().add(testDev);
        testTeam2.getDevelopers().add(testDev2);
        vkc.getVirtualKanban().getTeam().add(testTeam1);
        vkc.getVirtualKanban().getTeam().add(testTeam2);
        ArrayList<Developer> devList = new ArrayList<>();
        devList.add(testDev);
        devList.add(testDev2);

        assertEquals(devList,developerController.getDeveloperList());
    }
}