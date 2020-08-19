package controller;

import model.VirtualKanban;
import java.lang.UnsupportedOperationException;

public class VirtualKanbanController {

    /**
 	 * Reference to the ProjectController, witch can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private ProjectController projectController;

    /**
 	 * Reference to the TaskController, witch can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private TaskController taskController;

    /**
 	 * Reference to the DeveloperController, witch can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private DeveloperController developerController;

    /**
 	 * Reference to the TeamController, witch can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private TeamController teamController;

    /**
 	 * Reference to the IOController, witch can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private IOController iOController;

    /**
 	 * Reference to the VirtualKanban (Main-Class form Model)
 	 */
    private VirtualKanban virtualKanban;

    /**
 	 * Reference to the StatisticController, witch can be used by other controllers, the GUI or the VirtualKanban-Class
 	 */
    private StatisticController statisticController;

    public VirtualKanbanController() {
    }

    public VirtualKanban getVirtualKanban() {
        return virtualKanban;
    }
}
