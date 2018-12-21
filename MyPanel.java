package javalabs;

import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	IBoat boat;

	public MyPanel(IBoat ocean) {
		boat = ocean;
	}

	public void paint(Graphics g) {
		super.paint(g);
		boat.DrawBoat(g);
	}
}