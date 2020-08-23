package model;

import java.io.Serializable;

/**
 * The enum for the different stages a task can be in
 */
public enum Stage implements Serializable {
    NEW,
    ANALYSE_IN_PROGRESS,
    ANALYSE_FINISHED,
    IMPLEMENTATION_IN_PROGRESS,
    IMPLEMENTATION_FINISHED,
    TEST_IN_PROGRESS,
    TEST_FINISHED,COMPLETED;

    /**
     * an array containing the constants of the Stage type, in the order they are declared
     */
    private final static Stage[] STAGES = values();

    /**
     * Provides the next Stage
     * @return Stage the next Stage, if the last stage is already reached returns null
     */
    public Stage next(){
        if (this.ordinal() < STAGES.length-1){
            return STAGES[this.ordinal()+1];
        }
        return null;
    }

    /**
     * Provides the previous Stage
     * @return Stage the previous Stage, if the first stage is already reached returns null
     */
    public Stage previous(){
        if (this.ordinal() > 0){
            return STAGES[this.ordinal()-1];
        }
        return null;
    }
}
