import java.awt.Color;
import java.awt.Graphics;
public class Catamaran extends Boat {
    private Color dopColor;
    public Color getDopColor(){
        return dopColor;
    }
    public void setDopColor(Color dopColor) {
        this.dopColor = dopColor;
    }
    public void setDopColor(String colorName) {
        switch (colorName) {
            case "yellow":
                dopColor = Color.YELLOW;
                break;
            case "blue":
                dopColor = Color.BLUE;
                break;
            case "red":
                dopColor = Color.RED;
                break;
            case "green":
                dopColor = Color.GREEN;
                break;
            case "black":
                dopColor = Color.BLACK;
                break;
            case "orange":
                dopColor = Color.ORANGE;
                break;
            case "grey":
                dopColor = Color.GRAY;
                break;
            case "white":
                dopColor = Color.WHITE;
                break;
        }

    }
    public Catamaran(int maxSpeed, int weight, Color mainColor, Color dopColor)
    {
        super(maxSpeed, weight, mainColor);
        setDopColor(dopColor);
    }

    public Catamaran(String info) {
        super(info);
        String[] str = info.split(";");
        if(str.length == 8) {
            MaxSpeed = Integer.parseInt(str[0]);
            Weight = Float.parseFloat(str[1]);
            mainColor = new Color(Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]));
            dopColor = new Color(Integer.parseInt(str[5]), Integer.parseInt(str[6]), Integer.parseInt(str[7]));
        }
    }

    public void DrawBoat(Graphics g) {
        super.DrawBoat(g);
        g.setColor(mainColor); 
        g.fillRect((int) _startPosX + 55, (int) _startPosY + 4, 5, 30); 
        g.setColor(dopColor); 
        g.fillOval((int) _startPosX + 10, (int) _startPosY -3, 95, 15); 
        g.fillOval((int) _startPosX + 10, (int) _startPosY + 29, 95, 15);
    }

    @Override
    public String getInfo() {
        return MaxSpeed + ";" + Weight + ";" + mainColor.getRed() + ";"
                + mainColor.getGreen() + ";" +  mainColor.getBlue() + ";"
                + dopColor.getRed() + ";" + dopColor.getGreen() + ";"
                + dopColor.getBlue();
    }
}