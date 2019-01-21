
package modelo;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import utiles.Constantes;

public class Lista implements Listable{
	
	private LinkedList<Colores> lista = new LinkedList<Colores>();
	private int monedas;
	
	public Lista(LinkedList<Colores> lista){
		super();
		this.lista=lista;
		monedas=0;
	}
	
	
	public LinkedList<Colores> getLista() {
		return lista;
	}

	public void setLista(LinkedList<Colores> lista) {
		this.lista = lista;
	}

	@Override
	public void addLista(Colores color) {
		lista.addFirst(color);
		
	}
	
	public void removeLista(){
		this.lista.removeLast();
	}
	
	
	
public int getMonedas() {
		return monedas;
	}


	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	@Override
	public void borrarColores(Colores color){
		borrarColorLista(color);
	}

	public void borrarColorLista(Colores color){
		for (int i = 0; i < Constantes.tamanioLista; i++) {
			if(lista.get(i).compararColores(color)){
				lista.remove(i);
				lista.add(Colores.blanco);
				this.monedas++;
				borrarColorLista(color);
			}
		}
	}
	
	@Override
	public int recorrerListaAutomatico(){
		int contador=0;
		for (int i = 0; i < Constantes.tamanioLista-4; i++) {
			Colores color= lista.get(i);
			if(color.compararColores(lista.get(i+1)) && !color.compararColores(Colores.blanco)){
				if(color.compararColores(lista.get(i+2))){
					if(color.compararColores(lista.get(i+3))){
						for (int j = 0; j < 4; j++) {
							lista.remove(i);
							lista.add(Colores.blanco);
						}
						contador++;
					}
				}
			}
		}
		return contador;
	}	
}

