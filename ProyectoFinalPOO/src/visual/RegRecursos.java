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
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JRadioButton rdbtnDisponible;
    private JRadioButton rdbtnLocal;
    private GestionEvento gestion;

    public static void main(String[] args) {
        try {
            RegRecursos dialog = new RegRecursos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegRecursos() {
        this(null);
    }

    public RegRecursos(GestionEvento gestion) {
        this.gestion = gestion != null ? gestion : new GestionEvento();
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);
        
        setFont(new Font("Dialog", Font.BOLD, 12));
        setTitle("Registrar Recursos");
        setBounds(100, 100, 685, 500);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

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
        
        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(12, 32, 26, 16);
        panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(12, 74, 56, 16);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Tipo:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(12, 116, 56, 16);
        panel_1.add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setBounds(34, 29, 116, 22);
        panel_1.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(70, 71, 230, 22);
        panel_1.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(46, 113, 116, 22);
        panel_1.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Disponibilidad");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3.setBounds(330, 32, 99, 16);
        panel_1.add(lblNewLabel_3);

        rdbtnDisponible = new JRadioButton("");
        rdbtnDisponible.setSelected(true);
        rdbtnDisponible.setBounds(435, 32, 20, 20);
        rdbtnDisponible.setBackground(new Color(0, 102, 255));
        panel_1.add(rdbtnDisponible);

        rdbtnLocal = new JRadioButton("Recurso Local");
        rdbtnLocal.setFont(new Font("Tahoma", Font.BOLD, 13));
        rdbtnLocal.setForeground(Color.WHITE);
        rdbtnLocal.setBackground(new Color(0, 102, 255));
        rdbtnLocal.setBounds(330, 70, 120, 20);
        panel_1.add(rdbtnLocal);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(255, 255, 0));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton okButton = new JButton("Registrar");
        okButton.addActionListener(e -> registrarRecurso());
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
        
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> dispose());
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }
    
    private void registrarRecurso() {
        if (textField.getText().trim().isEmpty() || 
            textField_1.getText().trim().isEmpty() || 
            textField_2.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, 
                "Por favor, complete todos los campos obligatorios",
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        Recurso nuevoRecurso;
        if (rdbtnLocal.isSelected()) {
            nuevoRecurso = new RecursoLocal(
                textField.getText().trim(),
                textField_1.getText().trim(),
                textField_2.getText().trim(),
                rdbtnDisponible.isSelected(),
                ""
            );
        } else {
            nuevoRecurso = new Recurso(
                textField.getText().trim(),
                textField_1.getText().trim(),
                textField_2.getText().trim(),
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