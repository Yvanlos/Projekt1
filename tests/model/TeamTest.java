package model;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.*;


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
        URI testPicture2=URI.create("test2");
        Developer testDeveloper2=new Developer("name2",testPicture2);
        team.addDeveloper(testDeveloper2);
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
    }


}