package controller;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import model.Developer;
import model.Task;

import static org.junit.Assert.*;

public class DeveloperControllerTest {

    /**
     * tests the createDeveloper(team, name, URI) method
     */
    @Test
    public void testCreateDeveloper() {
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        ProjectController pc = vkc.getProjectController();
        TeamController tc = vkc.getTeamController();
        tc.createTeam("testTeam1");
        pc.createProject("testproj1", LocalDateTime.MAX,
                vkc.getVirtualKanban().getTeam().get(0),"the first test project");

        developerController.createDeveloper(vkc.getVirtualKanban().getTeam().get(0), "testDev1", null);
        assertFalse(vkc.getVirtualKanban().getTeam().get(0).getDevelopers().isEmpty());



    }

    /**
     * tests the deleteDeveloper(developer) method
     */
    @Test
    public void testDeleteDeveloper() {
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        ProjectController pc = vkc.getProjectController();
        TeamController tc = vkc.getTeamController();
        TaskController taskController = vkc.getTaskController();
        tc.createTeam("testTeam1");
        developerController.createDeveloper(vkc.getVirtualKanban().getTeam().get(0), "testDev1", null);
        pc.createProject("testproj1", LocalDateTime.MAX,
                vkc.getVirtualKanban().getTeam().get(0),"the first test project");
        Developer dev = vkc.getVirtualKanban().getTeam().get(0).getDevelopers().get(0);
        //taskController.addTask(vkc.getVirtualKanban().getProject().get(0), "testTask1",
        //       "the first testTask", LocalDateTime.MAX);
        //Task testTask = vkc.getVirtualKanban().getProject().get(0).getStageList().get(0).getTask().get(0);
        //taskController.startTask(testTask, vkc.getVirtualKanban().getProject().get(0), dev);


        developerController.deleteDeveloper(dev);
        assertTrue(vkc.getVirtualKanban().getTeam().get(0).getDevelopers().isEmpty());
        //assertTrue(vkc.getVirtualKanban().getProject().get(0).getStageList().get(0).getTask().contains(testTask));
    }

    /**
     * tests the changeTeam(developer, team) method
     */
    @Test
    public void testChangeTeam() {
        VirtualKanbanController vkc = new VirtualKanbanController();
        DeveloperController developerController = vkc.getDeveloperController();
        ProjectController pc = vkc.getProjectController();
        TeamController tc = vkc.getTeamController();
        TaskController taskController = vkc.getTaskController();
        tc.createTeam("testTeam1");
        tc.createTeam("testTeam2");
        developerController.createDeveloper(vkc.getVirtualKanban().getTeam().get(0), "testDev1", null);
        pc.createProject("testproj1", LocalDateTime.MAX,
                vkc.getVirtualKanban().getTeam().get(0),"the first test project");
        //taskController.addTask(vkc.getVirtualKanban().getProject().get(0), "testTask1",
        //       "the first testTask", LocalDateTime.MAX);
        //Task testTask = vkc.getVirtualKanban().getProject().get(0).getStageList().get(0).getTask().get(0);
        //taskController.startTask(testTask, vkc.getVirtualKanban().getProject().get(0), dev);

        developerController.changeTeam(vkc.getVirtualKanban().getTeam().get(0).getDevelopers().get(0),
                vkc.getVirtualKanban().getTeam().get(1));
        assertTrue(vkc.getVirtualKanban().getTeam().get(0).getDevelopers().isEmpty());
        assertFalse(vkc.getVirtualKanban().getTeam().get(1).getDevelopers().isEmpty());
        //assertTrue(vkc.getVirtualKanban().getProject().get(0).getStageList().get(0).getTask().contains(testTask));

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
        tc.createTeam("testTeam1");
        tc.createTeam("testTeam2");
        developerController.createDeveloper(vkc.getVirtualKanban().getTeam().get(0), "testDev1", null);
        pc.createProject("testproj1", LocalDateTime.MAX,
                vkc.getVirtualKanban().getTeam().get(0),"the first test project");
        pc.createProject("testproj1", LocalDateTime.MAX,
                vkc.getVirtualKanban().getTeam().get(1),"the first test project");
        //taskController.addTask(vkc.getVirtualKanban().getProject().get(0), "testTask1",
        //       "the first testTask", LocalDateTime.MAX);
        //Task testTask = vkc.getVirtualKanban().getProject().get(0).getStageList().get(0).getTask().get(0);

        //assertTrue(developerController.getProjectFromTask(testTask).equals(vkc.getVirtualKanban().getProject().get(0)));

    }
}