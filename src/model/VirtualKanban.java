package model;

import java.util.ArrayList;

public class VirtualKanban {

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
     */
    public void addTeam(Team team) {
        this.team.add(team);
    }
    /**
     * removes a team from the team list, if its contained
     */
    public void removeTeam(Team team) {
        this.team.remove(team);
    }
    /**
     * adds a new project to the project list
     */
    public void addProject(Project project) {
        this.project.add(project);
    }
    /**
     * removes a project from the project list, if its contained
     */
    public void removeProject(Project project) {
        this.project.remove(project);
    }
    /**
     * Getter for the project list
     */
    public ArrayList<Project> getProject() {
        return project;
    }
    /**
     * Getter form the team list
     */
    public ArrayList<Team> getTeam() {
        return team;
    }
    /**
     * Constructor initialises team and project lists
     */
    public void setProject(ArrayList<Project> project ){
        this.project = project ;
    }
    /**
     * Constructor initialises team and project lists
     */
    public void setTeam(ArrayList<Team> team) {
        this.team = team;
    }
}
