package tp04.ejercicio7;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;
import tp04.ejercicio1.CrearArbolGeneral;

public class TestRedDeAguaPotable {

	public static void main(String[] args) {
		
		CrearArbolGeneral cargar = new  CrearArbolGeneral();
		ArbolGeneral<String> arbol = cargar.crearArbolString();
		RedDeAguaPotable redAguaPotable = new RedDeAguaPotable(arbol);
		ListaEnlazadaGenerica<String> lista = arbol.recorridoPorNiveles();
		
		System.out.println(lista.toString());
		System.out.println();
		
		System.out.println("Minimo caudal: " + redAguaPotable.minimoCaudal(1000));
	}

}
