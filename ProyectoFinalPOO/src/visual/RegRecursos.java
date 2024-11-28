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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegRecursos extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField txt_Id;
    private JTextField txt_Nombre;
    private GestionEvento gestion;
    private JTextField txt_tipo;
    private JPanel panel_otro;
    private JPanel panel_campus;
    private JRadioButton rdLocal;
    private JRadioButton rdOtro;
    private JComboBox cmbCampus;

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
        setBounds(100, 100, 630, 380);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("InternalFrame.activeTitleGradient"), 
            UIManager.getColor("InternalFrame.activeTitleGradient"), UIManager.getColor("InternalFrame.activeTitleGradient"), 
            UIManager.getColor("InternalFrame.activeTitleGradient")));
        contentPanel.add(panel);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setForeground(new Color(255, 255, 255));
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Generales", 
            TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("FormattedTextField.foreground")));
        panel_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panel_1.setBounds(12, 13, 574, 117);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblNewLabel.setBounds(27, 32, 26, 16);
        panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setForeground(UIManager.getColor("FormattedTextField.foreground"));
        lblNewLabel_1.setBounds(27, 74, 56, 16);
        panel_1.add(lblNewLabel_1);
        
        txt_Id = new JTextField();
        txt_Id.setEditable(false);
        txt_Id.setText("R-"+GestionEvento.getInstance().codRecursos);
        txt_Id.setBounds(112, 29, 56, 22);
        panel_1.add(txt_Id);
        txt_Id.setColumns(10);
        
        txt_Nombre = new JTextField();
        txt_Nombre.setBounds(112, 71, 230, 22);
        panel_1.add(txt_Nombre);
        txt_Nombre.setColumns(10);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panel_2.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(12, 136, 574, 68);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        rdLocal = new JRadioButton("Recurso local");
        rdLocal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdLocal.setSelected(true);
                rdOtro.setSelected(false);
                panel_campus.setVisible(true);
                panel_otro.setVisible(false);
            }
        });
        rdLocal.setSelected(true);
        rdLocal.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        rdLocal.setBounds(82, 22, 127, 25);
        panel_2.add(rdLocal);
        
        rdOtro = new JRadioButton("Otro");
        rdOtro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdLocal.setSelected(false);
                rdOtro.setSelected(true);
                panel_campus.setVisible(false);
                panel_otro.setVisible(true);
            }
        });
        rdOtro.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        rdOtro.setBounds(340, 22, 127, 25);
        panel_2.add(rdOtro);
        
        panel_campus = new JPanel();
        panel_campus.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_campus.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panel_campus.setBounds(12, 217, 574, 68);
        panel.add(panel_campus);
        panel_campus.setLayout(null);
        
        cmbCampus = new JComboBox();
        cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"", "Campus Santiago", "Campus Santo Domingo"}));
        cmbCampus.setBounds(27, 20, 164, 22);
        panel_campus.add(cmbCampus);
        
        panel_otro = new JPanel();
        panel_otro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_otro.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
        panel_otro.setBounds(12, 217, 574, 68);
        panel.add(panel_otro);
        panel_otro.setLayout(null);
        panel_otro.setVisible(false);
        
        JLabel lblNewLabel_2 = new JLabel("Tipo:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2.setBounds(12, 20, 56, 16);
        panel_otro.add(lblNewLabel_2);
        
        txt_tipo = new JTextField();
        txt_tipo.setBounds(64, 20, 152, 22);
        panel_otro.add(txt_tipo);
        txt_tipo.setColumns(10);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Registrar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!(txt_Nombre.getText().equals(""))) {
                    if(rdLocal.isSelected()) {
                        if(cmbCampus.getSelectedIndex() > 0) {
                            RecursoLocal local = new RecursoLocal(txt_Id.getText().toString(),
                                    txt_Nombre.getText().toString(),
                                    "Local",
                                    cmbCampus.getSelectedItem().toString()); 
                            GestionEvento.getInstance().insertarRecurso(local);
                            JOptionPane.showMessageDialog(null, "Recurso registrado exitosamente", 
                                    "Registro", JOptionPane.INFORMATION_MESSAGE);
                            clean();
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe seleccionar un campus", 
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if(!(txt_tipo.getText().equals(""))) {
                            Recurso otro = new Recurso(txt_Id.getText().toString(),
                                    txt_Nombre.getText().toString(), 
                                    txt_tipo.getText().toString());
                            GestionEvento.getInstance().insertarRecurso(otro);
                            JOptionPane.showMessageDialog(null, "Recurso registrado exitosamente", 
                                    "Registro", JOptionPane.INFORMATION_MESSAGE);
                            clean();
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe especificar el tipo de recurso", 
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe completar todos los campos", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCancelar.setActionCommand("OK");
        buttonPane.add(btnCancelar);
    }

    private void clean() {
        GestionEvento.getInstance().codRecursos++;
        txt_Id.setText("R-" + GestionEvento.getInstance().codRecursos);
        txt_Nombre.setText("");
        txt_tipo.setText("");
        rdLocal.setSelected(true);
        rdOtro.setSelected(false);
        panel_campus.setVisible(true);
        panel_otro.setVisible(false);
        cmbCampus.setSelectedIndex(0);
    }
}