import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 682, 253);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblWelcomeToEncryption = new JLabel("Welcome to the best Encryption Tool");    //main interface
		lblWelcomeToEncryption.setBackground(Color.DARK_GRAY);
		lblWelcomeToEncryption.setForeground(Color.WHITE);
		lblWelcomeToEncryption.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblWelcomeToEncryption.setBounds(97, 11, 469, 42);
		frame.getContentPane().add(lblWelcomeToEncryption);
		
		JButton btnNewButton = new JButton("Start the Encryption Tool"); 					//Start the encryption button so the user can navigate to the application
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EncryptionTool asd = new EncryptionTool();										//this line of code here is to connect the welcome page with the encryption tool
				asd.main(null);
				
			}
		});
		btnNewButton.setBounds(229, 80, 176, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Read our Instructions");					//When the user clicks this button it will navigate the user straight to the instructions page
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Instructions asd = new Instructions();								//this line of code here is to connect the welcome page with the instructions page
				asd.main();
			}
		});
		btnNewButton_1.setBounds(229, 128, 176, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}