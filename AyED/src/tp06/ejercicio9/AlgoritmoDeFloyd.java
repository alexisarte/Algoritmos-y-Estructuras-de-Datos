package tp06.ejercicio9;

import tp06.ejercicio3.Grafo;

public class AlgoritmoDeFloyd {

	public void warshall(Grafo<String> grafo) {
		/** Numero de nodos del grafo */
		int numNodos = grafo.listaDeVertices().tamanio();
		/** Matriz de adyacencia, para almacenar los arcos del grafo */
		int[][] arcos = new int[numNodos][numNodos];
		/** Matriz de Camino (Warshall - Path) */
		boolean[][] warshallC = new boolean[numNodos][numNodos];
		
		int i, j, k;

		// Obtener la matriz de adyacencia en P
		for (i = 0; i < numNodos; i++)
			for (j = 0; j < numNodos; j++)
				warshallC[i][j] = (arcos[i][j] != Integer.MAX_VALUE);

		// Iterar
		for (k = 0; k < numNodos; k++)
			for (i = 0; i < numNodos; i++)
				for (j = 0; j < numNodos; j++)
					warshallC[i][j] = (warshallC[i][j] || (warshallC[i][k] && warshallC[k][j]));
	}
	
}
