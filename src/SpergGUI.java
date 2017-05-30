import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
import java.awt.Color;

public class SpergGUI {

	private JFrame frmDndStats;
	private final JButton btnNewButton = new JButton("Roll");
	private final Action action = new SwingAction();
	private int testHealth = 0;
	private int diceNum = 1;
	private int arrNums = 0;
	
	

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
		frmDndStats.setBounds(100, 100, 576, 404);
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
		
		
		//If D20 Radio button is selected, max number of sides on the die is 20.
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
		
		//If D6 radio button is selected, max number of sides on the die is 6!
		rdbtnDDie_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceNum = 6;
				rdbtnDDie_2.setSelected(false);
				rdbtnDDie.setSelected(false);
				diceVal.setText("D6 Dice");
			}
		});
		
		//If D2 radio button is selected, max number of sides on the die is 2!
		rdbtnDDie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceNum = 2;
				rdbtnDDie_1.setSelected(false);
				rdbtnDDie_2.setSelected(false);
				diceVal.setText("D2 Dice");
			}
		});
		
		
		//Blank number which will display the rolled number from the die after one is obtained.
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
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.BLACK);
		progressBar.setValue(10);
		progressBar.setBounds(392, 29, 146, 3);
		frmDndStats.getContentPane().add(progressBar);
		
		JLabel charName1s = new JLabel("charName1");
		charName1s.setBounds(392, 6, 146, 16);
		frmDndStats.getContentPane().add(charName1s);
		
		JLabel lblNewLabel_2 = new JLabel("HP");
		lblNewLabel_2.setBounds(374, 24, 17, 14);
		frmDndStats.getContentPane().add(lblNewLabel_2);
		
		//always on the bottom
		
		
		
		JButton updateCharButton = new JButton("Load Char");
		updateCharButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				
				testCar.listStats(0);
				testHealth = testCar.getHealth(0);
				
				progressBar.setValue(testHealth);
			
				
				try {
					Scanner inFile1 = new Scanner(new File("char.txt"));
					
				
					
					while(inFile1.hasNext()){
						testCar.CharList[arrNums] = inFile1.nextLine();
						
						charName1s.setText(testCar.CharList[0]);
						
						arrNums++;
					
						
					}
					arrNums = 0;
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		updateCharButton.setBounds(429, 319, 117, 29);
		frmDndStats.getContentPane().add(updateCharButton);
		
		//When damage button is pressed, an appropriate amount of health is subtracted from the total health.
		JButton btnNewButton_1 = new JButton("Damage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testHealth -= 1;
				progressBar.setValue(testHealth);
				
			}
		});
		
		//Add a character builder allowing for characters to be made and temporarily stored in the program
		btnNewButton_1.setBounds(313, 319, 117, 29);
		frmDndStats.getContentPane().add(btnNewButton_1);
		JButton btnWindow = new JButton("Build Char");
		btnWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CharSelection charDialog = new CharSelection();
				charDialog.setVisible(true);
				
			}
		});
		btnWindow.setBounds(10, 319, 117, 29);
		frmDndStats.getContentPane().add(btnWindow);
		
		JLabel strengthVal = new JLabel("");
		strengthVal.setBounds(396, 201, 127, 48);
		frmDndStats.getContentPane().add(strengthVal);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblStrength.setBounds(377, 43, 53, 10);
		frmDndStats.getContentPane().add(lblStrength);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(340, 20, 141, 23);
		frmDndStats.getContentPane().add(radioButton);
		
		
		
	
		
	
	
		
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
