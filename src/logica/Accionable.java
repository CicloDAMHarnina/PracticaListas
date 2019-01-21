package logica;

import java.util.ArrayList;

import modelo.Colores;

public interface Accionable {
	
	/**
	 * Usa el m�todo de datos "sortearColor" para dar tres colores.
	 */
	public ArrayList<Colores> seleccionarColor(ArrayList<Colores> repetidos, int ronda);
	
	/**
	 * Usa el m�todo "equilibrarPilas" de Datos para barajarlas y ponerlas al mismo tama�o (si es impar la primera es la peque)
	 */
	public void barajar();
	
	/**
	 * Elige un color y lo borra de la lista. Usa el m�todo "busquedaColor" de lista.
	 */
	public void borrarColor(Colores color);
}
