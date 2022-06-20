package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class Camino {

	private ListaGenerica<String> lista;
	private int costo;

	public Camino() {
		this.lista = new ListaEnlazadaGenerica<>();
		this.costo = Integer.MAX_VALUE;
	}

	public void agregar(String dato) {
		lista.agregarFinal(dato);
	}

	public void eliminarUltimo() {
		lista.eliminarEn(lista.tamanio());
	}

	public void clear() {
		lista.comenzar();
		while (!lista.fin())
			lista.eliminar(lista.proximo());
	}

	public void clonar(ListaGenerica<String> otraLista) {
		otraLista.comenzar();
		while (!otraLista.fin())
			lista.agregarFinal(otraLista.proximo());
	}

	public ListaGenerica<String> getLista() {
		return lista;
	}

	public void setLista(ListaGenerica<String> lista) {
		this.lista = lista;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

}
