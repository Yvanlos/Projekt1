package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.lang.UnsupportedOperationException;
import java.util.List;

/**
 * A team is a group of developers
 */
public class Team implements Serializable {

    /**
 	 * unique name of the team
 	 */
    private String name;

    /**
 	 * list of developers in the team
 	 */
    private ArrayList<Developer> developers;

	public Team(String name) {
		this.name = name;
		this.developers = new ArrayList<Developer>();
	}

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
 	 * @param developer
	 * 					developer, which is removed from the team
 	 *
 	 */
    public void removeDeveloper(Developer developer) {
        this.developers.remove(developer);
    }

	/**
	 * returns the name of the team
	 * @return name of the team
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns an ArrayList of developers
	 * @return ArrayList of developers
	 */
	public ArrayList<Developer> getDevelopers() {
		return developers;
	}

	/**
	 * sets the name of a team
	 * @param name
	 * 				new name of the team
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * sets a new ArrayList of developers
	 * @param developers
	 * 					new ArrayList of developers
	 */
	public void setDevelopers(ArrayList<Developer> developers) {
		this.developers = developers;
	}
}
