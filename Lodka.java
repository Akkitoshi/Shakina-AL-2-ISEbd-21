package javalabs;

import javalabs.DirectionClass.Direction;
import java.awt.*;

public abstract class Lodka implements IBoat {
	// ���������� X
	protected int _startPosX;
	// ���������� Y
	protected int _startPosY;
	// ������ ���� ���������
	protected int _pictureWidth;
	// ������ ���� ���������
	protected int _pictureHeight;
	// ������������ �������� �����
	protected int MaxSpeed;
	// ��� �����
	protected float Weight;
	// �������� ���� �����
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

	// ����������� ����� ��������� �����
	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	// ����� ��������� �����
	public abstract void DrawBoat(Graphics g);

	// ����� ����������� �����
	public abstract void MoveTransport(Direction direction);
}