package tp06.ejercicio9;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class AlgoritmoDeFloyd {

	public void warshall(Grafo<String> grafo) {
		/** Numero de nodos del grafo */
		int numNodos = grafo.listaDeVertices().tamanio() + 1;
		/** Matriz de adyacencia, para almacenar las distancias mínimas */
		int[][] distancias = new int[numNodos][numNodos];
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		for (int origen = 1; origen < distancias.length; origen++) {
			Vertice<String> verticeActual = vertices.elemento(origen);
			for (int destino = 1; destino < distancias.length; destino++) {
				if (origen == destino) {
					distancias[origen][destino] = 0;
				} else if (grafo.esAdyacente(vertices.elemento(destino), verticeActual)) {
					distancias[origen][destino] = grafo.peso(verticeActual, vertices.elemento(destino));
				} else {
					distancias[origen][destino] = Integer.MAX_VALUE;
				}
			}
		}
		/** Matriz de Camino (Warshall - Path) */
		boolean[][] warshallC = new boolean[numNodos][numNodos];

		int origen, destino, intermedio;

		// Obtener la matriz de adyacencia
		// for (origen = 1; origen < numNodos; origen++)
		// for (destino = 1; destino < numNodos; destino++)
		// warshallC[origen][destino] = (distancias[origen][destino] !=
		// Integer.MAX_VALUE);

		for (intermedio = 1; intermedio < numNodos; intermedio++)
			for (origen = 1; origen < numNodos; origen++)
				for (destino = 1; destino < numNodos; destino++)
					// cuando asigno dos valores a una variable con un or, se queda con el menor de los dos
					warshallC[origen][destino] = (warshallC[origen][destino] || (warshallC[origen][intermedio] && warshallC[intermedio][destino]));
	}

}
