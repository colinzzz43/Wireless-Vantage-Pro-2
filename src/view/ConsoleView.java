package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import application.Main;

public class ConsoleView implements ActionListener{
	
	public  Timer timer;
	JFrame frame;
	JPanel panel;
	JPanel universalPanel;
	JLabel universalLabel;
	JButton universalButton;
	JPanel windSpeedPanel;
	JLabel windSpeedLabel;
	JLabel windSpeedText;
	JButton windSpeedButton;
	JPanel windDirectionPanel;
	JLabel windDirectionLabel;
	JLabel windDirectionText;
	JButton windDirectionButton;
	JPanel humidityPanel;
	JLabel humidityLabel;
	JLabel humidityText;
	JButton humidityButton;
	JPanel temperaturePanel;
	JLabel temperatureLabel;
	JLabel temperatureText;
	JButton temperatureButton;
	JPanel rainPanel;
	JLabel rainLabel;
	JLabel rainText;
	JButton rainButton;
    public String myCurrentWindDirection;
    public String myCurrentWindSpeed;
    public int myCurrentHumidity;
    public int myCurrentTemperature;
    public double myCurrentRainAmount;
	
	public ConsoleView() {

		//frame setup
		frame = new JFrame();
		panel = new JPanel(new GridLayout(2,3));
		
		universalPanel = new JPanel(new GridLayout(2,1));
		universalLabel = new JLabel("Start/Stop for ALL sensors:");
		universalButton = new JButton("Start");
		universalPanel.add(universalLabel);
		universalPanel.add(universalButton);
		
		windSpeedPanel = new JPanel(new GridLayout(3,1));
		windSpeedLabel = new JLabel("Wind Speed:");
		windSpeedText = new JLabel("--");
		windSpeedButton = new JButton("Start");
		windSpeedPanel.add(windSpeedLabel);
		windSpeedPanel.add(windSpeedText);
		windSpeedPanel.add(windSpeedButton);
		
		windDirectionPanel = new JPanel(new GridLayout(3,1));
		windDirectionLabel = new JLabel("Wind Direction:");
		windDirectionText = new JLabel("--");
		windDirectionButton = new JButton("Start");
		windDirectionPanel.add(windDirectionLabel);
		windDirectionPanel.add(windDirectionText);
		windDirectionPanel.add(windDirectionButton);
		
		humidityPanel = new JPanel(new GridLayout(3,1));
		humidityLabel = new JLabel("Humidity:");
		humidityText = new JLabel("--");
		humidityButton = new JButton("Start");
		humidityPanel.add(humidityLabel);
		humidityPanel.add(humidityText);
		humidityPanel.add(humidityButton);
		
		temperaturePanel = new JPanel(new GridLayout(3,1));
		temperatureLabel = new JLabel("Temperature:");
		temperatureText = new JLabel("--");
		temperatureButton = new JButton("Start");
		temperaturePanel.add(temperatureLabel);
		temperaturePanel.add(temperatureText);
		temperaturePanel.add(temperatureButton);
		
		rainPanel = new JPanel(new GridLayout(3,1));
		rainLabel = new JLabel("Rain Collector:");
		rainText = new JLabel("--");
		rainButton = new JButton("Start");
		rainPanel.add(rainLabel);
		rainPanel.add(rainText);
		rainPanel.add(rainButton);
		
		panel.add(windSpeedPanel);
		panel.add(windDirectionPanel);
		panel.add(humidityPanel);
		panel.add(temperaturePanel);
		panel.add(rainPanel);
		panel.add(universalPanel);
		
		//timer keeping the data refreshed
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
            public void run() {
			    myCurrentWindDirection = Main.myIntegratedSensorSuite.myCurrentWindDirection;
			    myCurrentWindSpeed = Main.myIntegratedSensorSuite.myCurrentWindSpeed;
			    myCurrentHumidity = Main.myIntegratedSensorSuite.myCurrentHumidity;
			    myCurrentTemperature = Main.myIntegratedSensorSuite.myCurrentTemperature;
			    myCurrentRainAmount = Main.myIntegratedSensorSuite.myCurrentRainAmount;
			    refreshSensorData();
            }
		}, 0, 1000); //runs once initially then again every 3 seconds

		
		//begin ActionListeners for each button
		universalButton.addActionListener(e -> {
			if (universalButton.getText().equals("Start")) {
				windSpeedText.setText(myCurrentWindSpeed);
				windDirectionText.setText(myCurrentWindDirection);
				temperatureText.setText(""+myCurrentTemperature);
				humidityText.setText(""+myCurrentHumidity);
				rainText.setText(""+myCurrentRainAmount);
			} else if (universalButton.getText().equals("Stop")) {
				windSpeedText.setText("--");
				windDirectionText.setText("--");
				temperatureText.setText("--");
				humidityText.setText("--");
				rainText.setText("--");
			}
			buttonLabelChange(universalButton);
			buttonLabelChange(windSpeedButton);
			buttonLabelChange(windDirectionButton);
			buttonLabelChange(temperatureButton);
			buttonLabelChange(humidityButton);
			buttonLabelChange(rainButton);
		});
		
		windSpeedButton.addActionListener(e -> {
			if (windSpeedButton.getText().equals("Start")) {
				windSpeedText.setText(myCurrentWindSpeed);
			} else if (windSpeedButton.getText().equals("Stop")) {
				windSpeedText.setText("--");
			}
			buttonLabelChange(windSpeedButton);
			checkUniversalButton();
		});
		
		windDirectionButton.addActionListener(e -> {
			if (windDirectionButton.getText().equals("Start")) {
				windDirectionText.setText(myCurrentWindDirection);
			} else if (windDirectionButton.getText().equals("Stop")) {
				windDirectionText.setText("--");
			}
			buttonLabelChange(windDirectionButton);
			checkUniversalButton();
		});
		
		temperatureButton.addActionListener(e -> {
			if (temperatureButton.getText().equals("Start")) {
				temperatureText.setText(""+myCurrentTemperature + "° F");
			} else if (temperatureButton.getText().equals("Stop")) {
				temperatureText.setText("--");
			}
			buttonLabelChange(temperatureButton);
			checkUniversalButton();
		});
		
		humidityButton.addActionListener(e -> {
			if (humidityButton.getText().equals("Start")) {
				humidityText.setText(""+myCurrentHumidity + "%");
			} else if (humidityButton.getText().equals("Stop")) {
				humidityText.setText("--");
			}
			buttonLabelChange(humidityButton);
			checkUniversalButton();
		});
		
		rainButton.addActionListener(e -> {
			if (rainButton.getText().equals("Start")) {
				rainText.setText(""+myCurrentRainAmount);
			} else if (rainButton.getText().equals("Stop")) {
				rainText.setText("--");
			}
			buttonLabelChange(rainButton);
			checkUniversalButton();
		});
		
		// Basic frame set up
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather sensor");
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.add(panel);
		frame.setVisible(true);

	}
	
	public void buttonLabelChange(JButton button) {
		if (button.getText().equals("Start")) {
			button.setText("Stop");
		} else if (button.getText().equals("Stop")) {
			button.setText("Start");
		}
	}
	
	public void refreshSensorData() {
		if(!windSpeedText.getText().equals("--")) {
			windSpeedText.setText(myCurrentWindSpeed);
		}
		if(!windDirectionText.getText().equals("--")) {
			windDirectionText.setText(myCurrentWindDirection);
		}
		if(!temperatureText.getText().equals("--")) {
			temperatureText.setText(""+myCurrentTemperature + "° F");
		}
		if(!humidityText.getText().equals("--")) {
			humidityText.setText(""+myCurrentHumidity + "%");
		}
		if(!rainText.getText().equals("--")) {
			rainText.setText(""+myCurrentRainAmount);
		}
		
	}
	
	public void checkUniversalButton() {
		if(windSpeedText.getText().equals("--") 
				&& windDirectionText.getText().equals("--") 
				&& temperatureText.getText().equals("--") 
				&& humidityText.getText().equals("--") 
				&& rainText.getText().equals("--")) {
			universalButton.setText("Start");
		} else {
			if(!windSpeedText.getText().equals("--") 
					&& !windDirectionText.getText().equals("--") 
					&& !temperatureText.getText().equals("--") 
					&& !humidityText.getText().equals("--") 
					&& !rainText.getText().equals("--")) {
				universalButton.setText("Stop");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}

