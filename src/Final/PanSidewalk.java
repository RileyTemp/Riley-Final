package Final;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PanSidewalk extends JPanel implements ActionListener {

    static boolean drawn = false;
    Rectangle rB, rE, rP;
    SprPerson sprPerson = new SprPerson();
    private Timer timer;
    private Image background;
    static String sName;
    Label JLabel;
    int dx, dy;
    int nSpeed = 5;

    public PanSidewalk() {
        addKeyListener(new Movement());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("sidewalk.jpg");
        background = i1.getImage();
        //timer = new Timer(80, this);
        //timer.start();
        System.out.println(nSpeed);
    }

    public void Timer(Timer timer) {
        timer = new Timer(80, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent arg0) {

        sprPerson.move();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        g2d.drawImage(sprPerson.getImage(), sprPerson.getX(), sprPerson.getY(), null);
    }

    private class Movement extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent w) {
            dy = 0;
            dx = 0;
        }

        @Override
        public void keyPressed(KeyEvent w) {
            int code = w.getKeyCode();
            if (code == KeyEvent.VK_A) {
                sprPerson.i = 0;
                dx = -nSpeed;
                sprPerson.x += dx;
                if (sprPerson.x <= -245) {
                    sprPerson.x = 1000;
                }
            } else if (code == KeyEvent.VK_D) {
                sprPerson.i = 1;
                dx = nSpeed;
                sprPerson.x += dx;
                if (sprPerson.x >= 1000) {
                    sprPerson.x = -255;
                }
            } else if (code == KeyEvent.VK_W) {
                dy = -nSpeed;
                sprPerson.y += dy;
                if (sprPerson.y <= -220) {
                    sprPerson.y = 650;
                }
            } else if (code == KeyEvent.VK_S) {
                dy = nSpeed;
                sprPerson.y += dy;
                if (sprPerson.y >= 650) {
                    sprPerson.y = -220;
                }
            }
        }
    }

    void display(int n) {
    }

    void SpeedChange(String _s) {
        String Change = _s;
        System.out.println(Change);
        if (Change.equals("Speed Up")) {
            nSpeed += 1;
        } else if (Change.equals("Slow Down")) {
            nSpeed -= 1;
        }
    }
}