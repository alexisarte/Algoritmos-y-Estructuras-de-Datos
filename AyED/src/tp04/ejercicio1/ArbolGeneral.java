package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos == null) {
			this.hijos = new ListaEnlazadaGenerica<>();
		} else {
			this.hijos = hijos;
		}
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos == null) {
			this.hijos = new ListaEnlazadaGenerica<>();
		} else {
			this.hijos = hijos;
		}
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {
		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {
		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}

	public boolean esVacio() {
		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) {
				hijos.eliminar(hijo);
			}
		}
	}

	private void preOrden(ListaEnlazadaGenerica<T> lista) {
		if (!this.esVacio()) {
			lista.agregarFinal(this.getDato());
			if (this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
				lHijos.comenzar();
				while (!lHijos.fin()) {
					lHijos.proximo().preOrden(lista);
				}
			}
		}
	}

	public ListaEnlazadaGenerica<T> preOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		this.preOrden(lista);
		return lista;
	}

	private void postOrden(ListaEnlazadaGenerica<T> lista) {
		if (!this.esVacio()) {
			if (this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
				lHijos.comenzar();
				while (!lHijos.fin()) {
					lHijos.proximo().postOrden(lista);
				}
			}
			lista.agregarFinal(this.getDato());
		}
	}

	public ListaEnlazadaGenerica<T> postOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		this.postOrden(lista);
		return lista;
	}

	private void inOrden(ListaEnlazadaGenerica<T> lista) {
		if (!this.esVacio()) {
			// Llamar recursivamente con el primer hijo
			if (this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
				lHijos.comenzar();
				lHijos.proximo().inOrden(lista);
			}
			// Procesar el dato
			lista.agregarFinal(this.getDato());
			// Lamar recursivamente con el resto de los hijos
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			while (!lHijos.fin()) {
				lHijos.proximo().inOrden(lista);
			}
		}
	}

	public ListaEnlazadaGenerica<T> inOrden() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		this.inOrden(lista);
		return lista;
	}

	// Método que retorna una lista con los elementos del Árbol receptor, en orden de recorrido por
	// niveles de arriba hacia abajo y de izquierda a derecha, incluyendo algún elemento que indique
	// el fin de cada nivel
	public ListaEnlazadaGenerica<T> recorridoPorNiveles() {
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		ArbolGeneral<T> arbol = null;
		// Creamos una cola y encolamos la raiz y la marca
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		// Proceso la cola: mientras tengo elementos
		while (!cola.esVacia()) {
			// Saco un elemento, verifico si es un nodo o una marca
			arbol = cola.desencolar();
			// Si es un nodo, proceso el nodo y si tiene hijos los encolos
			if (arbol != null) {
				// Proceso el dato
				lista.agregarFinal(arbol.getDato());
				if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
					lHijos.comenzar();
					while (!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}
			} else {
				// Si es una marca y tengo elementos en la cola entonces
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
				lista.agregarFinal(null);
			}
		}
		return lista;
	}

//  Devuelve la altura del arbol, es decir, la longitud del camino mas largo desde el nodo raiz hasta una hoja.
	public Integer altura() {
		int caminoMaximo = -1;
		if (!this.esVacio()) {
			return this.altura(caminoMaximo);
		}
		return caminoMaximo;
	}

	// De abajo hacia arriba
	private int altura(int caminoMasLargo) {
		if (this.esHoja()) {
			return 0;
		} else {
			ListaGenerica<ArbolGeneral<T>> listaDehijos = this.getHijos();
			listaDehijos.comenzar();
			while (!listaDehijos.fin()) {
				caminoMasLargo = Math.max(caminoMasLargo, listaDehijos.proximo().altura());
			}
		}
		return ++caminoMasLargo;
	}

//	Devuelve la profundidad o nivel del dato en el arbol. El nivel de un nodo es la longitud del unico camino de la raiz al nodo
	public Integer nivel(T dato) {
		int nivel = 0;
		ArbolGeneral<T> arbol = null;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.getDato().equals(dato)) {
					return nivel;
				} else if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
					lHijos.comenzar();
					while (!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				++nivel;
			}
		}
		return -1;
	}

//  La amplitud (ancho) de un arbol se define como la cantidad de nodos que se encuentran en el nivel que posee la mayor cantidad de nodos.
	public Integer ancho() {
		ArbolGeneral<T> arbol = null;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		int cantidadNodos = 0;
		int cantidadNodosMaximo = 1;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lHijos = arbol.getHijos();
					lHijos.comenzar();
					while (!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
						++cantidadNodos;
					}
				}
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				cantidadNodosMaximo = Math.max(cantidadNodosMaximo, cantidadNodos);
				cantidadNodos = 0;
			}
		}
		return cantidadNodosMaximo;
	}

	private ArbolGeneral<T> buscarArbol(T valor, int nodos) {
		ArbolGeneral<T> arbol = null;
		if (!this.esVacio()) {
			if (this.getDato() == valor && nodos > 0) {
				return this;
			}
			++nodos;
			if (this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> listaDeHijos = this.getHijos();
				listaDeHijos.comenzar();
				while (!listaDeHijos.fin() && arbol == null) {
					arbol = listaDeHijos.proximo().buscarArbol(valor, nodos);
				}
			}
		}
		return arbol;
	}

	public boolean esAncestro(T a, T b) {
		ArbolGeneral<T> arbolA = null;
		ArbolGeneral<T> arbolB = null;
		if (!this.esVacio()) {
			arbolA = this.buscarArbol(a, 1); // Busco el arbol donde esta el nodoA para luego buscar en ese arbol al
												// nodo b // nodoB
			if (arbolA != null) {
				arbolB = arbolA.buscarArbol(b, 0); // Si existe el nodo a, entonces busco en ese arbol al nodo b
			}
		}
		return arbolB != null;
	}

}
