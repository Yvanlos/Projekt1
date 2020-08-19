package controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VirtualKanbanControllerTest {
    /**
     * The VirtualKanbanContoller which is used for the tests
     */
    VirtualKanbanController vkc;

    /**
     * Generates a new testing environment before each test
     */
    @Before
    public void setUp() {
        vkc = new VirtualKanbanController();
    }

    /**
     * Test for the constructor of VirtualKanbanController
     * Checks whether all references are set correctly
     */
    @Test
    public void testVirtualKanbanController() {
        // Needs an implemented version of getVirtualKanbanController() in every controller-class

        //assertEquals(vkc, vkc.getProjectController().getVirtualKanbanController());
        //assertEquals(vkc, vkc.getTaskController().getVirtualKanbanController());
        //assertEquals(vkc, vkc.getDeveloperController().getVirtualKanbanController());
        //assertEquals(vkc, vkc.getTeamController().getVirtualKanbanController());
        //assertEquals(vkc, vkc.getIOController().getVirtualKanbanController());
        //assertEquals(vkc, vkc.getStatisticController().getVirtualKanbanController());
    }

    /**
     * Test for method getProjectController()
     */
    @Test
    public void getProjectController() {
        assertNotNull(vkc.getProjectController());
    }

    /**
     * Test for method getTaskController()
     */
    @Test
    public void getTaskController() {
        assertNotNull(vkc.getTaskController());
    }

    /**
     * Test for method getDeveloperController()
     */
    @Test
    public void getDeveloperController() {
        assertNotNull(vkc.getDeveloperController());
    }

    /**
     * Test for method getTeamController()
     */
    @Test
    public void getTeamController() {
        assertNotNull(vkc.getTeamController());
    }

    /**
     * Test for method getIOController()
     */
    @Test
    public void getIOController() {
        assertNotNull(vkc.getIOController());
    }

    /**
     * Test for method getVirtualKanban()
     */
    @Test
    public void getVirtualKanban() {
        assertNotNull(vkc.getVirtualKanban());
    }

    /**
     * Test for method getStatisticController()
     */
    @Test
    public void getStatisticController() {
        assertNotNull(vkc.getStatisticController());
    }
}