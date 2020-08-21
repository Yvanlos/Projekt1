package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

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
        developerController.createDeveloper(testTeam, "testdev2", null);
        developerController.createDeveloper(testTeam, "testdev2", null);

        assertFalse(testTeam.getDevelopers().isEmpty());
        assertNotEquals(testTeam.getDevelopers().get(0).getName(),testTeam.getDevelopers().get(1).getName());
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
        Project testProj = new Project("testProj", "this is at test", LocalDateTime.MAX, testTeam);
        Task testTask = new Task("testTask", "this is a test",LocalDateTime.MAX);
        Developer testDev = new Developer("testDev", null);
        CompletedStage testStage = new CompletedStage(testTask, Stage.ANALYSE_IN_PROGRESS);
        testDev.setCurrentTaskStage(testStage);
        testTeam.getDevelopers().add(testDev);
        vkc.getVirtualKanban().getProject().add(testProj);
        vkc.getVirtualKanban().getTeam().add(testTeam);
        testProj.getStageList().get(1).addTask(testTask);
        testTask.setDeveloper(testDev);
        testDev.setAtWork(true);
        developerController.deleteDeveloper(testDev);

        assertFalse(testTeam.getDevelopers().contains(testDev));
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
        CompletedStage testStage = new CompletedStage(testTask, Stage.ANALYSE_IN_PROGRESS);
        testDev.setCurrentTaskStage(testStage);
        testTeam1.getDevelopers().add(testDev);
        vkc.getVirtualKanban().getProject().add(testProj);
        vkc.getVirtualKanban().getTeam().add(testTeam1);
        vkc.getVirtualKanban().getTeam().add(testTeam2);
        testProj.getStageList().get(1).addTask(testTask);
        testTask.setDeveloper(testDev);
        testDev.setAtWork(true);
        developerController.changeTeam(testDev, testTeam2);

        assertFalse(testTeam1.getDevelopers().contains(testDev));
        assertTrue(testTeam2.getDevelopers().contains(testDev));
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
}