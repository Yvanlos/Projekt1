package controller;

import com.itextpdf.text.DocumentException;
import model.Project;
import model.StageList;
import model.Task;
import model.Team;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
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
     * Tests the exportATable() method
     * @throws Exception Gets thrown if exporting was unsuccessful.
     */
    @Test
    public void testExportATable() throws Exception {
        LocalDateTime dateTimeP1 = LocalDateTime.of(2020, Month.AUGUST, 23, 16, 15, 15) ;
        LocalDateTime dateTimeP2 = LocalDateTime.of(2020, Month.AUGUST, 24, 16, 15, 15) ;
        LocalDateTime dateTimeP3 = LocalDateTime.of(2020, Month.AUGUST, 25, 16, 15, 15) ;
        LocalDateTime dateTimeP4 = LocalDateTime.of(2020, Month.AUGUST, 26, 16, 15, 15) ;
        LocalDateTime dateTimeP5 = LocalDateTime.of(2020, Month.AUGUST, 23, 10, 15, 15) ;
        LocalDateTime dateTimeP6 = LocalDateTime.of(2020, Month.AUGUST, 25, 10, 15, 15) ;
        LocalDateTime dateTimeP7 = LocalDateTime.of(2020, Month.AUGUST, 26, 10, 15, 15) ;


        Team team1 = new Team("a");
        Team team2 = new Team("b");
        Team team3 = new Team("c");
        Team team4 = new Team("d");
        Project p1 = new Project("vacation","gone trip",dateTimeP1,team1) ;
        Project p2 = new Project("game","fun",dateTimeP2,team2) ;
        Project p3 = new Project("work out","healthy",dateTimeP3,team3) ;
        Project p4 = new Project("end","back trip",dateTimeP4,team4) ;
        ArrayList<Project> projects = new ArrayList<>();
        projects.add(p1);
        projects.add(p2);
        projects.add(p3);
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
        ArrayList<StageList> stageListsP3 = p3.getStageList();
        ArrayList<StageList> stageListsP4 = p4.getStageList();
        for(int i = 0 ; i < 20 ; i++) {
            stageListsP1.get(0).addTask(tasks[i]);
        }
        for(int i = 20 ; i < 30 ; i++) {
            stageListsP1.get(3).addTask(tasks[i]);
        }
        for(int i = 20 ; i < 40 ; i++) {
            stageListsP2.get(0).addTask(tasks[i]);
        }

        // in ein ArrayList...
        ArrayList<Project> projectArrayList = new ArrayList<>() ;
        projectArrayList.add(p1);
        projectArrayList.add(p2);
        File file = new File(String.valueOf(DEST));
//        io.exportATable(DEST,p4);
        io.exportAllTable(DEST,projectArrayList);
    }
}
