package javalabs;

import java.awt.Color;
import java.awt.Graphics;
import javalabs.DirectionClass.Direction;

public class Boat extends Lodka {
	private final int BoatWidth = 140;

	private final int BoatHeight = 60;

	private Color DopColor;

	void getDopColor(Color DopColor) {
		this.DopColor = DopColor;
	}

	Color setDopColor() {
		return this.DopColor;
	}

	public Boat(int maxSpeed, int weight, Color mainColor) {
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
	}

	public void MoveTransport(Direction direction) {
		float step = MaxSpeed;
		switch (direction) {
		case Left: {
			if (_startPosX - step > 0) {
				_startPosX -= step;
			}
			break;
		}
		case Right: {
			if (_startPosX + step + BoatWidth < _pictureWidth) {
				_startPosX += step;
			}
			break;
		}
		case Up: {
			if (_startPosY - step > 0) {
				_startPosY -= step;
			}
			break;
		}
		case Down: {
			if (_startPosY + step + BoatHeight <= _pictureHeight) {
				_startPosY += step;
			}
			break;
		}
		}
	}

	public void DrawBoat(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(_startPosX + 25, _startPosY + 15, 75, 25);
		g.fillOval(_startPosX + 79, _startPosY + 15, 40, 25);
		g.fillOval(_startPosX, _startPosY + 15, 40, 25);
		g.setColor(MainColor);
		g.fillRect(_startPosX + 10, _startPosY + 15, 95, 5);
		g.fillRect(_startPosX + 10, _startPosY + 35, 95, 5);
	}
}