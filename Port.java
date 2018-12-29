package javalabs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

class Port <T extends IBoat> {
	private ArrayList<T> _places;
	private int PictureWidth;
	private int PictureHeight;
	private int _placeSizeWidth = 210;
	private int _placeSizeHeight = 85;

	public Port(int sizes, int pictureWidth, int pictureHeight) {
		_places = new ArrayList<T>();
		PictureWidth = pictureWidth;
		PictureHeight = pictureHeight;
		for (int i = 0; i < sizes; i++) {
			_places.add(null);
		}
	}

	public int Plus(T ocean) {
		for (int i = 0; i < _places.size(); i++) {
			if (CheckFreePlace(i)) {
				_places.add(i, ocean);
				_places.get(i).SetPosition(10 + i / 5 * _placeSizeWidth + 25,
						i % 5 * _placeSizeHeight + 35, PictureWidth,
						PictureHeight);
				return i;
			}
		}
		return -1;
	}

	public T Minus(int index) {
		if (index < 0 || index > _places.size()) {
			return null;
		}
		if (!CheckFreePlace(index)) {
			T ocean = _places.get(index);
			_places.set(index, null);
			return ocean;
		}
		return null;
	}

	private boolean CheckFreePlace(int index) {
		return _places.get(index) == null;
	}

	public void Draw(Graphics g) {
		DrawMarking(g);
		for (int i = 0; i < _places.size(); i++) {
			if (!CheckFreePlace(i)) {// если место не пустое
				_places.get(i).DrawBoat(g);
			}
		}
	}

	private void DrawMarking(Graphics g) {
		g.fillRect(0, 0, 160 * 4 + 132, 2);
		g.fillRect(0, 0, 2, 160 * 4 + 132);
		for (int i = 0; i < _places.size() / 5; i++) {
			for (int j = 1; j < 6; ++j) {
				g.drawRect(i * _placeSizeWidth, j * _placeSizeHeight, 160, 2);
				Color nc = new Color(0, 0, 0);
				g.setColor(nc);
				g.fillRect(i * _placeSizeWidth, j * _placeSizeHeight, 160, 2);
			}

		}
	}
}