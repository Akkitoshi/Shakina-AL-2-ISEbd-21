import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelConfig extends JPanel {
    private IBoat boat;

    void setBoat(IBoat transport) {
        boat = transport;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (boat != null) {
            boat.DrawBoat(g);
        }
    }
}