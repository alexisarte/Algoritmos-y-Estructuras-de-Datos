package tp04.ejercicio7;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;
import tp04.ejercicio1.CrearArbolGeneral;

public class TestRedDeAguaPotable {

	public static void main(String[] args) {
		
		CrearArbolGeneral cargar = new  CrearArbolGeneral();
		ArbolGeneral<String> arbol = cargar.crearArbolString();

		ListaEnlazadaGenerica<String> lista = arbol.recorridoPorNiveles();
		
		System.out.println(lista.toString());
		
		System.out.println();
		
		RedDeAguaPotable redAguaPotable = new RedDeAguaPotable(arbol);
		
		System.out.println(redAguaPotable.minimoCaudal(1000));
	}

}
