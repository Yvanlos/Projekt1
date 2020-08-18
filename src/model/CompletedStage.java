package model;

import java.time.LocalDateTime;
import java.lang.UnsupportedOperationException;

public class CompletedStage {

    /**
 	 * time at which the devloper started the task
 	 */
    private LocalDateTime startDate;

    /**
 	 * time at which the developer finished the task
 	 */
    private LocalDateTime completionDate;

    /**
 	 * the task the developer was working on
 	 */
    private Task task;

    /**
 	 * the stage of Kanban in which the task was while the developer worked on it
 	 */
    private Stage stage;

    /**
 	 * sets the CompletionDate to the actual date
 	 *
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void setCompletionDate() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
