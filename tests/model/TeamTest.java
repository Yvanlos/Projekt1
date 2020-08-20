package model;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.*;

public class TeamTest {

    private Team team;
    @Before
    public void setUp() throws Exception {
        team=new Team("testTeam");


    }

    @Test
    public void addDeveloper() {
        URI testPicture2=URI.create("test2");
        Developer testDeveloper2=new Developer("name2",testPicture2);
        team.addDeveloper(testDeveloper2);
    }

    @Test
    public void removeDeveloper() {
        URI testPicture1=URI.create("test1");
        Developer testDeveloper1=new Developer("name2",testPicture1);
        team.addDeveloper(testDeveloper1);
        team.removeDeveloper(testDeveloper1);
    }

    @Test
    public void getName() {
    }

    @Test
    public void getDevelopers() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void setDevelopers() {
    }
}