package lockThatDown;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LockThatDownGui 
{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LockThatDownGui window = new LockThatDownGui();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LockThatDownGui() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] comboOptions = {"kw1", "kw4"};
		
		
		JComboBox comboBox = new JComboBox(comboOptions);
		comboBox.setBounds(10, 53, 129, 20);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(10, 119, 129, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Select Keyway Format");
		lblNewLabel.setBounds(10, 28, 129, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel warningLabel = new JLabel("Enter digits only please.");
		warningLabel.setBounds(158, 118, 237, 23);
		frame.getContentPane().add(warningLabel);
		
		JButton btnNewButton = new JButton("Generate");
		
		btnNewButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
                String message = textField.getText();

                if (message.matches("[0-9]+"))
                {
                    warningLabel.setText(" ");  //Sets error message label
                }
                else warningLabel.setText("That's not a number!"); //Displays error message
                //JOptionPane.showMessageDialog(null, message);

            }
        });
		btnNewButton.setBounds(10, 150, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the number of locks for this keyset");
		lblNewLabel_1.setBounds(10, 94, 252, 20);
		frame.getContentPane().add(lblNewLabel_1);
		

	}
}
