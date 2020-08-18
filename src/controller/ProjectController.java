package controller;

import model.Project;
import model.Team;
import java.time.LocalDateTime;
import java.lang.UnsupportedOperationException;

public class ProjectController {

    /**
 	 * 
 	 */
    private VirtualKanbanController virtualKanbanController;

    public ProjectController(VirtualKanbanController virtualKanbanController) {
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param name
 	 * @param deadline
 	 * @param team
 	 * @param description
 	 * @return Project
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public Project createProject(String name, LocalDateTime deadline, Team team, String description) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param project
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void archiveProject(Project project) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param project
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void deleteProject(Project project) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
