package javalabs;


import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPort {
	private JFrame frame;
	private JPanel panel;
	private JList listBoxLevels;
	private DefaultListModel model;
	private JTextField maskedTextBox1;
	MultiLevelParking hangar;
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
		frame.setBounds(100, 100, 1050, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panelPort = new PanelPort();
		panelPort.setBounds(0, 11, 777, 443);
		frame.getContentPane().add(panelPort);
		hangar = panelPort.getPort();
		JPanel pictureBoxHangar = new JPanel();
		pictureBoxHangar.setBounds(0, 0, 778, 466);
		frame.getContentPane().add(pictureBoxHangar);

		JButton buttonSetAir = new JButton("Boat");
		buttonSetAir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color mainColor = JColorChooser.showDialog(null,
						"Choose a color", Color.GRAY);
				Boat ocean = new Boat(100, 1000, mainColor);
				int place = hangar.getHangar(listBoxLevels.getSelectedIndex())
						.Plus(ocean);
				panelPort.repaint();
			}
		});
		buttonSetAir.setBounds(790, 141, 118, 41);
		frame.getContentPane().add(buttonSetAir);

		JButton buttonSetAirBus = new JButton("Catamaran");
		buttonSetAirBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(null,
						"Choose a color", Color.GRAY);
				Color dopColor = JColorChooser.showDialog(null,
						"Choose a color", Color.GRAY);
				Catamaran ocean = new Catamaran(100, 1000, mainColor,
						dopColor);
				int place = hangar.getHangar(listBoxLevels.getSelectedIndex())
						.Plus(ocean);
				panelPort.repaint();
			}
		});
		buttonSetAirBus.setBounds(790, 182, 118, 41);
		frame.getContentPane().add(buttonSetAirBus);

		JPanel panel = new JPanel();
		panel.setBounds(779, 226, 250, 230);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		pictureBoxTakeOcean = new PanelBoat();
		pictureBoxTakeOcean.setBounds(12, 102, 250, 180);
		panel.add(pictureBoxTakeOcean);

		JLabel label = new JLabel("Take Boat");
		label.setBounds(12, 0, 118, 16);
		panel.add(label);

		maskedTextBox1 = new JTextField();
		maskedTextBox1.setBounds(68, 29, 70, 22);
		panel.add(maskedTextBox1);
		maskedTextBox1.setColumns(10);

		JLabel label_1 = new JLabel("Place:");
		label_1.setBounds(12, 32, 56, 16);
		panel.add(label_1);

		JButton buttonTakeAir = new JButton("Take");
		buttonTakeAir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!maskedTextBox1.getText().equals("")) {
					IBoat ocean = hangar.getHangar(
							listBoxLevels.getSelectedIndex()).Minus(
							Integer.parseInt(maskedTextBox1.getText()));
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
		buttonTakeAir.setBounds(22, 64, 97, 25);
		panel.add(buttonTakeAir);

		listBoxLevels = new JList();
		listBoxLevels.setBounds(790, 11, 118, 118);
		frame.getContentPane().add(listBoxLevels);
		model = new DefaultListModel();
		for (int i = 0; i < 6; i++) {
			model.addElement("Level " + (i + 1));
		}
		listBoxLevels.setModel(model);
		listBoxLevels.setSelectedIndex(0);
		panelPort.setListLevels(listBoxLevels);
		listBoxLevels.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				panelPort.repaint();
			}
		});

	}
}