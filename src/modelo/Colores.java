

package modelo;

import java.awt.Color;
import java.util.ArrayList;

public enum Colores{

	rojo(Color.red, "rojo"), amarillo(Color.YELLOW, "amarillo"), azul(Color.BLUE, "azul"), verde(Color.GREEN,
			"verde"), naranja(Color.orange, "naranja"), blanco(Color.white, "blanco");
	private Color color;
	private String nombre;

	private Colores(Color color, String nombre) {
		this.color = color;
		this.nombre = nombre;
	}

	public Color getColor() {
		return color;
	}

	public static int getCantidadElementos() {
		return Colores.values().length;
	}

	public static Colores getElement(int i) {
		return Colores.values()[i];
	}

	@Override
	public String toString() {
		return this.nombre;
	}
	
	/**
	 * Como el equals no se puede poner en una enumeración pues pongo este método para poder usarlo en las listas. No compara bien con el 
	 * equals por defecto
	 * @param color
	 * @return
	 */
	public boolean compararColores(Colores color){
		if(super.toString().equals(color.toString())){
			return true;
		}
		else
			return false;
	}
}
