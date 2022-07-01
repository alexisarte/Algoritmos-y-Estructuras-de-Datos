package parciales.arboles;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;
import tp04.ejercicio1.CrearArbolGeneral;

public class ParcialTest {

	public static void main(String[] args) {
		Parcial parcial = new Parcial();
		CrearArbolGeneral crear = new CrearArbolGeneral();
		ArbolGeneral<Character> arbol = crear.crearArbolCharacter();
		ListaGenerica<ListaGenerica<Character>> listaDeListas = parcial.caminosPares(arbol);
		ListaGenerica<Character> lista = new ListaEnlazadaGenerica<Character>();

		listaDeListas.comenzar();
		while (!listaDeListas.fin()) {
			lista = listaDeListas.proximo();
			System.out.println(lista.toString());
		}
	}

}
