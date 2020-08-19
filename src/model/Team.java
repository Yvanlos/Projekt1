package model;

import java.util.Collection;
import java.lang.UnsupportedOperationException;
import java.util.List;

/**
 * A team is a group of developers
 */
public class Team {

    /**
 	 * unique name of the team
 	 */
    private String name;

    /**
 	 * list of developers in the team
 	 */
    private List<Developer> developers;

    /**
 	 *	adds a developer to the team
	 *
 	 *
 	 * @param developer
	 * 					developer, which is added to the team
 	 *
 	 */
    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }

    /**
 	 * removes a developer from the team
	 *
 	 *
 	 * @param developer
	 * 					developer, which is removed from the team
 	 *
 	 */
    public void removeDeveloper(Developer developer) {
        this.developers.remove(developer);
    }

	public String getName() {
		return name;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
}
