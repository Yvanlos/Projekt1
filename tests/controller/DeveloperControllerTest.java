package controller;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import model.Developer;

import static org.junit.Assert.*;

public class DeveloperControllerTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createDeveloper() {
        VirtualKanbanController vkc;
        DeveloperController developerController;
        ProjectController pc;
        TeamController tc;
        vkc = new VirtualKanbanController();
        developerController = new DeveloperController(vkc);
        pc = new ProjectController(vkc);
        tc = new TeamController(vkc);
        tc.createTeam("testTeam1");
        pc.createProject("testproj1", LocalDateTime.MAX,vkc.getVirtualKanban().getTeam().get(0),"the first test project");

        developerController.createDeveloper(vkc.getVirtualKanban().getTeam().get(0), "testDev1", null);
        assertFalse(vkc.getVirtualKanban().getTeam().get(0).getDevelopers().isEmpty());



    }

    @Test
    public void deleteDeveloper() {
        VirtualKanbanController vkc;
        DeveloperController developerController;
        ProjectController pc;
        TeamController tc;
        vkc = new VirtualKanbanController();
        developerController = new DeveloperController(vkc);
        pc = new ProjectController(vkc);
        tc = new TeamController(vkc);
        tc.createTeam("testTeam1");
        developerController.createDeveloper(vkc.getVirtualKanban().getTeam().get(0), "testDev1", null);
        pc.createProject("testproj1", LocalDateTime.MAX,vkc.getVirtualKanban().getTeam().get(0),"the first test project");
        Developer dev = vkc.getVirtualKanban().getTeam().get(0).getDevelopers().get(0);

        developerController.deleteDeveloper(dev);
        assertTrue(vkc.getVirtualKanban().getTeam().get(0).getDevelopers().isEmpty());
    }

    @Test
    public void changeTeam() {
        VirtualKanbanController vkc;
        DeveloperController developerController;
        ProjectController pc;
        TeamController tc;
        vkc = new VirtualKanbanController();
        developerController = new DeveloperController(vkc);
        pc = new ProjectController(vkc);
        tc = new TeamController(vkc);
        tc.createTeam("testTeam1");
        tc.createTeam("testTeam2");
        developerController.createDeveloper(vkc.getVirtualKanban().getTeam().get(0), "testDev1", null);
        pc.createProject("testproj1", LocalDateTime.MAX,vkc.getVirtualKanban().getTeam().get(0),"the first test project");
        pc.createProject("testproj2", LocalDateTime.MAX,vkc.getVirtualKanban().getTeam().get(0),"the second test project");

        developerController.changeTeam(vkc.getVirtualKanban().getTeam().get(0).getDevelopers().get(0), vkc.getVirtualKanban().getTeam().get(1));
        assertTrue(vkc.getVirtualKanban().getTeam().get(0).getDevelopers().isEmpty());
        assertFalse(vkc.getVirtualKanban().getTeam().get(1).getDevelopers().isEmpty());


    }

    @Test
    public void getProjectFromTask() {
    }
}