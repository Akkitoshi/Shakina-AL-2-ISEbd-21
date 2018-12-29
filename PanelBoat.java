package javalabs;
import java.awt.Graphics;

import javax.swing.JPanel;
public class PanelBoat extends JPanel {
	public static IBoat boat;
	public static boolean initialization = false;

	void setOcean(IBoat transport){
		boat = transport;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(boat != null) {
			boat.DrawBoat(g);
		}
	}
}