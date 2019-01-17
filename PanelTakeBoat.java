import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelTakeBoat extends JPanel {
    public static IBoat boat;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (boat != null)
        {
            boat.SetPosition(5, 5, this.getWidth(), this.getHeight());
            boat.DrawBoat(g);
        }
    }
}