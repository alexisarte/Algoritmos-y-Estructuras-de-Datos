package tp06.ejercicio8;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio4.CargarGrafo;

public class TestAlgoritmoDeDijkstra {

    public static void main(String[] args) {
        AlgoritmoDeDijkstra dijkstra = new AlgoritmoDeDijkstra();
        CargarGrafo cargar = new CargarGrafo();
        Grafo<String> grafo = cargar.cargarGrafoString();

        ListaGenerica<String> lista = dijkstra.dijkstra(grafo, "Ayuntamiento");
        System.out.println("Camino mínimo con el algoritmo de Dijkstra");
        System.out.println(lista.toString());
    }

}
