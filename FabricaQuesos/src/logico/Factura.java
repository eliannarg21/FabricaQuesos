package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Factura implements Serializable {
	
	private static final long serialVersionUID = -7735450278062346586L;
	private String id;
	private Cliente micliente;
	private ArrayList<Queso> misquesos;
	private Calendar date;
	public static int generadorId = 1;
	
	public Factura(String id, Cliente micliente) {
		super();
		this.id = id;
		this.micliente = micliente;
		misquesos = new ArrayList<>();
		this.date = Calendar.getInstance();
		Factura.generadorId++;
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

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public float precioFactura() {
		float suma = 0;
		
		for (Queso queso : misquesos) {
			suma += queso.precioTotal();
		}
		return suma;
	}

}
