package model;

import java.util.Collection;
import java.lang.UnsupportedOperationException;
import java.util.LinkedList;

public class VirtualKanban {

    /**
 	 * Collection of all existing projects in the entire Program
 	 */
    private LinkedList<Project> project;

    /**
 	 * Collection of all existing teams in the entire Program
 	 */
    private LinkedList<Team> team;

    /**
     * Constructor initialises team and project lists
     */
    public VirtualKanban() {
        team = new LinkedList<Team>();
        project = new LinkedList<Project>();
    }
    /**
     * adds a new Team to the team list
     */
    public void addTeam(Team t) {
        team.add(t);
    }
    /**
     * removes a team from the team list, if its contained
     */
    public void removeTeam(Team t) {
        team.remove(t);
    }
    /**
     * adds a new project to the project list
     */
    public void addProject(Project p) {
        project.add(p);
    }
    /**
     * removes a project from the project list, if its contained
     */
    public void removeProject(Project p) {
        project.remove(p);
    }
    /**
     * Getter for the project list
     */
    public LinkedList<Project> getProject() {
        return project;
    }
    /**
     * Getter form the team list
     */
    public LinkedList<Team> getTeam() {
        return team;
    }
    /**
     * Constructor initialises team and project lists
     */
    public void setProject(LinkedList<Project> project ){
        this.project = project ;
    }
    /**
     * Constructor initialises team and project lists
     */
    public void setTeam(LinkedList<Team> team) {
        this.team = team;
    }
}
