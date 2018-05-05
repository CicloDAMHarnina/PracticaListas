package controlador;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;

import logica.Acciones;
import modelo.Colores;
import vista.desplegablePedirColor;
import vista.desplegableSeleccionColor;
import vista.vistaUI;

public class ParaPracticaListaUI extends vistaUI {

	private Acciones acciones = new Acciones();
	private desplegableSeleccionColor slctColor = new desplegableSeleccionColor();
	private ArrayList<Colores> repetidos = new ArrayList<Colores>();
	private ArrayList<Colores> select = new ArrayList<Colores>();
	private int ronda=0;

	public ParaPracticaListaUI() {

		vistaUno.setVisible(true);
		vistaDos.setVisible(false);
		//JLabel temporalLabel = new JLabel();
		
	

		vistaUno.getCogerBtnJugar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vistaDos.setVisible(true);
				vistaUno.setVisible(false);

				acciones.crearColaJlabel(vistaDos.getCogerCentro().getCogerCola());
				acciones.crearPilas(vistaDos.getCogerCentro().getCogerPilaUno(), vistaDos.getCogerCentro().getCogerPilaDos());
				acciones.crearLista(vistaDos.getCogerCentro().getCogerLista());
			}
		});

		vistaDos.getCogerCabecera().getCogerBtnSeleccionColor().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cogerComboBox = slctColor.getCogerComboBox();
				cogerComboBox.removeAllItems();
				ArrayList<Colores> colores = acciones.seleccionarColor(repetidos, ronda);
				cogerComboBox.addItem(acciones.coloresVista(colores, 0));
				cogerComboBox.addItem(acciones.coloresVista(colores, 1));
				cogerComboBox.addItem(acciones.coloresVista(colores, 2));
				
				cogerComboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Colores colorParcial = (Colores) cogerComboBox.getSelectedItem();
						Colores colorCola=acciones.getDato().getCola().desEncolar();
						acciones.entrarColorPila(colorCola);
						acciones.getDato().getCola().enColar(colorParcial);
						actualizarTodo();
						slctColor.dispose();
						
					}
				});
				slctColor.setVisible(true);
				
			}
		});

		vistaDos.getCogerCabecera().getCogerBtnPedirColor().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				desplegablePedirColor pdColor = new desplegablePedirColor();
				JComboBox cogerComboBox = pdColor.getCogerComboBox();
				cogerComboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						Colores colorParcial = (Colores) cogerComboBox.getSelectedItem();
						Colores colorCola=acciones.getDato().getCola().desEncolar();
						acciones.entrarColorPila(colorCola);
						acciones.getDato().getCola().enColar(colorParcial);
						actualizarTodo();
						pdColor.dispose();
					}
				});
				pdColor.setVisible(true);
			}
		});

	}
	
	public void crearListaRepes(Colores colorcillo){
		int contador=0;
		this.select.add(colorcillo);
		
		for (int i = 0; i < select.size(); i++) {
			if(colorcillo.equals(select.get(i))){
				contador++;
			}
		}
		if(contador>1){
			this.repetidos.add(colorcillo);
		}
		
	}
	
	/**
	 * este m�todo es al que hay que llamar siempre que se de a alg�n bot�n
	 */
	public void actualizarTodo(){
		acciones.pintarCola(vistaDos.getCogerCentro().getCogerCola());
		acciones.pintarPilas(vistaDos.getCogerCentro().getCogerPilaUno(), vistaDos.getCogerCentro().getCogerPilaDos());
	}

	public Acciones getAcciones() {
		return acciones;
	}

	public void setAcciones(Acciones acciones) {
		this.acciones = acciones;
	}

	public desplegableSeleccionColor getSlctColor() {
		return slctColor;
	}

	public void setSlctColor(desplegableSeleccionColor slctColor) {
		this.slctColor = slctColor;
	}

	public ArrayList<Colores> getRepetidos() {
		return repetidos;
	}

	public void setRepetidos(ArrayList<Colores> repetidos) {
		this.repetidos = repetidos;
	}

}
