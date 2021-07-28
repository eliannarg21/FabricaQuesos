package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import logico.Cilindro;
import logico.CilindroHueco;
import logico.Esfera;
import logico.Fabrica;
import logico.Queso;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class RegQueso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUnitario;
	private JTextField txtBase;
	private JTextField txtRadio;
	private JTextField txtLongitud;
	private JTextField txtInterior;
	private JTextField txtRadio1;
	private JTextField txtLongitud1;
	private JTextField txtRadio2;
	private JRadioButton rdbtnEsfera;
	private JRadioButton rdbtnCilindro;
	private JRadioButton rdbtnHueco;
	private JPanel panel_Hueco;
	private JPanel panel_Cilindro;
	private JPanel panel_Esfera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegQueso dialog = new RegQueso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegQueso() {
		setTitle("Registrar Queso");
		setBounds(100, 100, 515, 309);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(6, 6, 503, 65);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Precio base:");
			lblNewLabel.setBounds(20, 28, 80, 16);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Precio unitario:");
			lblNewLabel_1.setBounds(257, 28, 99, 16);
			panel.add(lblNewLabel_1);
			
			txtUnitario = new JTextField();
			txtUnitario.setBounds(355, 23, 130, 26);
			panel.add(txtUnitario);
			txtUnitario.setColumns(10);
			
			txtBase = new JTextField();
			txtBase.setBounds(98, 23, 130, 26);
			panel.add(txtBase);
			txtBase.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Forma:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 75, 503, 65);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbtnEsfera = new JRadioButton("Esférica");
		rdbtnEsfera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnEsfera.setSelected(true);
				rdbtnCilindro.setSelected(false);
				rdbtnHueco.setSelected(false);
				panel_Esfera.setVisible(true);
				panel_Cilindro.setVisible(false);
				panel_Hueco.setVisible(false);
			}
		});
		rdbtnEsfera.setSelected(true);
		rdbtnEsfera.setBounds(20, 25, 142, 23);
		panel.add(rdbtnEsfera);
		
		rdbtnCilindro = new JRadioButton("Cilíndrica");
		rdbtnCilindro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnEsfera.setSelected(false);
				rdbtnCilindro.setSelected(true);
				rdbtnHueco.setSelected(false);
				panel_Esfera.setVisible(false);
				panel_Cilindro.setVisible(true);
				panel_Hueco.setVisible(false);
			}
		});
		rdbtnCilindro.setBounds(174, 25, 141, 23);
		panel.add(rdbtnCilindro);
		
		rdbtnHueco = new JRadioButton("Cilindro hueco");
		rdbtnHueco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnEsfera.setSelected(false);
				rdbtnCilindro.setSelected(false);
				rdbtnHueco.setSelected(true);
				panel_Esfera.setVisible(false);
				panel_Cilindro.setVisible(false);
				panel_Hueco.setVisible(true);
			}
		});
		rdbtnHueco.setBounds(327, 25, 141, 23);
		panel.add(rdbtnHueco);
		
		panel_Hueco = new JPanel();
		panel_Hueco.setVisible(false);
		panel_Hueco.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Hueco.setBounds(6, 152, 503, 76);
		contentPanel.add(panel_Hueco);
		panel_Hueco.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Radio:");
		lblNewLabel_2.setBounds(20, 16, 61, 16);
		panel_Hueco.add(lblNewLabel_2);
		
		txtRadio = new JTextField();
		txtRadio.setBounds(62, 11, 130, 26);
		panel_Hueco.add(txtRadio);
		txtRadio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Longitud:");
		lblNewLabel_3.setBounds(257, 16, 61, 16);
		panel_Hueco.add(lblNewLabel_3);
		
		txtLongitud = new JTextField();
		txtLongitud.setBounds(320, 11, 130, 26);
		panel_Hueco.add(txtLongitud);
		txtLongitud.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Radio Interior:");
		lblNewLabel_4.setBounds(20, 44, 89, 16);
		panel_Hueco.add(lblNewLabel_4);
		
		txtInterior = new JTextField();
		txtInterior.setBounds(111, 39, 130, 26);
		panel_Hueco.add(txtInterior);
		txtInterior.setColumns(10);
		
		panel_Cilindro = new JPanel();
		panel_Cilindro.setVisible(false);
		panel_Cilindro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Cilindro.setBounds(6, 152, 503, 76);
		contentPanel.add(panel_Cilindro);
		panel_Cilindro.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Radio:");
		lblNewLabel_5.setBounds(20, 16, 61, 16);
		panel_Cilindro.add(lblNewLabel_5);
		
		txtRadio1 = new JTextField();
		txtRadio1.setBounds(62, 11, 130, 26);
		panel_Cilindro.add(txtRadio1);
		txtRadio1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Longitud:");
		lblNewLabel_6.setBounds(257, 16, 61, 16);
		panel_Cilindro.add(lblNewLabel_6);
		
		txtLongitud1 = new JTextField();
		txtLongitud1.setBounds(320, 11, 130, 26);
		panel_Cilindro.add(txtLongitud1);
		txtLongitud1.setColumns(10);
		
		panel_Esfera = new JPanel();
		panel_Esfera.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Esfera.setBounds(6, 152, 503, 76);
		contentPanel.add(panel_Esfera);
		panel_Esfera.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Radio:");
		lblNewLabel_7.setBounds(20, 16, 61, 16);
		panel_Esfera.add(lblNewLabel_7);
		
		txtRadio2 = new JTextField();
		txtRadio2.setBounds(62, 11, 130, 26);
		panel_Esfera.add(txtRadio2);
		txtRadio2.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Queso aux = null;
						String id = "Q"+Queso.generadorId;
						float pBase = new Float(txtBase.getText());
						float pUnitario = new Float(txtUnitario.getText());
						
						if (rdbtnEsfera.isSelected()) {
							float radio = new Float(txtRadio2.getText());
							aux = new Esfera(id, pBase, pUnitario, radio);
							
						} else if (rdbtnCilindro.isSelected()) {
							float radio = new Float(txtRadio1.getText());
							float longitud = new Float(txtLongitud1.getText());
							aux = new Cilindro(id, pBase, pUnitario, radio, longitud);
							
						} else if (rdbtnHueco.isSelected()) {
							float radio = new Float(txtRadio.getText());
							float longitud = new Float(txtLongitud.getText());
							float interior = new Float(txtInterior.getText());
							aux = new CilindroHueco(id, pBase, pUnitario, radio, longitud, interior);
						}
						Fabrica.getInstance().getQuesos().add(aux);
						
						if (aux != null) {
							JOptionPane.showMessageDialog(null, "Registrado satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
							clean();						} else {
							JOptionPane.showMessageDialog(null, "Registro fallido", "Información", JOptionPane.WARNING_MESSAGE);
						}
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
		txtBase.setText("");
		txtUnitario.setText("");
		txtRadio.setText("");
		txtRadio1.setText("");
		txtRadio2.setText("");
		txtInterior.setText("");
		txtLongitud.setText("");
		txtLongitud1.setText("");
		
	}
}
