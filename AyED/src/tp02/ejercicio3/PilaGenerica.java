package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {

	private ListaGenerica<T> datos;
	
	public PilaGenerica() {
		this.datos = new ListaEnlazadaGenerica<>();
	}
	
	/** Agrega elem a la pila. */
	public void apilar(T elem) {
		this.datos.agregarInicio(elem);
	}

	/** Elimina y devuelve el elemento en el tope de la pila. */
	public T desapilar() {
		T element = this.tope();
		this.datos.eliminarEn(1);
		return element;
	}
	
	/**Devuelve el elemento en el tope de la pila sin eliminarlo. */
	public T tope() {
		return this.datos.elemento(1);
	}
	
	/** Retorna true si la pila está vacía, false en caso contrario. */
	public boolean esVacia() {
		return 	this.datos.esVacia();
	}
	
}
