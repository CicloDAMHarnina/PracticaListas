package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;

public class vistaDos extends JFrame {

	private JPanel contentPane;
	private panelUno centro;
	private panelDos cabecera;

	/**
	 * Create the frame.
	 */
	public vistaDos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setTitle("PICOLI");
		setVisible(true);
		
		
		setBounds(100, 100, 679, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cabecera = new panelDos();
		cabecera.setBackground(new Color(255, 255, 153));
		cabecera.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cabecera.setBounds(5, 10, 769, 70);
		contentPane.add(cabecera);

		centro = new panelUno();
		centro.setBackground(new Color(255, 255, 153));
		centro.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		centro.setBounds(5, 92, 769, 458);
		contentPane.add(centro);
	}

	public JPanel getCogerContentPane() {
		return contentPane;
	}

	public void setCambiarContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public panelUno getCogerCentro() {
		return centro;
	}

	public void setCambiarCentro(panelUno centro) {
		this.centro = centro;
	}

	public panelDos getCogerCabecera() {
		return cabecera;
	}

	public void setCambiarCabecera(panelDos cabecera) {
		this.cabecera = cabecera;
	}
	
	

}
