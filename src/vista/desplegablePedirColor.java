package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Colores;
import utiles.Constantes;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class desplegablePedirColor extends JFrame {

	private JPanel contentPane;
	private JComboBox <Colores> comboBox= new JComboBox<>();
	private JPanel panel;
	
	/**
	 * Create the frame.
	 */
	public desplegablePedirColor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 397, 337);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(37, 13, 290, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(153, 204, 255));
		
		comboBox = new JComboBox(); 
		comboBox.setModel(new DefaultComboBoxModel(new Constantes().colores));
		comboBox.setName("");
		comboBox.setBackground(new Color(245, 255, 250));
		comboBox.setForeground(new Color(0, 0, 102));
		comboBox.setFont(new Font("Give You Glory", Font.BOLD | Font.ITALIC, 20));
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox.setBounds(10, 11, 268, 36);
		panel.add(comboBox);
	}

	public JPanel getCogerContentPane() {
		return contentPane;
	}

	public void setCambiarContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JComboBox getCogerComboBox() {
		return comboBox;
	}

	public void setCambiarComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JPanel getCogerPanel() {
		return panel;
	}

	public void setCambiarPanel(JPanel panel) {
		this.panel = panel;
	}
	
	
}
