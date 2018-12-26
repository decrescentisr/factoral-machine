package main;

import java.awt.*;
import java.awt.event.*;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import helpers.InputHelpers;
import helpers.OutputHelpers;

public class FactoralMachine extends JPanel
{
	public static JTextField txtNumber;
	public static JTextField txtResult;
	public static JLabel lblNumber;
	public static JLabel lblResult;
	public static JButton btnResult;
	public static JButton btnClear;
	FactoralMachine e;
	public static int fact = 1, m;
	String msg;
	
	private DecimalFormat df = new DecimalFormat("$#,##0.00");

	public FactoralMachine() {
		super();
		createPanel();
	}
	
	private void createPanel() {
		super.setLayout(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();
		
		bag.fill = GridBagConstraints.BOTH;
		bag.anchor = GridBagConstraints.FIRST_LINE_START;
		bag.insets = new Insets(5,5,5,5);
		
		//column 0, row 0
		bag.gridx = 0;
		bag.gridy = 0;
		lblNumber = new JLabel();
		lblNumber.setText("Enter the Number ");
		super.add(lblNumber, bag);
		
		//column 1, row 0
		bag.gridx = 1;
		bag.gridy = 0;
		txtNumber = new JTextField(20);
		super.add(txtNumber, bag);
		
		//column 0, row 1
		bag.gridx = 0;
		bag.gridy = 1;
		lblResult = new JLabel();
		lblResult.setText("Result: ");
		super.add(lblResult, bag);
		
		//column 1, row 1
		bag.gridx = 1;
		bag.gridy = 1;
		txtResult = new JTextField(10);
		txtResult.setEditable(false);
		super.add(txtResult, bag);
		
		//row 2, span both columns
		//take up half the column
		bag.gridx = 0;
		bag.gridy = 4;
		bag.gridwidth = 2;
		btnResult = new JButton ("Calculate Result");
		btnResult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = txtNumber.getText();
				if(str != "") {
					int num = Integer.parseInt(str);
					for(int i = num; i > 0; i--) {
						fact = fact * i;
					}
					
					msg = "" + fact;
					txtResult.setText(msg);
					fact = 1;
				}
				
			}	
		});
		super.add(btnResult, bag);
		
		bag.gridx = 2;
		bag.gridy = 4;
		bag.gridwidth = 2;
		btnClear = new JButton ("Clear");
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainForm.clearResults();
				
			}
			
		});
		super.add(btnClear, bag);
	}


	



	

}
