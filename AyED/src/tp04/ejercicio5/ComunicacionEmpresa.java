package tp04.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ComunicacionEmpresa {

	public Integer devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		int cantidadNodos = 0;
		int promedio = 0;
		int total = 0;
		ArbolGeneral<AreaEmpresa> arbol2 = null;
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
		cola.encolar(arbol);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol2 = cola.desencolar();
			if (arbol2 != null) {
				++cantidadNodos;
				total += arbol2.getDato().getTardanzaTransmision();
				if (arbol2.tieneHijos()) {
					ListaGenerica<ArbolGeneral<AreaEmpresa>> lHijos = arbol2.getHijos();
					lHijos.comenzar();
					while (!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}
			} else {
				if (!cola.esVacia())
					cola.encolar(null);
				if (total != 0)
					promedio = Math.max(promedio, total / cantidadNodos);
				cantidadNodos = 0;
				total = 0;
			}
		}
		return promedio;
	}

}
