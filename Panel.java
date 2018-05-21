import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel{

	protected void paintComponent(Graphics g)
	{   Graphics2D g2d= (Graphics2D)g;
		super.paintComponent(g2d);
		Pong.pong.render(g2d);
	}
	
	
}
