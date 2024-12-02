package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUsuario() {
		setTitle("Registrar Usuario");
		setBounds(100, 100, 457, 368);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel_1.setBounds(10, 11, 404, 261);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblImagen = new JLabel("");
			
			lblImagen.setBounds(316, 11, 78, 83);
			
			ImageIcon ico = new ImageIcon(getClass().getResource("Logo PUCMM (Color).png"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
	        
	        
	        lblImagen.setIcon(img);
	        panel_1.add(lblImagen);
	   
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 29, 113, 14);
			panel_1.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(10, 54, 113, 20);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_1.setBounds(172, 29, 78, 14);
			panel_1.add(lblNewLabel_1);
			
			textField_1 = new JTextField();
			textField_1.setBounds(172, 54, 113, 20);
			panel_1.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Confirmar contrase\u00F1a:");
			lblNewLabel_2.setBounds(172, 85, 134, 14);
			panel_1.add(lblNewLabel_2);
			
			textField_2 = new JTextField();
			textField_2.setBounds(172, 110, 113, 20);
			panel_1.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Apellido:");
			lblNewLabel_3.setBounds(10, 85, 113, 14);
			panel_1.add(lblNewLabel_3);
			
			textField_3 = new JTextField();
			textField_3.setBounds(10, 110, 113, 20);
			panel_1.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Nombre de Usuario:");
			lblNewLabel_4.setBounds(10, 141, 113, 14);
			panel_1.add(lblNewLabel_4);
			
			textField_4 = new JTextField();
			textField_4.setBounds(10, 166, 113, 20);
			panel_1.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Correo electr\u00F3nico:");
			lblNewLabel_5.setBounds(10, 197, 127, 14);
			panel_1.add(lblNewLabel_5);
			
			textField_5 = new JTextField();
			textField_5.setBounds(10, 222, 150, 20);
			panel_1.add(textField_5);
			textField_5.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
