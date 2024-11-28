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
        setTitle("Registrar Trabajo Científico");
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);
        
        setBounds(100, 100, 685, 500);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("InternalFrame.activeTitleGradient"), 
            UIManager.getColor("InternalFrame.activeTitleGradient"), 
            UIManager.getColor("InternalFrame.activeTitleGradient"), 
            UIManager.getColor("InternalFrame.activeTitleGradient")));
        contentPanel.add(panel);
        panel.setLayout(null);

        // Panel Datos del Trabajo
        JPanel panel_1 = new JPanel();
        panel_1.setForeground(Color.WHITE);
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
            "Datos del Trabajo", TitledBorder.LEADING, TitledBorder.TOP, null, 
            UIManager.getColor("FormattedTextField.foreground")));
        panel_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panel_1.setBounds(12, 13, 643, 157);
        panel.add(panel_1);
        panel_1.setLayout(null);

        // ID Trabajo
        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblId.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblId.setBounds(12, 32, 26, 16);
        panel_1.add(lblId);

        txtId = new JTextField();
        txtId.setEditable(false);
        txtId.setText("T-"+GestionEvento.getInstance().codTrabajos);
        txtId.setBounds(34, 29, 116, 22);
        panel_1.add(txtId);

        // Nombre Trabajo
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNombre.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblNombre.setBounds(12, 74, 56, 16);
        panel_1.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(70, 71, 230, 22);
        panel_1.add(txtNombre);

        // Área
        JLabel lblArea = new JLabel("Área:");
        lblArea.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblArea.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblArea.setBounds(12, 116, 56, 16);
        panel_1.add(lblArea);

        txtArea = new JTextField();
        txtArea.setBounds(70, 113, 230, 22);
        panel_1.add(txtArea);

        // Panel Datos del Autor
        panelAutor = new JPanel();
        panelAutor.setForeground(Color.WHITE);
        panelAutor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
            "Datos del Autor", TitledBorder.LEADING, TitledBorder.TOP, null, 
            UIManager.getColor("FormattedTextField.foreground")));
        panelAutor.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panelAutor.setBounds(12, 183, 643, 200);
        panel.add(panelAutor);
        panelAutor.setLayout(null);

        // ID Autor
        JLabel lblIdAutor = new JLabel("ID:");
        lblIdAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblIdAutor.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblIdAutor.setBounds(12, 32, 26, 16);
        panelAutor.add(lblIdAutor);

        txtIdAutor = new JTextField();
        txtIdAutor.setBounds(34, 29, 116, 22);
        panelAutor.add(txtIdAutor);

        // Cédula Autor
        JLabel lblCedulaAutor = new JLabel("Cédula:");
        lblCedulaAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCedulaAutor.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblCedulaAutor.setBounds(290, 32, 70, 16);
        panelAutor.add(lblCedulaAutor);

        txtCedulaAutor = new JTextField();
        txtCedulaAutor.setBounds(360, 29, 200, 22);
        panelAutor.add(txtCedulaAutor);

        // Nombre Autor
        JLabel lblNombreAutor = new JLabel("Nombre:");
        lblNombreAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNombreAutor.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblNombreAutor.setBounds(12, 74, 56, 16);
        panelAutor.add(lblNombreAutor);

        txtNombreAutor = new JTextField();
        txtNombreAutor.setBounds(70, 71, 200, 22);
        panelAutor.add(txtNombreAutor);

        // Apellidos Autor
        JLabel lblApellidosAutor = new JLabel("Apellidos:");
        lblApellidosAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblApellidosAutor.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblApellidosAutor.setBounds(290, 74, 70, 16);
        panelAutor.add(lblApellidosAutor);

        txtApellidosAutor = new JTextField();
        txtApellidosAutor.setBounds(360, 71, 200, 22);
        panelAutor.add(txtApellidosAutor);

        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEmail.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblEmail.setBounds(12, 116, 56, 16);
        panelAutor.add(lblEmail);

        txtEmailAutor = new JTextField();
        txtEmailAutor.setBounds(70, 113, 200, 22);
        panelAutor.add(txtEmailAutor);

        // Teléfono
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTelefono.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblTelefono.setBounds(290, 116, 70, 16);
        panelAutor.add(lblTelefono);

        txtTelefonoAutor = new JTextField();
        txtTelefonoAutor.setBounds(360, 113, 200, 22);
        panelAutor.add(txtTelefonoAutor);

        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Registrar");
        okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        okButton.addActionListener(e -> registrarTrabajo());
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        cancelButton.addActionListener(e -> dispose());
        buttonPane.add(cancelButton);
    }

    private void clean() {
        GestionEvento.getInstance().codTrabajos++;
        txtId.setText("T-" + GestionEvento.getInstance().codTrabajos);
        txtNombre.setText("");
        txtArea.setText("");
        txtIdAutor.setText("");
        txtCedulaAutor.setText("");
        txtNombreAutor.setText("");
        txtApellidosAutor.setText("");
        txtEmailAutor.setText("");
        txtTelefonoAutor.setText("");
    }

    private void registrarTrabajo() {
        // Validar campos del trabajo
        if (txtNombre.getText().trim().isEmpty() || 
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

        // Crear el trabajo científico
        TrabajoCientifico nuevoTrabajo = new TrabajoCientifico(
            txtId.getText().trim(),
            txtNombre.getText().trim(),
            txtArea.getText().trim(),
            autor
        );

        // Agregar el autor a la lista de personas si no existe
        boolean autorExiste = false;
        for (Persona p : GestionEvento.getInstance().getMisPersonas()) {
            if (p.getCedula().equals(autor.getCedula())) {
                autorExiste = true;
                break;
            }
        }
        if (!autorExiste) {
            GestionEvento.getInstance().getMisPersonas().add(autor);
        }

        // Agregar el trabajo
        GestionEvento.getInstance().getMisTrabajosCientificos().add(nuevoTrabajo);

        JOptionPane.showMessageDialog(this,
            "Trabajo científico registrado exitosamente",
            "Registro",
            JOptionPane.INFORMATION_MESSAGE);
        
        clean();
    }
}