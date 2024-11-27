package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import logico.*;

public class RegRecursos extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtTipoLocal;  // Para recursos locales
    private JTextField txtTipo;       // Para recursos normales
    private JRadioButton rdbtnDisponible;
    private JCheckBox chkLocal;       // Cambiado a CheckBox para mejor visibilidad
    private GestionEvento gestion;

    public RegRecursos(GestionEvento gestion) {
        this.gestion = gestion;
        setFont(new Font("Dialog", Font.BOLD, 12));
        setTitle("Registrar Recursos");
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);
        
        setBounds(100, 100, 685, 500);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new BorderLayout(0, 0));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 102, 255));
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 255, 0), 
                       new Color(255, 255, 0), new Color(255, 255, 0), new Color(255, 255, 0)));
        contentPanel.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setForeground(new Color(255, 255, 255));
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
                         "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, 
                         new Color(255, 255, 255)));
        panel_1.setBackground(new Color(0, 102, 255));
        panel_1.setBounds(12, 0, 643, 157);
        panel.add(panel_1);
        panel_1.setLayout(null);

        // Labels y campos
        // ID
        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblId.setForeground(Color.WHITE);
        lblId.setBounds(12, 32, 26, 16);
        panel_1.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(34, 29, 116, 22);
        panel_1.add(txtId);

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(12, 74, 56, 16);
        panel_1.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(70, 71, 230, 22);
        panel_1.add(txtNombre);

        // Tipo
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTipo.setForeground(Color.WHITE);
        lblTipo.setBounds(12, 116, 56, 16);
        panel_1.add(lblTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(46, 113, 116, 22);
        panel_1.add(txtTipo);

        // Tipo Local (inicialmente invisible)
        txtTipoLocal = new JTextField();
        txtTipoLocal.setBounds(46, 113, 200, 22);
        txtTipoLocal.setVisible(false);
        panel_1.add(txtTipoLocal);

        // Checkbox para Recurso Local
        chkLocal = new JCheckBox("Recurso Local");
        chkLocal.setFont(new Font("Tahoma", Font.BOLD, 13));
        chkLocal.setForeground(Color.WHITE);
        chkLocal.setBackground(new Color(0, 102, 255));
        chkLocal.setBounds(330, 70, 120, 20);
        chkLocal.addActionListener(e -> toggleTipoFields());
        panel_1.add(chkLocal);

        // Disponibilidad
        JLabel lblDisponibilidad = new JLabel("Disponibilidad");
        lblDisponibilidad.setForeground(Color.WHITE);
        lblDisponibilidad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDisponibilidad.setBounds(330, 32, 99, 16);
        panel_1.add(lblDisponibilidad);

        rdbtnDisponible = new JRadioButton("");
        rdbtnDisponible.setSelected(true);
        rdbtnDisponible.setBounds(435, 32, 20, 20);
        rdbtnDisponible.setBackground(new Color(0, 102, 255));
        panel_1.add(rdbtnDisponible);

        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(255, 255, 0));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> registrarRecurso());
        buttonPane.add(btnRegistrar);
        getRootPane().setDefaultButton(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        buttonPane.add(btnCancelar);
    }

    private void toggleTipoFields() {
        boolean isLocal = chkLocal.isSelected();
        txtTipo.setVisible(!isLocal);
        txtTipoLocal.setVisible(isLocal);
    }

    private void registrarRecurso() {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String tipo = chkLocal.isSelected() ? txtTipoLocal.getText().trim() : txtTipo.getText().trim();

        if (id.isEmpty() || nombre.isEmpty() || tipo.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, complete todos los campos obligatorios",
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        Recurso nuevoRecurso;
        if (chkLocal.isSelected()) {
            nuevoRecurso = new RecursoLocal(
                id,
                nombre,
                tipo,
                rdbtnDisponible.isSelected(),
                ""  // Ciudad (manteniendo el constructor original)
            );
        } else {
            nuevoRecurso = new Recurso(
                id,
                nombre,
                tipo,
                rdbtnDisponible.isSelected()
            );
        }

        gestion.getMisRecursos().add(nuevoRecurso);
        JOptionPane.showMessageDialog(this,
            "Recurso registrado exitosamente",
            "Registro",
            JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}