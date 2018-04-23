package modelo;

public interface Coleable{

	/**
	 * A�ade un color al final de la cola
	 * @param color
	 */
	public void enColar(Colores color);
	
	/**
	 * Elimina y retorna el primer color de la cola
	 * @return cola
	 */
	public Colores desEncolar();
}
