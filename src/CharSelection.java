import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
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
		Characters tstCar = new Characters();
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		CharName = new JTextField();
		CharName.setHorizontalAlignment(SwingConstants.CENTER);
		CharName.setText("Name");
		CharName.setBounds(6, 35, 130, 26);
		contentPanel.add(CharName);
		CharName.setColumns(10);
		String charName = CharName.getText().toString();
		
		
		HealthInput = new JTextField();
		HealthInput.setText("HP");
		HealthInput.setHorizontalAlignment(SwingConstants.CENTER);
		HealthInput.setBounds(6, 73, 130, 26);
		contentPanel.add(HealthInput);
		HealthInput.setColumns(10);
		
		//int hpNum = Integer.parseInt(HealthInput.getText());
		
		
		ManaInput = new JTextField();
		ManaInput.setHorizontalAlignment(SwingConstants.CENTER);
		ManaInput.setText("Mana");
		ManaInput.setBounds(6, 111, 130, 26);
		contentPanel.add(ManaInput);
		ManaInput.setColumns(10);
		
		JLabel lblCharacterAdder = new JLabel("Character Adder");
		lblCharacterAdder.setBounds(14, 7, 106, 16);
		contentPanel.add(lblCharacterAdder);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		
		JList charList = new JList();
		charList.setModel(new DefaultListModel() {
			String[] values = new String[] {" ", " ", " ", " ", " "};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		charList.setSelectedIndex(0);
		charList.setBounds(243, 40, 201, 138);
		contentPanel.add(charList);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hpNum = 0;
				int manaNum = 0;
				int testingnum = 0;
				tstCar.addChar(charName, hpNum, manaNum);
				//charTree.add(charTree, new DefaultMutableTreeNode(charName));
				charList.add(CharName, testingnum);
				testingnum++;
			 
			}
			
		});
		btnNewButton.setBounds(28, 149, 92, 29);
		contentPanel.add(btnNewButton);
		
	}
}
