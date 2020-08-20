package controller;

import model.*;
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
     * Tests the createProject() method with a correct project
     */
    @Test
    public void testCreateProjectSuccessful() {
        Project project = pc.createProject("testName", LocalDateTime.now(), new Team("testTeam"), "testDescription");
        assertTrue(pc.getVirtualKanbanController().getVirtualKanban().getProject().contains(project));
    }

    /**
     * Tests the createProject() method with a project without a name
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateProjectUnsuccessfulNull() {
        pc.createProject(null, LocalDateTime.now(), new Team("testTeam"), "testDescription");
    }

    /**
     * Tests the createProject() method with a project that has the same name as another project
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateProjectUnsuccessfulAlreadyExisting() {
        pc.createProject("testName", LocalDateTime.now(), new Team("testTeam"), "testDescription");
        pc.createProject("testName", LocalDateTime.now(), new Team("testTeam"), "testDescription");
    }

    /**
     * Tests the archiveProject() method
     */
    @Test
    public void testArchiveProject() {
        Project project = pc.createProject("testName", LocalDateTime.now(), new Team("testTeam"), "testDescription");
        pc.archiveProject(project);
        for (StageList list : project.getStageList()){
            if(list.getStage()== Stage.ANALYSE_IN_PROGRESS){
                assertTrue(list.getTask().isEmpty());
            }
            if(list.getStage()==Stage.IMPLEMENTATION_IN_PROGRESS){
                assertTrue(list.getTask().isEmpty());
            }
            if(list.getStage()==Stage.TEST_IN_PROGRESS){
                assertTrue(list.getTask().isEmpty());
            }
        }
        for (Developer developer: project.getTeam().getDevelopers()){
            assertFalse(developer.isAtWork());
        }
        assertTrue(project.isReadOnly());
    }

    /**
     * Tests the deleteProject() method
     */
    @Test
    public void testDeleteProject() {
        Project project = pc.createProject("testName", LocalDateTime.now(), new Team("testTeam"), "testDescription");
        pc.deleteProject(project);
        assertFalse(pc.getVirtualKanbanController().getVirtualKanban().getProject().contains(project));
    }
}