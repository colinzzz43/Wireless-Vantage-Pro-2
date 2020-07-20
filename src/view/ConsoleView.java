package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import application.Main;

public class ConsoleView implements ActionListener{
	
	public  Timer timer;
	
	private boolean running;
	
	public ConsoleView() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton stopButton = new JButton("Stop");
		JButton startButton = new JButton("Start");
		running = false;
		

		
		
		// Text area to show the result
		JTextArea displayConsole = new JTextArea(30, 30);
		displayConsole.setEditable(false);

		// Scroll panel
		JScrollPane scrollPane = new JScrollPane(displayConsole, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 20, 960, 500);

		// Auto-scroll for scroll panel 
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
	        public void adjustmentValueChanged(AdjustmentEvent e) {  
	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
	        }
	    });
		
		

		
		
		// Buttons
		startButton.setBounds(300, 700, 200, 50);
		startButton.addActionListener(new ActionListener() {

			@Override
			/**
			 * sets the program status to running and periodically prints the sensor data to the GUI
			 */
			public void actionPerformed(ActionEvent e) {
				// Start printing out the data
				if (running) return;
				timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
		            public void run() {
						running = true;
						displayConsole.append(Main.myIntegratedSensorSuite+"\n");
		            }
				}, 1000, 1000); //runs once initially then again every 3 seconds
				
			}
			
		});

		
		
		stopButton.setBounds(533, 700, 200, 50);
		stopButton.addActionListener(new ActionListener() {
			@Override
			/**
			 * terminates the timer that all sensors are running on and cancel printing of those values
			 */
			public void actionPerformed(ActionEvent e) {
				if (running) {
					timer.cancel();
					running = false;
				}
			}
		});

		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setBounds(10, 32, 274, 33);
		
//		executeButton.setAlignmentX(Component.LEFT_ALIGNMENT);
//		executeButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//		pauseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//		pauseButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//		stopButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
//		stopButton.setAlignmentY(Component.RIGHT_ALIGNMENT);
		
		
		panel.setLayout(null);
		panel.add(startButton);
		panel.add(stopButton);
		
		
		// Basic frame set up
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather sensor");
		frame.setSize(1000, 800);
		frame.setResizable(false);
		frame.add(scrollPane);
		frame.add(panel);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	


}

