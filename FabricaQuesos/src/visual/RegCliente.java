package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Fabrica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCliente dialog = new RegCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCliente() {
		setTitle("Registrar Cliente");
		setBounds(100, 100, 388, 212);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(16, 24, 61, 16);
		contentPanel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(89, 19, 285, 26);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula:");
		lblNewLabel_1.setBounds(16, 52, 61, 16);
		contentPanel.add(lblNewLabel_1);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(89, 47, 285, 26);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dirección:");
		lblNewLabel_2.setBounds(16, 80, 69, 16);
		contentPanel.add(lblNewLabel_2);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(89, 75, 285, 26);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Teléfono:");
		lblNewLabel_3.setBounds(16, 108, 61, 16);
		contentPanel.add(lblNewLabel_3);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(89, 103, 285, 26);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente aux = new Cliente(txtNombre.getText(), txtCedula.getText(), txtDireccion.getText(), txtTelefono.getText());
						Fabrica.getInstance().getClientes().add(aux);
						JOptionPane.showMessageDialog(null, "Registrado Satisfactoriamente", "Registro de clientes", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
	
	private void clean() {
		txtNombre.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
}
