package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import application.Main;

public class ConsoleView implements ActionListener{
	
	public  Timer timer;
	
	public ConsoleView() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(2,3));
		
		JPanel universalPanel = new JPanel(new GridLayout(2,1));
		JLabel universalLabel = new JLabel("Start/Stop for ALL sensors:");
		JButton universalButton = new JButton("Start");
		universalPanel.add(universalLabel);
		universalPanel.add(universalButton);
		
		JPanel windSpeedPanel = new JPanel(new GridLayout(3,1));
		JLabel windSpeedLabel = new JLabel("Wind Speed:");
		JLabel windSpeedText = new JLabel("--");
		JButton windSpeedButton = new JButton("Start");
		windSpeedPanel.add(windSpeedLabel);
		windSpeedPanel.add(windSpeedText);
		windSpeedPanel.add(windSpeedButton);
		
		JPanel windDirectionPanel = new JPanel(new GridLayout(3,1));
		JLabel windDirectionLabel = new JLabel("Wind Direction:");
		JLabel windDirectionText = new JLabel("--");
		JButton windDirectionButton = new JButton("Start");
		windDirectionPanel.add(windDirectionLabel);
		windDirectionPanel.add(windDirectionText);
		windDirectionPanel.add(windDirectionButton);
		
		JPanel humidityPanel = new JPanel(new GridLayout(3,1));
		JLabel humidityLabel = new JLabel("Humidity:");
		JLabel humidityText = new JLabel("--");
		JButton humidityButton = new JButton("Start");
		humidityPanel.add(humidityLabel);
		humidityPanel.add(humidityText);
		humidityPanel.add(humidityButton);
		
		JPanel temperaturePanel = new JPanel(new GridLayout(3,1));
		JLabel temperatureLabel = new JLabel("Temperature:");
		JLabel temperatureText = new JLabel("--");
		JButton temperatureButton = new JButton("Start");
		temperaturePanel.add(temperatureLabel);
		temperaturePanel.add(temperatureText);
		temperaturePanel.add(temperatureButton);
		
		JPanel rainPanel = new JPanel(new GridLayout(3,1));
		JLabel rainLabel = new JLabel("Rain Collector:");
		JLabel rainText = new JLabel("--");
		JButton rainButton = new JButton("Start");
		rainPanel.add(rainLabel);
		rainPanel.add(rainText);
		rainPanel.add(rainButton);
		
		
//		// Text area to show the result
//		JTextArea displayConsole = new JTextArea(30, 30);
//		displayConsole.setEditable(false);
//
//		// Scroll panel
//		JScrollPane scrollPane = new JScrollPane(displayConsole, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane.setBounds(10, 20, 960, 500);
//
//		// Auto-scroll for scroll panel 
//		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
//	        public void adjustmentValueChanged(AdjustmentEvent e) {  
//	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
//	        }
//	    });
		
		// Buttons
		//startButton.setBounds(300, 700, 200, 50);
		//stopButton.setBounds(533, 700, 200, 50);
		//panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		//panel.setBounds(10, 32, 274, 33);
		//panel.setLayout(null);
		panel.add(windSpeedPanel);
		panel.add(windDirectionPanel);
		panel.add(humidityPanel);
		panel.add(temperaturePanel);
		panel.add(rainPanel);
		panel.add(universalPanel);

		universalButton.addActionListener(e -> {
			if (universalButton.getText().equals("Start")) {
				//start all sensors
			} else if (universalButton.getText().equals("Stop")) {
				//stop all sensors
			}
			buttonLabelChange(universalButton);
		});
		
		windSpeedButton.addActionListener(e -> {
			if (windSpeedButton.getText().equals("Start")) {
				//start wind speed sensor
			} else if (windSpeedButton.getText().equals("Stop")) {
				//stop wind speed sensor
			}
			buttonLabelChange(windSpeedButton);
		});
		
		windDirectionButton.addActionListener(e -> {
			if (windDirectionButton.getText().equals("Start")) {
				//start wind direction sensor
			} else if (windDirectionButton.getText().equals("Stop")) {
				//stop wind direction sensor
			}
			buttonLabelChange(windDirectionButton);
		});
		
		temperatureButton.addActionListener(e -> {
			if (temperatureButton.getText().equals("Start")) {
				//start temperature sensor
			} else if (temperatureButton.getText().equals("Stop")) {
				//stop temperature sensor
			}
			buttonLabelChange(temperatureButton);
		});
		
		humidityButton.addActionListener(e -> {
			if (humidityButton.getText().equals("Start")) {
				//start humidity sensor
			} else if (humidityButton.getText().equals("Stop")) {
				//stop humidity sensor
			}
			buttonLabelChange(humidityButton);
		});
		
		rainButton.addActionListener(e -> {
			if (rainButton.getText().equals("Start")) {
				//start rain sensor
			} else if (rainButton.getText().equals("Stop")) {
				//stop rain sensor
			}
			buttonLabelChange(rainButton);
		});
		
		// Basic frame set up
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather sensor");
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.add(panel);
		frame.setVisible(true);

		// Start printing out the data
//		if (running) return;
//		timer = new Timer();
//		timer.schedule(new TimerTask() {
//			@Override
//            public void run() {
//				running = true;
//				//displayConsole.append(Main.myIntegratedSensorSuite+"\n");
//            }
//		}, 1000, 1000); //runs once initially then again every 3 seconds
	}
	
	public void buttonLabelChange(JButton button) {
		if (button.getText().equals("Start")) {
			button.setText("Stop");
		} else if (button.getText().equals("Stop")) {
			button.setText("Start");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}

