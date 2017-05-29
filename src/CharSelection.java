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
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class CharSelection extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField CharName;
    private JTextField HealthInput;
    private JTextField ManaInput;
    private JTextField textField;

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
    	
    	DefaultListModel<String> model = new DefaultListModel<>();
    	 JList<String> list = new JList<>(model);
    	 
         list.setBounds(228, 11, 196, 207);
         contentPanel.add(list);
    	
    	setTitle("Charcter Selection");
        Characters tstCar = new Characters();

        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        CharName = new JTextField();
        CharName.setToolTipText("Name");
        CharName.setHorizontalAlignment(SwingConstants.CENTER);
        CharName.setBounds(6, 35, 130, 26);
        contentPanel.add(CharName);
        CharName.setColumns(10);
       


        HealthInput = new JTextField();
        HealthInput.setToolTipText("Health");
        HealthInput.setText("1");
        HealthInput.setHorizontalAlignment(SwingConstants.CENTER);
        HealthInput.setBounds(6, 73, 130, 26);
        contentPanel.add(HealthInput);
        HealthInput.setColumns(10);

 


        ManaInput = new JTextField();
        ManaInput.setToolTipText("Mana");
        ManaInput.setHorizontalAlignment(SwingConstants.CENTER);
        ManaInput.setText("1");
        ManaInput.setBounds(6, 111, 130, 26);
        contentPanel.add(ManaInput);
        ManaInput.setColumns(10);

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
                String hpText = HealthInput.getText();
                int hpNum = Integer.parseInt(hpText);
                String charName = CharName.getText().toString();
                
                
                tstCar.addChar(charName, hpNum, manaNum, 5);
                
             
                testingnum++;
                model.addElement(charName);

            }

        });
        btnNewButton.setBounds(6, 189, 130, 29);
        contentPanel.add(btnNewButton);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setText("1-10");
        textField.setBounds(80, 148, 56, 20);
        contentPanel.add(textField);
        textField.setColumns(10);
        
        JLabel lblStrength = new JLabel("Strength:");
        lblStrength.setHorizontalAlignment(SwingConstants.CENTER);
        lblStrength.setBounds(6, 148, 84, 20);
        contentPanel.add(lblStrength);
        
       

    }
}
