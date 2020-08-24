package controller;

import model.Developer;
import model.Note;
import model.Project;
import model.StageList;
import model.Task;
import model.Team;
import model.VirtualKanban;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

/**
 * Tests the IOController class
 */
public class IOControllerTest{

   VirtualKanbanController vkc;
    IOController io;
    private static final File DEST = new File("KanbanBoard.pdf");

    /**
     * Creates a new IOControllerTest with a new VirtualKanbanController and new IOController
     */
    public IOControllerTest(){
        vkc = new VirtualKanbanController();
        io = new IOController(vkc);
    }
    
    /**
     * Tests the methods load() and save()
     */
    @Test
    public void testLoadSave() {
    	
    	URI testURI = URI.create("test");
    	String testDeveloperName = "TestDeveloper";
    	
    	String testTeamName = "TestTeam";
    	
    	String testProjectName = "TestProject";
    	String testProjectDescription = "Test Project Description";
    	LocalDateTime testProjectDeadline = LocalDateTime.of(2020, 8, 31, 13, 5);
    	
    	String testTaskName = "TestTask";
    	String testTaskDescription = "Test Task Description";
    	LocalDateTime testTaskDeadline = LocalDateTime.of(2020, 8, 29, 11, 3);
    	
    	String testCompletedTaskName = "TestCompletedTask";
    	String testCompletedTaskDescription = "Test Completed Task Description";
    	LocalDateTime testCompletedTaskDeadline = LocalDateTime.of(2020, 8, 30, 12, 15);
    	
    	
    	LocalDateTime testNoteDeadline = LocalDateTime.of(2020, 8, 31, 2, 30);
    	Note testNote = new Note("TestKommentar", "Test Kommentar Beschreibung", testNoteDeadline);
    	
    	
    	//create testTeam
    	vkc.getTeamController().createTeam(testTeamName);
    	
    	//get testTeam
    	Team testTeam = vkc.getVirtualKanban().getTeam().get(0);
    	
    	//create testDeveloper
    	vkc.getDeveloperController().createDeveloper(vkc.getVirtualKanban().getTeam().get(0), testDeveloperName, testURI);
    	
    	//get testDeveloper
    	Developer testDeveloper = testTeam.getDevelopers().get(0);
    	
    	//create testProject with team testTeam
    	vkc.getProjectController().createProject(testProjectName, testProjectDeadline, vkc.getVirtualKanban().getTeam().get(0), testProjectDescription);
    	
    	//get testProject
    	Project testProject = vkc.getVirtualKanban().getProject().get(0);
    	
    	//add testTask and testCompletedTask to testProject
    	vkc.getTaskController().addTask(testProject, testTaskName, testTaskDescription, testTaskDeadline);
    	vkc.getTaskController().addTask(testProject, testCompletedTaskName, testCompletedTaskDescription, testCompletedTaskDeadline);
    	
    	//get testTask and testCompletedTask
    	Task testTask = testProject.getStageList().get(0).getTask().get(0);
    	Task testCompletedTask = testProject.getStageList().get(0).getTask().get(1);
    	
    	//add testNote to testTask
    	vkc.getTaskController().addNote(testTask, testNote);
    	
    	//Complete the testCompletedTask with testDeveloper
    	vkc.getTaskController().startTask(testCompletedTask, testProject, testDeveloper);
    	vkc.getTaskController().finishTask(testCompletedTask, testProject);
    	
    	//assign testDeveloper to testTask
    	vkc.getTaskController().startTask(testTask, testProject, testDeveloper);
    	
    	
    	try {
			vkc.getIOController().save();
			try {
				VirtualKanban loadedVirtualKanban = vkc.getIOController().load();
				
				Team loadedTeam = loadedVirtualKanban.getTeam().get(0);
				Project loadedProject = loadedVirtualKanban.getProject().get(0);
				Developer loadedDeveloper = loadedTeam.getDevelopers().get(0);
				Task loadedCompletedTask = loadedDeveloper.getCompletedStageList().get(0).getTask();
				Task loadedCurrentTask = loadedDeveloper.getCurrentTaskStage().getTask();
				Note loadedNote = loadedCurrentTask.getNote().get(0);
				
				//Test all names
				assertEquals(loadedTeam.getName(), testTeamName);
				assertEquals(loadedProject.getName(), testProjectName);
				assertEquals(loadedDeveloper.getName(), testDeveloperName);
				assertEquals(loadedCompletedTask.getName(), testCompletedTaskName);
				assertEquals(loadedCurrentTask.getName(), testTaskName);
				assertEquals(loadedNote.getName(), testNote.getName());
				
				//Test all descriptions
				assertEquals(loadedProject.getDescription(), testProjectDescription);
				assertEquals(loadedCompletedTask.getDescription(), testCompletedTaskDescription);
				assertEquals(loadedCurrentTask.getDescription(), testTaskDescription);
				assertEquals(loadedNote.getContent(), testNote.getContent());
				
				//Test user picture
				assertEquals(loadedDeveloper.getPicture(), testURI);
				
				//Test deadlines
				assertEquals(loadedProject.getDeadline(), testProjectDeadline);
				assertEquals(loadedCompletedTask.getDeadline(), testCompletedTaskDeadline);
				assertEquals(loadedCurrentTask.getDeadline(), testTaskDeadline);
				
				//Test creation dates
				assertEquals(loadedNote.getCreationDate(), testNote.getCreationDate());
				
				
				
				
			} catch (IOException e) {
				assertTrue("Failed loading the save file.", false);
			} catch (NullPointerException e) {
				assertTrue("Data was not loaded correctly.", false);
			}
		} catch (IOException e1) {
			assertTrue("Failed saving.", false);
		}
    	
    }

    /**
     * Tests the exportATable() method
     * @throws Exception Gets thrown if exporting was unsuccessful.
     */
    @Test
    public void testExportTable() throws Exception {
        LocalDateTime dateTimeP1 = LocalDateTime.of(2020, Month.AUGUST, 23, 16, 15, 15) ;
        LocalDateTime dateTimeP2 = LocalDateTime.of(2020, Month.AUGUST, 24, 16, 15, 15) ;
        LocalDateTime dateTimeP3 = LocalDateTime.of(2020, Month.AUGUST, 25, 16, 15, 15) ;
        LocalDateTime dateTimeP4 = LocalDateTime.of(2020, Month.AUGUST, 26, 16, 15, 15) ;
        LocalDateTime dateTimeP5 = LocalDateTime.of(2020, Month.AUGUST, 23, 10, 15, 15) ;
        LocalDateTime dateTimeP6 = LocalDateTime.of(2020, Month.AUGUST, 25, 10, 15, 15) ;
        LocalDateTime dateTimeP7 = LocalDateTime.of(2020, Month.AUGUST, 26, 10, 15, 15) ;


        Team team1 = new Team("a");
        Team team2 = new Team("b");
        Team team4 = new Team("d");
        Project p1 = new Project("vacation","gone trip",dateTimeP1,team1) ;
        Project p2 = new Project("game","fun",dateTimeP2,team2) ;
        Project p4 = new Project("end","back trip",dateTimeP4,team4) ;
        ArrayList<Project> projects = new ArrayList<>();
        projects.add(p1);
        projects.add(p4);

        // 4 Task pro projekte .

        Task t1 = new Task("job1","all of us",dateTimeP5);
        Task t2 = new Task("job2","all of us",dateTimeP1);
        Task t3 = new Task("job3","all of us",dateTimeP2);
        Task t4 = new Task("job4","all of us",dateTimeP3);
        Task t5 = new Task("job5","all of us",dateTimeP4);
        Task t6 = new Task("job6","all of us",dateTimeP2);
        Task t7 = new Task("job7","all of us",dateTimeP5);
        Task t8 = new Task("job8","all of us",dateTimeP6);
        Task t9 = new Task("job9","all of us",dateTimeP6);
        Task t10 = new Task("job10","all of us",dateTimeP6);
        Task t11= new Task("job11","all of us",dateTimeP6);
        Task t12 = new Task("job12","all of us",dateTimeP6);
        Task t13= new Task("job13","all of us",dateTimeP6);
        Task t14= new Task("job14","all of us",dateTimeP6);
        Task t15= new Task("job15","all of us",dateTimeP6);
        Task t16= new Task("job16","all of us",dateTimeP6);
        Task t17= new Task("job17","all of us",dateTimeP4);
        Task t18= new Task("job18","all of us",dateTimeP6);
        Task t19 = new Task("job19","all of us",dateTimeP6);
        Task t20 = new Task("job20","all of us",dateTimeP6);
        Task t21 = new Task("job21","all of us",dateTimeP3);
        Task t22= new Task("job22","all of us",dateTimeP5);
        Task t23= new Task("job23","all of us",dateTimeP6);
        Task t24 = new Task("job24","all of us",dateTimeP5);
        Task t25= new Task("job25","all of us",dateTimeP4);
        Task t26= new Task("job26","all of us",dateTimeP3);
        Task t27= new Task("job27","all of us",dateTimeP5);
        Task t28= new Task("job28","all of us",dateTimeP1);
        Task t29= new Task("job29","all of us",dateTimeP2);
        Task t30= new Task("job30","all of us",dateTimeP3);
        Task t31= new Task("job31","all of us",dateTimeP5);
        Task t32 = new Task("job32","all of us",dateTimeP6);
        Task t33= new Task("job33","all of us",dateTimeP7);
        Task t34= new Task("job34","all of us",dateTimeP7);
        Task t35= new Task("job35","all of us",dateTimeP6);
        Task t36= new Task("job36","all of us",dateTimeP1);
        Task t37= new Task("job37","all of us",dateTimeP2);
        Task t38= new Task("job38","all of us",dateTimeP5);
        Task t39= new Task("job39","all of us",dateTimeP3);
        Task t40= new Task("job40","all of us",dateTimeP4);

        Task [] tasks = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,
                         t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,
                        t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40};
        ArrayList<StageList> stageListsP1 = p1.getStageList();
        ArrayList<StageList> stageListsP2 = p2.getStageList();
        for(int i = 0 ; i < 20 ; i++) {
            stageListsP1.get(0).addTask(tasks[i]);
        }
        for(int i = 20 ; i < 30 ; i++) {
            stageListsP1.get(3).addTask(tasks[i]);
        }
        for(int i = 20 ; i < 40 ; i++) {
            stageListsP2.get(0).addTask(tasks[i]);
        }
        for(int i = 0 ; i < 40 ; i++) {
            p4.getStageList().get(0).addTask(tasks[i]);
        }


        File file = new File(String.valueOf(DEST));
        io.exportATable(DEST,p4);
        io.exportAllTable(DEST,projects);
    }
}
