package javalabs;

import javalabs.DirectionClass.Direction;
import java.awt.*;

public abstract class Lodka implements IBoat {
	// Координата X
	protected int _startPosX;
	// Координата Y
	protected int _startPosY;
	// Ширина окна отрисовки
	protected int _pictureWidth;
	// Высота окна отрисовки
	protected int _pictureHeight;
	// Максимальная скорость судна
	protected int MaxSpeed;
	// Вес судна
	protected float Weight;
	// Основной цвет судна
	protected Color MainColor;

	public int getMaxSpeed() {
		return MaxSpeed;
	}

	public float getWeight() {
		return Weight;
	}

	public Color getMainColor() {
		return MainColor;
	}

	// Определение места отрисовки судна
	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	// Метод отрисовки судна
	public abstract void DrawBoat(Graphics g);

	// Метод перемещения судна
	public abstract void MoveTransport(Direction direction);
}