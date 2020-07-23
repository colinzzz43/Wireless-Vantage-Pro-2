package tests;

import javax.swing.JButton;

import org.junit.jupiter.api.Test;

import view.ConsoleView;

class TestConsoleView {
	
	ConsoleView myConsoleView;
	
	JButton testButton;

	/**
	 * Test constructor.
	 */
	@Test
	void testConstructor() {
		myConsoleView = new ConsoleView(false);
		assert(myConsoleView != null);
	}
	
	/**
	 * Test listener.
	 */
	@Test
	void testListener() {
		testButton = new JButton("Start");
		myConsoleView = new ConsoleView(false);
		myConsoleView.checkUniversalButton();
		myConsoleView.refreshSensorData();
		myConsoleView.checkUniversalButton();
		myConsoleView.buttonLabelChange(testButton);
		myConsoleView.buttonLabelChange(testButton);
		myConsoleView.triggerActions();
	}

}
