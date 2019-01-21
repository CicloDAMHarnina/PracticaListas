package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class vistaFinal extends JFrame {

	private JPanel contentPane;
	private JLabel lblSentencia;
	private JLabel lblIcono;
	private JButton btnReinicio;

	/**
	 * Create the frame.
	 */
	public vistaFinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		lblIcono = new JLabel("");
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setBounds(85, 81, 193, 132);
		getContentPane().add(lblIcono, BorderLayout.CENTER);
		
		btnReinicio = new JButton("SALIR");
		btnReinicio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnReinicio.setBackground(new Color(153, 204, 255));
		btnReinicio.setForeground(new Color(0, 0, 102));
		btnReinicio.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 20));
		btnReinicio.setBounds(85, 244, 193, 42);
		contentPane.add(btnReinicio);
		
		lblSentencia = new JLabel();
		lblSentencia.setBounds(30, 11, 318, 59);
		lblSentencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblSentencia.setForeground(new Color(0, 0, 102));
		lblSentencia.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 26));
		contentPane.add(lblSentencia, BorderLayout.NORTH);
	}
	
	public JLabel getCogerLblSentencia() {
		return lblSentencia;
	}

	public void setCambiarLblSentencia(JLabel lblSentencia) {
		this.lblSentencia = lblSentencia;
	}

	public JLabel getCogerLblIcono() {
		return lblIcono;
	}

	public void setCambiarLblIcono(JLabel lblIcono) {
		this.lblIcono = lblIcono;
	}

	public JButton getCogerBtnReinicio() {
		return btnReinicio;
	}

	public void setCambiarBtnReinicio(JButton btnReinicio) {
		this.btnReinicio = btnReinicio;
	}
}