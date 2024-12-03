package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import logico.Evento;
import logico.GestionEvento;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class PrincipalGestion extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGestion frame = new PrincipalGestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalGestion() {

		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);
		
		setBackground(new Color(255, 255, 0));
		setTitle("Gesti\u00F3n de Eventos PUCMM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dim = getToolkit().getScreenSize();
		setBounds(100, 100, 450, 300);
		setSize(dim.width, dim.height-35);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registrar");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Persona");
		mntmNewMenuItem.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/persona2 (1).png")));
		
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegPersona dialog = new RegPersona();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Trabajo Cient\u00EDfico");
		mntmNewMenuItem_1.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/trabajo2 (1).png")));
		mntmNewMenuItem_1.addActionListener(e ->{
			RegTrabajo dialog = new RegTrabajo();
			dialog.setModal(true);
			dialog.setVisible(true);
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Comisi\u00F3n");
		mntmNewMenuItem_2.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/comision (1).png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegComision regcomision = new RegComision();
				regcomision.setModal(true);
				regcomision.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Recurso");
		mntmNewMenuItem_3.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/recurso (1).png")));
		mntmNewMenuItem_3.addActionListener(e -> {
            RegRecurso dialog = new RegRecurso();
            dialog.setModal(true);
            dialog.setVisible(true);
        });
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Listar");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Personas");
		mntmNewMenuItem_5.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/listarPersona (1).png")));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPersona dialog = new ListPersona();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Recursos");
		mntmNewMenuItem_6.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/recurso (1).png")));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListRecursos listarRecursos = new ListRecursos();
				listarRecursos.setModal(true);
				listarRecursos.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Trabajos Cient\u00EDficos");
		mntmNewMenuItem_7.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/trabajo2 (1).png")));
		mntmNewMenuItem_7.addActionListener(e -> {
			ListTrabajosCientifico dialog = new ListTrabajosCientifico();
            dialog.setLocationRelativeTo(this);
            dialog.setModal(true);
            dialog.setVisible(true);
        });
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Eventos");
		mntmNewMenuItem_8.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/evento (1).png")));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fechaActual = new Date();
		        for (Evento obj : GestionEvento.getInstance().getMisEventos()) {
					if(obj.getFecha().before(fechaActual)) {
						obj.setEstado(false);
					}
				}
				ListEvento dialog = new ListEvento();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Comisiones");
		mntmNewMenuItem_9.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/comision (1).png")));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListComision listcomision = new ListComision();
				listcomision.setModal(true);
				listcomision.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_1 = new JMenu("Evento");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Planificar evento");
		mntmNewMenuItem_4.setIcon(new ImageIcon(PrincipalGestion.class.getResource("/visual/evento (1).png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlanificarEvento dialog = new PlanificarEvento();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.inactiveForeground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}
}
