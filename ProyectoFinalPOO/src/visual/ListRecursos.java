package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Comision;
import logico.GestionEvento;
import logico.Recurso;
import logico.RecursoLocal;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListRecursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelo;
	private Object row[];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListRecursos dialog = new ListRecursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListRecursos() {
		setTitle("Lista de recursos");
		setBounds(100, 100, 575, 466);
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
			panel_1.setBorder(new TitledBorder(null, "Recursos registrados", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("InternalFrame.activeTitleForeground")));
			panel_1.setBounds(10, 11, 529, 362);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			modelo = new DefaultTableModel();
			String[] identificadores = {"Código", "Nombre", "Tipo", "Campus"};
			modelo.setColumnIdentifiers(identificadores);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Modificar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selectedRow = table.getSelectedRow();
				        if(selectedRow >= 0) {
				            String codigo = (String)modelo.getValueAt(selectedRow, 0);
				            Recurso recursoSeleccionado = buscarRecurso(codigo);
				            if(recursoSeleccionado != null) {
				                RegRecursos regRecursos = new RegRecursos(recursoSeleccionado);
				                regRecursos.setModal(true);
				                regRecursos.setVisible(true);
				                loadRecursos();
				            }
				        } else {
				            JOptionPane.showMessageDialog(null, 
				                "Debe seleccionar un recurso para modificar.",
				                "Error", JOptionPane.ERROR_MESSAGE);
				        }
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnNewButton = new JButton("Eliminar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selectedRow = table.getSelectedRow();
				        if(selectedRow >= 0) {
				            int option = JOptionPane.showConfirmDialog(null,
				                "¿Está seguro que desea eliminar este recurso?",
				                "Confirmación", JOptionPane.YES_NO_OPTION);
				            
				            if(option == JOptionPane.YES_OPTION) {
				                String codigo = (String) modelo.getValueAt(selectedRow, 0);
				                eliminarRecurso(codigo);
				                loadRecursos();
				            }
				        } else {
				            JOptionPane.showMessageDialog(null, 
				                "Debe seleccionar un recurso para eliminar.",
				                "Error", JOptionPane.ERROR_MESSAGE);
				        }
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}loadRecursos();
		
		
	}
	private void loadRecursos() {
	    modelo.setRowCount(0);
	    row = new Object[table.getColumnCount()];
	    for (Recurso recurso : GestionEvento.getInstance().getMisRecursos()) {
	        row[0] = recurso.getId();
	        row[1] = recurso.getNombre();
	        row[2] = recurso.getTipo();
	        if(recurso instanceof RecursoLocal) {
	            row[3] = ((RecursoLocal) recurso).getCiudad();
	        } else {
	            row[3] = "N/A";
	        }
	        modelo.addRow(row);
	    }
	}
	
	private Recurso buscarRecurso(String codigo) {
	    for(Recurso recurso : GestionEvento.getInstance().getMisRecursos()) {
	        if(recurso.getId().equals(codigo)) {
	            return recurso;
	        }
	    }
	    return null;
	}
	
	private void eliminarRecurso(String codigo) {
	    Recurso recursoAEliminar = buscarRecurso(codigo);
	    if(recursoAEliminar != null) {
	        GestionEvento.getInstance().getMisRecursos().remove(recursoAEliminar);
	        JOptionPane.showMessageDialog(null, 
	            "Recurso eliminado exitosamente.",
	            "Información", JOptionPane.INFORMATION_MESSAGE);
	    }
	}

}
