package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RegComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComision dialog = new RegComision();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegComision() {
		setTitle("Registrar Comisiones");
		setBounds(100, 100, 967, 576);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 102, 255));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 102, 255));
			panel_1.setBorder(new TitledBorder(null, "Datos:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel_1.setBounds(10, 11, 922, 117);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(10, 31, 42, 14);
			panel_1.add(lblNewLabel);
			
			JTextPane textPane = new JTextPane();
			textPane.setBackground(UIManager.getColor("Button.light"));
			textPane.setForeground(UIManager.getColor("Button.focus"));
			textPane.setEditable(false);
			textPane.setBounds(67, 31, 76, 20);
			panel_1.add(textPane);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(10, 80, 48, 14);
			panel_1.add(lblNewLabel_1);
			
			JTextPane textPane_1 = new JTextPane();
			textPane_1.setBounds(67, 74, 161, 20);
			panel_1.add(textPane_1);
			
			JLabel lblNewLabel_2 = new JLabel("\u00C1rea:");
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setBounds(240, 31, 32, 14);
			panel_1.add(lblNewLabel_2);
			
			JTextPane textPane_2 = new JTextPane();
			textPane_2.setBounds(282, 31, 161, 20);
			panel_1.add(textPane_2);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Jurados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel_2.setBackground(new Color(0, 102, 255));
			panel_2.setBounds(10, 139, 450, 333);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(10, 23, 162, 299);
			panel_2.add(panel_4);
			panel_4.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_4.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBounds(278, 23, 162, 299);
			panel_2.add(panel_5);
			panel_5.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_5.add(scrollPane_1, BorderLayout.CENTER);
			
			table_1 = new JTable();
			scrollPane_1.setViewportView(table_1);
			
			JButton btnNewButton = new JButton("Agregar");
			btnNewButton.setBounds(179, 184, 89, 23);
			panel_2.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Quitar");
			btnNewButton_1.setBounds(179, 222, 89, 23);
			panel_2.add(btnNewButton_1);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Trabajos Cient\u00EDficos:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel_3.setBackground(new Color(0, 102, 255));
			panel_3.setBounds(482, 139, 450, 333);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JPanel panel_6 = new JPanel();
			panel_6.setBounds(10, 25, 162, 299);
			panel_3.add(panel_6);
			panel_6.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_2 = new JScrollPane();
			panel_6.add(scrollPane_2, BorderLayout.CENTER);
			
			table_2 = new JTable();
			scrollPane_2.setViewportView(table_2);
			
			JButton btnNewButton_2 = new JButton("Agregar");
			btnNewButton_2.setBounds(182, 190, 89, 23);
			panel_3.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("Quitar");
			btnNewButton_3.setBounds(182, 226, 89, 23);
			panel_3.add(btnNewButton_3);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBounds(278, 25, 162, 299);
			panel_3.add(panel_7);
			panel_7.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_3 = new JScrollPane();
			panel_7.add(scrollPane_3, BorderLayout.CENTER);
			
			table_3 = new JTable();
			scrollPane_3.setViewportView(table_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 0));
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
