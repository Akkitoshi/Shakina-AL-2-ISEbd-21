import java.awt.Graphics;

public interface IBoat {
    void SetPosition(int x, int y, int width, int height);
    void MoveTransport(Direction direction);
    void DrawBoat(Graphics g);
    void setMainColor(String colorName);
    String getInfo();
}