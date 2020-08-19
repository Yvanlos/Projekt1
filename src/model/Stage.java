package model;

import java.lang.UnsupportedOperationException;

public enum Stage {
    ;

    /**
 	 * 
 	 */
    private Stage NEW;

    /**
 	 * 
 	 */
    private Stage ANALYSE_IN_PROGRESS;

    /**
 	 * 
 	 */
    private Stage ANALYSE_FINISHED;

    /**
 	 * 
 	 */
    private Stage IMPLEMETNATION_IN_PROGRESS;

    /**
 	 * 
 	 */
    private Stage IMPLEMENTATION_FINISHED;

    /**
 	 * 
 	 */
    private Stage TEST_IN_PROGRESS;

    /**
 	 * 
 	 */
    private Stage TEST_FINISHED;

    /**
 	 * 
 	 */
    private Stage COMPLETED;

    private static Stage[] stages = values();

    public Stage next(){
        if (this.ordinal() < stages.length){
            return stages[this.ordinal()+1];
        }
        return this;
    }

    public Stage previous(){
        if (this.ordinal() > 0){
            return stages[this.ordinal()-1];
        }
        return this;
    }
}
