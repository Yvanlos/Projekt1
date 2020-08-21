package controller;

import model.CompletedStage;
import model.Developer;
import model.Project;
import model.Team;
import java.lang.UnsupportedOperationException;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class StatisticController {

    /**
 	 * 
 	 */
    private VirtualKanbanController virtualKanbanController;

    public StatisticController(VirtualKanbanController virtualKanbanController) {
    	virtualKanbanController=virtualKanbanController;
    }

    /**
 	 * shows the statistics of a project
	 *
 	 * TODO: create JavaDoc. 
 	 * @param project
	 * 					project, of which the statistics are shown
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void showStats(Project project) throws UnsupportedOperationException {







        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * shows the statistics of a team
	 *
 	 * TODO: create JavaDoc. 
 	 * @param team
	 * 				team, of which the statistics are shown
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public String[][] showStats(Team team) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

	/**
	 * shows a ranking of all developers, ordered by the number of tasks completed within the last seven days.
	 * @return a two-dimensional String array with every developer and the number of tasks they completed within the last seven days
	 */
	public String[][] showRanking(){
    	int numberOfDevelopers=0;

    	ArrayList<Team> teamArrayList=virtualKanbanController.getVirtualKanban().getTeam();

    	for(Team currentTeam:teamArrayList)
		{
			ArrayList<Developer> developerArrayList= currentTeam.getDevelopers();
			for(Developer currentDeveloper:developerArrayList) {
				numberOfDevelopers++;
			}
		}
    	String[][] unsortedTable=new String[2][numberOfDevelopers];
    	int arrayIndex=0;
    	for(Team currentTeam:teamArrayList) {
			ArrayList<Developer> DeveloperArrayList= currentTeam.getDevelopers();
			for(Developer currentDeveloper:DeveloperArrayList){
				Integer numberOfCompletions=0;
				ArrayList<CompletedStage> completedStageArrayList=currentDeveloper.getCompletedStageList();
				for(CompletedStage currentCompletedStage:completedStageArrayList){

					LocalDateTime completionDate=currentCompletedStage.getCompletionDate();
					LocalDateTime currentDate=LocalDateTime.now();
					long timePassed=completionDate.until(currentDate,DAYS);
					if(timePassed<=7)
					{
						numberOfCompletions++;
					}
				}
				String nocToString=numberOfCompletions.toString();
				unsortedTable[0][arrayIndex]=currentDeveloper.getName();
				unsortedTable[1][arrayIndex]=nocToString;
				arrayIndex++;
			}
		}


        return unsortedTable;
    }
}
