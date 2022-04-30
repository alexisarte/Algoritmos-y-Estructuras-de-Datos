package tp03.ejercicio2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {

	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 *
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return (this.esHoja() && this.getDato() == null);
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public boolean esLleno() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		int cantidadNodos = 0;
		boolean lleno = true;
		int nivel = 1;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
					++cantidadNodos;
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
					++cantidadNodos;
				}
			} else {
				if (!cola.esVacia()) {
					if (cantidadNodos == Math.pow(2, nivel++)) {
						cola.encolar(null);
						cantidadNodos = 0;
					} else {
						lleno = false;
					}
				}
			}
		}
		return lleno;
	}

	public boolean esCompleto() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		boolean exito = true;
		boolean exito2 = true;
		while (!cola.esVacia() && exito) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (nivel < (this.altura() - 1)) {
					if (!arbol.tieneHijoIzquierdo() || !arbol.tieneHijoDerecho()) {
						exito = false;
					}
					if (arbol.tieneHijoIzquierdo()) {
						cola.encolar(arbol.getHijoIzquierdo());
					}
					if (arbol.tieneHijoDerecho()) {
						cola.encolar(arbol.getHijoDerecho());
					}
				} else {
					if ((!arbol.tieneHijoIzquierdo() && !arbol.tieneHijoDerecho())
							|| (arbol.tieneHijoIzquierdo() && !arbol.tieneHijoDerecho())) {
						exito2 = false;
					} else if (!arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho()) {
						exito = false;
					} else if (exito2 == false && arbol.tieneHijoIzquierdo()) {
						exito = false;
					}
				}
			} else {
				++nivel;
				if (!cola.esVacia())
					cola.encolar(null);
			}
		}
		return exito;
	}

	private int alturaRecursivo(int caminoMasLargo) {
		if (this.esHoja()) {
			return 0;
		} else {
			if (this.tieneHijoIzquierdo()) {
				caminoMasLargo = Math.max(caminoMasLargo, this.getHijoIzquierdo().altura());
			}
			if (this.tieneHijoDerecho()) {
				caminoMasLargo = Math.max(caminoMasLargo, this.getHijoDerecho().altura());
			}
			++caminoMasLargo;
		}
		return caminoMasLargo;
	}

	public int altura() {
		int caminoMaximo = -1;
		if (!this.esVacio()) {
			return this.alturaRecursivo(caminoMaximo);
		}
		return caminoMaximo;
	}

	// imprime el Arbol en preorden
	public void printPreorden() {
		System.out.println(this.toString());
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
	}

	// imprime el Arbol en postorden
	public void printPostorden() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
		System.out.println(this.toString());
	}

	public void recorridoPorNiveles() {
		ArbolBinario<T> arbol = null;
		// Creamos una cola y encolamos la raiz y la marca
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		int nivel = 0;
		cola.encolar(this);
		cola.encolar(null);
		System.out.println("Nivel: " + nivel);
		// Proceso la cola: mientras tengo elementos
		while (!cola.esVacia()) {
			// Saco un elemento, verifico si es un nodo o una marca
			arbol = cola.desencolar();
			// Si es un nodo, proceso el nodo y si tiene hijos los encolos
			if (arbol != null) {
				// Proceso el dato
				System.out.println(arbol.getDato());
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			} else {
				// Si es una marca y tengo elementos en la cola entonces
				if (!cola.esVacia()) {
					System.out.println();
					System.out.println("Nivel: " + ++nivel);
					cola.encolar(null);
				}
			}
		}
	}

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<>();
		this.frontera(l);
		return l;
	}

	private void frontera(ListaGenerica<T> l) {
		if (this.esHoja())
			l.agregarFinal(this.getDato());
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().frontera(l);
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().frontera(l);
		}
	}

	public int contarHojas() {
		int hojasIzquierda = 0;
		int hojasDerecha = 0;
		if (this.esVacio()) {
			return 0;
		} else if (this.esHoja()) {
			return 1;
		} else {
			if (this.tieneHijoIzquierdo()) {
				hojasIzquierda += this.getHijoIzquierdo().contarHojas();
			}
			if (this.tieneHijoDerecho()) {
				hojasDerecha += this.getHijoDerecho().contarHojas();
			}
		}
		return hojasIzquierda + hojasDerecha;
	}

	public ArbolBinario<T> espejo() {
		ArbolBinario<T> arbol = new ArbolBinario<>(this.getDato());
		if (this.tieneHijoIzquierdo()) {
			arbol.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		}
		if (this.tieneHijoDerecho()) {
			arbol.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		}
		return arbol;
	}

	void traverse(ArbolBinario<T> x) {
		if (x != null) {
			System.out.println(x.dato);
			traverse(x.hijoIzquierdo);
			traverse(x.hijoDerecho);
			System.out.println();
			System.out.println(x.dato);
		}
	}

}
