package logico;

import java.util.ArrayList;

public class Factura {
	
	private String id;
	private Cliente micliente;
	private ArrayList<Queso> misquesos;
	public static int generadorId = 1;
	
	public Factura(String id, Cliente micliente) {
		super();
		this.id = id;
		this.micliente = micliente;
		misquesos = new ArrayList<>();
		generadorId++;
	}

	public Cliente getMicliente() {
		return micliente;
	}

	public void setMicliente(Cliente micliente) {
		this.micliente = micliente;
	}

	public ArrayList<Queso> getMisquesos() {
		return misquesos;
	}

	public void setMisquesos(ArrayList<Queso> misquesos) {
		this.misquesos = misquesos;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float precioFactura() {
		float suma = 0;
		
		for (Queso queso : misquesos) {
			suma += queso.precioTotal();
		}
		return suma;
	}

}
