package visual;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import logico.*;

public class ListTrabajosCientificos extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel model;
    private GestionEvento gestion;

    public static void main(String[] args) {
        try {
            ListTrabajosCientificos dialog = new ListTrabajosCientificos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListTrabajosCientificos() {
        this(null);
    }

    public ListTrabajosCientificos(GestionEvento gestion) {
        this.gestion = gestion != null ? gestion : new GestionEvento();
        setTitle("Listar Trabajos Científicos");
        setBounds(100, 100, 800, 500);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 102, 255));
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 255, 0), 
                       new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0)));
        contentPanel.add(panel);
        panel.setLayout(null);

        JPanel panelTable = new JPanel();
        panelTable.setForeground(Color.WHITE);
        panelTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
                           "Trabajos Científicos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
        panelTable.setBackground(new Color(0, 102, 255));
        panelTable.setBounds(12, 0, 750, 408);
        panel.add(panelTable);
        panelTable.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panelTable.add(scrollPane, BorderLayout.CENTER);

        model = new DefaultTableModel();
        String[] headers = {"ID", "Nombre", "Área", "Autor", "Email Autor"};
        model.setColumnIdentifiers(headers);

        table = new JTable();
        table.setModel(model);
        scrollPane.setViewportView(table);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(255, 255, 0));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> dispose());
        buttonPane.add(cancelButton);

        loadTrabajos();
    }

    private void loadTrabajos() {
        model.setRowCount(0); // Limpiar la tabla
        
        for (TrabajoCientifico trabajo : gestion.getMisTrabajosCientificos()) {
            Participante autor = trabajo.getAutor();
            Object[] row = {
                trabajo.getId(),
                trabajo.getNombre(),
                trabajo.getArea(),
                autor.getNombre() + " " + autor.getApellidos(),
                autor.getEmail()
            };
            model.addRow(row);
        }
    }
}