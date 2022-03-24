package parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial2 {
	
	public ListaGenerica<String> resolver(Grafo<String> ciudades, String origen, String destino, int montoMamximo) {
		ListaGenerica<String> caminoMasCorto = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
//		Vertice<String> casaCaperucita = buscarOrigen("Buenos Aires");
//		if (casaCaperucita != null ) {
			boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio() + 1];
//			
//		}
		return caminoMasCorto;
	}
	
}
