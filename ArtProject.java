import java.awt.*;
import javax.swing.*;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        
        FontMetrics FontMetrics = g.getFontMetrics();
        String str = "Hello, Java Graphics World!";

        int stringWidth = FontMetrics.stringWidth(str);

        g.setFont(new Font("Magneto", 1, 12));

        super.setBackground(new Color(0,0,25));
        super.setForeground(new Color(49,140,231));

        //First one right
        g.drawLine(600, 200, 50, 100);

        g.setColor(new Color (52,174,83));
        g.fillOval(125, 30, 35, 35);
      
        g.setColor(new Color (52,15,155));
        g.drawArc(300, 200, 100, 50, 65, 500);

        g.setColor(new Color (200,10,60));
        g.fill3DRect(100, 100, 200, 200, getFocusTraversalKeysEnabled());

        g.fill3DRect(200, 200, 100, 100, getFocusTraversalKeysEnabled());

        g.setColor(new Color (244,165,174));
        //Polygon 
        int[] xPoints = {25,50,75, 100};
        int[] yPoints = {35,65,85, 200};
        Polygon p = new Polygon(xPoints, yPoints, 4);

        g.fillPolygon(p);



    }
}

public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}