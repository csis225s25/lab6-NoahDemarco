import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Lab 5 demo of mouse events.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener{
	private int count = 0;
    String toDisplay;
    JButton reset;
	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MousePressCounter");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		JPanel panel = new JPanel(new BorderLayout()) {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				toDisplay = "Clicks: " + count;
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
			}
		};


        reset = new JButton("Reset");
        reset.addActionListener(this);

		frame.add(panel);
		panel.addMouseListener(this);
        panel.add(reset, BorderLayout.SOUTH);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == reset){
            count = 0;
            toDisplay = "Clicks: " + count;
            run();
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
        count++;
        toDisplay = "Clicks: " + count;
        run();
	}

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}
