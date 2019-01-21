package modelo;

import java.util.ArrayList;

public interface Listable {

	/**
	 * Añade un color a la lista
	 * @param color
	 */
	public void addLista(Colores color);
	
	/**
	 * Borra color en todas sus posiciones y actualiza monedas
	 * @param posiciones
	 * @return
	 */
	public void borrarColores(Colores color);
	
	/**
	 * Recorre la lista, borra los colores que estén repetidos cuatro veces y añade las monedas
	 * @return numero de monedas
	 */
	public int recorrerListaAutomatico();

}
