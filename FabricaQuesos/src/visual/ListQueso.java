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
import javax.swing.table.DefaultTableModel;

import logico.Cilindro;
import logico.CilindroHueco;
import logico.Esfera;
import logico.Fabrica;
import logico.Queso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListQueso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model;
	private static Object rows[];
	private Queso selected = null;
	private JTable table;
	private JComboBox cbxTipo;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListQueso dialog = new ListQueso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListQueso() {
		setTitle("Listado de Quesos");
		setBounds(100, 100, 597, 369);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Listado de Quesos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Tipo de Queso:");
				lblNewLabel.setBounds(16, 29, 102, 16);
				panel.add(lblNewLabel);
			}
			{
				cbxTipo = new JComboBox();
				cbxTipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selection = cbxTipo.getSelectedIndex();
						loadtable(selection);
					}
				});
				cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Esférico", "Cilíndrico", "Cilindro hueco"}));
				cbxTipo.setBounds(118, 25, 115, 27);
				panel.add(cbxTipo);
			}
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(6, 57, 573, 224);
			panel.add(scrollPane);
			{
				model = new DefaultTableModel();
				String headers[] = {"Codigo", "Precio base", "Precio unitario", "Volúmen", "Forma"};
				model.setColumnIdentifiers(headers);
				loadtable(0);
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = -1;
						index = table.getSelectedRow();
						if (index != -1) {
							btnEliminar.setEnabled(true);
							String id = (String)(model.getValueAt(index, 0));
							selected = Fabrica.getInstance().findQuesoById(id);
						}
					}
				});
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "Desea eliminar el queso seleccionado: "+ selected.getId(), "Eliminar Queso", JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							Fabrica.getInstance().getQuesos().remove(selected);
							loadtable(0);
							btnEliminar.setEnabled(false);
						}
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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

	private static void loadtable(int selection) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		switch (selection) {
		case 0:
			for (Queso aux : Fabrica.getInstance().getQuesos()) {
				rows[0] = aux.getId();
				rows[1] = aux.getPrecioBase();
				rows[2] = aux.getPrecioUnitario();
				rows[3] = aux.volumen();
				if (aux instanceof Esfera) {
					rows[4] = "Esférico";
				}
				if (aux instanceof Cilindro) {
					rows[4] = "Cilíndrico";
				}
				if (aux instanceof CilindroHueco) {
					rows[4] = "Cilindro hueco";
				}
				
				model.addRow(rows);
			}
			break;

		case 1:
			for (Queso aux : Fabrica.getInstance().getQuesos()) {
				if (aux instanceof Esfera) {
					rows[0] = aux.getId();
					rows[1] = aux.getPrecioBase();
					rows[2] = aux.getPrecioUnitario();
					rows[3] = aux.volumen();
					rows[4] = "Esférico";
					
					model.addRow(rows);
				}
			}
			break;
			
		case 2:
			for (Queso aux : Fabrica.getInstance().getQuesos()) {
				if (aux instanceof Cilindro) {
					rows[0] = aux.getId();
					rows[1] = aux.getPrecioBase();
					rows[2] = aux.getPrecioUnitario();
					rows[3] = aux.volumen();
					rows[4] = "Cilíndrico";
					
					model.addRow(rows);
				}
			}
			break;
			
		case 3:
			for (Queso aux : Fabrica.getInstance().getQuesos()) {
				if (aux instanceof CilindroHueco) {
					rows[0] = aux.getId();
					rows[1] = aux.getPrecioBase();
					rows[2] = aux.getPrecioUnitario();
					rows[3] = aux.volumen();
					rows[4] = "Esférico";
					
					model.addRow(rows);
				}
			}
			break;
		}		
		
	}
}
