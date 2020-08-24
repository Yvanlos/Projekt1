package controller;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import model.Project;
import model.Team;

/**
 * Tests the TeamController class
 */
public class TeamControllerTest {

	VirtualKanbanController virtualKanbanController;

	/**
	 * Sets up a clean testing environment before every test.
	 * @throws Exception Gets thrown if setting up clean environment was unsuccessful.
	 */
	@Before
	public void setUp() throws Exception {
		virtualKanbanController = new VirtualKanbanController();
	}

	/**
	 * Tests the constructor and fails if an exception is thrown.
	 */
	@Test
	public void testTeamController() {
		new TeamController(new VirtualKanbanController());
	}

	
	/**
	 * Tests the methods createTeam(String) and deleteTeam(Team)
	 */
	@Test
	public void testCreateTeam() {
		TeamController teamController = virtualKanbanController.getTeamController();
		teamController.createTeam("TestTeam");
		
		assertFalse(virtualKanbanController.getVirtualKanban().getTeam().isEmpty());
		
		Team newTeam = virtualKanbanController.getVirtualKanban().getTeam().get(0);
		
		assertEquals(newTeam.getName() , "TestTeam");
		
		virtualKanbanController.getProjectController().createProject("Testname", LocalDateTime.now(), newTeam, "This is a test");
		
		Project testProject = virtualKanbanController.getVirtualKanban().getProject().get(0);
		
		virtualKanbanController.getProjectController().archiveProject(testProject);
		
		teamController.deleteTeam(newTeam);
		
		assertTrue(virtualKanbanController.getVirtualKanban().getTeam().isEmpty());
	}
	
	/**
	 * Tests the method deleteTeam(Team)
	 */
	@Test(expected = NoSuchElementException.class)
	public void testDeleteTeam() {
		TeamController teamController = virtualKanbanController.getTeamController();
		Team testTeam = new Team("notInList");
		teamController.deleteTeam(testTeam);
	}

}
