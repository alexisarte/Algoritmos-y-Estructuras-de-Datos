package tp02.ejercicio4;

import java.util.Scanner;
import tp02.ejercicio3.PilaGenerica;

public class TestBalanceo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese la cadena a balancear: ");
		System.out.print(evaluarBalance(s.next()) ? "Balanceada" : "Desbalanceada");
		s.close();
	}

	public static boolean evaluarBalance(String cadena) {
		Agrupador test = new Agrupador();
		PilaGenerica<Character> apertura = new PilaGenerica<Character>();
		int i = 0;
		char caracter;
		boolean balanceo = true;
		while (i < cadena.length() && balanceo) {
			caracter = cadena.charAt(i);
			if (test.esAgrupador(caracter)) {
				if (test.esApertura(caracter)) {
					apertura.apilar(caracter);
				}
				if (test.esCierre(caracter)) {
					if (!apertura.esVacia()) {
						if (test.match(apertura.tope(), caracter)) {	// siempre hay match si la cadena esta balanceada
							apertura.desapilar();						// porque desapilo el caracter de apertura correspondiente al de cierre
						} else {									
							balanceo = false;	// si no hay match, esta desbalanceada, dejo de evaluar la cadena
						}
					} else {
						balanceo = false;
					}
				}
			}
			++i;
		}
		return apertura.esVacia() && (i == cadena.length());
	}

}
