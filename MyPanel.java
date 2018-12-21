package javalab;

import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	Catamaran catamaran;

	public MyPanel(Catamaran ocean) {
		catamaran = ocean;
	}

	public void paint(Graphics g) {
		super.paint(g);
		catamaran.DrawCatamaran(g);
	}
}