package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class VirtualKanbanTest {

    private VirtualKanban testClass;

    @Before
    public void setUp() {
        testClass = new VirtualKanban();
    }

    @Test
    public void testConstructor() {
        assertNotEquals(testClass.getProject().isEmpty(), false);
        assertNotEquals(testClass.getTeam().isEmpty(), false);
    }

    @Test
    public void addAndGetProject() {
        Project p = new Project("Test", "TestDescription", LocalDateTime.now(), new Team());
        testClass.addProject(p);
        assertSame(p, testClass.getProject().get(0));
    }

    @Test
    public void addAndGetTeam() {
        Team t = new Team();
        t.setName("Test");
        testClass.addTeam(t);
        assertSame(t, testClass.getTeam().get(0));
    }
}