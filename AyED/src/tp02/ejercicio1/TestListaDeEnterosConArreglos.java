package tp02.ejercicio1;

public class TestListaDeEnterosConArreglos {

	public static void main(int[] args) {

		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();

		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				lista.agregarFinal(args[i]);
			}
		} else {
			System.out.println("No hay datos que agregar");
		}
		
		lista.comenzar();
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}
		
	}
	
}