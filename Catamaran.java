package javalabs;

import java.awt.Color;
import java.awt.Graphics;

public class Catamaran extends Boat {
	private Color DopColor;

	void getDopColor(Color DopColor) {
		this.DopColor = DopColor;
	}

	Color setDopColor() {
		return this.DopColor;
	}

	public Catamaran(int maxSpeed, int weight, Color mainColor, Color dopColor) {
		super(maxSpeed, weight, mainColor);
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
		DopColor = dopColor;
	}

	public void DrawBoat(Graphics g) {
		super.DrawBoat(g);
		g.setColor(Color.black);
		g.fillRect(_startPosX + 55, _startPosY + 10, 5, 30);
		g.setColor(DopColor);
		g.fillOval(_startPosX + 10, _startPosY + 3, 95, 15);
		g.fillOval(_startPosX + 10, _startPosY + 35, 95, 15);
	}
}
