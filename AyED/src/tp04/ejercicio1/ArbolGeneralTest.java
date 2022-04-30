package tp04.ejercicio1;

public class ArbolGeneralTest {
	
	public static void main(String[] args) {
		CrearArbolGeneral crear = new CrearArbolGeneral();
		ArbolGeneral<Character> arbol = crear.crearArbolCharacter();
		ArbolGeneral<Integer> hoja = new ArbolGeneral<>(1);
		
		System.out.println(arbol.recorridoPorNiveles());
		
		System.out.println("Ancho del arbol: " + arbol.ancho());
		System.out.println("Ancho de la hoja: " + hoja.ancho());
	}
	
}
