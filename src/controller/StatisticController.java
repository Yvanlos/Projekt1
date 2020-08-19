package controller;

import model.Project;
import model.Team;
import java.lang.UnsupportedOperationException;

public class StatisticController {

    /**
 	 * 
 	 */
    private VirtualKanbanController virtualKanbanController;

    public StatisticController(VirtualKanbanController virtualKanbanController) {
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
    public void showStats(Team team) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *	shows a ranking of all developers, ordered by the number of tasks completed within the last seven days
	 *
 	 * TODO: create JavaDoc. 
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void showRanking() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
