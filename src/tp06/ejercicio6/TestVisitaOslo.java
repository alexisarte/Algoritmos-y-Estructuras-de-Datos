package tp06.ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio4.CargarGrafo;

public class TestVisitaOslo {

	public static void main(String[] args) {

		CargarGrafo crear = new CargarGrafo();
		Grafo<String> lugares = crear.cargarGrafoString();
		VisitaOslo visita = new VisitaOslo();

		ListaGenerica<String> lugaresRestringidos = new ListaEnlazadaGenerica<>();
		lugaresRestringidos.agregarFinal("Akker Brigge");
		lugaresRestringidos.agregarFinal("Palacio Real");

		ListaGenerica<String> lista = visita.paseoEnBici(lugares, "Museo Vikingo", 120, lugaresRestringidos);
		System.out.println("Paseo en bici: " + lista.toString());
	}

}
