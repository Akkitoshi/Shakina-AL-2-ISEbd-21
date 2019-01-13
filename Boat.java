import java.awt.Color;
import java.awt.Graphics;

public class Boat extends Lodka {

	protected final int boatWidth = 100;
	protected final int boatHeight = 60;

	public Boat(int maxSpeed, float weight, Color mainColor) {
		__MaxSpeed = maxSpeed;
		__Weight = weight;
		__MainColor = mainColor;
	}

	@Override
	public void MoveTransport(Direction direction) {
		float step = __MaxSpeed * 100 / __Weight;
		switch (direction) {
		case Right:
			if (_startPosX + step < _pictureWidth - boatWidth) {
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0) {
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step > 25) {
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - boatHeight) {
				_startPosY += step;
			}
			break;
		}
	}

	@Override
	public void DrawBoat(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int)_startPosX + 25,(int) _startPosY + 15, 75, 25);
		g.fillOval((int)_startPosX + 79, (int)_startPosY + 15, 40, 25);
		g.fillOval((int)_startPosX, (int)_startPosY + 15, 40, 25);
		g.setColor(getMainColor());
		g.fillRect((int)_startPosX + 10,(int) _startPosY + 15, 95, 5);
		g.fillRect((int)_startPosX + 10, (int)_startPosY + 35, 95, 5);
	}
}
