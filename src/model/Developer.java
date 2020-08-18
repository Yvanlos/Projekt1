package model;

import java.net.URI;
import java.util.Collection;
import java.lang.UnsupportedOperationException;

public class Developer {

    /**
 	 * 
 	 */
    private String name;

    /**
 	 * 
 	 */
    private URI picture;

    /**
 	 * 
 	 */
    private boolean atWork;

    /**
 	 * 
 	 */
    private Collection<CompletedStage> completedStage;

    /**
 	 * 
 	 */
    private CompletedStage currentTaskStage;

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addCompletedStage() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void cancelTask() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
