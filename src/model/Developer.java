package model;

import java.net.URI;
import java.util.ArrayList;

/**
 * The Developer class that holds a name and a profile picture.
 * 
 */
public class Developer {

    /**
 	 * The developers name.
 	 */
    private String name;

    /**
 	 * An URI that leads to the developers profile picture.
 	 */
    private URI picture;

    /**
 	 * Dedicates if the developer is currently assigned to a task.
 	 */
    private boolean atWork;

    /**
 	 * List of all completed tasks.
 	 */
    private ArrayList<CompletedStage> completedStageList;

    /**
 	 * Currently assigned task.
 	 */
    private CompletedStage currentTaskStage;
    
    
    /**
     * Constructor for a new Developer.
     * 
     * @param name The name of the new Developer.
     * @param picture The URI that leads to the Developers picture.
     */
    public Developer(String name, URI picture) {
		this.name = name;
		this.picture = picture;
		completedStageList = new ArrayList<CompletedStage>();
	}

	/**
 	 * Sets the current date as completionDate in currentTaskStage 
 	 * and adds the currentTaskStage to the completedStage list.
 	 * Then sets atWork to false.
 	 * 
 	 */
    public void addCompletedStage(){
    	
        currentTaskStage.setCompletionDate();
        completedStageList.add(currentTaskStage);
        
        setCurrentTaskStage(null);
        setAtWork(false);
    }

    /**
 	 * Drop the <b>currentTaskStage</b> and set <b>atWork</b> to false.
 	 * 
 	 */
    public void cancelTask(){
        setCurrentTaskStage(null);
        setAtWork(false);
    }
    
    /**
     * Returns the name of the Developer.
     * 
     * @return Name of the Developer
     */
	public String getName() {
		return name;
	}


	/**
	 * Returns an URI to the developers picture.
	 * @return URI to the deveopers picture.
	 */
	public URI getPicture() {
		return picture;
	}

	/**
	 * Returns if the developer is currently working on a task.
	 * @return boolean
	 */
	public boolean isAtWork() {
		return atWork;
	}

	/**
	 * Sets if the developer is working on a task.
	 * @param atWork boolean
	 */
	public void setAtWork(boolean atWork) {
		this.atWork = atWork;
	}

	/**
	 * Returns a List of all CompletedStages completed by the developer
	 * @return CompletedStage-List
	 */
	public ArrayList<CompletedStage> getCompletedStageList() {
		return completedStageList;
	}

	/**
	 * Returns the current TaskStage the developer is working on.
	 * @return current CompletedStage
	 */
	public CompletedStage getCurrentTaskStage() {
		return currentTaskStage;
	}

	/**
	 * Sets the current CompletedStage of the developer.
	 * @param currentTaskStage the new CompletedStage object.
	 */
	public void setCurrentTaskStage(CompletedStage currentTaskStage) {
		this.currentTaskStage = currentTaskStage;
	}
    
    
    
}
