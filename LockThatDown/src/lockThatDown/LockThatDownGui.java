package lockThatDown;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LockThatDownGui extends LockThatDownImplementation
{

	JFrame frame;
	private JTextField textField;

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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 565, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		String[] comboOptions = {"kw1", "kw4"};
		String[] pinOptions = {"4", "5"};
		
		JComboBox comboBox = new JComboBox(comboOptions);
		comboBox.setFont(new Font("8-bit pusab", Font.PLAIN, 14));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(10, 53, 129, 20);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("8-bit pusab", Font.PLAIN, 14));
		textField.setBounds(10, 119, 129, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Select Keyway Format");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("8-bit pusab", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 28, 200, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel warningLabel = new JLabel("Enter digits only please.");
		warningLabel.setFont(new Font("8-bit pusab", Font.PLAIN, 8));
		warningLabel.setForeground(Color.WHITE);
		warningLabel.setBounds(149, 150, 237, 23);
		frame.getContentPane().add(warningLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the number of locks for this keyset");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("8-bit pusab", Font.PLAIN, 8));
		lblNewLabel_1.setBounds(10, 94, 302, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox pinBox = new JComboBox(pinOptions);
		pinBox.setFont(new Font("8-bit pusab", Font.PLAIN, 11));
		pinBox.setBounds(358, 53, 96, 22);
		frame.getContentPane().add(pinBox);
		
		JLabel pinLabel = new JLabel("Select the Number of Pins");
		pinLabel.setForeground(Color.WHITE);
		pinLabel.setFont(new Font("8-bit pusab", Font.PLAIN, 8));
		pinLabel.setBounds(358, 29, 240, 14);
		frame.getContentPane().add(pinLabel);
		
		JButton generateButton = new JButton("Generate");
		generateButton.setFont(new Font("8-bit pusab", Font.PLAIN, 11));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 184, 340, 340);
		frame.getContentPane().add(scrollPane);
		
		JLabel results = new JLabel("Your generated key depths will appear here");
		results.setFont(new Font("8-bit pusab", Font.PLAIN, 8));
		scrollPane.setViewportView(results);
		
		generateButton.setBounds(10, 150, 129, 23);
		frame.getContentPane().add(generateButton);
		
		//master key code still needs to be implemented
		JRadioButton masterKeyRadioButton = new JRadioButton("Master Key");
		masterKeyRadioButton.setForeground(Color.WHITE);
		masterKeyRadioButton.setFont(new Font("8-bit pusab", Font.PLAIN, 8));
		masterKeyRadioButton.setBounds(358, 119, 109, 23);
		masterKeyRadioButton.setOpaque(false);
		masterKeyRadioButton.setContentAreaFilled(false);
		masterKeyRadioButton.setBorderPainted(false);
		frame.getContentPane().add(masterKeyRadioButton);
		
		//button to close frame
		JButton closeButton = new JButton("CLOSE");
		closeButton.setBackground(Color.BLACK);
		closeButton.setForeground(Color.WHITE);
		closeButton.setFont(new Font("8-bit pusab", Font.PLAIN, 11));
		closeButton.setBounds(441, 540, 114, 23);
		closeButton.setOpaque(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		frame.getContentPane().add(closeButton);
		
		closeButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       frame.dispose();
		    }
		});
		
		JLabel teamLabel = new JLabel("<html>Lock That Down<br/><br/> A Team Bliss Collaboration<html>");
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLabel.setForeground(Color.WHITE);
		teamLabel.setFont(new Font("8-bit pusab", Font.PLAIN, 11));
		teamLabel.setBounds(358, 184, 197, 340);
		frame.getContentPane().add(teamLabel);

		generateButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
                String message = textField.getText();

                if (message.matches("[0-9]+"))
                {
                    warningLabel.setText(" ");  //Sets error message label
                }
                else warningLabel.setText("That's not a number!"); //Displays error message
                
                String brandChoice = (String)comboBox.getSelectedItem();
                //Do we have something to pass the brand choice into?
                
                String pinChoice = (String)pinBox.getSelectedItem();
                Integer pinChoiceInt = 5;
                if (pinChoice == "4") { pinChoiceInt = 4; }
                
                Integer numberOfLocks = Integer.parseInt((String)textField.getText());
                
                if (numberOfLocks > 1000) 
                {
                	warningLabel.setText("That's too many locks!");
                }
                
                else
                {	
	                int[][] listInts = comboGenerator(numberOfLocks, pinChoiceInt);
	                
	                String listString = "<html>" + Arrays.deepToString(listInts) + "<html>"; //String formatting
	                listString = listString.replace("[", "");
	                listString = listString.replace("]", "<br/>");
	                listString = listString.replace(",", " ");
	                
	                System.out.println(listString);
	                results.setText(listString);
                }
            }
        });
		
	}
}
