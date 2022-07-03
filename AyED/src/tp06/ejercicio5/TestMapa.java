package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio4.CargarGrafo;

public class TestMapa {

	public static void main(String[] args) {
		
		CargarGrafo crear = new CargarGrafo();
		Grafo<String> grafo = crear.cargarGrafoDirigidoString();
		Mapa mapa = new Mapa(grafo);

		ListaGenerica<String> lista = mapa.devolverCamino("Buenos Aires", "La Habana");
		System.out.println("devolverCamino: " + lista.toString());
		
		ListaGenerica<String> lista2 = new ListaEnlazadaGenerica<>();
		lista2.agregarFinal("Santiago");
		
		lista = mapa.devolverCaminoExceptuando("Buenos Aires", "Asuncion", lista2);
		System.out.println("devolverCaminoExceptuando: " + lista.toString());

		lista = mapa.caminoMasCorto("Buenos Aires", "Asuncion");
		System.out.println("caminoMasCorto: " + lista.toString());

		lista = mapa.caminoSinCargarCombustible("Buenos Aires", "Asuncion", 503);
		System.out.println("caminoSinCargarCombustible: " + lista.toString());
		
		lista = mapa.caminoConMenorCargaDeCombustible("Buenos Aires", "Asuncion", 5);
		System.out.println("caminoConMenorCargaDeCombustible: " + lista.toString());
	}

}
