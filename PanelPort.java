import javax.swing.JList;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelPort extends JPanel{
    private  MultiLevelPort port;
    private JList listBoxLevels;
    public final int countLevel = 5;
    public MultiLevelPort getPort() {
        return port;
    }
    public PanelPort() {
        port = new MultiLevelPort(countLevel, 615, 603);
    }

    public void setListLevels(JList listBoxLevels) {
        this.listBoxLevels = listBoxLevels;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int selectedLevel = listBoxLevels.getSelectedIndex();
        port.getPort(selectedLevel).Draw(g);
        if(selectedLevel != -1){
            if(port != null) {
                port.getPort(selectedLevel).Draw(g);
            }
        }
    }
}