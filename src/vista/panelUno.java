package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class panelUno extends JPanel {
	private JTextField numeroMonedas;
	private JTextField txtMensaje;
	private JPanel cola;
	private JPanel pilaUno;
	private JPanel pilaDos;
	private JPanel lista;
	private JLabel lblCola;
	private JLabel lblPilaUno;
	private JLabel lblPilaDos;
	private JLabel lblLista;
	private JLabel lblIconoMonedas;

	/**
	 * Create the panel.
	 */
	public panelUno() {
		setBackground(new Color(255, 255, 153));
		setLayout(null);

		cola = new JPanel();
		cola.setBackground(Color.WHITE);
		cola.setBounds(162, 50, 570, 35);
		add(cola);

		pilaUno = new JPanel();
		pilaUno.setBackground(Color.WHITE);
		pilaUno.setBounds(162, 105, 570, 35);
		add(pilaUno);

		pilaDos = new JPanel();
		pilaDos.setBackground(Color.WHITE);
		pilaDos.setBounds(162, 149, 570, 35);
		add(pilaDos);

		lista = new JPanel();
		lista.setBackground(Color.WHITE);
		lista.setBounds(162, 200, 570, 150);
		add(lista);

		lblCola = new JLabel("Cola");
		lblCola.setForeground(new Color(0, 0, 102));
		lblCola.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 16));
		lblCola.setBounds(49, 60, 67, 25);
		add(lblCola);

		lblPilaUno = new JLabel("PilaUno");
		lblPilaUno.setForeground(new Color(0, 0, 102));
		lblPilaUno.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 16));
		lblPilaUno.setBounds(49, 113, 67, 25);
		add(lblPilaUno);

		lblPilaDos = new JLabel("PilaDos");
		lblPilaDos.setForeground(new Color(0, 0, 102));
		lblPilaDos.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 16));
		lblPilaDos.setBounds(49, 149, 67, 25);
		add(lblPilaDos);

		lblLista = new JLabel("Lista");
		lblLista.setForeground(new Color(0, 0, 102));
		lblLista.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 16));
		lblLista.setBounds(49, 244, 67, 25);
		add(lblLista);

		numeroMonedas = new JTextField();
		numeroMonedas.setForeground(new Color(0,0,102));
		numeroMonedas.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 16));
		numeroMonedas.setBounds(103, 398, 300, 25);
		numeroMonedas.setEditable(false);
		add(numeroMonedas);

		lblIconoMonedas = new JLabel("");
		lblIconoMonedas.setBounds(27, 377, 67, 63);

		ImageIcon imgIcon = new ImageIcon("img/iconoMonedas.png");
		Image imgEscalada = imgIcon.getImage().getScaledInstance(lblIconoMonedas.getWidth(),
				lblIconoMonedas.getHeight(), Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		lblIconoMonedas.setIcon(iconoEscalado);
		add(lblIconoMonedas);

		/*txtMensaje = new JTextField();
		txtMensaje.setBounds(376, 400, 334, 40);
		txtMensaje.setEnabled(false);
		add(txtMensaje);
		txtMensaje.setColumns(10);*/

	}

	public JTextField getCogerTxtMensaje() {
		return txtMensaje;
	}

	public JTextField getCogerNumeroMonedas() {
		return numeroMonedas;
	}


	public void setCogerNumeroMonedas(JTextField numeroMonedas) {
		this.numeroMonedas = numeroMonedas;
	}


	public void setCambiarTxtMensaje(JTextField txtMensaje) {
		this.txtMensaje = txtMensaje;
	}

	public JPanel getCogerCola() {
		return cola;
	}

	public void setCambiarCola(JPanel cola) {
		this.cola=cola;
	}

	public JPanel getCogerPilaUno() {
		return pilaUno;
	}

	public void setCambiarPilaUno(JPanel pilaUno) {
		this.pilaUno = pilaUno;
	}

	public JPanel getCogerPilaDos() {
		return pilaDos;
	}

	public void setCambiarPilaDos(JPanel pilaDos) {
		this.pilaDos = pilaDos;
	}

	public JPanel getCogerLista() {
		return lista;
	}

	public void setCambiarLista(JPanel lista) {
		this.lista = lista;
	}

	public JLabel getCogerLblCola() {
		return lblCola;
	}

	public void setCambiarLblCola(JLabel lblCola) {
		this.lblCola = lblCola;
	}

	public JLabel getCogerLblPilaUno() {
		return lblPilaUno;
	}

	public void setCambiarLblPilaUno(JLabel lblPilaUno) {
		this.lblPilaUno = lblPilaUno;
	}

	public JLabel getCogerLblPilaDos() {
		return lblPilaDos;
	}

	public void setCambiarLblPilaDos(JLabel lblPilaDos) {
		this.lblPilaDos = lblPilaDos;
	}

	public JLabel getCogerLblLista() {
		return lblLista;
	}

	public void setCambiarLblLista(JLabel lblLista) {
		this.lblLista = lblLista;
	}

	public JLabel getCogerLblIconoMonedas() {
		return lblIconoMonedas;
	}

	public void setCambiarLblIconoMonedas(JLabel lblIconoMonedas) {
		this.lblIconoMonedas = lblIconoMonedas;
	}
	
}
