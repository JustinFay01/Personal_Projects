package NumberConverter.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;

public class ConvertGUI {

	private JFrame frmNumberConverter;
	private JTextField toBeConverted;

	/**
	 * Launch the application.
	 */
	public static void runWindow() {
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
		
		JComboBox toCombo = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("Enter Number");
		
		toBeConverted = new JTextField();
		toBeConverted.setColumns(10);
		
		JComboBox fromCombo = new JComboBox();
		
		JLabel valueLabel = new JLabel("Value:");
		
		JTextPane textPane = new JTextPane();
		
		JButton convertButton = new JButton("= Convert");
		convertButton.setBorderPainted(false);
		convertButton.setOpaque(true);
		convertButton.setBackground(new Color(128, 255, 128));
		convertButton.setForeground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frmNumberConverter.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
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
							.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addComponent(valueLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(convertButton))
					.addContainerGap())
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(convertButton)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		frmNumberConverter.getContentPane().setLayout(groupLayout);
	}
	
	//Method contains all of the code for creating events 
	private void createEvents() {
			// TODO Auto-generated method stub
			
		}
}

