package tp06.ejercicio4;

import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class CargarGrafo {

	public GrafoImplListAdy<Integer> cargarGrafoInteger() {

		GrafoImplListAdy<Integer> grafo = new GrafoImplListAdy<>();

		VerticeImplListAdy<Integer> vertice1 = new VerticeImplListAdy<>(1);
		VerticeImplListAdy<Integer> vertice2 = new VerticeImplListAdy<>(2);
		VerticeImplListAdy<Integer> vertice3 = new VerticeImplListAdy<>(3);

		grafo.agregarVertice(vertice1);
		grafo.agregarVertice(vertice2);
		grafo.agregarVertice(vertice3);

		grafo.conectar(vertice1, vertice2, 1);
		grafo.conectar(vertice1, vertice3, 1);
		grafo.conectar(vertice2, vertice1, 1);
		grafo.conectar(vertice2, vertice3, 1);
		grafo.conectar(vertice3, vertice1, 1);
		grafo.conectar(vertice3, vertice2, 1);

		return grafo;
	}

	
	public Grafo<String> cargarGrafoDirigidoString() {
		
		Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Caracas");
		Vertice<String> v7 = new VerticeImplListAdy<String>("La Habana");
	
		Grafo<String> ciudades = new GrafoImplListAdy<String>();
		ciudades.agregarVertice(v1);
		ciudades.agregarVertice(v2);
		ciudades.agregarVertice(v3);
		ciudades.agregarVertice(v4);
		ciudades.agregarVertice(v5);
		ciudades.agregarVertice(v6);
		ciudades.agregarVertice(v7);
		
		ciudades.conectar(v1, v2, 3);
		ciudades.conectar(v1, v3, 2);
		ciudades.conectar(v1, v4, 4);
		ciudades.conectar(v1, v5, 10);
		ciudades.conectar(v3, v5, 4);
		
		ciudades.conectar(v2, v5, 500);
		ciudades.conectar(v2, v7, 4);
		
		ciudades.conectar(v4, v5, 6);
		
		ciudades.conectar(v6, v5, 11);
		ciudades.conectar(v6, v7, 10);
		
		Recorridos<String> r = new Recorridos<String>();
		System.out.println("--- Se imprime el GRAFO con DFS ---");
		r.dfs(ciudades);
		return ciudades;
	}
	
public Grafo<String> cargarGrafoString() {
		
		Vertice<String> v1 = new VerticeImplListAdy<String>("Ayuntamiento");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Akker Brigge");
		Vertice<String> v3 = new VerticeImplListAdy<String>("El Tigre");
		Vertice<String> v4 = new VerticeImplListAdy<String>("FolkMuseum");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Fortaleza Akershus");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Galeria Nacional");
		Vertice<String> v7 = new VerticeImplListAdy<String>("Holmenkollen");
		Vertice<String> v8 = new VerticeImplListAdy<String>("La Opera");
		Vertice<String> v9 = new VerticeImplListAdy<String>("Museo del Barco Polar");
		Vertice<String> v10 = new VerticeImplListAdy<String>("Museo Fram");
		Vertice<String> v11 = new VerticeImplListAdy<String>("Museo Munch");
		Vertice<String> v12 = new VerticeImplListAdy<String>("Museo Vikingo");
		Vertice<String> v13 = new VerticeImplListAdy<String>("Parque Botanico");
		Vertice<String> v14 = new VerticeImplListAdy<String>("Palacio Real");
		Vertice<String> v15 = new VerticeImplListAdy<String>("Parque Vigeland");
		
		Grafo<String> bicisendas = new GrafoImplListAdy<String>();
		bicisendas.agregarVertice(v1);
		bicisendas.agregarVertice(v2);
		bicisendas.agregarVertice(v3);
		bicisendas.agregarVertice(v4);
		bicisendas.agregarVertice(v5);
		bicisendas.agregarVertice(v6);
		bicisendas.agregarVertice(v7);
		bicisendas.agregarVertice(v8);
		bicisendas.agregarVertice(v9);
		bicisendas.agregarVertice(v10);
		bicisendas.agregarVertice(v11);
		bicisendas.agregarVertice(v12);
		bicisendas.agregarVertice(v13);
		bicisendas.agregarVertice(v14);
		bicisendas.agregarVertice(v15);
		
		bicisendas.conectar(v1, v2, 20);
		bicisendas.conectar(v1, v3, 15);
		bicisendas.conectar(v1, v13, 10);
		bicisendas.conectar(v1, v14, 5);		
		
		bicisendas.conectar(v2, v1, 20);
		bicisendas.conectar(v2, v4, 30);
		bicisendas.conectar(v2, v12, 30);
		
		bicisendas.conectar(v3, v1, 15);
		bicisendas.conectar(v3, v11, 15);
		bicisendas.conectar(v3, v8, 5);
		
		bicisendas.conectar(v4, v2, 30);
		bicisendas.conectar(v4, v10, 5);
		bicisendas.conectar(v4, v14, 5);
		bicisendas.conectar(v4, v15, 20);
		
		bicisendas.conectar(v5, v8, 10);
		
		bicisendas.conectar(v6, v13, 15);
		bicisendas.conectar(v6, v15, 10);
		
		bicisendas.conectar(v7, v15, 30);
		
		bicisendas.conectar(v8, v3, 5);
		bicisendas.conectar(v8, v5, 10);
		
		bicisendas.conectar(v9, v10, 5);
		bicisendas.conectar(v9, v12, 5);
		
		bicisendas.conectar(v10, v4, 5);
		bicisendas.conectar(v10, v9, 5);
		
		bicisendas.conectar(v11, v3, 15);
		bicisendas.conectar(v11, v13, 1);
		
		bicisendas.conectar(v12, v2, 30);
		bicisendas.conectar(v12, v9, 5);
		
		bicisendas.conectar(v13, v6, 15);
		bicisendas.conectar(v13, v11, 1);
		
		bicisendas.conectar(v14, v1, 5);
		bicisendas.conectar(v14, v4, 5);
		
		bicisendas.conectar(v15, v4, 20);
		bicisendas.conectar(v15, v6, 10);
		bicisendas.conectar(v15, v7, 30);
		
	
		Recorridos<String> r = new Recorridos<String>();
		System.out.println("--- Se imprime el GRAFO con DFS ---");
		r.dfs(bicisendas);
		return bicisendas;
	}

}
