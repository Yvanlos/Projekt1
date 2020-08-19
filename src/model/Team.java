package model;

import java.util.Collection;
import java.lang.UnsupportedOperationException;

public class Team {

    /**
 	 * unique name of the team
 	 */
    private String name;

    /**
 	 * list of developers in the team
 	 */
    private Collection<Developer> developer;

    /**
 	 *	adds a developer to the team
	 *
 	 * TODO: create JavaDoc. 
 	 * @param developer
	 * 					developer, which is added to the team
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void addDeveloper(Developer developer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }

    /**
 	 * removes a developer from the team
	 *
 	 * TODO: create JavaDoc. 
 	 * @param developer
	 * 					developer, which is removed from the team
 	 * @throws UnsupportedOperationException
 	 *	 	 	Diese Exception wird geworfen, fallsdie Methode noch nicht implementiert ist. 
 	 */
    public void removeDeveloper(Developer developer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
}
