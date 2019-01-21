package modelo;

import java.util.Collection;
import java.util.LinkedList;

public class Pila implements Pilable {

	private LinkedList<Colores> pila;

	public Pila(LinkedList<Colores> pila) {
		super();
		this.pila= pila;
	}

	public LinkedList<Colores> getPila() {
		return pila;
	}

	public void setPila(LinkedList<Colores> pila) {
		this.pila = pila;
	}

	@Override
	public void apilar(Colores color) {
		this.pila.addFirst(color);

	}

	@Override
	public Colores desApilar() {
		return this.pila.removeFirst();
	}
	
	public void apilarBlanco(){
		this.pila.addFirst(Colores.blanco);
	}
	public Colores desApilarBlanco(){
		return this.pila.removeLast();
	}
	
	//rellena una pila con otra directamente. Lo usaba en equilibrarPila antiguamente pero ahora uso Iterator
	//Si quieres usarlo debería estar en privado y hacer otro metodo en publico que lo utilice.
	//por la privacidad y esas cosas que se dicen (el de abajo tambien)
	public Collection getCollection(){
		return this.pila;
	}
	
	//borra una pila completa (solo los datos).
	public void removeCollection(){
		this.pila.removeAll(this.pila);
	}

}
