package model;

import static org.junit.Assert.*;

import java.net.URI;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class DeveloperTest {
	
	private URI profilePicture;

	@Before
	public void setUp() throws Exception {
		profilePicture = URI.create("testURI");
	}

	
	/**
	 * Tests the constructor
	 * 
	 */
	@Test
	public void testDeveloper() {
		String devName = "Max Mustermann";
		Developer developer = new Developer(devName, profilePicture);
		assertEquals(developer.getName(), devName);
		assertEquals(developer.getPicture(), profilePicture);
	}

	/**
	 * Tests the method addCompletedStage(), getCompletedStageList()
	 */
	@Test
	public void testAddCompletedStage() {
		Developer dev = new Developer("TestCancelTask", profilePicture);
		
		CompletedStage stage1 = new CompletedStage(null, null);
		
		dev.setCurrentTaskStage(stage1);
		dev.addCompletedStage();
		
		assertEquals(dev.getCurrentTaskStage(), null);
		assertEquals(dev.isAtWork(), false);
		assertEquals(dev.getCompletedStageList().get(0), stage1);
	}
	
	/**
	 * Tests the method cancelTask()
	 */
	@Test
	public void testCancelTask() {
		Developer developer = new Developer("TestCancelTask", profilePicture);
		
		Task testTask = new Task("TestTask", "this is a test task", LocalDateTime.now());
		CompletedStage testStage = new CompletedStage(testTask, null);
		
		developer.setCurrentTaskStage(testStage);
		developer.cancelTask();
		assertEquals(developer.getCurrentTaskStage(), null);
		assertEquals(developer.isAtWork(), false);
	}
	
	
	/**
	 * Tests the methods isAtWork() and setAtWork(boolean)
	 */
	@Test
	public void testIsAtWork() {
		Developer dev = new Developer("TestIsAtWork", profilePicture);
		dev.setAtWork(true);
		assertEquals(dev.isAtWork(), true);
		dev.setAtWork(false);
		assertEquals(dev.isAtWork(), false);
	}
	
	/**
	 * Tests the method getName()
	 * 
	 */
	@Test
	public void testGetName() {
		Developer dev = new Developer("TestGetName", profilePicture);
		assertEquals(dev.getName(), "TestGetName");
	}
	
	/**
	 * Tests the method getPicture()
	 */
	@Test
	public void testGetPicture() {
		Developer dev = new Developer("TestIsAtWork", profilePicture);
		assertEquals(dev.getPicture(), URI.create("testURI"));
	}

	/**
	 * Tests the method getCurrentTaskStage() and setCurrentTaskStage(CompletedStage)
	 */
	@Test
	public void testGetCurrentTaskStage() {
		Developer dev = new Developer("TestIsAtWork", profilePicture);
		
		CompletedStage testStage = new CompletedStage(null, null);
		
		dev.setCurrentTaskStage(testStage);
		assertEquals(dev.getCurrentTaskStage(), testStage);
	}

}
