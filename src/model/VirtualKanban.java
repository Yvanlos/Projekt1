package model;

import java.util.Collection;
import java.lang.UnsupportedOperationException;

public class VirtualKanban {

    /**
 	 * Collection of all existing projects in the entire Program
 	 */
    private Collection<Project> project;

    /**
 	 * Collection of all existing teams in the entire Program
 	 */
    private Collection<Team> team;

    /***
     *
     */
    public VirtualKanban() {
    }

    /***
     *
     * @return the all projects that are listed in this Collection
     */
    public Collection<Project> getProject() {
        return project;
    }

    /***
     *
     * @return return all teams listed  in this collection
     */
    public Collection<Team> getTeam() {
        return team;
    }

    /***
     *
     * @param project is the Project collection we are assotiating the our project Collection
     */
    public void setProject(Collection<Project> project ){
        this.project = project ;
    }

    /***
     *
     * @param team is the Team Collection that are going to be use in each project
     */
    public void setTeam(Collection<Team> team) {
        this.team = team;
    }
}
