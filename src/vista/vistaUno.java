package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dimension;
import java.awt.Dialog.ModalExclusionType;

public class vistaUno extends JFrame {

	private JPanel contentPane;
	private JButton btnJugar;
	private JLabel lblIcono;
	private JLabel lblJuegoPicoli;


	/**
	 * Create the frame.
	 */

	public vistaUno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setTitle("PICOLI");
		setVisible(true);

		
		getContentPane().setName("vistaUno");
		getContentPane().setBackground(new Color(255, 255, 153));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		btnJugar = new JButton("Jugar");
		btnJugar.setForeground(new Color(0, 0, 102));
		btnJugar.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 20));
		btnJugar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnJugar.setBackground(new Color(153, 204, 255));
		getContentPane().add(btnJugar, BorderLayout.SOUTH);
		
		lblIcono = new JLabel("");
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setIcon(new ImageIcon("img/giphy7.gif"));
		lblIcono.setBounds(189, 72, 225, 225);
		getContentPane().add(lblIcono, BorderLayout.CENTER);
		
		lblJuegoPicoli = new JLabel("Juego PICOLI");
		lblJuegoPicoli.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuegoPicoli.setForeground(new Color(0, 0, 102));
		lblJuegoPicoli.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 26));
		getContentPane().add(lblJuegoPicoli, BorderLayout.NORTH);

	}

	public JPanel getCogerContentPane() {
		return contentPane;
	}

	public void setCambiarContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JButton getCogerBtnJugar() {
		return btnJugar;
	}

	public void setCambiarBtnJugar(JButton btnJugar) {
		this.btnJugar = btnJugar;
	}

	public JLabel getCogerLblIcono() {
		return lblIcono;
	}

	public void setCambiarLblIcono(JLabel lblIcono) {
		this.lblIcono = lblIcono;
	}

	public JLabel getCogerLblJuegoPicoli() {
		return lblJuegoPicoli;
	}

	public void setCambiarLblJuegoPicoli(JLabel lblJuegoPicoli) {
		this.lblJuegoPicoli = lblJuegoPicoli;
	}
	
	

}
