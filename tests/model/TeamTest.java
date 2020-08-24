package model;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests the Team class
 */
public class TeamTest {

    private Team team;

    /**
     * sets up a clean testing environment before every test.
     * @throws Exception gets thrown if setting up clean environment was unsuccessful
     */
    @Before
    public void setUp() throws Exception {
        team=new Team("testTeam");


    }

    /**
     * tests addDeveloper()
     */
    @Test
    public void addDeveloper() {
        URI testPicture2 = URI.create("test2");
        Developer testDeveloper2 = new Developer("name2",testPicture2);
        team.addDeveloper(testDeveloper2);
        assertTrue(team.getDevelopers().contains(testDeveloper2));
    }

    /**
     * tests removeDeveloper
     */
    @Test
    public void removeDeveloper() {
        URI testPicture1=URI.create("test1");
        Developer testDeveloper1=new Developer("name2",testPicture1);
        team.addDeveloper(testDeveloper1);
        team.removeDeveloper(testDeveloper1);
        assertFalse(team.getDevelopers().contains(testDeveloper1));
    }
    
    /**
     * tests setDevelopers
     */
    @Test
    public void testSetDevelopers() {
        Developer testDeveloper = new Developer("TestDev",null);
        ArrayList<Developer> newDevelopersList = new ArrayList<Developer>();
        newDevelopersList.add(testDeveloper);
        team.setDevelopers(newDevelopersList);
        assertTrue(team.getDevelopers().contains(testDeveloper));
    }


}