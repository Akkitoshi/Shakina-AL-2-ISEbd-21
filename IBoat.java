package javalabs;

import javalabs.DirectionClass.Direction;
import java.awt.*;

public interface IBoat {
	// Установка позиции судна
	void SetPosition(int x, int y, int width, int height);

	// Перемещение судна
	void MoveTransport(Direction direction);

	// Отрисовка судна
	void DrawBoat(Graphics g);
}
