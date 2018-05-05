package logica;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.*;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import modelo.Colores;
import utiles.Constantes;

public class Acciones implements Accionable{
	
	private Datos dato = new Datos();
	
	//Los tres primeros m�todos aun no est�n hechos (yolanda y mamen)
	//Los dem�s, en orden son para:
	//	1-crear la cola
	//	2-A�adir en la pila los que pasan de la cola
	//	3-Crearse los JLabel de las estructuras
	//	4-Pintar las estructuras

	@Override
	public ArrayList<Colores> seleccionarColor(ArrayList<Colores> repetidos,int ronda) {
		
		ArrayList<Colores> sltColores = new ArrayList<Colores>();
		
		Colores colorDos;
		Colores colorTres;
		Colores colorUno = dato.sortearColor(repetidos);
		
		do{
			colorDos = dato.sortearColor(repetidos);	
		}while(colorUno.equals(colorDos));
		
		do{
			colorTres = dato.sortearColor(repetidos);
		}while((colorTres.equals(colorUno)) || (colorTres.equals(colorDos)));
		
		
		sltColores.add(colorUno);
		sltColores.add(colorDos);
		sltColores.add(colorTres);
		
		aumentarRonda(repetidos,ronda);
		
		
		
		return sltColores;
	}

	public void aumentarRonda(ArrayList<Colores> repetidos,int ronda) {
		ronda++;
		if(ronda==5){
			ronda=0;
			repetidos.clear();
		}
	}

	//no est� hecho
	@Override
	public Colores pedirColor() {
		return null;
	}

	@Override
	public void barajar() {
		this.dato.equilibrarPilas();
		
	}

	@Override
	public void borrarColor(Colores color) {
		this.dato.getLista().borrarColores(this.dato.getLista().busquedaColor(color));
		
	}

	public Datos getDato() {
		return dato;
	}

	public void setDato(Datos dato) {
		this.dato = dato;
	}
	
	/**
	 * Para crear los colores aleatorios de la cola al principio del juego
	 * @return
	 */
	public LinkedList<JLabel> generarColoresCola(){
		LinkedList<Colores> cola= this.dato.generarCola();
		LinkedList<JLabel> colaVista= new LinkedList<JLabel>();
		for (Iterator iterator = cola.iterator(); iterator.hasNext();) {
			Colores color = (Colores) iterator.next();
			JLabel colorVista= new JLabel();
			colorVista.setBackground(color.getColor());
		}
		return colaVista;
	}

	/**
	 * Para meter el color que sale de la cola en una pila al azar
	 * @param color
	 */
	public void entrarColorPila(Colores color){
		int aleatorio= (int)(Math.random()*2);
		if(aleatorio==0){
			dato.getPilaUno().desApilarBlanco();
			dato.getPilaUno().apilar(color);}
		else{
			dato.getPilaDos().desApilarBlanco();
			dato.getPilaDos().apilar(color);
		}	
	}
	
	/**
	 * Coge la cola de los datos y la pinta en la vista
	 * @param panelito
	 */
	public void crearColaJlabel(JPanel panelito){
		panelito.removeAll();
		int comienzo=0;
		for (int i = 0; i < Constantes.tamanioCola; i++) {
			JLabel etiqueta= new JLabel();
			etiqueta.setBounds(comienzo,0,Constantes.separacionEtiquetasCola,35);
			comienzo+=Constantes.separacionEtiquetasCola;
			etiqueta.setName(""+i);
			etiqueta.setVisible(true);
			etiqueta.setBackground(dato.getCola().getCola().get(i).getColor());
			etiqueta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			etiqueta.setOpaque(true);
			panelito.add(etiqueta);
		}
	}
	
	/**
	 * Crea los JLabel de las pilas para luego pintarlos
	 * @param pilaUno
	 * @param pilaDos
	 */
	public void crearPilas(JPanel pilaUno, JPanel pilaDos){
		int comienzo=0;
			for (int i = 0; i < Constantes.tamanioPilaUno; i++) {
				JLabel etiqueta= new JLabel();
				etiqueta.setBounds(comienzo,0,Constantes.separacionEtiquetasPilaUno,35);
				comienzo+=Constantes.separacionEtiquetasPilaUno;
				etiqueta.setName(""+i);
				etiqueta.setVisible(true);
				etiqueta.setBackground(Colores.blanco.getColor());
				etiqueta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				etiqueta.setOpaque(true);
				pilaUno.add(etiqueta);
			}
		
		comienzo=0;
		for (int i = 0; i < Constantes.tamanioPilaDos; i++) {
			JLabel etiqueta= new JLabel();
			etiqueta.setBounds(comienzo,0,Constantes.separacionEtiquetasPilaDos,35);
			comienzo+=Constantes.separacionEtiquetasPilaDos;
			etiqueta.setName(""+i);
			etiqueta.setVisible(true);
			etiqueta.setBackground(Colores.blanco.getColor());
			etiqueta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			etiqueta.setOpaque(true);
			pilaDos.add(etiqueta);
		}
	
	}
	
	public void crearLista(JPanel lista){
		int comienzo=0;
		for (int i = 0; i < Constantes.tamanioLista; i++) {
			JLabel etiqueta= new JLabel();
			etiqueta.setBounds(comienzo,0,Constantes.separacionEtiquetasLista,35);
			comienzo+=Constantes.separacionEtiquetasLista;
			etiqueta.setName(""+i);
			etiqueta.setVisible(true);
			etiqueta.setBackground(Colores.blanco.getColor());
			etiqueta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			etiqueta.setOpaque(true);
			pilaDos.add(etiqueta);
		}
	}
	/**
	 * Pinta la cola en la vista
	 * @param panelito
	 */
	public void pintarCola(JPanel panelito){
		for (int i = 0; i < Constantes.tamanioCola; i++) {
			panelito.getComponent(i).setBackground(dato.getCola().getCola().get(i).getColor());
		}
	}
	/**
	 * Pinta las dos pilas.
	 * @param pilaUno
	 * @param pilaDos
	 */
	public void pintarPilas(JPanel pilaUno, JPanel pilaDos){
		pilaUno.setBackground(new Color(254, 254, 254));
		pilaDos.setBackground(new Color(254, 254, 254));
		for (int i = 0; i < Constantes.tamanioPilaUno; i++) {
			pilaUno.getComponent(i).setBackground(dato.getPilaUno().getPila().get(i).getColor());
		}
		for (int i = 0; i < Constantes.tamanioPilaDos; i++) {
			pilaDos.getComponent(i).setBackground(dato.getPilaDos().getPila().get(i).getColor());
		}
		}

}
