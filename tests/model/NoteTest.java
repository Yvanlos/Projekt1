package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class NoteTest {

    private Note testClass;

    @Before
    public void setUp() {
        testClass = new Note("test", "TestContent", LocalDateTime.now());
    }

    @Test
    public void setAndGetName() {
        testClass.setName("test2");
        assertEquals("test2", testClass.getName());
    }

    @Test
    public void setAndGetContent() {
        testClass.setContent("TestContent2");
        assertEquals("TestContent2", testClass.getContent());
    }

    @Test
    public void setAndGetCreationDate() {
        testClass.setCreationDate(LocalDateTime.MAX);
        assertEquals(LocalDateTime.MAX, testClass.getCreationDate());
    }

}