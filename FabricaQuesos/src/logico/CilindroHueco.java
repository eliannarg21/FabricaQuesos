package logico;

public class CilindroHueco extends Cilindro {
	
	private float radioInterior;
	
	public CilindroHueco(String id, float precioBase, float precioUnitario, float radio, float longitud, float radioInterior) {
		super(id, precioBase, precioUnitario, radio, longitud);
		this.radioInterior = radioInterior;
	}

	public float getRadioInterior() {
		return radioInterior;
	}

	public void setRadioInterior(float radioInterior) {
		this.radioInterior = radioInterior;
	}
	
	public float areaBase() {
		return (float) (Math.PI * (Math.pow(radio, 2) - Math.pow(radioInterior, 2)));
	}

}
