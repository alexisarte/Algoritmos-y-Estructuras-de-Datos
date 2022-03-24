package tp04.ejercicio7;

import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {

	private ArbolGeneral<String> arbol;

	public RedDeAguaPotable(ArbolGeneral<String> arbol) {
		this.arbol = arbol;
	}

	public ArbolGeneral<String> getArbol() {
		return arbol;
	}

	public double minimoCaudalRecursivo(double caudal, double minimo, ArbolGeneral<String> arbol) {
		if (arbol.esHoja()) {
			return caudal;
		} else {
			arbol.getHijos().comenzar();
			while (!arbol.getHijos().fin()) {
				minimo = Math.min(minimo, minimoCaudalRecursivo(caudal / arbol.getHijos().tamanio(), minimo, arbol.getHijos().proximo()));
			}
		}
		return minimo;
	}

	public double minimoCaudal(double caudal) {
		if (!this.getArbol().esVacio()) {
			return minimoCaudalRecursivo(caudal, caudal, this.getArbol());
		}
		return caudal;
	}

}
