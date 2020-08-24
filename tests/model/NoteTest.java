package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;

/**
 * Tests the Note class
 */
public class NoteTest {

    private Note testClass;

    /**
     * Sets up a clean testing environment before every test.
     */
    @Before
    public void setUp() {
        testClass = new Note("test", "TestContent", LocalDateTime.now());
    }

    /**
     * Tests the setName() and getName() method
     */
    @Test
    public void setAndGetName() {
        testClass.setName("test2");
        assertEquals("test2", testClass.getName());
    }

    /**
     * Tests the setContent() and getContent() method
     */
    @Test
    public void setAndGetContent() {
        testClass.setContent("TestContent2");
        assertEquals("TestContent2", testClass.getContent());
    }

    /**
     * Tests the setCreationDate() and getCreationDate() method
     */
    @Test
    public void setAndGetCreationDate() {
        testClass.setCreationDate(LocalDateTime.MAX);
        assertEquals(LocalDateTime.MAX, testClass.getCreationDate());
    }

}