package controller;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import model.Team;

public class TeamControllerTest {

	VirtualKanbanController virtualKanbanController;
	
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
		assertEquals(virtualKanbanController.getVirtualKanban().getTeam().get(0).getName() , "TestTeam");
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
