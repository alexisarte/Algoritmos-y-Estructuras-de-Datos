package tp04.ejercicio3;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;
import tp04.ejercicio1.CrearArbolGeneral;

public class RecorridosAGTest {

	public static void main(String[] args) {
		
		CrearArbolGeneral crear = new  CrearArbolGeneral();
		RecorridosAG recorridos = new RecorridosAG();
		
		ArbolGeneral<Integer> arbol = crear.crearArbolDeEnteros();
		
		ListaGenerica<Integer> lista = recorridos.numerosImparesMayoresQuePorNiveles(arbol, 10);
		
		System.out.println(arbol.preOrden() + "\n");
		
		System.out.println("Numero impares mayores que n: " + lista.toString());

	}

}
