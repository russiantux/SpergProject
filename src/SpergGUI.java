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

	private JFrame frmDndStats;
	private final JButton btnNewButton = new JButton("Roll");
	private final Action action = new SwingAction();
	private int testHealth = 0;
	private int diceNum = 1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpergGUI window = new SpergGUI();
					window.frmDndStats.setVisible(true);
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
		//testCar.addChar("testname", 100, 10, 5);
		
		
		//
		frmDndStats = new JFrame();
		frmDndStats.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		frmDndStats.setTitle("DnD Stats");
		frmDndStats.setBounds(100, 100, 562, 387);
		frmDndStats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtnDDie = new JRadioButton("D2 Die");
		rdbtnDDie.setBounds(27, 137, 109, 23);
		frmDndStats.getContentPane().add(rdbtnDDie);
		
		JRadioButton rdbtnDDie_1 = new JRadioButton("D6 Die");
		rdbtnDDie_1.setBounds(27, 163, 109, 23);
		frmDndStats.getContentPane().add(rdbtnDDie_1);
		
		JLabel diceVal = new JLabel("");
		diceVal.setHorizontalAlignment(SwingConstants.CENTER);
		diceVal.setBounds(27, 29, 127, 14);
		frmDndStats.getContentPane().add(diceVal);
		
		
		
		JRadioButton rdbtnDDie_2 = new JRadioButton("D20 Die");
		rdbtnDDie_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceNum = 20;
				rdbtnDDie_1.setSelected(false);
				rdbtnDDie.setSelected(false);
				diceVal.setText("D20 Dice");
				
				
			}
		});
		rdbtnDDie_2.setBounds(27, 189, 109, 23);
		frmDndStats.getContentPane().add(rdbtnDDie_2);
		
		
		rdbtnDDie_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceNum = 6;
				rdbtnDDie_2.setSelected(false);
				rdbtnDDie.setSelected(false);
				diceVal.setText("D6 Dice");
			}
		});
		
		rdbtnDDie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceNum = 2;
				rdbtnDDie_1.setSelected(false);
				rdbtnDDie_2.setSelected(false);
				diceVal.setText("D2 Dice");
			}
		});
		
		
		
		final JLabel rollLablel = new JLabel(" ");
		rollLablel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		rollLablel.setHorizontalAlignment(SwingConstants.CENTER);
		rollLablel.setBounds(43, 53, 93, 36);
		frmDndStats.getContentPane().add(rollLablel);
		
		btnNewButton.setBounds(27, 101, 127, 29);
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollLablel.setText(" " + dice.roll(diceNum));
			}
		});
		frmDndStats.getContentPane().setLayout(null);
		frmDndStats.getContentPane().add(btnNewButton);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(10);
		progressBar.setBounds(392, 69, 146, 20);
		frmDndStats.getContentPane().add(progressBar);
		
		JLabel charName1s = new JLabel("charName1");
		charName1s.setBounds(392, 41, 146, 16);
		frmDndStats.getContentPane().add(charName1s);
		
		JLabel lblNewLabel_2 = new JLabel("HP");
		lblNewLabel_2.setBounds(392, 86, 61, 16);
		frmDndStats.getContentPane().add(lblNewLabel_2);
		
		JLabel healCount = new JLabel("$");
		healCount.setHorizontalAlignment(SwingConstants.CENTER);
		healCount.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		healCount.setBounds(487, 87, 32, 16);
		frmDndStats.getContentPane().add(healCount);
		
		JLabel slashLabel = new JLabel("/ ");
		slashLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		slashLabel.setBounds(515, 85, 9, 16);
		frmDndStats.getContentPane().add(slashLabel);
		
		JLabel healthTotal = new JLabel("$");
		healthTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		healthTotal.setBounds(529, 85, 23, 16);
		frmDndStats.getContentPane().add(healthTotal);
		
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
		frmDndStats.getContentPane().add(updateCharButton);
		
		JButton btnNewButton_1 = new JButton("Damage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testHealth -= 1;
				progressBar.setValue(testHealth);
				healCount.setText(" " + testHealth);
			}
		});
		btnNewButton_1.setBounds(402, 114, 117, 29);
		frmDndStats.getContentPane().add(btnNewButton_1);
		
		JButton btnWindow = new JButton("window");
		btnWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CharSelection charDialog = new CharSelection();
				charDialog.setVisible(true);
				
			}
		});
		btnWindow.setBounds(19, 319, 117, 29);
		frmDndStats.getContentPane().add(btnWindow);
		
		
		
	
		
	
	
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Roll");
			putValue(SHORT_DESCRIPTION, "Roll the dice!");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
