package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Tests the StatistiController class
 */
public class StatisticControllerTest {

    private VirtualKanbanController virtualKanbanController;
    private StatisticController testClass;
    private Team team1;

    /**
     * Sets up a clean testing environment before every test.
     */
    @Before
    public void setUp() {
        virtualKanbanController = new VirtualKanbanController();
        testClass = virtualKanbanController.getStatisticController();
        team1 = new Team("TestTeam1");
        Team team2 = new Team("TestTeam2");
        virtualKanbanController.getVirtualKanban().addTeam(team1);
        virtualKanbanController.getVirtualKanban().addTeam(team2);
        virtualKanbanController.getVirtualKanban().addProject(new Project("TestProject1", "TestDescription1", LocalDateTime.now(), team1));
        virtualKanbanController.getVirtualKanban().addProject(new Project("TestProject2", "TestDescription2", LocalDateTime.now(), team2));
        Developer testDev1 = new Developer("TestDev1", null);
        Developer testDev2 = new Developer("TestDev2", null);
        Developer testDev3 = new Developer("TestDev3", null);
        Developer testDev4 = new Developer("TestDev4", null);

        CompletedStage completedStage1 = new CompletedStage(new Task("name1", "des", LocalDateTime.now()), Stage.COMPLETED);
        completedStage1.setStartDate(LocalDateTime.of(LocalDate.of(2020, 8, 20), LocalTime.now()));
        completedStage1.setCompletionDate(LocalDateTime.of(LocalDate.of(2020, 8, 21), LocalTime.now()));

        CompletedStage completedStage2 = new CompletedStage(new Task("name2", "des2", LocalDateTime.now()), Stage.COMPLETED);
        completedStage2.setStartDate(LocalDateTime.of(LocalDate.of(2020, 8, 19), LocalTime.now()));
        completedStage2.setCompletionDate(LocalDateTime.of(LocalDate.of(2020, 8, 21), LocalTime.now()));

        CompletedStage completedStage3 = new CompletedStage(new Task("name3", "des3", LocalDateTime.now()), Stage.COMPLETED);
        completedStage3.setStartDate(LocalDateTime.of(LocalDate.of(2020, 8, 18), LocalTime.now()));
        completedStage3.setCompletionDate(LocalDateTime.of(LocalDate.of(2020, 8, 21), LocalTime.now()));


        CompletedStage completedStage4 = new CompletedStage(new Task("name4", "des4", LocalDateTime.now()), Stage.COMPLETED);
        completedStage4.setStartDate(LocalDateTime.of(LocalDate.of(2020, 8, 17), LocalTime.now()));
        completedStage4.setCompletionDate(LocalDateTime.of(LocalDate.of(2020, 8, 21), LocalTime.now()));

        CompletedStage completedStage5 = new CompletedStage(new Task("name5", "des5", LocalDateTime.now()), Stage.COMPLETED);
        completedStage5.setStartDate(LocalDateTime.of(LocalDate.of(2020, 8, 16), LocalTime.now()));
        completedStage5.setCompletionDate(LocalDateTime.of(LocalDate.of(2020, 8, 21), LocalTime.now()));


        CompletedStage completedStage6 = new CompletedStage(new Task("name6", "des6", LocalDateTime.now()), Stage.COMPLETED);
        completedStage6.setStartDate(LocalDateTime.of(LocalDate.of(2020, 8, 15), LocalTime.now()));
        completedStage6.setCompletionDate(LocalDateTime.of(LocalDate.of(2020, 8, 21), LocalTime.now()));

        CompletedStage completedStage7 = new CompletedStage(new Task("name7", "des7", LocalDateTime.now()), Stage.COMPLETED);
        completedStage7.setStartDate(LocalDateTime.of(LocalDate.of(2020, 8, 16), LocalTime.now()));
        completedStage7.setCompletionDate(LocalDateTime.of(LocalDate.of(2020, 8, 21), LocalTime.now()));


        CompletedStage completedStage8 = new CompletedStage(new Task("name8", "des8", LocalDateTime.now()), Stage.COMPLETED);
        completedStage8.setStartDate(LocalDateTime.of(LocalDate.of(2020, 8, 17), LocalTime.now()));
        completedStage8.setCompletionDate(LocalDateTime.of(LocalDate.of(2020, 8, 21), LocalTime.now()));

        ArrayList<CompletedStage> arrayList1 = new ArrayList<>();
        ArrayList<CompletedStage> arrayList2 = new ArrayList<>();
        ArrayList<CompletedStage> arrayList3 = new ArrayList<>();
        ArrayList<CompletedStage> arrayList4 = new ArrayList<>();

        arrayList1.add(completedStage1);
        arrayList1.add(completedStage2);
        arrayList1.add(completedStage3);
        testDev1.setCompletedStageList(arrayList1);

        arrayList2.add(completedStage4);
        arrayList2.add(completedStage5);
        testDev2.setCompletedStageList(arrayList2);

        arrayList3.add(completedStage6);
        arrayList3.add(completedStage7);
        testDev3.setCompletedStageList(arrayList3);

        arrayList4.add(completedStage8);
        testDev4.setCompletedStageList(arrayList4);

        team1.addDeveloper(testDev1);
        team1.addDeveloper(testDev2);

        team2.addDeveloper(testDev3);
        team2.addDeveloper(testDev4);

    }

    /**
     * Tests the showStats() method
     */
    @Test
    public void testShowStats() {
        HashMap<String, double[]> map = testClass.showStats(team1);
        assertNotEquals(map.get("TestDev1")[2], 0);
    }

    /**
     * Tests the showRanking() method
     */
    @Test
    public void testShowRanking() {
        HashMap<String,Integer> map = testClass.showRanking();
        assertEquals(map.get("TestDev3").intValue(),2);
        assertEquals(map.get("TestDev1").intValue(),3);
    }
}