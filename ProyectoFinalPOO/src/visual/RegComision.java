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
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Comision;
import logico.GestionEvento;
import logico.Jurado;
import logico.Participante;
import logico.Persona;
import logico.TrabajoCientifico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JPanel buttonPane; 
	private DefaultTableModel modeloNoSelectJurado;
	private DefaultTableModel modeloSelectJurado;
	private DefaultTableModel modeloNoSelectTrabajo;
	private DefaultTableModel modeloSelecTrabajo;
	private Object rowJuradoSelect[];
	private Object rowJuradoNoSelect[];
	private Object rowTrabajoSelect[];
	private Object rowTrabajoNoSelect[];
	private JTextField txtCodigo;
	private String codComision;
	private JTextField txtNombre;
	private JComboBox cbxArea;
	private Comision comisionAModificar = null;

	
	public RegComision(Comision comision) {
	    // Primero llamamos al constructor original que inicializa todos los componentes
	    this();
	    
	    // Después de que todo está inicializado, modificamos los componentes
	    try {
	        this.comisionAModificar = comision;
	        
	        // Modificar el título de la ventana
	        setTitle("Modificar Comisión");
	        
	        // Cargar los datos de la comisión
	        txtCodigo.setText(comision.getCodComision());
	        txtNombre.setText(comision.getNombre());
	        cbxArea.setSelectedItem(comision.getArea());
	        
	        // Limpiar las selecciones anteriores
	        for (Persona persona : GestionEvento.getInstance().getMisPersonas()) {
	            if (persona instanceof Jurado) {
	                ((Jurado) persona).setSeleccionado(false);
	            }
	        }
	        
	        for (TrabajoCientifico trabajo : GestionEvento.getInstance().getMisTrabajosCientificos()) {
	            trabajo.setSeleccionado(false);
	        }
	        
	        // Cargar jurados seleccionados
	        for (Jurado jurado : comision.getJurado()) {
	            jurado.setSeleccionado(true);
	        }
	        
	        // Cargar trabajos seleccionados
	        for (TrabajoCientifico trabajo : comision.getTrabajos()) {
	            trabajo.setSeleccionado(true);
	        }
	        
	        // Actualizar las tablas
	        loadJurados();
	        loadSelectJurados();
	        loadNoSelectTrabajos();
	        loadSelectTrabajos();
	        
	        // Buscar y modificar el botón Registrar
	        for (Component comp : getContentPane().getComponents()) {
	            if (comp instanceof JPanel) {
	                JPanel panel = (JPanel) comp;
	                for (Component btn : panel.getComponents()) {
	                    if (btn instanceof JButton) {
	                        JButton button = (JButton) btn;
	                        if (button.getText().equals("Registrar")) {
	                            button.setText("Modificar");
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, 
	            "Error al cargar los datos de la comisión",
	            "Error", 
	            JOptionPane.ERROR_MESSAGE);
	    }
	}
	
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
		
		setBounds(100, 100, 1115, 576);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel_1.setBounds(10, 11, 1069, 117);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBounds(10, 31, 42, 14);
			panel_1.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setBounds(10, 80, 48, 14);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("\u00C1rea:");
			lblNewLabel_2.setForeground(Color.BLACK);
			lblNewLabel_2.setBounds(240, 31, 32, 14);
			panel_1.add(lblNewLabel_2);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setText("C-"+GestionEvento.getInstance().codComision);
			txtCodigo.setBounds(67, 28, 86, 20);
			panel_1.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(67, 77, 161, 20);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);
			
			cbxArea = new JComboBox();
			cbxArea.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Tecnolog\u00EDa en inform\u00E1tica ", "Ciencias de la salud", "Ciencias Sociales", "Investigaci\u00F3n\u00A0y\u00A0Desarrollo"}));
			cbxArea.setBounds(282, 28, 179, 20);
			panel_1.add(cbxArea);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jurados:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel_2.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			panel_2.setBounds(10, 139, 524, 333);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(10, 23, 198, 299);
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
			panel_5.setBounds(316, 23, 198, 299);
			panel_2.add(panel_5);
			panel_5.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_2 = new JScrollPane();
			panel_5.add(scrollPane_2, BorderLayout.CENTER);
			
			table_2 = new JTable(); 
			modeloSelectJurado = new DefaultTableModel(); 
			String [] identificadores3 = {"Nombre", "Apellido","Area"};
			table_2.setModel(modeloSelectJurado); 
			scrollPane_2.setViewportView(table_2);
			modeloSelectJurado.setColumnIdentifiers(identificadores3);
			
			JButton btnNewButton = new JButton("Agregar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = table.getSelectedRow();
			        if(selectedRow >= 0) {
			        	
			        	if(cbxArea.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
			        		JOptionPane.showMessageDialog(null,"Debe elegir un área.", "Error", JOptionPane.ERROR_MESSAGE);
			        	}else if(modeloNoSelectJurado.getValueAt(selectedRow, 2).toString().equalsIgnoreCase(cbxArea.getSelectedItem().toString())) {
			                Object[] rowData = new Object[3];
			                for(int i = 0; i < 3; i++) {
			                    rowData[i] = modeloNoSelectJurado.getValueAt(selectedRow, i);
			                }
			                
			                modeloSelectJurado.addRow(rowData);
			                modeloNoSelectJurado.removeRow(selectedRow);
			                
			                if(modeloSelectJurado.getRowCount() > 0) {
			                    cbxArea.setEnabled(false);
			                }
			               
			                String nombre = rowData[0].toString();
			                String cedula = rowData[1].toString();
			                for (Persona persona : GestionEvento.getInstance().getMisPersonas()) {
			                    if (persona instanceof Jurado && 
			                        persona.getNombre().equals(nombre) && 
			                        persona.getCedula().equals(cedula)) {
			                        ((Jurado) persona).setSeleccionado(true);
			                        break;
			                    }
			                }
			            } else {
			                JOptionPane.showMessageDialog(null, 
			                    "El área del jurado debe coincidir con el área de la comisión",
			                    "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
				}
			});
			btnNewButton.setBounds(217, 172, 89, 23);
			panel_2.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Quitar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = table_2.getSelectedRow();
			        if(selectedRow >= 0) {
			            Object[] rowData = new Object[3];
			            for(int i = 0; i < 3; i++) {
			                rowData[i] = modeloSelectJurado.getValueAt(selectedRow, i);
			            }
			            
			            modeloNoSelectJurado.addRow(rowData);
			            modeloSelectJurado.removeRow(selectedRow);
			            
			            if(modeloSelectJurado.getRowCount() == 0) {
			                cbxArea.setEnabled(true);
			            }
			            
			            String nombre = rowData[0].toString();
			            String cedula = rowData[1].toString();
			            for (Persona persona : GestionEvento.getInstance().getMisPersonas()) {
			                if (persona instanceof Jurado && 
			                    persona.getNombre().equals(nombre) && 
			                    persona.getCedula().equals(cedula)) {
			                    ((Jurado) persona).setSeleccionado(false);
			                    break;
			                }
			            }
			        }
				}
			});
			btnNewButton_1.setBounds(217, 205, 89, 23);
			panel_2.add(btnNewButton_1);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Trabajos Cient\u00EDficos:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel_3.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			panel_3.setBounds(555, 139, 524, 333);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JPanel panel_6 = new JPanel();
			panel_6.setBounds(10, 25, 198, 299);
			panel_3.add(panel_6);
			panel_6.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_6.add(scrollPane_1, BorderLayout.CENTER);
			
			table_1 = new JTable(); 
			modeloNoSelectTrabajo = new DefaultTableModel(); 
			String[] identificadoresTrabajos = {"Título", "Area"};
			table_1.setModel(modeloNoSelectTrabajo); 
			scrollPane_1.setViewportView(table_1);
			modeloNoSelectTrabajo.setColumnIdentifiers(identificadoresTrabajos); 
			
			JButton btnNewButton_2 = new JButton("Agregar");
			btnNewButton_2.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        int selectedRow = table_1.getSelectedRow();
			        if(selectedRow >= 0) {
			            
			        	if(cbxArea.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
			        		JOptionPane.showMessageDialog(null,"Debe elegir un área.", "Error", JOptionPane.ERROR_MESSAGE);
			        	}else if(modeloNoSelectTrabajo.getValueAt(selectedRow, 1).toString().equalsIgnoreCase(cbxArea.getSelectedItem().toString())) {
			        		Object[] rowData = new Object[2];
				            for(int i = 0; i < 2; i++) {
				                rowData[i] = modeloNoSelectTrabajo.getValueAt(selectedRow, i);
				            }

				            modeloSelecTrabajo.addRow(rowData);
				            modeloNoSelectTrabajo.removeRow(selectedRow);
				            
				            if(modeloSelecTrabajo.getRowCount() > 0) {
			                    cbxArea.setEnabled(false);
			                }
				            
				            String titulo = rowData[0].toString();
				            for (TrabajoCientifico trabajo : GestionEvento.getInstance().getMisTrabajosCientificos()) {
				                if (trabajo.getNombre().equals(titulo)) {
				                    trabajo.setSeleccionado(true);
				                    break;
				                }
				            }
			        	}else {
			                JOptionPane.showMessageDialog(null, 
				                    "El área del jurado debe coincidir con el área de la comisión",
				                    "Error", JOptionPane.ERROR_MESSAGE);
				        }
			        }
			    }
			});
			btnNewButton_2.setBounds(218, 169, 89, 23);
			panel_3.add(btnNewButton_2);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBounds(316, 25, 198, 299);
			panel_3.add(panel_7);
			panel_7.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_3 = new JScrollPane();
			panel_7.add(scrollPane_3, BorderLayout.CENTER);
			
			table_3 = new JTable(); 
			modeloSelecTrabajo = new DefaultTableModel(); 
			table_3.setModel(modeloSelecTrabajo); 
			scrollPane_3.setViewportView(table_3);
			modeloSelecTrabajo.setColumnIdentifiers(identificadoresTrabajos); 
			
			JButton btnNewButton_3 = new JButton("Quitar");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = table_3.getSelectedRow();
			        if(selectedRow >= 0) {
			            Object[] rowData = new Object[2];
			            for(int i = 0; i < 2; i++) {
			                rowData[i] = modeloSelecTrabajo.getValueAt(selectedRow, i);
			            }
			            
			            modeloNoSelectTrabajo.addRow(rowData);
			            modeloSelecTrabajo.removeRow(selectedRow);
			            
			            if(modeloSelecTrabajo.getRowCount() == 0) {
			                cbxArea.setEnabled(true);
			            }
			            
			            String titulo = rowData[0].toString();
			            for (TrabajoCientifico trabajo : GestionEvento.getInstance().getMisTrabajosCientificos()) {
			                if (trabajo.getNombre().equals(titulo)) {
			                    trabajo.setSeleccionado(false);
			                    break;
			                }
			            }
			        }
				}
			});
			btnNewButton_3.setBounds(218, 203, 89, 23);
			panel_3.add(btnNewButton_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(modeloSelectJurado.getRowCount() > 0 && modeloSelecTrabajo.getRowCount() > 0 && !txtNombre.getText().isEmpty() 
							&& cbxArea.getSelectedIndex() != 0) {
							
							 Comision comision;
					            if(comisionAModificar == null) {
					                
					                comision = new Comision(txtCodigo.getText(), txtNombre.getText(), 
					                                      cbxArea.getSelectedItem().toString());
					                GestionEvento.getInstance().insertarComision(comision);
					            } else {
					                comisionAModificar.setNombre(txtNombre.getText());
					                comisionAModificar.setArea(cbxArea.getSelectedItem().toString());
					                comisionAModificar.getJurado().clear();
					                comisionAModificar.getTrabajos().clear();
					                comision = comisionAModificar;
					            }
					            
					            
					            for (Persona jurado : GestionEvento.getInstance().getMisPersonas()) {
					                if(jurado instanceof Jurado) {
					                    if(((Jurado) jurado).isSeleccionado()) {
					                        comision.getJurado().add((Jurado) jurado);
					                        ((Jurado) jurado).setSeleccionado(false);
					                    }
					                }
					            }
					            
					            for (TrabajoCientifico trabajo : GestionEvento.getInstance().getMisTrabajosCientificos()) {
					                if(trabajo.isSeleccionado()){
					                    comision.getTrabajos().add(trabajo);
					                    trabajo.setSeleccionado(false);
					                }   
					            }
					            
					            JOptionPane.showMessageDialog(null, 
					                comisionAModificar == null ? "Comisión registrada con éxito" : "Comisión modificada con éxito");
					            dispose();
					        } else {
					            if(txtNombre.getText().isEmpty() && cbxArea.getSelectedIndex() == 0) {
					                JOptionPane.showMessageDialog(null, "Debe completar todos los datos generales.");
					            } else if(modeloSelectJurado.getRowCount() == 0) {
					                JOptionPane.showMessageDialog(null, "Debe ingresar al menos un jurado.");
					            } else if(modeloSelecTrabajo.getRowCount() == 0) {
					                JOptionPane.showMessageDialog(null, "Debe ingresar al menos un trabajo científico.");
					            }
					        }
					}
				});
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
		rowJuradoSelect = new Object[table.getColumnCount()];
		for(Persona persona : aux) {
			if(persona instanceof Jurado) {
				rowJuradoSelect[0] = persona.getNombre();
				rowJuradoSelect[1] = persona.getApellidos();
				rowJuradoSelect[2] = ((Jurado) persona).getArea();
				modeloNoSelectJurado.addRow(rowJuradoSelect);
			}
		}
	}
	
	private void loadSelectJurados() { 
		modeloSelectJurado.setRowCount(0);  
		ArrayList<Persona> aux = GestionEvento.getInstance().getMisPersonas(); 
		rowJuradoNoSelect = new Object[3]; 
		for (Persona persona : aux) { 
			if (persona instanceof Jurado && ((Jurado) persona).isSeleccionado()) { 
				rowJuradoNoSelect[0] = persona.getNombre(); 
				rowJuradoNoSelect[1] = persona.getApellidos();
				rowJuradoNoSelect[2] = ((Jurado) persona).getArea(); modeloSelectJurado.addRow(rowJuradoNoSelect); 
			} 
		} 
	}
	
	private void loadNoSelectTrabajos() {
	    modeloNoSelectTrabajo.setRowCount(0);
	    ArrayList<TrabajoCientifico> aux = GestionEvento.getInstance().getMisTrabajosCientificos();
	    rowTrabajoNoSelect = new Object[table_2.getColumnCount()];
	    for (TrabajoCientifico trabajo : aux) {
	    	rowTrabajoNoSelect[0] = trabajo.getNombre();
	    	rowTrabajoNoSelect[1] = trabajo.getArea();
	        modeloNoSelectTrabajo.addRow(rowTrabajoNoSelect);
	    }
	}


	private void loadSelectTrabajos() {
	    modeloSelecTrabajo.setRowCount(0);
	    ArrayList<TrabajoCientifico> aux = GestionEvento.getInstance().getMisTrabajosCientificos();
	    rowTrabajoSelect = new Object[table_3.getColumnCount()];
	    for (TrabajoCientifico trabajo : aux) {
	        if (trabajo.isSeleccionado()) {
	        	rowTrabajoSelect[0] = trabajo.getNombre();
	        	rowTrabajoSelect[1] = trabajo.getArea();
	            modeloSelecTrabajo.addRow(rowTrabajoSelect);
	        }
	    }
	}
	
	
	
}
