package tp02.ejercicio3;

import tp02.ejercicio2.*;

public class ColaGenerica<T> {

	private ListaGenerica<T> datos;

	public ColaGenerica() {
		this.datos = new ListaEnlazadaGenerica<>();
	}

	/** Agrega elem a la cola. */
	public void encolar(T elem) {
		this.datos.agregarFinal(elem);
	}

	/** Elimina y devuelve el primer elemento de la cola. */
	public T desencolar() {
		T element = this.tope();
		this.datos.eliminarEn(1);
		return element;
	}

	/** Devuelve el elemento en el tope de la cola sin eliminarlo. */
	public T tope() {
		return this.datos.elemento(1);
	}

	/** Retorna true si la cola está vacía, false en caso contrario. */
	public boolean esVacia() {
		return datos.esVacia();
	}

}
