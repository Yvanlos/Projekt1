package controller;

import model.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;
import java.util.stream.IntStream;


/**
 * This class is responsible for gathering statistics and preparing them for further usage.
 */
public class StatisticController {

    /**
 	 * reference to the main-controller
 	 */
    private VirtualKanbanController virtualKanbanController;

	/**
	 * Maximum number of days since a task was finished, for it to remain relevant for the stats
	 */
	private final int MAXIMUM_TIME_PASSED=7;

	/**
	 * the StatisticController constructor
	 * @param virtualKanbanController reference to the main-controller
	 */
    public StatisticController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController = virtualKanbanController;
    }


    /*public HashMap<String, Integer> showStats(Project project) {
    	HashMap<String, Integer> result = new HashMap<>();
    	for(StageList stagelist : project.getStageList()) {
    		for(Task task : stagelist.getTask()) {

			}
		}
		return null;
    }*/

    /**
 	 * returns a map, which holds the developer names + min, max and avg time for the finished tasks
	 */
    public HashMap<String, double[]> showStats(Team team) {
    	HashMap<String, double[]> result = new HashMap<>();
    	ArrayList<Developer> devs = team.getDevelopers();
    	for(Developer dev : devs) {
			Supplier<IntStream> streamSupplier = () -> dev.getCompletedStageList().stream()
					.filter(currentStage -> ChronoUnit.DAYS.between(currentStage.getCompletionDate()
							.toLocalDate(), LocalDate.now()) <= MAXIMUM_TIME_PASSED)
					.mapToInt(currentStage -> (int)ChronoUnit.MINUTES
							.between(currentStage.getStartDate(), currentStage.getCompletionDate()));
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
	public HashMap<String,Integer> showRanking(){

    	HashMap<String,Integer> rankingTable= new HashMap<>();
    	for(Team currentTeam:virtualKanbanController.getVirtualKanban().getTeam()) {
			for(Developer currentDeveloper:currentTeam.getDevelopers()){
				rankingTable.put(currentDeveloper.getName(),(int)currentDeveloper.getCompletedStageList().stream()
						.filter(currentStage->ChronoUnit.DAYS.between(currentStage.getCompletionDate()
								.toLocalDate(),LocalDate.now())<=MAXIMUM_TIME_PASSED).count());
			}
		}
        return rankingTable;
    }
}
