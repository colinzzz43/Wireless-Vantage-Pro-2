package View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.Timer;

public class GUI implements ActionListener{
	
	public GUI() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton stopButton = new JButton("Stop");
		JButton pauseButton = new JButton("Pause");
		JButton executeButton = new JButton("Execute");

		
		// Sensors
		// Probably make a sensor method to display each data
		
		
		
		
		
		// Text area to show the result
		JTextArea displayConsole = new JTextArea(30, 30);
		displayConsole.setEditable(false);

		// Scroll panel
		JScrollPane scrollPane = new JScrollPane(displayConsole, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 20, 960, 500);

		
		
		Timer timer = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue()+10);
                if (scrollPane.getVerticalScrollBar().getValue()>=scrollPane.getVerticalScrollBar().getMaximum()) {
                    ((Timer)e.getSource()).stop();
                }
			}
			
		});
		
		
		// Buttons
		executeButton.setBounds(370, 700, 100, 20);
		executeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Start printing out the data
				timer.start();
				for (int i = 0; i < 5000; i++) {
					displayConsole.append("Testing\n");
				}
			}
			
		});
		
		
		pauseButton.setBounds(470, 700, 100, 20);
		pauseButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// Pause the printing service
			
			}
			
		});
		
		
		stopButton.setBounds(570, 700, 100, 20);
		stopButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// Terminate the printing service
				timer.stop();
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
		panel.add(executeButton);
		panel.add(pauseButton);
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
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	


}

