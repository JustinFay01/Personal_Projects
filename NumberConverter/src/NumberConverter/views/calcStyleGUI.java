package NumberConverter.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import java.awt.Font;

public class calcStyleGUI {

	private JFrame frmNumberConverter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calcStyleGUI window = new calcStyleGUI();
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
	public calcStyleGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNumberConverter = new JFrame();
		frmNumberConverter.setVisible(true);
		frmNumberConverter.getContentPane().setBackground(new Color(38, 38, 38));
		
		JCheckBox chcHex = new JCheckBox("Hex");
		chcHex.setForeground(new Color(255, 255, 255));
		chcHex.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		chcHex.setBorder(null);
		chcHex.setBackground(new Color(38, 38, 38));
		GroupLayout groupLayout = new GroupLayout(frmNumberConverter.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chcHex, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(208, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(105)
					.addComponent(chcHex)
					.addContainerGap(237, Short.MAX_VALUE))
		);
		frmNumberConverter.getContentPane().setLayout(groupLayout);
		frmNumberConverter.setBackground(new Color(0, 0, 0));
		frmNumberConverter.setTitle("Number Converter");
		frmNumberConverter.setIconImage(Toolkit.getDefaultToolkit().getImage(calcStyleGUI.class.getResource("/NumberConverter/resources/convertIcon128.png")));
		frmNumberConverter.setBounds(100, 100, 325, 400);
		frmNumberConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
