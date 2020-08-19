package controller;

import model.Project;
import model.Team;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ProjectControllerTest {

    ProjectController pc;

    /**
     * Sets up a testing environment by creating a project controller
     * @throws Exception if the creation was unsuccessful
     */
    @Before
    public void setUp() throws Exception {
        pc = new ProjectController(new VirtualKanbanController());
    }

    /**
     * Tests the createProject() method
     */
    @Test
    public void testCreateProject() {
        Project project = pc.createProject("testName", LocalDateTime.now(), new Team(), "testDescription");
        //assertTrue(pc.getVirtualKanbanController().getVirtualKanban().getProject().contains(project));
        //needs an implemented VirtualKanbanController
    }

    /**
     * Tests the archiveProject() method
     */
    @Test
    public void testArchiveProject() {
        Project project = pc.createProject("testName", LocalDateTime.now(), new Team(), "testDescription");
        pc.archiveProject(project);
        assertTrue(project.isReadOnly());
    }

    /**
     * Tests the deleteProject() method
     */
    @Test
    public void testDeleteProject() {
        Project project = pc.createProject("testName", LocalDateTime.now(), new Team(), "testDescription");
        pc.deleteProject(project);
        //assertFalse(pc.getVirtualKanbanController().getVirtualKanban().getProject().contains(project));
        //needs an implemented VirtualKanbanController
    }
}