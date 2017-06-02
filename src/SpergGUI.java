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
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class SpergGUI {

	private JFrame frmDndStats;
	private final JButton btnNewButton = new JButton("Roll");
	private final Action action = new SwingAction();
	private int testHealth = 0;
	private int diceNum = 1;
	private int arrNums = 0;
	private int dotArr = 0;
	
	

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
		frmDndStats.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/mac/SpergProject/DnDDice.png"));
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
		
		JPanel charPanel1 = new JPanel();
		charPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		charPanel1.setBounds(351, 6, 219, 48);
		frmDndStats.getContentPane().add(charPanel1);
		charPanel1.setLayout(null);
		
		JRadioButton radioButton1 = new JRadioButton("");
		
		
		radioButton1.setBounds(0, 0, 28, 48);
		charPanel1.add(radioButton1);
		
		JLabel charName1s = new JLabel("charName1");
		charName1s.setHorizontalAlignment(SwingConstants.CENTER);
		charName1s.setBounds(31, 0, 146, 16);
		charPanel1.add(charName1s);
		
		JLabel lblNewLabel_2 = new JLabel("HP");
		lblNewLabel_2.setBounds(29, 17, 17, 25);
		charPanel1.add(lblNewLabel_2);
		
		JProgressBar progressBar1 = new JProgressBar();
		progressBar1.setBounds(51, 28, 146, 3);
		charPanel1.add(progressBar1);
		progressBar1.setBackground(Color.WHITE);
		progressBar1.setForeground(Color.BLACK);
		progressBar1.setValue(100);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setBounds(143, 28, 53, 20);
		charPanel1.add(lblStrength);
		lblStrength.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		
		
		JPanel charPanel2 = new JPanel();
		charPanel2.setLayout(null);
		charPanel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		charPanel2.setBounds(351, 66, 219, 48);
		frmDndStats.getContentPane().add(charPanel2);
		
		JRadioButton radioButton2 = new JRadioButton("");
		radioButton2.setBounds(0, 0, 28, 48);
		charPanel2.add(radioButton2);
		
		JLabel charName_2 = new JLabel("charName2");
		charName_2.setHorizontalAlignment(SwingConstants.CENTER);
		charName_2.setBounds(31, 0, 146, 16);
		charPanel2.add(charName_2);
		
		JLabel label_1 = new JLabel("HP");
		label_1.setBounds(29, 17, 17, 25);
		charPanel2.add(label_1);
		
		JProgressBar progressBar2 = new JProgressBar();
		progressBar2.setValue(100);
		progressBar2.setForeground(Color.BLACK);
		progressBar2.setBackground(Color.WHITE);
		progressBar2.setBounds(51, 28, 146, 3);
		charPanel2.add(progressBar2);
		
		JLabel label_2 = new JLabel("Strength:");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		label_2.setBounds(143, 28, 53, 20);
		charPanel2.add(label_2);
		
		JPanel charPanel3 = new JPanel();
		charPanel3.setLayout(null);
		charPanel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		charPanel3.setBounds(351, 126, 219, 48);
		frmDndStats.getContentPane().add(charPanel3);
		
		JRadioButton radioButton3 = new JRadioButton("");
		radioButton3.setBounds(0, 0, 28, 48);
		charPanel3.add(radioButton3);
		
		JLabel lblCharname = new JLabel("charName3");
		lblCharname.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharname.setBounds(31, 0, 146, 16);
		charPanel3.add(lblCharname);
		
		JLabel label_3 = new JLabel("HP");
		label_3.setBounds(29, 17, 17, 25);
		charPanel3.add(label_3);
		
		JProgressBar progressBar3 = new JProgressBar();
		progressBar3.setValue(100);
		progressBar3.setForeground(Color.BLACK);
		progressBar3.setBackground(Color.WHITE);
		progressBar3.setBounds(51, 28, 146, 3);
		charPanel3.add(progressBar3);
		
		JLabel label_4 = new JLabel("Strength:");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		label_4.setBounds(143, 28, 53, 20);
		charPanel3.add(label_4);
		
		JPanel charPanel4 = new JPanel();
		charPanel4.setLayout(null);
		charPanel4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		charPanel4.setBounds(351, 189, 219, 48);
		frmDndStats.getContentPane().add(charPanel4);
		
		JRadioButton radioButton4 = new JRadioButton("");
		radioButton4.setBounds(0, 0, 28, 48);
		charPanel4.add(radioButton4);
		
		JLabel lblCharname_1 = new JLabel("charName4");
		lblCharname_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharname_1.setBounds(31, 0, 146, 16);
		charPanel4.add(lblCharname_1);
		
		JLabel label_5 = new JLabel("HP");
		label_5.setBounds(29, 17, 17, 25);
		charPanel4.add(label_5);
		
		JProgressBar progressBar4 = new JProgressBar();
		progressBar4.setValue(100);
		progressBar4.setForeground(Color.BLACK);
		progressBar4.setBackground(Color.WHITE);
		progressBar4.setBounds(51, 28, 146, 3);
		charPanel4.add(progressBar4);
		
		JLabel label_6 = new JLabel("Strength:");
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		label_6.setBounds(143, 28, 53, 20);
		charPanel4.add(label_6);
		
		JPanel charPanel5 = new JPanel();
		charPanel5.setLayout(null);
		charPanel5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		charPanel5.setBounds(351, 249, 219, 48);
		frmDndStats.getContentPane().add(charPanel5);
		
		JRadioButton radioButton5 = new JRadioButton("");
		radioButton5.setBounds(0, 0, 28, 48);
		charPanel5.add(radioButton5);
		
		JLabel lblCharname_2 = new JLabel("charName5");
		lblCharname_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharname_2.setBounds(31, 0, 146, 16);
		charPanel5.add(lblCharname_2);
		
		JLabel label_7 = new JLabel("HP");
		label_7.setBounds(29, 17, 17, 25);
		charPanel5.add(label_7);
		
		JProgressBar progressBar5 = new JProgressBar();
		progressBar5.setValue(100);
		progressBar5.setForeground(Color.BLACK);
		progressBar5.setBackground(Color.WHITE);
		progressBar5.setBounds(51, 28, 146, 3);
		charPanel5.add(progressBar5);
		
		JLabel label_8 = new JLabel("Strength:");
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		label_8.setBounds(143, 28, 53, 20);
		charPanel5.add(label_8);
		
		
		//turn system
		radioButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton1.setSelected(true);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);
				dotArr = 0;
			}
		});
		radioButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton1.setSelected(false);
				radioButton2.setSelected(true);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);
				dotArr = 1;
			}
		});
		radioButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(true);
				radioButton4.setSelected(false);
				radioButton5.setSelected(false);
				dotArr = 2;
			}
		});
		radioButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(true);
				radioButton5.setSelected(false);
				dotArr = 3;
			}
		});
		radioButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				radioButton5.setSelected(true);
				dotArr = 4;
			}
		});
		
		
		
		
		//always on the bottom
		
		
		
		JButton updateCharButton = new JButton("Load Char");
		updateCharButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				
				
			
				
				try {
					Scanner inFile1 = new Scanner(new File("saves/char.txt"));
					Scanner inFile2 = new Scanner(new File("saves/health.txt"));
					
				
					
					while(inFile1.hasNext()){
						
						
							
						for(int arrNumss = 0; arrNumss < 5; arrNumss++){
							
						testCar.CharList.set(arrNumss, inFile1.nextLine());
						}
						
						
						charName1s.setText(testCar.getName(1));
						charName_2.setText(testCar.getName(1));
						lblCharname.setText(testCar.getName(2));
						lblCharname_1.setText(testCar.getName(3));
						lblCharname_2.setText(testCar.getName(4));
						
						
						}
					
				
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				progressBar1.setValue((int) testCar.HealthList.get(0));
				progressBar2.setValue(testCar.getHealth(1));
				progressBar3.setValue(testCar.getHealth(2));
				progressBar4.setValue(testCar.getHealth(3));
				progressBar5.setValue(testCar.getHealth(4));
			}
		});
		updateCharButton.setBounds(440, 319, 117, 29);
		frmDndStats.getContentPane().add(updateCharButton);
		
		JButton btnNewButton_1 = new JButton("Damage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testCar.attack(dotArr);
				progressBar1.setValue(testCar.getHealth(dotArr));
				
			}
		});
		btnNewButton_1.setBounds(320, 319, 117, 29);
		frmDndStats.getContentPane().add(btnNewButton_1);
		
		JButton btnWindow = new JButton("Character Selection");
		btnWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CharSelection charDialog = new CharSelection();
				charDialog.setVisible(true);
				
			}
		});
		btnWindow.setBounds(6, 319, 165, 29);
		frmDndStats.getContentPane().add(btnWindow);
		
		JLabel strengthVal = new JLabel("");
		strengthVal.setBounds(396, 201, 127, 48);
		frmDndStats.getContentPane().add(strengthVal);
		
		
		
	
		
	
	
		
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
