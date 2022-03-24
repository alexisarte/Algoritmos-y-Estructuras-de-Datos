package tp04.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;
import tp04.ejercicio1.CrearArbolGeneral;

public class TestComunicacionEmpresa {

	public static void main(String[] args) {
		
		CrearArbolGeneral cargar = new  CrearArbolGeneral();
		ArbolGeneral<AreaEmpresa> arbol = cargar.crearArbolObjeto();
		
		
		ListaEnlazadaGenerica<AreaEmpresa> lista = arbol.recorridoPorNiveles();
		
		lista.comenzar();
		while (!lista.fin()) {
			System.out.println(lista.proximo().getIdentificacion());
		}
		
		System.out.println();
		
		ComunicacionEmpresa empresa = new ComunicacionEmpresa();
		System.out.println(empresa.devolverMaximoPromedio(arbol));

	}

}
