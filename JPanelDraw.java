import javax.swing.*;
import java.awt.*;

public class JPanelDraw extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IBoat boat;

	public void setTransport(IBoat transport) {
		this.boat = transport;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (boat != null) {
			boat.DrawBoat(g);
		}
	}
}