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
import utiles.Constantes;
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
				
				desplegableSeleccionColor slColor = new desplegableSeleccionColor();
				
				JComboBox<Colores> cogerComboBox = slColor.getCogerComboBox();
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
						slColor.dispose();
						
					}
				});
				slColor.setVisible(true);
				
			}
		});

		/**
		 * Boton que te da a escoger entre los cinco colores un maximo de 5 veces
		 */
		vistaDos.getCogerCabecera().getCogerBtnPedirColor().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(acciones.getDato().getPedirColor()<Constantes.maxPedirColor){
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
					
					acciones.getDato().setPedirColor(acciones.getDato().getPedirColor()+1);
				}
				
			}
		});
		
		/**
		 * Boton que baraja las pilas como maximo 3 veces
		 */
		vistaDos.getCogerCabecera().getCogerBtnBarajarPilas().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(acciones.getDato().getBarajarPilas()<Constantes.maxBarajarPilas){
					acciones.barajar();
					actualizarTodo();	
					acciones.getDato().setBarajarPilas(acciones.getDato().getBarajarPilas()+1);
				}
				
			}
			
		});
		
		/**
		 * Boton que borra el color que quieras de la lista
		 */
		vistaDos.getCogerCabecera().getCogerBtnBorrarcolor().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(acciones.getDato().getBorrarColor()<Constantes.maxBorrarColor){
				desplegablePedirColor elegirColor = new desplegablePedirColor();
				elegirColor.setVisible(true);
				JComboBox cogerComboBox = elegirColor.getCogerComboBox();
					cogerComboBox.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Colores colorParcial = (Colores) cogerComboBox.getSelectedItem();
							acciones.borrarColor(colorParcial);
							actualizarTodo();
							elegirColor.dispose();
						}
				});
				}
				acciones.getDato().setBorrarColor(acciones.getDato().getBorrarColor()+1);
		}
		});
		
		vistaFinal.getCogerBtnReinicio().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vistaFinal.dispose();
				vistaDos.dispose();
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
	 * este método es al que hay que llamar siempre que se de a algún botón
	 */
	public void actualizarTodo(){
		acciones.recorrerAutomatico();
		acciones.pintarCola(vistaDos.getCogerCentro().getCogerCola());
		acciones.pintarPilas(vistaDos.getCogerCentro().getCogerPilaUno(), vistaDos.getCogerCentro().getCogerPilaDos());
		acciones.pintarLista(vistaDos.getCogerCentro().getCogerLista());
		vistaDos.getCogerCentro().getCogerNumeroMonedas().setText("Numero monedas: "+acciones.getDato().getLista().getMonedas());
		if(acciones.getDato().getLista().getMonedas()>=Constantes.monedasGanador){
			vistaFinal.setVisible(true);
			vistaFinal.getCogerLblSentencia().setText("¡Has ganado!");
		}
		else{
			if(!acciones.getDato().getLista().getLista().get(Constantes.tamanioLista-1).compararColores(Colores.blanco)){
				vistaFinal.setVisible(true);
				vistaFinal.getCogerLblSentencia().setText("Perdiste...");
			}
		}
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
