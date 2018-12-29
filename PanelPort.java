package javalabs;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelPort extends JPanel{
    public Port<IBoat> port;

    public Port<IBoat> getPort() {
        return port;
    }

    public PanelPort() {
        port = new Port<>(20, 615, 603);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(port != null) {
            port.Draw(g);
        }
    }
}
