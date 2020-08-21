package controller;

import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.time.temporal.ChronoUnit.DAYS;

public class StatisticController {

    /**
 	 * reference to the main-controller
 	 */
    private VirtualKanbanController virtualKanbanController;

    public StatisticController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    }

    /**
 	 *
 	 */
    public HashMap<String, Integer> showStats(Project project) {
    	HashMap<String, Integer> result = new HashMap<>();
    	for(StageList stagelist : project.getStageList()) {
    		for(Task task : stagelist.getTask()) {
    			//TODO
			}
		}
		return null;
    }

    /**
 	 * returns a map, which holds the developer names + min, max and avg time for the finished tasks
	 */
    public HashMap<String, double[]> showStats(Team team) {
    	HashMap<String, double[]> result = new HashMap<>();
    	ArrayList<Developer> devs = team.getDevelopers();
    	for(Developer dev : devs) {
			Supplier<IntStream> streamSupplier = () -> dev.getCompletedStageList().stream().filter(cs -> ChronoUnit.DAYS.between(cs.getCompletionDate().toLocalDate(), LocalDate.now()) <= 7).mapToInt(cs -> (int)ChronoUnit.MINUTES.between(cs.getStartDate(), cs.getCompletionDate()));
			double[] value = new double[] {0, 0, 0};
			if(streamSupplier.get().min().isPresent()) value[0] = streamSupplier.get().min().getAsInt();
			if(streamSupplier.get().average().isPresent()) value[1] = streamSupplier.get().average().getAsDouble();
			if(streamSupplier.get().max().isPresent()) value[2] = streamSupplier.get().max().getAsInt();
			result.put(dev.getName(), value);
		}
        return result;
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
