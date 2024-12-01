package visual;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import logico.*;

public class ListTrabajosCientifico extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel model;

    public static void main(String[] args) {
        try {
            ListTrabajosCientifico dialog = new ListTrabajosCientifico();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListTrabajosCientifico() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);
        setTitle("Listar Trabajos Científicos");
        setBounds(100, 100, 800, 500);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("InternalFrame.activeTitleGradient"), UIManager.getColor("InternalFrame.activeTitleGradient"), UIManager.getColor("InternalFrame.activeTitleGradient"), UIManager.getColor("InternalFrame.activeTitleGradient")));
        contentPanel.add(panel);
        panel.setLayout(null);

        JPanel panelTable = new JPanel();
        panelTable.setForeground(Color.WHITE);
        panelTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Trabajos Cient\u00EDficos", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("FormattedTextField.foreground")));
        panelTable.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panelTable.setBounds(12, 13, 748, 382);
        panel.add(panelTable);
        panelTable.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelTable.add(scrollPane, BorderLayout.CENTER);

        model = new DefaultTableModel();
        String[] headers = {"ID", "Nombre", "Área", "Autor", "Cédula Autor"};
        model.setColumnIdentifiers(headers);

        table = new JTable();
        table.setModel(model);
        scrollPane.setViewportView(table);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        cancelButton.addActionListener(e -> dispose());
        
        JButton btnNewButton_1 = new JButton("Modificar");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton_1.setEnabled(false);
        buttonPane.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.setEnabled(false);
        buttonPane.add(btnNewButton);
        buttonPane.add(cancelButton);

        loadTrabajos();
    }

    private void loadTrabajos() {
        model.setRowCount(0); 
        for (TrabajoCientifico trabajo : GestionEvento.getInstance().getMisTrabajosCientificos()) {
            Participante autor = trabajo.getAutor();
            Object[] row = {
                trabajo.getId(),
                trabajo.getNombre(),
                trabajo.getArea(),
                autor.getNombre() + " " + autor.getApellidos(),
                autor.getCedula()
            };
            model.addRow(row);
        }
    }
}