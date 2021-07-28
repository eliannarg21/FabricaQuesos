package logico;

public class Cilindro extends Queso {
	
	protected float radio;
	protected float longitud;

	public Cilindro(String id, float precioBase, float precioUnitario, float radio, float longitud) {
		super(id, precioBase, precioUnitario);
		this.radio = radio;
		this.longitud = longitud;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	@Override
	public float volumen() {
		return (float) (longitud * areaBase());
	}

	private float areaBase() {
		
		return (float) (Math.PI * Math.pow(radio, 2));
	}

}
