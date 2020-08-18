package model;

import java.net.URI;
import java.util.Collection;
import java.lang.UnsupportedOperationException;

public class Developer {

    /**
 	 * The developers name.
 	 */
    private String name;

    /**
 	 * An URI that leads to the developers profile picture.
 	 */
    private URI picture;

    /**
 	 * Dedicates if the developer is currently ist currently assigned to a task.
 	 */
    private boolean atWork;

    /**
 	 * List of all completed tasks.
 	 */
    private Collection<CompletedStage> completedStage;

    /**
 	 * Currently assigned task.
 	 */
    private CompletedStage currentTaskStage;

    /**
 	 * Sets the current date as completionDate in currentTaskStage 
 	 * and adds the currentTaskStage to the completedStage list.
 	 * Then sets atWork to false.
 	 * 
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addCompletedStage() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * Drop the <b>currentTaskStage</b> and set <b>atWork</b> to false.
 	 * 
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void cancelTask() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
