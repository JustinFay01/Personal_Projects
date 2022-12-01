package NumberConverter.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import convert.Converter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;

public class ConvertGUI {

	private JFrame frmNumberConverter;
	private JButton convertButton;
	private JComboBox fromCombo;
	private JComboBox toCombo;
	private Converter con;
	private JTextField toBeConverted;
	private JTextArea valueDisplay;
	private JButton btmSwap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertGUI window = new ConvertGUI();
					window.frmNumberConverter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConvertGUI() {
		initialize();
		createEvents();
		con = new Converter();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNumberConverter = new JFrame();
		frmNumberConverter.getContentPane().setForeground(new Color(170, 185, 213));
		frmNumberConverter.setForeground(new Color(170, 185, 213));
		frmNumberConverter.setBackground(new Color(170, 185, 213));
		frmNumberConverter.setIconImage(Toolkit.getDefaultToolkit().getImage(ConvertGUI.class.getResource("/NumberConverter/resources/convertIcon128.png")));
		frmNumberConverter.setTitle("Number Converter");
		frmNumberConverter.setBounds(100, 100, 450, 300);
		frmNumberConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel fromLabel = new JLabel("From:");
		
		JLabel toLabel = new JLabel("To:");
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter number to be converted:");
		
		toBeConverted = new JTextField();
		toBeConverted.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		toBeConverted.setColumns(10);
		
		
		//What to convert From
		String[] convertOptions = { "Decimal", "Binary", "Octal", "Hexadecimal"};
		fromCombo = new JComboBox(convertOptions);
		
		
		toCombo = new JComboBox(convertOptions);
		toCombo.setSelectedIndex(1);
		
		
		
		/*
		 * Windows Builder Code
		 */
		JLabel valueLabel = new JLabel("Value:");
		
		convertButton = new JButton("= Convert");
		
		convertButton.setBorderPainted(false);
		convertButton.setOpaque(true);
		convertButton.setBackground(new Color(128, 255, 128));
		convertButton.setForeground(new Color(255, 255, 255));
		
		valueDisplay = new JTextArea();
		valueDisplay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		valueDisplay.setVerifyInputWhenFocusTarget(false);
		valueDisplay.setTabSize(75);
		valueDisplay.setLineWrap(true);
		valueDisplay.setEditable(false);
		valueDisplay.setOpaque(true);
		
		btmSwap = new JButton("Swap");
		
		GroupLayout groupLayout = new GroupLayout(frmNumberConverter.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(valueDisplay, Alignment.LEADING)
						.addComponent(toBeConverted, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(fromLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(fromCombo, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(toLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(109))
								.addComponent(toCombo, 0, 186, Short.MAX_VALUE)))
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(valueLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(convertButton)
							.addGap(18)
							.addComponent(btmSwap, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fromLabel)
						.addComponent(toLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(toCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fromCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toBeConverted, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(valueLabel)
					.addGap(1)
					.addComponent(valueDisplay, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(convertButton)
						.addComponent(btmSwap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		frmNumberConverter.getContentPane().setLayout(groupLayout);
	}
	
	//Handles the actual conversion and creates action event based off of convert
	private void createEvents() {
		
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Selected Item From Combo Box
				String from = (String)fromCombo.getSelectedItem();
				//Get text that needs to be converted
				String toConvert = toBeConverted.getText();
				
				long converted = 0;
				
				//Convert Text
				try {
				switch (from) {
				case "Decimal":
					converted = Integer.valueOf(toConvert);
					break;
					
				case "Binary":
					converted = con.btoD(toConvert);
					
					break;
				case "Octal":
					converted = con.otoD(toConvert);
					break;
				case "Hexadecimal":
					converted = con.htoD(toConvert);
					break;
				}
				
				
				
				//Print in value box
				String to = (String)toCombo.getSelectedItem();
				ArrayList<String> finalCon = new ArrayList<>();
				
				//conversion Error
				if(converted == -1)	{
					valueDisplay.setText("Invalid Number");
				}
				else {//Correct Number
				switch(to) {
				case "Decimal":
					valueDisplay.setText(String.valueOf(converted));
					break;
				case "Binary":
					finalCon = con.toBinary(converted);	
					valueDisplay.setText(con.arrayToString(finalCon));
			
					break;
				case "Octal":
					finalCon = con.toOctal(converted);	
					valueDisplay.setText(con.arrayToString(finalCon));
					break;
				case "Hexadecimal":
					finalCon = con.toHex(converted);	
					valueDisplay.setText(con.arrayToString(finalCon));
					break;
					}
				}
			}
				catch (NumberFormatException error) {
					valueDisplay.setText("Oh No! Number Format Exception!");
				}
				
			}
			
		});
		
		btmSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Swap Combo Boxes
				String tmp = (String)toCombo.getSelectedItem();
				toCombo.setSelectedItem((String)fromCombo.getSelectedItem());
				fromCombo.setSelectedItem(tmp);
				
				//clear text
				valueDisplay.setText("");
				toBeConverted.setText("");
			}
		});
		}
}

