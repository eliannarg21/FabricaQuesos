package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Fabrica;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream fabrica;
				FileOutputStream fabrica2;
				ObjectInputStream fabricaRead;
				ObjectOutputStream fabricaWrite;
				try {
					fabrica = new FileInputStream("Fabrica.dat");
					fabricaRead = new ObjectInputStream(fabrica);
					Fabrica temp = (Fabrica)fabricaRead.readObject();
					Fabrica.setFabrica(temp);
					fabrica.close();
					fabricaRead.close();
				} catch(FileNotFoundException e) { 
					try {
						fabrica2 = new FileOutputStream("Fabrica.dat");
						fabricaWrite = new ObjectOutputStream(fabrica2);
						Usuario aux = new Usuario("Administrador", "Admin", "Admin");
						Fabrica.getInstance().regUser(aux);
						fabricaWrite.writeObject(Fabrica.getInstance());
						fabrica2.close();
						fabricaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			
				} catch (IOException e) {
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Fábrica de quesos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 179);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(26, 28, 61, 16);
		panel.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(107, 23, 211, 26);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setBounds(26, 68, 75, 16);
		panel.add(lblNewLabel_1);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(107, 63, 211, 26);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Fabrica.getInstance().confirmLogin(txtUsername.getText(), txtPassword.getText())) {
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(217, 101, 101, 29);
		panel.add(btnNewButton);
	}
}
