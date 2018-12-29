package javalabs;

import java.util.ArrayList;

public class MultiLevelParking {
	ArrayList<Port<IBoat>> parkingStages;
	private int countPlaces = 20;

	public MultiLevelParking(int countStages, int pictureWidth,
			int pictureHeight) {
		parkingStages = new ArrayList<Port<IBoat>>();
		for (int i = 0; i < countStages; ++i) {
			parkingStages.add(new Port<IBoat>(countPlaces, pictureWidth,
					pictureHeight));
		}
	}

	public Port<IBoat> getHangar(int ind) {
		if ((ind > -1) && (ind < parkingStages.size())) {
			return parkingStages.get(ind);
		}
		return null;
	}
}