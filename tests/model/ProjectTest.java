package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProjectTest {

    Project project;
    ArrayList<StageList> stageList;

    /**
     * Sets up a clean testing environment before every test.
     * @throws Exception Gets thrown if setting up clean environment was unsuccessful.
     */
    @Before
    public void setUp() throws Exception {
        project = new Project("testProject", "testDescription", LocalDateTime.now(),new Team("testTeam"));
    }

    /**
     * Tests the method moveTaskForward()
     */
    @Test
    public void testMoveTaskForeward() {
        Task task = new Task("testName","testDescription",LocalDateTime.now());
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.NEW){
                list.addTask(task);
            }
        }
        project.moveTaskForeward(task);
        assertEquals(Stage.ANALYSE_IN_PROGRESS, project.getStageFromTask(task).getStage());
    }

    /**
     * Tests the method moveTaskBackward()
     */
    @Test
    public void testMoveTaskBackward() {
        Task task = new Task("testName","testDescription",LocalDateTime.now());
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.ANALYSE_IN_PROGRESS){
                list.addTask(task);
            }
        }
        project.moveTaskBackward(task);
        assertEquals(Stage.NEW, project.getStageFromTask(task).getStage());
    }

    /**
     * Tests the method getStageFromTask()
     */
    @Test
    public void testGetStageFromTask() {
        Task task = new Task("testName","testDescription",LocalDateTime.now());
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.NEW){
                list.addTask(task);
            }
        }
        assertEquals(Stage.NEW, project.getStageFromTask(task).getStage());
    }

    /**
     * Tests the method getNextStage()
     */
    @Test
    public void testGetNextStage() {
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.NEW){
                assertEquals(Stage.ANALYSE_IN_PROGRESS, project.getNextStage(list).getStage());
            }
        }
    }

    /**
     * Tests the method getPreviousStage()
     */
    @Test
    public void testGetPreviousStage() {
        for (StageList list : project.getStageList()){
            if (list.getStage() == Stage.ANALYSE_IN_PROGRESS){
                assertEquals(Stage.NEW, project.getPreviousStage(list).getStage());
            }
        }
    }

    /**
     * Tests the method getName()
     */
    @Test
    public void testGetName() {
        assertEquals("testProject",project.getName());
    }

    /**
     * Tests the method getStartDate()
     */
    @Test
    public void testGetStartDate() {
        assertEquals(LocalDateTime.now(), project.getStartDate());
    }

    /**
     * Tests the method getDescription()
     */
    @Test
    public void testGetDescription() {
        assertEquals("testDescription",project.getDescription());
    }

    /**
     * Tests the method getDeadline()
     */
    @Test
    public void testGetDeadline() {
        assertEquals(LocalDateTime.now(), project.getDeadline());
    }

    /**
     * Tests the method isReadOnly()
     */
    @Test
    public void testIsReadOnly() {
        assertFalse(project.isReadOnly());
    }

    /**
     * Tests the method getTeam()
     */
    @Test
    public void testGetTeam() {
        assertEquals("testTeam", project.getTeam().getName());
    }

    /**
     * Tests the method getStageList()
     */
    @Test
    public void testGetStageList() {
        stageList = new ArrayList<>(8);
        stageList.add(new StageList(Stage.NEW));
        stageList.add(new StageList(Stage.ANALYSE_IN_PROGRESS));
        stageList.add(new StageList(Stage.ANALYSE_FINISHED));
        stageList.add(new StageList(Stage.IMPLEMENTATION_IN_PROGRESS));
        stageList.add(new StageList(Stage.IMPLEMENTATION_FINISHED));
        stageList.add(new StageList(Stage.TEST_IN_PROGRESS));
        stageList.add(new StageList(Stage.TEST_FINISHED));
        stageList.add(new StageList(Stage.COMPLETED));
        project.setStageList(stageList);
        assertEquals(stageList, project.getStageList());
    }

    /**
     * Tests the method setName()
     */
    @Test
    public void testSetName() {
        project.setName("newName");
        assertEquals("newName", project.getName());
    }

    /**
     * Tests the method setDescription()
     */
    @Test
    public void testSetDescription() {
        project.setDescription("newDescription");
        assertEquals("newDescription",project.getDescription());
    }

    /**
     * Tests the method setDeadline()
     */
    @Test
    public void testSetDeadline() {
        project.setDeadline(LocalDateTime.MAX);
        assertEquals(LocalDateTime.MAX, project.getDeadline());
    }

    /**
     * Tests the method setReadOnly()
     */
    @Test
    public void testSetReadOnly() {
        project.setReadOnly(true);
        assertTrue(project.isReadOnly());
    }

    /**
     * Tests the method setTeam()
     */
    @Test
    public void testSetTeam() {
        project.setTeam(new Team("analysisTeam"));
        assertEquals("analysisTeam", project.getTeam().getName());
    }

    /**
     * Tests the method setStageList()
     */
    @Test
    public void testSetStageList(){
        stageList = new ArrayList<StageList>(8);
        stageList.add(new StageList(Stage.NEW));
        project.setStageList(stageList);
        assertEquals(stageList, project.getStageList());
    }
}