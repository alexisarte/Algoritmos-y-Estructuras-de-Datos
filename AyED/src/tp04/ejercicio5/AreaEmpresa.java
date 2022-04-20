package tp04.ejercicio5;

public class AreaEmpresa {
	
	char identificacion;
	private int tardanzaTransmision;
	
	public AreaEmpresa(char identificacion, int tardanzaTransmision) {
		super();
		this.identificacion = identificacion;
		this.tardanzaTransmision = tardanzaTransmision;
	}

	public char getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(char identificacion) {
		this.identificacion = identificacion;
	}

	public int getTardanzaTransmision() {
		return tardanzaTransmision;
	}

	public void setTardanzaTransmision(int tardanzaTransmision) {
		this.tardanzaTransmision = tardanzaTransmision;
	} 
	
}
