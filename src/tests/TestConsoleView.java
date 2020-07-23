package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import view.ConsoleView;

class TestConsoleView {
	
	ConsoleView myConsoleView;

	/**
	 * Test constructor.
	 */
	@Test
	void testConstructor() {
		myConsoleView = new ConsoleView();
		assert(myConsoleView != null);
	}
	
	/**
	 * Test listener.
	 */
	@Test
	void testListener() {
		myConsoleView = new ConsoleView();
		myConsoleView.checkUniversalButton();
	}

}
