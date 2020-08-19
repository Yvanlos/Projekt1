package model;

import java.util.Collection;
import java.lang.UnsupportedOperationException;

public class Team {

    /**
 	 * 
 	 */
    private String name;

    /**
 	 * 
 	 */
    private Collection<Developer> developer;

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param developer
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addDeveloper(Developer developer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 *
 	 * TODO: create JavaDoc. 
 	 * @param developer
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void removeDeveloper(Developer developer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
