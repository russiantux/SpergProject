import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import com.sun.xml.internal.bind.v2.model.impl.ModelBuilder;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class CharSelection extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField CharName;
    private JTextField HealthInput;
    private JTextField ManaInput;
    private JTextField stengthInput;
    private int charTestNum = 0;
    
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            CharSelection dialog = new CharSelection();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    
  
    
    public CharSelection() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/mac/SpergProject/DnDDice.png"));
    	
    	
    	
    	DefaultListModel<String> model = new DefaultListModel<>();
    	 JList<String> list = new JList<>(model);
    	 list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    	 list.setVisibleRowCount(6);
    	 list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	 
         list.setBounds(228, 11, 200, 185);
         contentPanel.add(list);
    	
    	setTitle("Charcter Selection");
        Characters tstCar = new Characters();

        setBounds(100, 100, 450, 321);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        CharName = new JTextField();
        CharName.setText("DefaultName");
        CharName.setToolTipText("Name");
        CharName.setHorizontalAlignment(SwingConstants.CENTER);
        CharName.setBounds(6, 24, 130, 26);
        contentPanel.add(CharName);
        CharName.setColumns(10);
       


        HealthInput = new JTextField();
        HealthInput.setToolTipText("Health");
        HealthInput.setText("1");
        HealthInput.setHorizontalAlignment(SwingConstants.CENTER);
        HealthInput.setBounds(72, 61, 64, 26);
        contentPanel.add(HealthInput);
        HealthInput.setColumns(10);

 


        ManaInput = new JTextField();
        ManaInput.setEnabled(false);
        ManaInput.setToolTipText("Mana");
        ManaInput.setHorizontalAlignment(SwingConstants.CENTER);
        ManaInput.setText("1");
        ManaInput.setBounds(6, 98, 130, 26);
        contentPanel.add(ManaInput);
        ManaInput.setColumns(10);

       
        stengthInput = new JTextField();
        stengthInput.setText("1");
        stengthInput.setToolTipText("1-10");
        stengthInput.setHorizontalAlignment(SwingConstants.CENTER);
        stengthInput.setBounds(80, 136, 56, 20);
        contentPanel.add(stengthInput);
        stengthInput.setColumns(10);
        
        JLabel lblStrength = new JLabel("Strength:");
        lblStrength.setHorizontalAlignment(SwingConstants.CENTER);
        lblStrength.setBounds(6, 136, 84, 20);
        contentPanel.add(lblStrength);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Char dead");
        chckbxNewCheckBox.setEnabled(false);
        chckbxNewCheckBox.setBounds(19, 163, 97, 23);
        contentPanel.add(chckbxNewCheckBox);
        
        JLabel lblHealth = new JLabel("Health:");
        lblHealth.setBounds(16, 66, 45, 16);
        contentPanel.add(lblHealth);
        
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			int arrIndex = list.getSelectedIndex();
        			
        			if(arrIndex != -1){
        				model.remove(arrIndex);
        				tstCar.CharList.set(arrIndex, " ");
        				tstCar.HealthList.set(arrIndex, 1);
        				tstCar.StrengthList.set(arrIndex, 1);
        				
        			}
        	}
        });
        btnDelete.setBounds(344, 204, 84, 29);
        contentPanel.add(btnDelete);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(tstCar.ListNum == 5){
            		JOptionPane.showMessageDialog(contentPanel,
        				    "CharList maxed out, reseting back to zero.",
        				    "ERROR: CharList maxed out.",
        				    JOptionPane.ERROR_MESSAGE);
            		
            		tstCar.ListNum = 0;
            	}
                
                int manaNum = 0;
                int testingnum = 0;
                boolean dirMake = false;
                String hpText = HealthInput.getText();
                int hpNum = Integer.parseInt(hpText);
                String charName = CharName.getText().toString();
                
                String strengthNum = stengthInput.getText().toString();
                int stengthnum = Integer.parseInt(strengthNum);
                
                
              
                
                
                tstCar.addChar(charName, hpNum, 1, stengthnum);
                
             
                testingnum++;
                model.addElement(charName);
                
               
                new File("saves").mkdirs();
                
               
                
                
               
            }

        });
        btnNewButton.setBounds(6, 189, 130, 29);
        contentPanel.add(btnNewButton);
        
        
        
        
        
        try {
			Scanner inFile1 = new Scanner(new File("saves/char.txt"));
			Scanner inFile2 = new Scanner(new File("saves/health.txt"));
			
		
			
			while(inFile1.hasNext()){
				 
				
				
				
				if(inFile1.equals(null)){
					inFile1.nextLine();
				}
				else{
					
					if(inFile1.equals("$")){
						inFile1.nextLine();
					}
					else{
					
					model.addElement(inFile1.nextLine());
					charTestNum++;
					}
				}
			
			
				
			}
			
			
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        JLabel lblCharacterAdder = new JLabel("Character Adder");
        lblCharacterAdder.setHorizontalAlignment(SwingConstants.CENTER);
        lblCharacterAdder.setBounds(10, 8, 106, 16);
        contentPanel.add(lblCharacterAdder);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		
                		PrintWriter pr;
        				try {
        					pr = new PrintWriter("saves/char.txt");
        					 for (int i=0; i<5 ; i++)
        		                {
        		                    pr.println(tstCar.CharList.get(i));
        		                    
        		                }
        		                pr.close();

        				} catch (FileNotFoundException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        					
        					JOptionPane.showMessageDialog(contentPanel,
                				    "error when writing file.",
                				    "ERROR: CharList maxed out.",
                				    JOptionPane.ERROR_MESSAGE);
        				}    
        				
        				PrintWriter pr1;
        				try {
        					pr1 = new PrintWriter("saves/health.txt");
        					 for (int i=0; i<5 ; i++)
        		                {
        		                    pr1.println(tstCar.HealthList.get(i));
        		                }
        		                pr1.close();

        				} catch (FileNotFoundException e2) {
        					// TODO Auto-generated catch block
        					e2.printStackTrace();
        					
        					JOptionPane.showMessageDialog(contentPanel,
                				    "error when writing file.",
                				    "ERROR: CharList maxed out.",
                				    JOptionPane.ERROR_MESSAGE);
        				}    

        				PrintWriter pr2;
        				try {
        					pr2 = new PrintWriter("saves/strength.txt");
        					 for (int i=0; i<5 ; i++)
        		                {
        		                    pr2.println(tstCar.StrengthList.get(i));
        		                }
        		                pr2.close();

        				} catch (FileNotFoundException e3) {
        					// TODO Auto-generated catch blocks
        					e3.printStackTrace();
        					
        					JOptionPane.showMessageDialog(contentPanel,
                				    "error when writing file.",
                				    "ERROR: CharList maxed out.",
                				    JOptionPane.ERROR_MESSAGE);
        				}    
        				
                		dispose();
                	}
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		dispose();
                	}
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }

        
     
        
       

    }
}
