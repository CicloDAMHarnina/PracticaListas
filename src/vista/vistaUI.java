package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class vistaUI extends JFrame {

	private JPanel contentPane;
	protected vistaUno vistaUno;
	protected vistaDos vistaDos;
	protected vistaFinal vistaFinal;

	/**
	 * Create the frame.
	 */
	public vistaUI() {
		vistaUno= new vistaUno();
		vistaDos= new vistaDos();
		vistaFinal= new vistaFinal();
		
	}

	public JPanel getCogerContentPane() {
		return contentPane;
	}

	public void setCambiarContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public vistaUno getCogerVistaUno() {
		return vistaUno;
	}

	public void setCambiarVistaUno(vistaUno vistaUno) {
		this.vistaUno = vistaUno;
	}

	public vistaDos getCogerVistaDos() {
		return vistaDos;
	}

	public void setCambiarVistaDos(vistaDos vistaDos) {
		this.vistaDos = vistaDos;
	}
	
	

}
