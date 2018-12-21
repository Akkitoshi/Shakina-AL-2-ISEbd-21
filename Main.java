package javalab;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javalab.DirectionClass.Direction;
import java.awt.SystemColor;

public class Main {
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	Catamaran catamaran;
	private JPanel panel;
	private JButton buttonLeft;

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.BLUE);
		frame.setBounds(100, 100, 1196, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Button button = new Button("\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
		button.setForeground(new Color(0, 0, 153));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catamaran = new Catamaran(60, 10, Color.GRAY, Color.BLACK);
				panel = new MyPanel(catamaran);
				panel.setBounds(80, 80, 1000, 450);
				frame.getContentPane().add(panel);
				panel.setBackground(SystemColor.BLUE);
				catamaran.SetPosition(100, 100, panel.getWidth(),
						panel.getHeight());
				panel.repaint();

			}
		});
		button.setBounds(23, 10, 79, 24);
		frame.getContentPane().add(button);

		buttonLeft = new JButton("");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catamaran.MoveTransport(Direction.Left);
				panel.repaint();
			}
		});
		buttonLeft.setIconTextGap(2);

		buttonLeft.setIcon(new ImageIcon(
				"C:\\Users\\Lenovo\\Downloads\\buttonleft.NbWOT.jpg"));
		buttonLeft.setBounds(995, 599, 37, 40);
		frame.getContentPane().add(buttonLeft);

		JButton buttonDown = new JButton("");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catamaran.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
		buttonDown.setIcon(new ImageIcon(
				"C:\\Users\\Lenovo\\Downloads\\buttondown.NqwnK.jpg"));
		buttonDown.setIconTextGap(2);
		buttonDown.setBounds(1042, 599, 40, 40);
		frame.getContentPane().add(buttonDown);

		JButton buttonUp = new JButton("");
		buttonUp.setSelectedIcon(new ImageIcon(
				"C:\\Users\\Lenovo\\Downloads\\buttonup.OnSpI.jpg"));
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catamaran.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		buttonUp.setIcon(new ImageIcon(
				"C:\\Users\\Lenovo\\Downloads\\buttonup.OnSpI.jpg"));
		buttonUp.setIconTextGap(2);
		buttonUp.setBounds(1042, 550, 40, 40);
		frame.getContentPane().add(buttonUp);

		JButton buttonRight = new JButton("");
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catamaran.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
		buttonRight.setIcon(new ImageIcon(
				"C:\\Users\\Lenovo\\Downloads\\buttonright.fNVEH.jpg"));
		buttonRight.setIconTextGap(2);
		buttonRight.setBounds(1092, 599, 40, 40);
		frame.getContentPane().add(buttonRight);

	}
}