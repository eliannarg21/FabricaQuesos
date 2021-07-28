package logico;

import java.util.ArrayList;

public class Fabrica {
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Queso> quesos;
	private ArrayList<Factura> facturas;
	private static Fabrica fabrica = null;

	public Fabrica() {
		clientes = new ArrayList<>();
		quesos = new ArrayList<>();
		facturas = new ArrayList<>();
	}
	
	public static Fabrica getInstance() {
		if (fabrica == null) {
			fabrica = new Fabrica();
		}
		return fabrica;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Queso> getQuesos() {
		return quesos;
	}

	public void setQuesos(ArrayList<Queso> quesos) {
		this.quesos = quesos;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public float totalFactura (Factura f) {
		float suma = 0;
		
		for (Queso queso : f.getMisquesos()) {
			suma += queso.precioTotal();
		}
		return suma;
	}
	
	public void cantidadQuesos() {
		int esfera = 0;
		int cilindro = 0;
		int hueco = 0;
		
		for (Queso queso : quesos) {
			if (queso instanceof Esfera) {
				esfera++;
			} else if (queso instanceof Cilindro) {
				cilindro++;
			} else if (queso instanceof CilindroHueco) {
				hueco++;
			}
		}
		
		System.out.println("Esférico: "+esfera);
		System.out.println("Cilíndrico: "+cilindro);
		System.out.println("Cilindro hueco: "+hueco);
	}
	
	public float mayorQuesoEsferico(Factura f) {
		float mayor = 0;
		int index = 0;
		
		for (Queso queso : f.getMisquesos()) {
			if (queso instanceof Esfera && mayor < queso.volumen()) {
				mayor = queso.volumen();
				index = f.getMisquesos().indexOf(queso);
			}
		}
		return f.getMisquesos().get(index).precioTotal();
	}
	
	public Cliente findClienteByCedula(String id) {
		for (Cliente cliente : clientes) {
			if (cliente.getCedula().equalsIgnoreCase(id)) {
				return cliente;
			}
		}
		return null;
	}
	
	public Queso findQuesoById(String id) {
		for (Queso queso : quesos) {
			if (queso.getId().equalsIgnoreCase(id)) {
				return queso;
			}
		}
		return null;
	}

}
