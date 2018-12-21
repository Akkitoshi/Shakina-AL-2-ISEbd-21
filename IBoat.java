package javalabs;

import javalabs.DirectionClass.Direction;
import java.awt.*;

public interface IBoat {
	// ��������� ������� �����
	void SetPosition(int x, int y, int width, int height);

	// ����������� �����
	void MoveTransport(Direction direction);

	// ��������� �����
	void DrawBoat(Graphics g);
}
