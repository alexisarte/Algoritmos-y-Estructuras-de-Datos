package tp04.ejercicio3;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;
import tp04.ejercicio1.CrearArbolGeneral;

public class RecorridosAGTest {

	public static void main(String[] args) {
		
		CrearArbolGeneral crear = new  CrearArbolGeneral();
		RecorridosAG recorridos = new RecorridosAG();
		
		ArbolGeneral<Integer> arbol = crear.crearArbolDeEnteros();
		
		ListaGenerica<Integer> lista = recorridos.numerosImparesMayoresQuePreOrden(arbol, -4);
		
		System.out.println(arbol.preOrden() + "\n");
		
		System.out.println("Numero impares mayores que n, preorden: " + lista.toString());
		
		lista = recorridos.numerosImparesMayoresQueInOrden(arbol, -4);
		System.out.println("Numero impares mayores que n, inorden: " + lista.toString());
		
		lista = recorridos.numerosImparesMayoresQuePostOrden(arbol, -4);
		System.out.println("Numero impares mayores que n, postorden: " + lista.toString());

	}

}
