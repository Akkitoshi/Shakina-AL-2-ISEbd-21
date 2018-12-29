package javalabs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

class Port<T extends IBoat> {
	private HashMap<Integer, T> _places;
	private int _maxCount;
	private int PictureWidth;
	private int PictureHeight;

	public int getPictureWidth() {
		return PictureWidth;
	}

	public void setPictureWidth(int pw) {
		PictureWidth = pw;
	}

	public int getPictureHeight() {
		return PictureHeight;
	}

	public void setPictureHeight(int ph) {
		PictureHeight = ph;
	}

	private int _placeSizeWidth = 210;
	private int _placeSizeHeight = 85;

	public Port(int sizes, int pictureWidth, int pictureHeight) {
		_maxCount = sizes;
		_places = new HashMap<Integer, T>();
		PictureWidth = pictureWidth;
		PictureHeight = pictureHeight;
	}

	public int Plus(T ocean) {
		if (_places.size() == _maxCount) {
			return -1;
		}
		for (int i = 0; i < _maxCount; i++) {
			if (CheckFreePlace(i)) {
				_places.put(i, ocean);
				_places.get(i).SetPosition(10 + i / 5 * _placeSizeWidth + 25,
						i % 5 * _placeSizeHeight + 35, PictureWidth,
						PictureHeight);
				return i;
			}
		}
		return -1;
	}

	public T Minus(int index) {
		if (index < 0 || index > _maxCount) {
			return null;
		}
		if (!CheckFreePlace(index)) {
			T ocean = _places.get(index);
			_places.remove(index);
			return ocean;
		}
		return null;
	}

	private boolean CheckFreePlace(int index) {
		return !_places.containsKey(index);
	}

	public void Draw(Graphics g) {
		DrawMarking(g);
		for (int i = 0; i < _places.keySet().toArray().length; i++) {
			_places.get(_places.keySet().toArray()[i]).DrawBoat(g);
		}
	}

	private void DrawMarking(Graphics g) {
		g.fillRect(0, 0, 160 * 4 + 132, 3);
		g.fillRect(0, 0, 2, 160 * 4 + 132);
		for (int i = 0; i < _maxCount / 5; i++) {
			for (int j = 0; j < 6; ++j) {
				g.drawRect(i * _placeSizeWidth, j * _placeSizeHeight, 160, 2);
				Color nc = new Color(0, 0, 0);
				g.setColor(nc);
				g.fillRect(i * _placeSizeWidth, j * _placeSizeHeight, 160, 2);
			}
		}
	}
}