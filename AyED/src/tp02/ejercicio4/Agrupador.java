package tp02.ejercicio4;

public class Agrupador {

	public boolean esAgrupador(char caracter) {
		return (esApertura(caracter) || esCierre(caracter)) ? true : false;
	}

	public boolean esApertura(char caracter) {
		return ((caracter == '(') || (caracter == '[') || (caracter == '{')) ? true : false;
	}

	public boolean esCierre(char caracter) {
		return ((caracter == ')') || (caracter == ']') || (caracter == '}')) ? true : false;
	}

	public boolean match(char caracter1, char caracter2) {
		return ((caracter1 == '(') && (caracter2 == ')')) || ((caracter1 == '[') && (caracter2 == ']'))
				|| ((caracter1 == '{') && (caracter2 == '}')) ? true : false;
	}

}
