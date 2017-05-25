import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;

public class SpergGUI {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("Roll");
	private final Action action = new SwingAction();
	private int testHealth = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpergGUI window = new SpergGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SpergGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Characters testCar = new Characters();
		testCar.addChar("testname", 100, 10);
		
		
		//
		frame = new JFrame();
		frame.setBounds(100, 100, 562, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel rollLablel = new JLabel(" ");
		rollLablel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		rollLablel.setHorizontalAlignment(SwingConstants.CENTER);
		rollLablel.setBounds(43, 53, 93, 36);
		frame.getContentPane().add(rollLablel);
		
		btnNewButton.setBounds(27, 101, 127, 29);
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollLablel.setText(" " + dice.roll(20));
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(10);
		progressBar.setBounds(392, 69, 146, 20);
		frame.getContentPane().add(progressBar);
		
		JLabel charName1s = new JLabel("charName1");
		charName1s.setBounds(392, 41, 146, 16);
		frame.getContentPane().add(charName1s);
		
		JLabel lblNewLabel_2 = new JLabel("HP");
		lblNewLabel_2.setBounds(392, 86, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel healCount = new JLabel("$");
		healCount.setHorizontalAlignment(SwingConstants.CENTER);
		healCount.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		healCount.setBounds(487, 87, 32, 16);
		frame.getContentPane().add(healCount);
		
		JLabel slashLabel = new JLabel("/ ");
		slashLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		slashLabel.setBounds(519, 87, 9, 16);
		frame.getContentPane().add(slashLabel);
		
		JLabel healthTotal = new JLabel("$");
		healthTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		healthTotal.setBounds(531, 87, 23, 16);
		frame.getContentPane().add(healthTotal);
		
		//always on the bottom
		
		JButton updateCharButton = new JButton("Load Char");
		updateCharButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testCar.listStats(0);
				testHealth = testCar.getHealth(0);
				charName1s.setText(testCar.getName(0));
				progressBar.setValue(testHealth);
				healthTotal.setText(" " + testCar.getHealth(0));
				
			}
		});
		updateCharButton.setBounds(439, 330, 117, 29);
		frame.getContentPane().add(updateCharButton);
		
		JButton btnNewButton_1 = new JButton("Damage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testHealth -= 1;
				progressBar.setValue(testHealth);
				healCount.setText(" " + testHealth);
			}
		});
		btnNewButton_1.setBounds(402, 114, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JRadioButton rdbtnDDie = new JRadioButton("D2 Die");
		rdbtnDDie.setBounds(27, 137, 109, 23);
		frame.getContentPane().add(rdbtnDDie);
		
		JRadioButton rdbtnDDie_1 = new JRadioButton("D6 Die");
		rdbtnDDie_1.setBounds(27, 163, 109, 23);
		frame.getContentPane().add(rdbtnDDie_1);
		
		JRadioButton rdbtnDDie_2 = new JRadioButton("D20 Die");
		rdbtnDDie_2.setBounds(27, 189, 109, 23);
		frame.getContentPane().add(rdbtnDDie_2);
		
	
	
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Roll");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
