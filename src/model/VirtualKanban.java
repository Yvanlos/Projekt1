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

    public VirtualKanban() {
    }
}
