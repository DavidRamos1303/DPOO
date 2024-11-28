package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.GestionEvento;
import logico.Jurado;
import logico.Participante;
import logico.Persona;
import logico.TrabajoCientifico;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private DefaultTableModel modeloNoSelectJurado;
	private DefaultTableModel modeloSelectJurado;
	private DefaultTableModel modeloNoSelectTrabajo;
	private DefaultTableModel modeloSelecTrabajo;
	private Object row[];
	private JTextField textField;
	private String codComision;

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
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);
		
		setBounds(100, 100, 967, 576);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
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
			
			textField = new JTextField();
			textField.setEditable(false);
			textField.setText("C-"+GestionEvento.getInstance().codComision);
			textField.setBounds(67, 28, 86, 20);
			panel_1.add(textField);
			textField.setColumns(10);
			
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
			modeloNoSelectJurado = new DefaultTableModel();
			String [] identificadores2 = {"Nombre", "Apellido","Area"};
			modeloNoSelectJurado.setColumnIdentifiers(identificadores2);
			table.setModel(modeloNoSelectJurado);
			scrollPane.setViewportView(table);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBounds(278, 23, 162, 299);
			panel_2.add(panel_5);
			panel_5.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_5.add(scrollPane_1, BorderLayout.CENTER);
			
			table_1 = new JTable(); 
			modeloSelectJurado = new DefaultTableModel(); 
			modeloSelectJurado.setColumnIdentifiers(identificadores2); 
			table_1.setModel(modeloSelectJurado); scrollPane_1.setViewportView(table_1);
			
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
			modeloNoSelectTrabajo = new DefaultTableModel(); 
			String[] identificadoresTrabajos = {"Título", "Autor"}; 
			modeloNoSelectTrabajo.setColumnIdentifiers(identificadoresTrabajos); 
			table_2.setModel(modeloNoSelectTrabajo); 
			scrollPane_2.setViewportView(table_2);
			
			JButton btnNewButton_2 = new JButton("Agregar");
			btnNewButton_2.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        int selectedRow = table.getSelectedRow();
			        if(selectedRow >= 0) {
			            
			            Object[] rowData = new Object[table.getColumnCount()];
			            for(int i = 0; i < table.getColumnCount(); i++) {
			                rowData[i] = modeloNoSelectTrabajo.getValueAt(selectedRow, i);
			            }
			            
			            
			            modeloSelecTrabajo.addRow(rowData);
			            
			            modeloNoSelectTrabajo.removeRow(selectedRow);
			            
			            
			        }
			    }
			});
			btnNewButton_2.setBounds(182, 190, 89, 23);
			panel_3.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("Quitar");
			btnNewButton_3.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        int selectedRow = table_1.getSelectedRow();
			        if(selectedRow >= 0) {
			           
			            Object[] rowData = new Object[table_1.getColumnCount()];
			            for(int i = 0; i < table_1.getColumnCount(); i++) {
			                rowData[i] = modeloSelecTrabajo.getValueAt(selectedRow, i);
			            }
			            
			            
			            modeloNoSelectTrabajo.addRow(rowData);
			            
			            modeloSelecTrabajo.removeRow(selectedRow);
			            
			            
			        }
			    }
			});
			btnNewButton_3.setBounds(182, 190, 89, 23);
			panel_3.add(btnNewButton_3);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBounds(278, 25, 162, 299);
			panel_3.add(panel_7);
			panel_7.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_3 = new JScrollPane();
			panel_7.add(scrollPane_3, BorderLayout.CENTER);
			
			table_3 = new JTable(); 
			modeloSelecTrabajo = new DefaultTableModel(); 
			modeloSelecTrabajo.setColumnIdentifiers(identificadoresTrabajos); 
			table_3.setModel(modeloSelecTrabajo); 
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
		loadJurados();
		loadSelectJurados();
		loadNoSelectTrabajos();
		loadSelectTrabajos();
	}
	
	private void loadJurados() {
		modeloNoSelectJurado.setRowCount(0);
		ArrayList<Persona> aux = GestionEvento.getInstance().getMisPersonas();
		row = new Object[table.getColumnCount()];
		for(Persona persona : aux) {
			if(persona instanceof Jurado) {
				row[0] = persona.getNombre();
				row[1] = persona.getCedula();
				row[0] = ((Jurado) persona).getArea();
				modeloNoSelectJurado.addRow(row);
			}
		}
	}
	
	private void loadSelectJurados() { 
		modeloSelectJurado.setRowCount(0);  
		ArrayList<Persona> aux = GestionEvento.getInstance().getMisPersonas(); 
		row = new Object[table_1.getColumnCount()]; 
		for (Persona persona : aux) { 
			if (persona instanceof Jurado && ((Jurado) persona).isSeleccionado()) { 
			row[0] = persona.getNombre(); 
			row[1] = persona.getCedula(); 
			row[2] = ((Jurado) persona).getArea(); modeloSelectJurado.addRow(row); 
			} 
		} 
	}
	
	private void loadNoSelectTrabajos() {
	    modeloNoSelectTrabajo.setRowCount(0);
	    
	    for (TrabajoCientifico trabajo : GestionEvento.getInstance().getMisTrabajosCientificos()) {
	        if (!trabajo.isSeleccionado()) {  
	            Participante autor = trabajo.getAutor();
	            Object[] row = {
	                trabajo.getId(),
	                trabajo.getNombre(),
	                trabajo.getArea(),
	                autor.getNombre() + " " + autor.getApellidos(),
	                autor.getEmail()
	            };
	            modeloNoSelectTrabajo.addRow(row);
	        }
	    }
	}


	private void loadSelectTrabajos() {
	    modeloSelecTrabajo.setRowCount(0);
	    
	    for (TrabajoCientifico trabajo : GestionEvento.getInstance().getMisTrabajosCientificos()) {
	        if (trabajo.isSeleccionado()) {  
	            Participante autor = trabajo.getAutor();
	            Object[] row = {
	                trabajo.getId(),
	                trabajo.getNombre(),
	                trabajo.getArea(),
	                autor.getNombre() + " " + autor.getApellidos(),
	                autor.getEmail()
	            };
	            modeloSelecTrabajo.addRow(row);
	        }
	    }
	}
	
	private void asignarTrabajo(TrabajoCientifico trabajo) {
	    trabajo.setSeleccionado(true);
	    GestionEvento.getInstance().asignarTrabajoAComision(trabajo, codComision);
	    loadNoSelectTrabajos();
	    loadSelectTrabajos();
	}

	private void desasignarTrabajo(TrabajoCientifico trabajo) {
	    trabajo.setSeleccionado(false);
	    GestionEvento.getInstance().removerTrabajoDeComision(trabajo, codComision);
	    loadNoSelectTrabajos();
	    loadSelectTrabajos();
	}
}
