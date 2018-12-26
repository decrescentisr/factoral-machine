package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import helpers.ApplicationHelpers;


public class MainForm extends JFrame
{
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 500;

	JTabbedPane jtp;
	
	private JLabel lblWelcome;
	private JPanel framePanel;
		
	private FactoralMachine factoralMachine;
	
	private ExitButton exitButton;
	
	public MainForm(){
		super();
		createTabPane();
		
		setFrame();
		
		ApplicationHelpers.displayApplicationInformation("Factoral Machine", "Robert DeCrescentis", "Business Application");
	}
	
	

	private void createTabPane()
	{
		super.setLayout(new GridBagLayout());
		framePanel = new JPanel(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();
		
		jtp = new JTabbedPane();
		jtp.addTab("Factoral Machine", new FactoralMachine());
		
		
		lblWelcome = new JLabel();
		lblWelcome.setText("Factoral Machine");
		bag.gridx = 0;
		bag.gridy = 0;
		bag.weighty = 0;
		framePanel.add(lblWelcome, bag);
				
		bag.fill = GridBagConstraints.HORIZONTAL;
		bag.gridx = 0;
		bag.gridy = 0;
		bag.ipady = 250;
		bag.weightx = 1;
		bag.weighty = .75;
		this.add(jtp, bag);
		
		bag.fill = GridBagConstraints.CENTER;
		bag.gridx = 0;
		bag.gridy = 1;
		bag.ipady = 40;
		bag.ipadx = 400;
		bag.weightx = 1;
		bag.weighty = .25;
		bag.insets = new Insets(10,0,10,0);
		
		this.add(new ExitButton("Factoral Machine"), bag);
		
		//create the main menu object, but will need to create the main menu first, then come back and complete these steps
		MenuMain mainMenu = new MenuMain(this);
		this.setJMenuBar(mainMenu);
	}
	

	
	private void setFrame()
	{
		Dimension windowSize = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
		super.setTitle("Factoral Machine");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(windowSize);
		
		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}
	
	public static void clearResults(){
		FactoralMachine.txtNumber.setText("");
		FactoralMachine.txtResult.setText("");

	}

}
