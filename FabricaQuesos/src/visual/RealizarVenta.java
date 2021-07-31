package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Fabrica;
import logico.Factura;
import logico.Queso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ScrollPaneConstants;

public class RealizarVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JList listDisponible;
	private DefaultListModel<String> listModelDisp;
	private JList listQuesos;
	private DefaultListModel<String> listModelQuesos;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private JTextField txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RealizarVenta dialog = new RealizarVenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RealizarVenta() {
		setTitle("Realizar Venta");
		setBounds(100, 100, 455, 409);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cédula:");
			lblNewLabel.setBounds(12, 6, 61, 16);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(68, 1, 123, 26);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente clienteAux = Fabrica.getInstance().findClienteByCedula(txtCedula.getText());
					if (clienteAux != null) {
						txtNombre.setText(clienteAux.getNombre());
						txtTelefono.setText(clienteAux.getTelefono());
						txtDireccion.setText(clienteAux.getDireccion());
						listDisponible.enable(true);
						listQuesos.enable(true);
					} else {
						clean();
					}
				}
			});
			btnBuscar.setBounds(193, 0, 79, 29);
			panel.add(btnBuscar);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(6, 34, 428, 102);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(6, 16, 61, 16);
			panel_1.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setBounds(79, 11, 329, 26);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Teléfono:");
			lblNewLabel_2.setBounds(6, 44, 72, 16);
			panel_1.add(lblNewLabel_2);
			
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setBounds(79, 39, 329, 26);
			panel_1.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Dirección:");
			lblNewLabel_5.setBounds(6, 72, 72, 16);
			panel_1.add(lblNewLabel_5);
			
			txtDireccion = new JTextField();
			txtDireccion.setEditable(false);
			txtDireccion.setBounds(79, 67, 329, 26);
			panel_1.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(6, 140, 428, 12);
			panel.add(separator);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(12, 172, 163, 145);
			panel.add(scrollPane);
			
			listDisponible = new JList();
			listDisponible.setEnabled(false);
			listDisponible.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = -1;
					index = listDisponible.getSelectedIndex();
					btnDerecha.setEnabled(true);
				}
			});
			listModelDisp = new DefaultListModel<String>();
			listDisponible.setModel(listModelDisp);
			listDisponible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(listDisponible);
			
			JLabel lblNewLabel_3 = new JLabel("Quesos Disponibles:");
			lblNewLabel_3.setBounds(12, 152, 150, 16);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Mis Quesos:");
			lblNewLabel_4.setBounds(271, 152, 123, 16);
			panel.add(lblNewLabel_4);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_1.setBounds(270, 172, 164, 145);
			panel.add(scrollPane_1);
			
			listQuesos = new JList();
			listQuesos.setEnabled(false);
			listQuesos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = -1;
					index = listQuesos.getSelectedIndex();
					if(index != -1) {
						btnIzquierda.setEnabled(true);
					}
				}
			});
			listModelQuesos = new DefaultListModel<String>();
			listQuesos.setModel(listModelQuesos);
			listQuesos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane_1.setViewportView(listQuesos);
			
			btnIzquierda = new JButton("<<");
			btnIzquierda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = listQuesos.getSelectedValue().toString();
					listModelQuesos.remove(listQuesos.getSelectedIndex());
					listModelDisp.addElement(aux);
					btnIzquierda.setEnabled(false);
				}
			});
			btnIzquierda.setEnabled(false);
			btnIzquierda.setBounds(187, 243, 75, 29);
			panel.add(btnIzquierda);
			
			btnDerecha = new JButton(">>");
			btnDerecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = listDisponible.getSelectedValue().toString();
					listModelQuesos.addElement(aux);
					listModelDisp.remove(listDisponible.getSelectedIndex());
					Queso queso = Fabrica.getInstance().findQuesoById(aux.substring(7, aux.indexOf('|')));
					btnDerecha.setEnabled(false);
				}
			});
			btnDerecha.setEnabled(false);
			btnDerecha.setBounds(187, 212, 75, 29);
			panel.add(btnDerecha);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Realizar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Queso> quesos = new ArrayList<>();
						Factura fac;
						for (int i = 0; i < listModelQuesos.getSize(); i++) {
							String aux = listModelQuesos.elementAt(i);
							Queso queso = Fabrica.getInstance().findQuesoById(aux.substring(8, aux.indexOf('|')));
							quesos.add(queso);
							Fabrica.getInstance().getQuesos().remove(queso);
						}
						Cliente cliente = Fabrica.getInstance().findClienteByCedula(txtCedula.getText());
						if (cliente != null) {
							fac = new Factura("F-"+Factura.generadorId, cliente);
							fac.setMisquesos(quesos);
							cliente.getMisFacturas().add(fac);
							Fabrica.getInstance().getFacturas().add(fac);
						} else {
							Cliente nuevo = new Cliente(txtNombre.getText(), txtCedula.getText(), txtDireccion.getText(), txtTelefono.getText());
							Fabrica.getInstance().getClientes().add(nuevo);
							fac = new Factura("F-"+Factura.generadorId, nuevo);
							fac.setMisquesos(quesos);
							nuevo.getMisFacturas().add(fac);
							Fabrica.getInstance().getFacturas().add(fac);
							
						}
						JOptionPane.showMessageDialog(null, "Registrado satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						String id = fac.getId();
						File archivo = new File("factura/"+id+".txt");
						FileWriter escritor;
						
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
							DecimalFormat df = new DecimalFormat("0.00");
							escritor = new FileWriter(archivo);
							String date = sdf.format(fac.getDate().getTime());
							escritor.write("Fecha: "+date+"\nCliente: "+fac.getMicliente().getNombre()+"\n\nQuesos: \n");
							for (Queso queso : fac.getMisquesos()) {
								escritor.write(queso.getId()+"\t"+df.format(queso.volumen())+"\t"+df.format(queso.precioTotal())+"\n");
							}
							escritor.write("\nTotal: "+df.format(fac.precioFactura()));
							escritor.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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
		loadQuesosDisp();
	}

	private void loadQuesosDisp() {
		listModelDisp.removeAllElements();
		for (Queso  q : Fabrica.getInstance().getQuesos()) {
			String aux = new String("Código: "+q.getId()+"| Precio: "+q.precioTotal());
			listModelDisp.addElement(aux);
		}
	}
	
	private void clean() {
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtNombre.setEditable(true);
		txtTelefono.setEditable(true);
		txtDireccion.setEditable(true);
		listModelQuesos.removeAllElements();
		listDisponible.enable(true);
		listQuesos.enable(true);
	}
}
