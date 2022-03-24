package tp06.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio4.CargarGrafo;

public class TestTopsort {

	public static void main(String[] args) {
		
		Topsort topsort = new Topsort();
		CargarGrafo cargar = new CargarGrafo();
		Grafo<String> grafo = cargar.cargarGrafoDirigidoString();
		ListaGenerica<String> lista = topsort.topsort(grafo);
		System.out.println(lista.toString());
		
		System.out.println();
		
		lista = topsort.topsort2(grafo);
		System.out.println(lista.toString());
		
		System.out.println();
		
		lista = topsort.topsortEnProfundidad(grafo);
		System.out.println(lista.toString());
	}

}
