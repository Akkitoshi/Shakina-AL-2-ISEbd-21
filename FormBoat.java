package javalabs;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javalabs.DirectionClass.Direction;

public class FormBoat {
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBoat window = new FormBoat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormBoat() {
		initialize();
	}

	public IBoat boat;
	private JPanel panel;
	private JButton buttonLeft;

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Button button = new Button("Create Boat");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boat = new Boat(60, 10, Color.GRAY);
				panel = new PanelBoat();
				panel.setBounds(100, 100, 1000, 540);
				frame.getContentPane().add(panel);
				boat.SetPosition(100, 100, panel.getWidth(),
						panel.getHeight());
				panel.repaint();

			}
		});
		button.setBounds(23, 10, 99, 24);
		frame.getContentPane().add(button);

		Button button1 = new Button("Create Catamaran");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boat = new Catamaran(60, 10, Color.BLACK, Color.BLUE);
				panel = new PanelBoat();
				panel.setBounds(100, 100, 1000, 540);
				frame.getContentPane().add(panel);
				boat.SetPosition(100, 100, panel.getWidth(),
						panel.getHeight());
				panel.repaint();
			}
		});
		button1.setBounds(23, 50, 129, 24);
		frame.getContentPane().add(button1);

		buttonLeft = new JButton("");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boat.MoveTransport(Direction.Left);
				panel.repaint();
			}
		});
		buttonLeft.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonLeft.setIconTextGap(2);

		buttonLeft
				.setIcon(new ImageIcon(
						"C:\\Users\\Lenovo\\Downloads\\buttondown.NqwnK.jpg"));
		buttonLeft.setBounds(1013, 691, 40, 40);
		frame.getContentPane().add(buttonLeft);

		JButton buttonDown = new JButton("");
		buttonDown
				.setSelectedIcon(new ImageIcon(
						"C:\\Users\\Lenovo\\Downloads\\buttondown.NqwnK.jpg"));
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boat.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
		buttonDown
				.setIcon(new ImageIcon(
						"C:\\Users\\Lenovo\\Downloads\\buttondown.NqwnK.jpg"));
		buttonDown.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonDown.setIconTextGap(2);
		buttonDown.setBounds(1063, 691, 40, 40);
		frame.getContentPane().add(buttonDown);

		JButton buttonUp = new JButton("");
		buttonUp.setSelectedIcon(new ImageIcon(
				"C:\\Users\\Lenovo\\Downloads\\buttonup.OnSpI.jpg"));
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boat.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		buttonUp.setIcon(new ImageIcon(
				"C:\\Users\\Lenovo\\Downloads\\buttonup.OnSpI.jpg"));
		buttonUp.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonUp.setIconTextGap(2);
		buttonUp.setBounds(1063, 644, 40, 40);
		frame.getContentPane().add(buttonUp);

		JButton buttonRight = new JButton("");
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boat.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
		buttonRight
				.setIcon(new ImageIcon(
						"C:\\Users\\Lenovo\\Downloads\\buttonright.fNVEH.jpg"));
		buttonRight.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonRight.setIconTextGap(2);
		buttonRight.setBounds(1113, 691, 40, 40);
		frame.getContentPane().add(buttonRight);

	}
}
