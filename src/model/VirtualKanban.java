package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The VirtualKanban which has a reference to all projects and teams
 */
public class VirtualKanban implements Serializable {

    /**
 	 * Collection of all existing projects in the entire Program
 	 */
    private ArrayList<Project> project;

    /**
 	 * Collection of all existing teams in the entire Program
 	 */
    private ArrayList<Team> team;

    /**
     * Constructor initialises team and project lists
     */
    public VirtualKanban() {
        team = new ArrayList<>();
        project = new ArrayList<>();
    }

    /**
     * adds a new Team to the team list
     * @param team the team to be added to the list of teams
     */
    public void addTeam(Team team) {
        this.team.add(team);
    }

    /**
     * removes a team from the team list, if its contained
     * @param team the team to be removed from the list of teams
     */
    public void removeTeam(Team team) {
        this.team.remove(team);
    }

    /**
     * adds a new project to the project list
     * @param project the project to be added to the list of projects
     */
    public void addProject(Project project) {
        this.project.add(project);
    }

    /**
     * removes a project from the project list, if its contained
     * @param project the project to be removed from the list of projects
     */
    public void removeProject(Project project) {
        this.project.remove(project);
    }

    /**
     * Getter for the project list
     * @return ArrayList the ArrayList of projects
     */
    public ArrayList<Project> getProject() {
        return project;
    }

    /**
     * Getter form the team list
     * @return the ArrayList of teams
     */
    public ArrayList<Team> getTeam() {
        return team;
    }

    /**
     * Constructor initialises project list
     * @param project the ArrayList of projects
     */
    public void setProject(ArrayList<Project> project ){
        this.project = project ;
    }

    /**
     * Constructor initialises team list
     * @param team the ArrayList of teams
     */
    public void setTeam(ArrayList<Team> team) {
        this.team = team;
    }
}
