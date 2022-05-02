package tp04.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {

	private ArbolGeneral<String> arbol;

	public RedDeAguaPotable(ArbolGeneral<String> arbol) {
		this.arbol = arbol;
	}

	public ArbolGeneral<String> getArbol() {
		return arbol;
	}

	public double minimoCaudal(double caudal) {
		if (!this.getArbol().esVacio()) {
			return this.minimoCaudal(caudal, caudal, this.getArbol());
		}
		return caudal;
	}
	
	public double minimoCaudal(double caudal, double caudalMinimo, ArbolGeneral<String> arbol) {
		if (arbol.esHoja()) {
			return caudal;
		} else {
			ListaGenerica<ArbolGeneral<String>> hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				caudalMinimo = Math.min(caudalMinimo, this.minimoCaudal(caudal / hijos.tamanio(), caudalMinimo, hijos.proximo()));
			}
		}
		return caudalMinimo;
	}

}
