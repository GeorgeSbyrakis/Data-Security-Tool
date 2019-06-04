import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class EncryptionTool extends javax.swing.JFrame {
	
	private String table = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_:+-()[]{}.,;*/ @$#¿?!¡='\""; // they array table in order for Caesar cipher to replace the letters when encrypting
	private JFrame frmComputerSecurityCoursework;
	private JTextField textField;							//added all the necessary textfields and keyfield in order to present the user the input, the output, the password and the directory
	private JTextField textField_1;							// textfield = input text, textfield_1 = output text and textfield_3 = presents directory of file, image and folder
	private JTextField keyField;
	private JTextField textField_3;

	FileDialog fileDialog;
	JFrame frame;
	
	public EncryptionTool() 
	{
		frame = new JFrame("");										//this lines of code here is for when the user chooses a file
		fileDialog = new FileDialog(frame, "Choose a file");
		
		initialize();
		setLocationRelativeTo(this);
	}
	
	private String text1(String text) 									// this string is the main function on order for the Caesar encryption and decryption to work effectively
	{
		text = text.replaceAll("\n", "");
		
		for(int k = 0; k < text.length(); k++)
				{
					int textPosition = table.indexOf(text.charAt(k));
					if (textPosition == -1)
					{
						text = text.replace(text.charAt(k), ' ');
					}
				}
		return text;
	}
	
	public String Encryption(String txt, int passwordKey)				//this string is here to encrypt the input text of the user
	{
		String Text = text1(txt);
		String encryption = "";
		
		for(int k = 0; k < Text.length(); k++)
		{
			int textPosition = table.indexOf(Text.charAt(k));
			
			if ((textPosition + passwordKey) < table.length())
			{
				encryption += table.charAt(textPosition + passwordKey);
			}
			else
			{
				encryption += table.charAt((textPosition + passwordKey) - table.length());
			}
		}
		return encryption;
	}
	
	public String Decryption(String txt, int passwordKey)						//this string is to decrypt the input text of ther user
	{
		String Text = text1(txt);
		String decryption = "";
		
		for(int k = 0; k < Text.length(); k++)
		{
			int textPosition = table.indexOf(Text.charAt(k));
			if ((textPosition - passwordKey) < 0 )
			{
				decryption += table.charAt((textPosition - passwordKey) + table.length());
			}
			
		else
		{
			decryption += table.charAt(textPosition - passwordKey);
		}
	}
		return decryption;
	}
	
	
	public static void main(String[] args) 
	{
		java.awt.EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					EncryptionTool window = new EncryptionTool();
					window.frmComputerSecurityCoursework.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() 																	//this void is the design initialisation and its where the actual encryption and decryption code is applied to the buttons
	{
		frmComputerSecurityCoursework = new JFrame();
		frmComputerSecurityCoursework.setTitle("Computer Security Coursework");					//The name of the of application window
		frmComputerSecurityCoursework.getContentPane().setBackground(Color.DARK_GRAY);
		frmComputerSecurityCoursework.setBounds(100, 100, 987, 428);
		frmComputerSecurityCoursework.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmComputerSecurityCoursework.getContentPane().setLayout(null);
		frmComputerSecurityCoursework.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {												//Mouse entered is to present the user with the functionality of the specific field or button 
				textField.setToolTipText("This textfield asks the user to input text");
			}
			@Override
			public void mouseExited(MouseEvent e) {													//Mouse exited is to get to tool tip text and show it to the user
				textField.getToolTipText();
			}
		});
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));	
		textField.setBounds(96, 79, 278, 102);
		frmComputerSecurityCoursework.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textField_1.setToolTipText("This textfield outputs the user's input text in an ecrypted format");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textField_1.getToolTipText();
			}
		});
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(96, 256, 278, 102);
		frmComputerSecurityCoursework.getContentPane().add(textField_1);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEncrypt.setToolTipText("This button is to encrypt the input text");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEncrypt.getToolTipText();
			}
		});
		btnEncrypt.setBackground(Color.WHITE);
		btnEncrypt.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnEncrypt.addActionListener(new ActionListener() 															
		{
			
			public void actionPerformed(ActionEvent e) 											//this action performed is where the encryption of the input text of the user takes place
			{
				String input = textField.getText();
				
				int passwordKey = Integer.parseInt(keyField.getText());							// the code for the password and it has to be one digit number below the number 10
				
				if (passwordKey <= 10)
				{
					textField_1.setText(Encryption(input, passwordKey));
				}
				
			}
			
			
		});
		
		btnEncrypt.setBounds(96, 208, 89, 23);
		frmComputerSecurityCoursework.getContentPane().add(btnEncrypt);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDecrypt.setToolTipText("This button is to decrypt the input text");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDecrypt.getToolTipText();
			}
		});
		btnDecrypt.setBackground(Color.WHITE);
		btnDecrypt.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDecrypt.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)                     //this action performed is where the encryption of the input text of the user takes place
			{
				
				String output = textField.getText();
				
				int passwordKey = Integer.parseInt(keyField.getText());
				
				if (passwordKey <= 10)
				{
					textField_1.setText(Decryption(output, passwordKey));
				}
			}
		});
		
		try {																															//this part of the code is to present the user when browsing a file with the windows
																																		// file explorer
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		frmComputerSecurityCoursework.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmComputerSecurityCoursework.getContentPane().setLayout(null);
		
		JButton btnFileButton = new JButton("Choose file");
		btnFileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFileButton.setToolTipText("This button is to help the user to choose a file or folder");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFileButton.getToolTipText();
			}
		});
		btnFileButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnFileButton.setBackground(Color.WHITE);
		btnFileButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {												//this action here is the actual code when the user chooses a files and saving it to the directory of the app

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setMultiSelectionEnabled(true);
				fileChooser.setCurrentDirectory(new java.io.File("."));
			    fileChooser.setDialogTitle("Select Folder");
			    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			    fileChooser.setAcceptAllFileFilterUsed(true);
			    fileChooser.setSelectedFile(new java.io.File("."));
			    fileChooser.setFileHidingEnabled(false);
			    fileChooser.showOpenDialog(null);
			    File filechooser = fileChooser.getSelectedFile();
			    textField_3.setText(filechooser.getAbsolutePath());
				
			}
			
		});
		
		btnFileButton.setBounds(450, 202, 114, 43);
		frmComputerSecurityCoursework.getContentPane().add(btnFileButton);
		
		btnDecrypt.setBounds(285, 208, 89, 23);
		frmComputerSecurityCoursework.getContentPane().add(btnDecrypt);
		
		keyField = new JTextField();													//the keyfield is where the user adds their password
		keyField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				keyField.setToolTipText("This textfield asks the user to add a passoword number 1 until 10");
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		keyField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		keyField.setBounds(574, 256, 86, 20);
		frmComputerSecurityCoursework.getContentPane().add(keyField);
		keyField.setColumns(10);
		
		JTextPane txtpnOutputText = new JTextPane();													//all the appropriate coding in order for the application to look nice and professional
		txtpnOutputText.setForeground(Color.WHITE);
		txtpnOutputText.setEditable(false);
		txtpnOutputText.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtpnOutputText.setBackground(Color.DARK_GRAY);
		txtpnOutputText.setText("Output Text:");
		txtpnOutputText.setBounds(9, 299, 77, 23);
		frmComputerSecurityCoursework.getContentPane().add(txtpnOutputText);
		
		JTextPane txtpnInputText = new JTextPane();
		txtpnInputText.setForeground(Color.WHITE);
		txtpnInputText.setEditable(false);
		txtpnInputText.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtpnInputText.setText("Input Text:");
		txtpnInputText.setBackground(Color.DARK_GRAY);
		txtpnInputText.setBounds(21, 119, 65, 23);
		frmComputerSecurityCoursework.getContentPane().add(txtpnInputText);
		
		JTextPane txtpnKeyPassword = new JTextPane();
		txtpnKeyPassword.setForeground(Color.WHITE);
		txtpnKeyPassword.setEditable(false);
		txtpnKeyPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtpnKeyPassword.setText("Key Password:");
		txtpnKeyPassword.setBackground(Color.DARK_GRAY);
		txtpnKeyPassword.setBounds(478, 253, 86, 23);
		frmComputerSecurityCoursework.getContentPane().add(txtpnKeyPassword);
		
		JTextPane txtpnEncrytionTool = new JTextPane();
		txtpnEncrytionTool.setForeground(Color.WHITE);
		txtpnEncrytionTool.setEditable(false);
		txtpnEncrytionTool.setFont(new Font("Times New Roman", Font.BOLD, 32));
		txtpnEncrytionTool.setText("Encryption Tool");
		txtpnEncrytionTool.setBackground(Color.DARK_GRAY);
		txtpnEncrytionTool.setBounds(352, 11, 230, 55);
		frmComputerSecurityCoursework.getContentPane().add(txtpnEncrytionTool);
		
		JButton btnEncryptFiles = new JButton("Encrypt File");
		btnEncryptFiles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEncryptFiles.setToolTipText("This button is to encrypt file");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEncryptFiles.getToolTipText();
			}
		});
		btnEncryptFiles.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				String input = btnEncryptFiles.getText();
				
				int passwordKey = Integer.parseInt(keyField.getText());
				
				if (passwordKey <= 10)
				{
					Encryption(input, passwordKey);
				}
				
				try 																							//this method is here to encrypt all the text files that the user has chosen
				{ 																								// also when its encrypted the text will return to the directory of the project
				FileInputStream inputStream = new FileInputStream(textField_3.getText());
				FileOutputStream outputStream = new FileOutputStream("EncryptedText.txt");
				
				byte p[]="CoolCool10021005".getBytes();
				SecretKeySpec key = new SecretKeySpec(p, "AES");
				Cipher enCipher = Cipher.getInstance("AES");
				enCipher.init(Cipher.ENCRYPT_MODE,  key);
				CipherOutputStream cipheroutputStream = new CipherOutputStream(outputStream, enCipher);
				byte[] buffer = new byte[1024];
				int readText;
				while((readText=inputStream.read(buffer))!=-1) 
				{
					 cipheroutputStream.write(buffer, 0,readText);
				}
				
				inputStream.close();
				outputStream.flush();
				cipheroutputStream.close();
				JOptionPane.showMessageDialog(null, "The text file has been encrypted");									//dialog to inform the user about the app's progress
			}
				catch(Exception e1){
		JOptionPane.showMessageDialog (null, e1);
				
			}
				
			}
			
		});

		btnEncryptFiles.setBackground(Color.WHITE);
		btnEncryptFiles.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnEncryptFiles.setBounds(450, 119, 114, 23);
		frmComputerSecurityCoursework.getContentPane().add(btnEncryptFiles);
		
		JButton btnDecryptFiles = new JButton("Decrypt File");
		btnDecryptFiles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDecryptFiles.setToolTipText("This button is to decrypt the file");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDecryptFiles.getToolTipText();
			}
		});
		btnDecryptFiles.setBackground(Color.WHITE);
		btnDecryptFiles.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDecryptFiles.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				String input = btnDecryptFiles.getText();
				
				int passwordKey = Integer.parseInt(keyField.getText());
				
				if (passwordKey <= 10)
				{
					Decryption(input, passwordKey);
				}
				
				try 																					//this method is here to decrypt the encrypted text files that the user has chosen from the directory of the project
				{
					FileInputStream inputStream = new FileInputStream(textField_3.getText());
					FileOutputStream outputStream = new FileOutputStream("DecryptedText.txt");
					
					byte p[]="CoolCool10021005".getBytes();
					SecretKeySpec key = new SecretKeySpec(p, "AES");
					Cipher enCipher = Cipher.getInstance("AES");
					enCipher.init(Cipher.DECRYPT_MODE,  key);
					CipherOutputStream cipheroutputStream = new CipherOutputStream(outputStream , enCipher);
					
					byte[] buffer = new byte[1024];
					int readText;
					while((readText=inputStream.read(buffer))!=-1) 
					{
						 cipheroutputStream.write(buffer, 0, readText);
					}
					inputStream.close();
					outputStream .flush();
					cipheroutputStream.close();
					JOptionPane.showMessageDialog(null, "The text file has been decrypted");				//dialog to inform the user about the app's progress
				}																							
					catch(Exception e1){
			JOptionPane.showMessageDialog (null, e1);
					
				}
			}
		});
		btnDecryptFiles.setBounds(450, 158, 114, 23);
		frmComputerSecurityCoursework.getContentPane().add(btnDecryptFiles);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_3.setBounds(574, 203, 293, 32);
		frmComputerSecurityCoursework.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Encrypt Image");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setToolTipText("This button is to encrypt an image");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.getToolTipText();
			}
		});
		btnNewButton.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				String input =  btnNewButton.getText();
				
				int passwordKey = Integer.parseInt(keyField.getText());
				
				if (passwordKey <= 10)
				{
					Encryption(input, passwordKey);
				}
				
				try 																				//this method is here to encrypt the image text that the user has chosen
				{ 																					// also when its encrypted, the image will return to the directory of the project
					FileInputStream file = new FileInputStream(textField_3.getText());
					FileOutputStream outputStream = new FileOutputStream("EncryptedImage.jpg");
					byte p[]="CoolCool10021005".getBytes();
					SecretKeySpec key = new SecretKeySpec(p, "AES");
					Cipher enCipher = Cipher.getInstance("AES");
					enCipher.init(Cipher.ENCRYPT_MODE,  key);
					CipherOutputStream cipheroutputStream = new CipherOutputStream(outputStream, enCipher);
					byte[] buffer = new byte[1024];
					int readImage;
					while(( readImage=file.read(buffer))!=-1) 
					{
						cipheroutputStream.write(buffer, 0,  readImage);
					}
					
					file.close();
					outputStream.flush();
					cipheroutputStream.close();
					JOptionPane.showMessageDialog(null, "The image has been encrypted");				//inform the user about the app's progress
				}
					catch(Exception e1)
				{
			JOptionPane.showMessageDialog (null, e1);
					
				}
				
			}
		});
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(568, 119, 114, 23);
		frmComputerSecurityCoursework.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decrypt Image");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setToolTipText("This button is to decrypt an image");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.getToolTipText();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String input =  btnNewButton_1.getText();
				
				int passwordKey = Integer.parseInt(keyField.getText());
				
				if (passwordKey <= 10)
				{
					Decryption(input, passwordKey);
				}
				
				try 
				{																							//this method is here to decrypt the image text that the user has chosen from the project's directory
					
					FileInputStream file = new FileInputStream(textField_3.getText());
					FileOutputStream outputStream = new FileOutputStream("DecryptedImage.jpg");
					
					byte p[]="CoolCool10021005".getBytes();
					SecretKeySpec key = new SecretKeySpec(p, "AES");
					Cipher enCipher = Cipher.getInstance("AES");
					enCipher.init(Cipher.DECRYPT_MODE,  key);
					CipherOutputStream cipheroutputStream = new CipherOutputStream(outputStream, enCipher);
					
					byte[] buffer = new byte[1024];
					int readImage;
					while(( readImage=file.read(buffer))!=-1) 
					{
						cipheroutputStream.write(buffer, 0, readImage);
					}
					file.close();
					outputStream.flush();
					cipheroutputStream.close();
					JOptionPane.showMessageDialog(null, "The image has been decrypted");                  //inform the user about the app's progress
				}
					catch(Exception e1)
				{
			JOptionPane.showMessageDialog (null, e1);
					
				}
			}
			
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setBounds(568, 158, 114, 23);
		frmComputerSecurityCoursework.getContentPane().add(btnNewButton_1);
		
		JButton btnInstructions = new JButton("Instructions");
		btnInstructions.setBackground(Color.WHITE);
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Instructions asd = new Instructions();											//this line of code is to connect the application with the instructions page
				asd.main();
				
			}
		});
		btnInstructions.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnInstructions.setBounds(1, 0, 101, 23);
		frmComputerSecurityCoursework.getContentPane().add(btnInstructions);
		
		JButton btnEncryptFolder = new JButton("Encrypt Folder");
		btnEncryptFolder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEncryptFolder.setToolTipText("This button is to encrypt a folder");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEncryptFolder.getToolTipText();
			}
		});
		btnEncryptFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String input = btnEncryptFiles.getText();
				
				int passwordKey = Integer.parseInt(keyField.getText());
				
				if (passwordKey <= 10)
				{
					Encryption(input, passwordKey);
				}
		
				try {																								//this method is here to encrypt a folder text that the user has chosen
					
				   File file = new File(textField_3.getText());
					if(file.isDirectory()) {
					    File[] content = file.listFiles();
					    for (File folder : content) {
					
					    	if (folder.isFile() && folder.canRead()) {
				                
				                InputStream inputStream = new FileInputStream(folder);
				                File newFile = new File(folder + "-Encrypted-" + folder.getName());
				                FileOutputStream outputStream = new FileOutputStream(newFile);
				                byte p[]="CoolCool10021005".getBytes();
								SecretKeySpec key = new SecretKeySpec(p, "AES");
								Cipher enCipher = Cipher.getInstance("AES");
								enCipher.init(Cipher.ENCRYPT_MODE,  key);
								CipherOutputStream cipheroutputStream = new CipherOutputStream(outputStream, enCipher);
								byte[] buffer = new byte[1024];
								int readImage;
								while(( readImage = inputStream.read(buffer))!=-1) 
								{
									cipheroutputStream.write(buffer, 0,  readImage);
								}
								inputStream.close();
								outputStream.flush();
								cipheroutputStream.close();
								
								
				            }}   } }catch(Exception e1){
								
						JOptionPane.showMessageDialog (null, e1);
					}
			}

		});
		btnEncryptFolder.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnEncryptFolder.setBackground(Color.WHITE);
		btnEncryptFolder.setBounds(692, 119, 123, 23);
		frmComputerSecurityCoursework.getContentPane().add(btnEncryptFolder);
		
		JButton btnDecryptFolder = new JButton("Decrypt Folder");
		btnDecryptFolder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDecryptFolder.setToolTipText("This button is to decrypt a folder");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDecryptFolder.getToolTipText();
			}
		});
		btnDecryptFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String input = btnEncryptFiles.getText();
				int passwordKey = Integer.parseInt(keyField.getText());
				if (passwordKey <= 10)
				{
					Encryption(input, passwordKey);
				}
				
				try {                                                                 //this method is here to decrypt the folder text that the user has chosen
					
					   File file = new File(textField_3.getText());
						if(file.isDirectory()) {
						    File[] content = file.listFiles();
						    for (File folder : content) {
						
						    	if (folder.isFile() && folder.canRead()) {
					                
					                InputStream inputStream = new FileInputStream(folder);
					                File newFile = new File(folder + "-Decrypted-" + folder.getName());
					                FileOutputStream outputStream = new FileOutputStream(newFile);
					                byte p[]="CoolCool10021005".getBytes();
									SecretKeySpec key = new SecretKeySpec(p, "AES");
									Cipher enCipher = Cipher.getInstance("AES");
									enCipher.init(Cipher.DECRYPT_MODE,  key);
									CipherOutputStream cipheroutputStream = new CipherOutputStream(outputStream, enCipher);
									byte[] buffer = new byte[1024];
									int readImage;
									while(( readImage = inputStream.read(buffer))!=-1) 
									{
										cipheroutputStream.write(buffer, 0,  readImage);
									}
									inputStream.close();
									outputStream.flush();
									cipheroutputStream.close();
								
									
									
					            }}   } }catch(Exception e1){
									
							JOptionPane.showMessageDialog (null, e1);
						}
				}
			
		});
		btnDecryptFolder.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDecryptFolder.setBackground(Color.WHITE);
		btnDecryptFolder.setBounds(692, 158, 123, 23);
		frmComputerSecurityCoursework.getContentPane().add(btnDecryptFolder);
		
	}
}