import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Instructions {

	private JFrame frame;

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructions window = new Instructions();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Instructions() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 970, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblInstructions.setBounds(369, 0, 188, 54);
		frame.getContentPane().add(lblInstructions);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("Capture1.png")).getImage();				//this line of code is to attach the image to the scene builder of the application
		lblNewLabel.setIcon( new ImageIcon(img));
		lblNewLabel.setBounds(0, 50, 966, 374);
		frame.getContentPane().add(lblNewLabel);
	}
}