import java.awt.Color;
import java.awt.Graphics;

public class Catamaran extends Boat{
	
    public Color DopColor;
    public Color getDopColor() {
		return DopColor;
	}

	public void setDopColor(Color value) {
		DopColor = value;
	}
	
    public boolean RightSail;
    public boolean getRightSail (){
    	return RightSail;
    }
    public boolean LeftSail;
    public boolean getLeftSail (){
    	return LeftSail;
    }
    
    public Catamaran(int maxSpeed, float weight, Color mainColor, Color dopColor)
    {	super(maxSpeed, weight, mainColor);    
        __MaxSpeed = maxSpeed;
        __Weight = weight;
        __MainColor = mainColor;
        DopColor = dopColor;
    }
    @Override
    public void DrawBoat(Graphics g)
    {
        super.DrawBoat(g);
        g.setColor(Color.black);
		g.fillRect((int)_startPosX + 55,(int) _startPosY + 10, 5, 30);
		g.setColor(DopColor);
		g.fillOval((int)_startPosX + 10,(int) _startPosY + 3, 95, 15);
		g.fillOval((int)_startPosX + 10,(int) _startPosY + 35, 95, 15);
    
    }

	@Override
	public void MoveTransport(Direction direction) {
		// TODO Auto-generated method stub
		
	}

}
