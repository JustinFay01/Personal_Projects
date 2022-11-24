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

public class ConvertGUI {

	private JFrame frmNumberConverter;

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
		frmNumberConverter.setTitle("Number Converter");
		frmNumberConverter.setBounds(100, 100, 450, 300);
		frmNumberConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Method contains all of the code for creating events 
	private void createEvents() {
			// TODO Auto-generated method stub
			
		}
}

