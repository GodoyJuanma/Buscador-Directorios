package es.florida.ActivitatAvaluable1;

/**
 * Classe principal de la App on se crea la app en model MVC
 * 
 * @author juvigo
 * @version 1.0
 */

public class Principal {

	/**
	 * Mètode main on se inicialitcen el objectes de les clases controlador , model
	 * y vista
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m = new Model();
		Vista v = new Vista();
		Controlador c = new Controlador(m, v);
	}

}
