package tp06.ejercicio12;

import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;

public class AlgoritmoDeKruskal {

	public Grafo<Integer> AlgoritmoDeKruskal(Grafo<Integer> grafo) {
		for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
			// Nuevo conjunto C(v) ← {v}.
		}
		// Nuevo heap Q que contiene todas las aristas de G, ordenando por su peso
		//Defino un árbol T ← Ø
		Grafo<Integer> t = new GrafoImplListAdy<>();
		   // n es el número total de vértices
		   //Mientras T tenga menos de n-1 aristas y !Q.vacío() hacer
		     //(u,v) ← Q.sacarMin()
		     // previene ciclos en T. agrega (u,v) si u y v están 
		     // diferentes componentes en el conjunto.
		     // Nótese que C(u) devuelve la componente a la que pertenece u
		     //Si C(v) ≠ C(u) hacer
		       //Agregar arista (v,u) a  T
		       //Merge C(v) y C(u) en el conjunto
		   return t;
	}

}
