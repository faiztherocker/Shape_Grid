package octagons_try;

import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {
    private static final long serialVersionUID = 1L;
    private final int WIDTH = 800;
    private final int HEIGHT = 800;

   
    public Main() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point origin = new Point(WIDTH / 2, HEIGHT / 2);
     //   g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        drawHexGridLoop(g2d, origin, 15, 60);
    }

    private void drawHexGridLoop(Graphics g, Point origin, int size, int radius) {
        double ang30 = Math.toRadians(34);
        double xOff = Math.cos(ang30) * (radius);
        double yOff = Math.sin(ang30) * (radius);
        int half = size / 2;

        for (int row = 0; row < size; row++) {
           // int cols = size - java.lang.Math.abs(row - half);

            for (int col = 0; col < size; col++) {
                int x = (int) (origin.x + xOff * (col * 2 + 1 - size));
                int y = (int) (origin.y + yOff * (row - half) * 3);
                drawHex(g, x, y, radius);
            }
        }
    } 

    private void drawHex(Graphics g, int x, int y, int r) {
        Graphics2D g2d = (Graphics2D) g;
        Hexagon hex = new Hexagon(x, y, r);
        hex.draw(g2d, x, y);
        
    
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Main p = new Main();

        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


