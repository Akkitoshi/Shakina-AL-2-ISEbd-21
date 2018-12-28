package javalabs;
import java.awt.*;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormPort {

	private JFrame frame;
	private JPanel panel;
	private JTextField maskedTextBox1;
	Port<IBoat> port;
	private PanelBoat pictureBoxTakeOcean;
	private PanelPort panelPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPort window = new FormPort();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormPort() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panelPort = new PanelPort();
		panelPort.setBounds(10, 11, 768, 432);
		frame.getContentPane().add(panelPort);
		port = panelPort.getPort();
		JPanel pictureBoxHangar = new JPanel();
		pictureBoxHangar.setBounds(0, 0, 778, 466);
		frame.getContentPane().add(pictureBoxHangar);

		JButton buttonSetOcean = new JButton("Boat");
		buttonSetOcean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color mainColor = JColorChooser.showDialog(null,
						"Choose a color", Color.GRAY);
				Boat ocean = new Boat(100, 1000, mainColor);
				int place = port.Plus(ocean);
				PanelBoat.initialization = true;
				panelPort.repaint();
			}
		});
		buttonSetOcean.setBounds(788, 11, 110, 20);
		frame.getContentPane().add(buttonSetOcean);

		JButton buttonSetOcean2 = new JButton("Catamaran");
		buttonSetOcean2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(null,
						"Choose a color", Color.GRAY);
				Color dopColor = JColorChooser.showDialog(null,
						"Choose a color", Color.GRAY);
				Catamaran ocean = new Catamaran(100, 1000, mainColor,
						dopColor);
				int place = port.Plus(ocean);
				PanelBoat.initialization = true;
				panelPort.repaint();
			}
		});
		buttonSetOcean2.setBounds(788, 42, 110, 20);
		frame.getContentPane().add(buttonSetOcean2);

		JPanel panel = new JPanel();
		panel.setBounds(779, 226, 250, 230);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		pictureBoxTakeOcean = new PanelBoat();
		pictureBoxTakeOcean.setBounds(12, 102, 250, 180);
		panel.add(pictureBoxTakeOcean);

		JLabel label = new JLabel("Take Boat");
		label.setBounds(12, 0, 110, 20);
		panel.add(label);

		maskedTextBox1 = new JTextField();
		maskedTextBox1.setBounds(68, 29, 70, 22);
		panel.add(maskedTextBox1);
		maskedTextBox1.setColumns(10);

		JLabel label_1 = new JLabel("Place:");
		label_1.setBounds(12, 32, 56, 16);
		panel.add(label_1);

		JButton buttonTakeOcean = new JButton("Take");
		buttonTakeOcean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!maskedTextBox1.getText().equals("")) {
					IBoat ocean = port.Minus(Integer
							.parseInt(maskedTextBox1.getText()));
					if (ocean != null) {
						ocean.SetPosition(35, 30, pictureBoxTakeOcean.getWidth(),
								pictureBoxTakeOcean.getHeight());
						pictureBoxTakeOcean.setOcean(ocean);
						pictureBoxTakeOcean.repaint();
						panelPort.repaint();
					} else {
						pictureBoxTakeOcean.setOcean(null);
						pictureBoxTakeOcean.repaint();
					}
				}
			}
		});
		buttonTakeOcean.setBounds(22, 64, 110, 20);
		panel.add(buttonTakeOcean);
	}
}