package logico;

public class Esfera extends Queso {
	
	private float radio;

	public Esfera(String id, float precioBase, float precioUnitario, float radio) {
		super(id, precioBase, precioUnitario);
		this.radio = radio;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	@Override
	public float volumen() {
		float vol = (float) ((4.0/3.0) * Math.PI * Math.pow(radio, 3));
		return vol;
	}

}
