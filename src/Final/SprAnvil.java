package Final;

import java.awt.*;
import javax.swing.*;

public class SprAnvil {

    private Image img;
    int i;
    int x, y, by, dx, dy;
    boolean left, right, up, down;
    int nSpeed;
    ImageIcon p1 = new ImageIcon("anvil1.png");// Looking Left
    int imgWidth = p1.getIconHeight();
    int imgHeight = p1.getIconWidth();
    Image arnRunning_R[] = new Image[1];
    Rectangle r;

    public SprAnvil() {
        r = new Rectangle();
        x = 400;
        y = 0;
        dx = 0;
        dy = 0;
        left = false;
        right = false;
        up = false;
        down = false;
        arnRunning_R[0] = p1.getImage();


    }

    public Rectangle getRect() {
        r.setBounds(x, y, imgWidth, imgHeight);
        return r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        img = arnRunning_R[i];
        return img;
    }

    void reset() {
        x = 400;
        y = 0;
    }

    void falling(int _nSpeed) {
        nSpeed = _nSpeed;
        y += nSpeed;
    }
}
