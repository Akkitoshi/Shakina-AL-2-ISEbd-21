package javalabs;

import java.awt.Graphics;
import javax.swing.*;

public class PanelPort extends JPanel {
	private MultiLevelParking hangar;
	private JList listBoxLevels;
	public final int countLevel = 7;

	public MultiLevelParking getPort() {
		return hangar;
	}

	public PanelPort() {
		hangar = new MultiLevelParking(countLevel, 615, 603);
	}

	public void setListLevels(JList listBoxLevels) {
		this.listBoxLevels = listBoxLevels;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int selectedLevel = listBoxLevels.getSelectedIndex();
		hangar.getHangar(selectedLevel).Draw(g);
		if (selectedLevel != -1) {
			if (hangar != null) {
				hangar.getHangar(selectedLevel).Draw(g);
			}
		}
	}
}
