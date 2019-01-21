package logica;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import modelo.Cola;
import modelo.Colores;
import modelo.Lista;
import modelo.Pila;
import utiles.Constantes;

public class Datos {

	private Lista lista = new Lista(generarLista());
	private Cola cola = new Cola(generarCola());
	private Pila pilaUno = new Pila(generarPilaUno());
	private Pila pilaDos = new Pila(generarPilaDos());
	private int pedirColor;
	private int barajarPilas;
	private int borrarColor;
	private int monedas;

	public Datos(){
		super();
		this.pedirColor=0;
		this.barajarPilas=0;
		this.borrarColor=0;
		this.monedas=0;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public Cola getCola() {
		return cola;
	}

	public void setCola(Cola cola) {
		this.cola = cola;
	}

	public Pila getPilaUno() {
		return pilaUno;
	}

	public void setPilaUno(Pila pilaUno) {
		this.pilaUno = pilaUno;
	}

	public Pila getPilaDos() {
		return pilaDos;
	}

	public void setPilaDos(Pila pilaDos) {
		this.pilaDos = pilaDos;
	}
	
	public int getPedirColor() {
		return pedirColor;
	}

	public void setPedirColor(int pedirColor) {
		this.pedirColor = pedirColor;
	}

	public int getBarajarPilas() {
		return barajarPilas;
	}

	public void setBarajarPilas(int barajarPilas) {
		this.barajarPilas = barajarPilas;
	}

	public int getBorrarColor() {
		return borrarColor;
	}

	public void setBorrarColor(int borrarColor) {
		this.borrarColor = borrarColor;
	} 

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	/**
	 * coge las dos pilas y las deja del mismo tamaño (y si es impar el primero lo deja mas peque) funciona perfecto
	 */
	public void equilibrarPilas() {
		LinkedList<Colores> pilaParcial= new LinkedList<Colores>();
		LinkedList<Colores>pilaBlancos= new LinkedList<Colores>();
		rellenarPilaParcial(pilaParcial,pilaBlancos);
		int largo= (pilaParcial.size())/2;
		desordenarColores(pilaParcial);
		rellenarDeNuevoPilas(pilaParcial, largo);
		rellenarConBlancos(pilaUno.getPila(), Constantes.tamanioPilaUno);
		rellenarConBlancos(pilaDos.getPila(), Constantes.tamanioPilaDos);
	}
	
	/**
	 * Desordena los colores de pilaParcial para entrarlas en las pilas y que estén desordenadas.
	 * @param pilaParcial
	 */
	private void desordenarColores(LinkedList<Colores> pilaParcial){

		for (int i = 0; i < 100; i++) {
			int aleatorio= (int) (Math.random()*pilaParcial.size());
			Colores color= pilaParcial.remove(aleatorio);
			pilaParcial.add(color);
		}
	}

	/**
	 * Rellena una pila parcial con las dos pilas para poder desordenarla.
	 * @param pilaParcial
	 */
	private void rellenarPilaParcial(LinkedList<Colores>pilaParcial,LinkedList<Colores>pilaBlancos)
	{

		for (Iterator iterator = pilaUno.getPila().iterator(); iterator.hasNext();) {
			Colores colores = (Colores) iterator.next();
			if(!colores.toString().equals("blanco")){
				pilaParcial.add(pilaUno.getPila().getFirst());
			}
			else{
				pilaBlancos.add(pilaUno.getPila().getFirst());
			}
			iterator.remove();
		}
		
		for (Iterator iterator = pilaDos.getPila().iterator(); iterator.hasNext();) {
			Colores colores = (Colores) iterator.next();
			if(!colores.toString().equals("blanco")){
				pilaParcial.add(pilaDos.getPila().getFirst());
			}
			else{
				pilaBlancos.add(pilaDos.getPila().getFirst());
			}
			iterator.remove();
			
		}
	}
	
	/**
	 * Rellena las pilas (la primera es la corta en caso de impar) con los colores de la pila parcial
	 * @param pilaParcial
	 * @param largo
	 */
	private void rellenarDeNuevoPilas(LinkedList<Colores>pilaParcial,int largo){
		int numeroParcial=0;
		for (Iterator iterator = pilaParcial.iterator(); iterator.hasNext();) {
			Colores color = (Colores) iterator.next();
			if(numeroParcial<largo){
				this.pilaUno.apilar(color);
			}
			else{
				this.pilaDos.apilar(color);
			}
			numeroParcial++;
		}
	}

	/**
	 * Para tener los blancos y que no se descordine con la vista
	 * @param pilaParcial
	 * @param tamanio
	 */
	private void rellenarConBlancos(LinkedList<Colores>pilaParcial,int tamanio){
		for (int i = pilaParcial.size(); i < tamanio; i++) {
			pilaParcial.add(Colores.blanco);
		}
	}

	/**
	 * Una cola de diez posiciones con colores aleatorios
	 * @return
	 */
	public LinkedList<Colores> generarCola() {
		
		LinkedList<Colores> ColaParcial=new LinkedList<Colores>();
		for (int i = 0; i < Constantes.tamanioCola; i++) {
			int aleatorio= (int)(Math.random()*Constantes.numeroColores);
			ColaParcial.add(Constantes.colores[aleatorio]);
		}
		return ColaParcial;
	}
	
	/**
	 * Genera la pila uno de 3 elementos de colores blancos
	 * @return
	 */
	public LinkedList<Colores> generarPilaUno(){
		LinkedList<Colores> PilaParcial= new LinkedList<Colores>();
		for (int i = 0; i < Constantes.tamanioPilaUno; i++) {
			PilaParcial.add(Colores.blanco);
		}
		return PilaParcial;
	}
	
	/**
	 * Genera la pila dos de 4 elementos de colores blancos
	 * @return
	 */
	public LinkedList<Colores> generarPilaDos(){
		LinkedList<Colores> PilaParcial= new LinkedList<Colores>();
		for (int i = 0; i < Constantes.tamanioPilaDos; i++) {
			PilaParcial.add(Colores.blanco);
		}
		return PilaParcial;
	}
	
	/**
	 * Genera una lista de 20 elementos con colores blancos
	 * @return
	 */
	public LinkedList<Colores> generarLista(){
		LinkedList<Colores> ListaParcial= new LinkedList<Colores>();
		for (int i = 0; i < Constantes.tamanioLista; i++) {
			ListaParcial.add(Colores.blanco);
		}
		return ListaParcial;
	}
	
	/**
	 * Devuelve un color teniendo en cuenta que no puede devolver un repetido
	 * @param repetidos
	 * @return
	 */
	public Colores sortearColor(ArrayList<Colores> repetidos) {
		boolean salir= true;
		int index=0;
		do{
			index = (int) (Math.random()*(Colores.getCantidadElementos()-1));
			
			salir=true;
			for (int i = 0; i < repetidos.size(); i++) {
				if(Colores.getElement(index).equals(repetidos.get(i))){
					salir= false;
				}
			}
			
		}while(!salir);
	
		return Colores.values()[index];
	}
}
