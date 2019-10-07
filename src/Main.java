import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField field_apaterno;
	private JTextField field_amaterno;
	private JTextField field_nombres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		super("Formulario de ingreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos personales");
		lblNewLabel.setBounds(29, 11, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido paterno:");
		lblNewLabel_1.setBounds(60, 54, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido materno:");
		lblNewLabel_2.setBounds(60, 79, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombres:");
		lblNewLabel_3.setBounds(60, 104, 78, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox field_estadocivil = new JComboBox();
		field_estadocivil.setMaximumRowCount(16);
		field_estadocivil.setToolTipText("");
		field_estadocivil.setBounds(172, 131, 100, 20);
		contentPane.add(field_estadocivil);
		field_estadocivil.addItem("soltero");
		field_estadocivil.addItem("casado");
		field_estadocivil.addItem("divorciado");
		
		JLabel lblNewLabel_4 = new JLabel("Estado civil");
		lblNewLabel_4.setBounds(60, 134, 78, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lbl_sexo = new JLabel("Sexo");
		lbl_sexo.setBounds(60, 171, 46, 14);
		contentPane.add(lbl_sexo);
		
		JRadioButton radio_m = new JRadioButton("Masculino");
		radio_m.setBounds(172, 167, 109, 23);
		contentPane.add(radio_m);
		
		JRadioButton radio_f = new JRadioButton("Femenino");
		radio_f.setBounds(283, 167, 109, 23);
		contentPane.add(radio_f);
		
		// grupo de botones para que solo se pueda seleccionar uno
		ButtonGroup group = new ButtonGroup();
		group.add(radio_f);
		group.add(radio_m);
		
		radio_f.setActionCommand("Femenino");
		radio_m.setActionCommand("Masculino");
		
		field_apaterno = new JTextField();
		field_apaterno.setBounds(172, 51, 128, 20);
		contentPane.add(field_apaterno);
		field_apaterno.setColumns(10);
		
		field_amaterno = new JTextField();
		field_amaterno.setBounds(172, 76, 128, 20);
		contentPane.add(field_amaterno);
		field_amaterno.setColumns(10);
		
		field_nombres = new JTextField();
		field_nombres.setBounds(172, 101, 128, 20);
		contentPane.add(field_nombres);
		field_nombres.setColumns(10);
		
		JButton btn_guardar = new JButton("Guardar");
		btn_guardar.setBounds(10, 193, 89, 23);
		contentPane.add(btn_guardar);
		
		JButton btn_salir = new JButton("Salir");
		btn_salir.setBounds(335, 193, 89, 23);
		contentPane.add(btn_salir);
		
		JTextPane listado = new JTextPane();
		listado.setEditable(false);
		listado.setBounds(20, 250, 393, 112);
		contentPane.add(listado);
		
		JLabel lblListado = new JLabel("Listado:");
		lblListado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListado.setBounds(29, 225, 77, 14);
		contentPane.add(lblListado);
		
		getContentPane().add(field_apaterno);
		getContentPane().add(field_amaterno);
		getContentPane().add(field_nombres);
		getContentPane().add(field_estadocivil);
		getContentPane().add(listado);
		
		btn_salir.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btn_guardar.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String apaterno = field_apaterno.getText();
				String amaterno = field_amaterno.getText();
				String nombres = field_nombres.getText();
				String estado_civil = field_estadocivil.getSelectedItem().toString();
				String sexo = group.getSelection().getActionCommand();
				listado.setText("Apellido paterno: " + apaterno + "\nApellido materno: " + amaterno + "\nNombres: " + nombres + 
						"\nEstado civil: " + estado_civil + "\nSexo: " + sexo);
			}
		});
	}
}
