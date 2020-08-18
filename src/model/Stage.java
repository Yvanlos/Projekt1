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
}
