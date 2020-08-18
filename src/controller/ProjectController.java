package controller;

import model.Project;
import model.Team;
import java.time.LocalDateTime;
import java.lang.UnsupportedOperationException;

/**
 * This class allows it to create, remove and archive projects
 */
public class ProjectController {

	/**
	 * the VirtualKanbanController which knows and is known by every other controller
	 */
    private VirtualKanbanController virtualKanbanController;

    public ProjectController(VirtualKanbanController virtualKanbanController) {
    }

    /**
	 * Creates a new project and assigns it to a team
	 *
 	 * @param name the name of the project
 	 * @param deadline the deadline of the project
 	 * @param team the team assigned to the project
 	 * @param description a description of the project
 	 * @return Project the newly created project
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public Project createProject(String name, LocalDateTime deadline, Team team, String description) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Archives the specified project and releases the team which was assigned to the project
 	 *
 	 * @param project the project to be archived
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public void archiveProject(Project project) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Deletes the specified project and releases the team which was assigned to the project
 	 *
 	 * @param project the project to be deleted
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, falls die Methode noch nicht implementiert ist.
 	 */
    public void deleteProject(Project project) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
