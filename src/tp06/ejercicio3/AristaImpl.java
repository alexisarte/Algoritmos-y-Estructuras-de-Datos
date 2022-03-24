package tp06.ejercicio3;

public class AristaImpl<T> implements Arista<T> {

	private Vertice<T> destino;
	private int peso;

	public AristaImpl(Vertice<T> dest, int p) {
		destino = dest;
		peso = p;
	}

	@Override
	public Vertice<T> verticeDestino() {
		return destino;
	}

	@Override
	public int peso() {
		return peso;
	}

	public Vertice<T> getDestino() {
		return destino;
	}

	public void setDestino(Vertice<T> destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
