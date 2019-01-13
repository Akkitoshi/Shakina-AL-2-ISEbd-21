import java.awt.Color;
import java.awt.Graphics;

public class Boat extends lodka {
    private int airWidth = 100;
    private int airHeight = 60;

    public Boat(int maxSpeed, int weight, Color mainColor) {
        setMaxSpeed(maxSpeed);
        setWeight(weight);
        setMainColor(mainColor);
    }

    public Boat(String info) {
        String[] str = info.split(";");
        if(str.length == 5) {
            MaxSpeed = Integer.parseInt(str[0]);
            Weight = Float.parseFloat(str[1]);
            mainColor = new Color(Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]));
        }
    }

    public void MoveTransport(Direction direction) {

        float step = getMaxSpeed() * 100 / getWeight();
        switch (direction) {
            case Right:
                if (_startPosX + step < _pictureWidth - airWidth) {
                    _startPosX += step;
                }
                break;
            case Left:
                if (_startPosX - step > 0) {
                    _startPosX -= step;
                }
                break;
            case Up:
                if (_startPosY - step - 10 > 0) {
                    _startPosY -= step;
                }
                break;
            case Down:
                if (_startPosY + step < _pictureHeight - airHeight) {
                    _startPosY += step;
                }
                break;
        }
    }

    public void DrawBoat(Graphics g) {
    	g.setColor(Color.DARK_GRAY); 
    	g.fillRect((int) _startPosX + 25, (int) _startPosY + 9, 75, 25); 
    	g.fillOval((int) _startPosX + 79, (int) _startPosY + 9, 40, 25); 
    	g.fillOval((int) _startPosX, (int) _startPosY + 9, 40, 25); 
    	g.setColor(getMainColor()); 
    	g.fillRect((int) _startPosX + 10, (int) _startPosY + 9, 95, 5); 
    	g.fillRect((int) _startPosX + 10, (int) _startPosY + 29, 95, 5);
    }

    @Override
    public String getInfo() {
        return MaxSpeed + ";" + Weight + ";"  + mainColor.getRed() + ";"
                + mainColor.getGreen() + ";" + mainColor.getBlue();
    }
}