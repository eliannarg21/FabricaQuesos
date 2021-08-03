package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Fabrica implements Serializable {
	
	private static final long serialVersionUID = -6678963222406516977L;
	private ArrayList<Usuario> users;
	private ArrayList<Cliente> clientes;
	private ArrayList<Queso> quesos;
	private ArrayList<Factura> facturas;
	private static Fabrica fabrica = null;
	private static Usuario loginUser;

	public Fabrica() {
		users = new ArrayList<>();
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
	
	public ArrayList<Usuario> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Usuario> users) {
		this.users = users;
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
	
	public static Usuario getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(Usuario loginUser) {
		Fabrica.loginUser = loginUser;
	}

	public static Fabrica getFabrica() {
		return fabrica;
	}

	public static void setFabrica(Fabrica fabrica) {
		Fabrica.fabrica = fabrica;
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
	
	public Usuario findUsuarioByUsername(String username) {
		for (Usuario user : users) {
			if (user.getUsername().equals(username)) {
				return user;
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
	
	public boolean confirmLogin(String username, String password) {
		boolean login = false;
		for (Usuario user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				loginUser = user;
				login = true;
			}
		}
		return login;
	}
	
	public void regUser(Usuario user) {
		users.add(user);
	}

}
