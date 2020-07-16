package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class GUI implements ActionListener{
	
	private Timer timer;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton stopButton = new JButton("Stop");
	JButton pauseButton = new JButton("Pause");
	JButton executeButton = new JButton("Execute");
	
	
	public GUI() {

		
		// Sensors
		
		
		// Text area to show the result
		JTextArea resultDisplay = new JTextArea(30, 30);
		resultDisplay.setEditable(false);
		resultDisplay.setBounds(10, 10, 240, 20);
		// Scroll panel
		JScrollPane scrollPane = new JScrollPane(resultDisplay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		// Buttons
		executeButton.setBounds(260, 10, 100, 20);
		executeButton.setLocation(100, 50);
		executeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Start printing out the data
				timer.start();
			}
			
		});
		
		
		stopButton.setBounds(10, 40, 320, 20);
		stopButton.setLocation(200, 50);
		stopButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// Terminate the printing service
				timer.stop();
			}
			
		});
		
		pauseButton.setBounds(10, 40, 320, 20);
		pauseButton.setLocation(200, 50);
		pauseButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// Pause the printing service
				
			}
			
		});
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(2, 1, 3, 3));
		

		panel.add(scrollPane);
		panel.add(executeButton);
		panel.add(pauseButton);
		panel.add(stopButton);

		// Basic frame set up
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather sensor");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);


	}
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	


}
