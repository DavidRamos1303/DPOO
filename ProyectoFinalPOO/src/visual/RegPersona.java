package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class RegPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPersona dialog = new RegPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPersona() {
		setTitle("Registrar Persona");
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"));
        setIconImage(icon);
		
		setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		setBounds(100, 100, 671, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("InternalFrame.activeTitleGradient"), UIManager.getColor("InternalFrame.activeTitleGradient"), UIManager.getColor("InternalFrame.activeTitleGradient"), UIManager.getColor("InternalFrame.activeTitleGradient")));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos generales:", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("FormattedTextField.foreground")));
				panel_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
				panel_1.setBounds(10, 0, 633, 139);
				panel.add(panel_1);
				panel_1.setLayout(null);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
	}
}
