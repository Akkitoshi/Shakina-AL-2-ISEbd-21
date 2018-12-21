package javalab;

import java.awt.Color;
import java.awt.Graphics;
import javalab.DirectionClass.Direction;

public class Catamaran {
	private int _startPosX;

	private int _startPosY;

	private int _pictureWidth;

	private int _pictureHeight;

	private final int CatamaranWidth = 140;

	private final int CatamaranHeight = 60;
	private int MaxSpeed;

	void getMaxSpeed(int MaxSpeed) {
		this.MaxSpeed = MaxSpeed;
	}

	int setMaxSpeed() {
		return this.MaxSpeed;
	}

	private int Weight;

	void getWeight(int Weight) {
		this.Weight = Weight;
	}

	int setWeight() {
		return this.Weight;
	}

	private Color MainColor;

	void getMainColor(Color MainColor) {
		this.MainColor = MainColor;
	}

	Color setMainColor() {
		return this.MainColor;
	}

	private Color DopColor;

	void getDopColor(Color DopColor) {
		this.DopColor = DopColor;
	}

	Color setDopColor() {
		return this.DopColor;
	}

	public Catamaran(int maxSpeed, int weight, Color mainColor, Color dopColor) {
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
		DopColor = dopColor;

	}

	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
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
			if (_startPosX + step + CatamaranWidth < _pictureWidth) {
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
			if (_startPosY + step + CatamaranHeight <= _pictureHeight) {
				_startPosY += step;
			}
			break;
		}
		}
	}

	public void DrawCatamaran(Graphics g) {
		g.setColor(MainColor);
		g.fillRect(_startPosX + 30, _startPosY + 20, 75, 30);
		g.fillOval(_startPosX + 79, _startPosY + 20, 40, 30);
		g.fillOval(_startPosX, _startPosY + 20, 40, 30);
		g.setColor(Color.BLACK);
		g.fillRect(_startPosX + 60, _startPosY + 20, 5, 30);
		g.setColor(DopColor);
		g.fillOval(_startPosX + 10, _startPosY + 11, 105, 19);
		g.fillOval(_startPosX + 10, _startPosY + 45, 105, 19);
	}

}