package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * tests teh VirtualKanban Class
 */
public class VirtualKanbanTest {

    /**
     * the tested object
     */
    private VirtualKanban testClass;

    /**
     * create a object of the VirtualKanban class
     */
    @Before
    public void setUp() {
        testClass = new VirtualKanban();
    }

    /**
     * tests the constructor
     */
    @Test
    public void testConstructor() {
        assertNotEquals(testClass.getProject().isEmpty(), false);
        assertNotEquals(testClass.getTeam().isEmpty(), false);
    }

    /**
     * tests the methods addProject and getProject
     */
    @Test
    public void addAndGetProject() {
        Project p = new Project("Test", "TestDescription", LocalDateTime.now(), new Team("testTeam"));
        testClass.addProject(p);
        assertSame(p, testClass.getProject().get(0));
    }

    /**
     * tests teh methods addTeam and getTeam
     */
    @Test
    public void addAndGetTeam() {
        Team t = new Team("testTeam");
        t.setName("Test");
        testClass.addTeam(t);
        assertSame(t, testClass.getTeam().get(0));
    }

    /**
     * tests the method removeTeam(team)
     */
    @Test
    public void removeTeam() {
        Team t = new Team("testTeam");
        t.setName("Test");
        testClass.addTeam(t);
        testClass.removeTeam(t);
        assertEquals(testClass.getTeam().size(), 0);
    }

    /**
     * tests the method removePtoject(project)
     */
    @Test
    public void removeProject() {
        Project p = new Project("Test", "TestDescription", LocalDateTime.now(), new Team("testTeam"));
        testClass.addProject(p);
        testClass.removeProject(p);
        assertEquals(testClass.getProject().size(), 0);
    }

    /**
     * tests the method setTeam
     */
    @Test
    public void testSetTeam() {
        ArrayList<Team> c = new ArrayList<>();
        testClass.setTeam(c);
        assertEquals(c, testClass.getTeam());
    }

    /**
     * test teh method setProject
     */
    @Test
    public void testSetProject() {
        ArrayList<Project> c = new ArrayList<>();
        testClass.setProject(c);
        assertEquals(c, testClass.getProject());
    }
}