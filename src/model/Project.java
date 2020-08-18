package model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.lang.UnsupportedOperationException;

public class Project {

    /**
 	 * 
 	 */
    private String name;

    /**
 	 * 
 	 */
    private LocalDateTime startdate;

    /**
 	 * 
 	 */
    private String description;

    /**
 	 * 
 	 */
    private LocalDateTime deadline;

    /**
 	 * 
 	 */
    private boolean readOnly;

    /**
 	 * 
 	 */
    private Team team;

    /**
 	 * 
 	 */
    private Collection<StageList> stageList;

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param task
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void moveTaskForeward(Task task) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param task
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void moveTaskBackward(Task task) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param task
 	 * @return StageList
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public StageList getStageFromTask(Task task) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param stageList
 	 * @return StageList
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public StageList getNextStage(StageList stageList) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param stageList
 	 * @return StageList
 	 * @throws UnsupportedOperation Exception
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public StageList getPreviousStage(StageList stageList) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
