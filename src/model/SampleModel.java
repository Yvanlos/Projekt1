package model;

import java.io.Serializable;
import java.lang.UnsupportedOperationException;

/**
 * Provides an example for a model class.
 */
public class SampleModel implements Serializable {

    /**
     * This method intentionally violates PMD rules.
     * @param i The integer to return.
     * @return Returns the value of parameter i.
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public int a(int i) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
