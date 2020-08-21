package controller;

import model.VirtualKanban;

/**
 * The main contoller which connects the contoller classes with the model
 */
public class VirtualKanbanController {

    /**
 	 * Reference to the ProjectController, which can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private final ProjectController projectController;

    /**
 	 * Reference to the TaskController, which can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private final TaskController taskController;

    /**
 	 * Reference to the DeveloperController, which can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private final DeveloperController developerController;

    /**
 	 * Reference to the TeamController, which can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private final TeamController teamController;

    /**
 	 * Reference to the IOController, which can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private final IOController iOController;

    /**
 	 * Reference to the VirtualKanban (Main-Class of model)
 	 */
    private VirtualKanban virtualKanban;

    /**
 	 * Reference to the StatisticController, which can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private final StatisticController statisticController;

    /**
     * Constructor of the virtualKanbanController
     *
     * TODO: replace 'new VirtualKanban()' with the loading mechanism from IOController
     */
    public VirtualKanbanController() {
        projectController = new ProjectController(this);
        taskController = new TaskController(this);
        developerController = new DeveloperController(this);
        teamController = new TeamController(this);
        iOController = new IOController(this);
        statisticController = new StatisticController(this);
        virtualKanban = new VirtualKanban();

        /*
        try{
            virtualKanban = getIOController().load();
        }
        catch (Exception e){
            virtualKanban = new VirtualKanban();
        }

         */
    }


    /**
     * Returns the ProjectController, which can be used by other controllers, the GUI or the VirtualKanban-Class
     *
     * @return ProjectController
     */
    public ProjectController getProjectController() {
        return projectController;
    }

    /**
     * Returns the TaskController, which can be used by other controllers, the GUI or the VirtualKanban-Class
     *
     * @return TaskController
     */
    public TaskController getTaskController() {
        return taskController;
    }

    /**
     * Returns the DeveloperController, which can be used by other controllers, the GUI or the VirtualKanban-Class
     *
     * @return DeveloperController
     */
    public DeveloperController getDeveloperController() {
        return developerController;
    }

    /**
     * Returns the TeamController, which can be used by other controllers, the GUI or the VirtualKanban-Class
     *
     * @return TeamController
     */
    public TeamController getTeamController() {
        return teamController;
    }

    /**
     * Returns the IOController, which can be used by other controllers, the GUI or the VirtualKanban-Class
     *
     * @return IOController
     */
    public IOController getIOController() {
        return iOController;
    }

    /**
     * Returns the VirtualKanban, which is the Main-Class of the model
     *
     * @return VirtualKanban
     */
    public VirtualKanban getVirtualKanban() {
        return virtualKanban;
    }

    /**
     * Returns the StatisticController, which can be used by other controllers, the GUI or the VirtualKanban-Class
     *
     * @return StatisticController
     */
    public StatisticController getStatisticController() {
        return statisticController;
    }

    public void setVirtualKanban(VirtualKanban virtualKanban) {
        this.virtualKanban = virtualKanban;
    }
}
