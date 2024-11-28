package visual;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import logico.*;

public class RegTrabajos extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtArea;
    private JPanel panelAutor;
    private JTextField txtIdAutor;
    private JTextField txtCedulaAutor;
    private JTextField txtNombreAutor;
    private JTextField txtApellidosAutor;
    private JTextField txtEmailAutor;
    private JTextField txtTelefonoAutor;
    private GestionEvento gestion;

    public static void main(String[] args) {
        try {
            RegTrabajos dialog = new RegTrabajos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegTrabajos() {
        this(null);
    }

    public RegTrabajos(GestionEvento gestion) {
        this.gestion = gestion != null ? gestion : new GestionEvento();
        setTitle("Registrar Trabajo Científico");
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);
        
        setBounds(100, 100, 685, 500);
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

        // Panel Datos del Trabajo
        JPanel panel_1 = new JPanel();
        panel_1.setForeground(Color.WHITE);
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
                         "Datos del Trabajo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
        panel_1.setBackground(new Color(0, 102, 255));
        panel_1.setBounds(12, 13, 643, 157);
        panel.add(panel_1);
        panel_1.setLayout(null);

        // ID Trabajo
        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblId.setForeground(Color.WHITE);
        lblId.setBounds(12, 32, 26, 16);
        panel_1.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(34, 29, 116, 22);
        panel_1.add(txtId);

        // Nombre Trabajo
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(12, 74, 56, 16);
        panel_1.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(70, 71, 230, 22);
        panel_1.add(txtNombre);

        // Área
        JLabel lblArea = new JLabel("Área:");
        lblArea.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblArea.setForeground(Color.WHITE);
        lblArea.setBounds(12, 116, 56, 16);
        panel_1.add(lblArea);

        txtArea = new JTextField();
        txtArea.setBounds(70, 113, 230, 22);
        panel_1.add(txtArea);

        // Panel Datos del Autor
        panelAutor = new JPanel();
        panelAutor.setForeground(Color.WHITE);
        panelAutor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
                           "Datos del Autor", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
        panelAutor.setBackground(new Color(0, 102, 255));
        panelAutor.setBounds(12, 183, 643, 200);
        panel.add(panelAutor);
        panelAutor.setLayout(null);

        // ID Autor
        JLabel lblIdAutor = new JLabel("ID:");
        lblIdAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblIdAutor.setForeground(Color.WHITE);
        lblIdAutor.setBounds(12, 32, 26, 16);
        panelAutor.add(lblIdAutor);

        txtIdAutor = new JTextField();
        txtIdAutor.setBounds(34, 29, 116, 22);
        panelAutor.add(txtIdAutor);

        // Cédula Autor
        JLabel lblCedulaAutor = new JLabel("Cédula:");
        lblCedulaAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCedulaAutor.setForeground(Color.WHITE);
        lblCedulaAutor.setBounds(290, 32, 70, 16);
        panelAutor.add(lblCedulaAutor);

        txtCedulaAutor = new JTextField();
        txtCedulaAutor.setBounds(360, 29, 200, 22);
        panelAutor.add(txtCedulaAutor);

        // Nombre Autor
        JLabel lblNombreAutor = new JLabel("Nombre:");
        lblNombreAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNombreAutor.setForeground(Color.WHITE);
        lblNombreAutor.setBounds(12, 74, 56, 16);
        panelAutor.add(lblNombreAutor);

        txtNombreAutor = new JTextField();
        txtNombreAutor.setBounds(70, 71, 200, 22);
        panelAutor.add(txtNombreAutor);

        // Apellidos Autor
        JLabel lblApellidosAutor = new JLabel("Apellidos:");
        lblApellidosAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblApellidosAutor.setForeground(Color.WHITE);
        lblApellidosAutor.setBounds(290, 74, 70, 16);
        panelAutor.add(lblApellidosAutor);

        txtApellidosAutor = new JTextField();
        txtApellidosAutor.setBounds(360, 71, 200, 22);
        panelAutor.add(txtApellidosAutor);

        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setBounds(12, 116, 56, 16);
        panelAutor.add(lblEmail);

        txtEmailAutor = new JTextField();
        txtEmailAutor.setBounds(70, 113, 200, 22);
        panelAutor.add(txtEmailAutor);

        // Teléfono
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTelefono.setForeground(Color.WHITE);
        lblTelefono.setBounds(290, 116, 70, 16);
        panelAutor.add(lblTelefono);

        txtTelefonoAutor = new JTextField();
        txtTelefonoAutor.setBounds(360, 113, 200, 22);
        panelAutor.add(txtTelefonoAutor);

        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(255, 255, 0));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Registrar");
        okButton.addActionListener(e -> registrarTrabajo());
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> dispose());
        buttonPane.add(cancelButton);
    }

    private void registrarTrabajo() {
        // Validar campos del trabajo
        if (txtId.getText().trim().isEmpty() || 
            txtNombre.getText().trim().isEmpty() || 
            txtArea.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, 
                "Por favor, complete todos los campos del trabajo",
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar campos del autor
        if (txtIdAutor.getText().trim().isEmpty() ||
            txtCedulaAutor.getText().trim().isEmpty() || 
            txtNombreAutor.getText().trim().isEmpty() || 
            txtApellidosAutor.getText().trim().isEmpty() || 
            txtEmailAutor.getText().trim().isEmpty() || 
            txtTelefonoAutor.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, 
                "Por favor, complete todos los campos del autor",
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el participante
        Participante autor = new Participante(
            txtCedulaAutor.getText().trim(),
            txtNombreAutor.getText().trim(),
            txtApellidosAutor.getText().trim(),
            txtEmailAutor.getText().trim(),
            txtTelefonoAutor.getText().trim()
        );
        autor.setId(txtIdAutor.getText().trim());

        // Crear el trabajo científico
        TrabajoCientifico nuevoTrabajo = new TrabajoCientifico(
            txtId.getText().trim(),
            txtNombre.getText().trim(),
            txtArea.getText().trim(),
            autor
        );

        // Agregar el autor a la lista de personas si no existe
        boolean autorExiste = false;
        for (Persona p : gestion.getMisPersonas()) {
            if (p.getCedula().equals(autor.getCedula())) {
                autorExiste = true;
                break;
            }
        }
        if (!autorExiste) {
            gestion.getMisPersonas().add(autor);
        }

        // Agregar el trabajo
        gestion.getMisTrabajosCientificos().add(nuevoTrabajo);

        JOptionPane.showMessageDialog(this,
            "Trabajo científico registrado exitosamente",
            "Registro",
            JOptionPane.INFORMATION_MESSAGE);
        
        dispose();
    }
}