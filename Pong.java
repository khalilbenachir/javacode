import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Pong extends JPanel implements ActionListener,KeyListener{
	public static Pong pong;
	public int width=700,height=700;
	public Panel panel;
	public Paddle player1,player2;
	public boolean but=false;
	public boolean w,s,up,down;
	public Ball ball;
	
	
	
	
	
	public Pong() 
	{
		Timer timer=new Timer(20,this);
		JFrame jframe=new JFrame("Pong");
		panel=new Panel();
		ball=new Ball(this);
		
		jframe.setSize(width, height);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.add(panel);
		jframe.addKeyListener(this);
		
		
		start();
	    timer.start();	
	}
	protected void paintComponent(Graphics g)
	{   Graphics2D g2d= (Graphics2D)g;
		super.paintComponent(g2d);
		Pong.pong.render(g2d);
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,0, width, height);
		
		g.setColor(Color.green);
		g.setStroke(new BasicStroke(5f));
		g.drawLine(width/2, 0, width/2, height);
		g.drawOval(167, 140, width/2,350);
		
		
		player1.render(g);
		player2.render(g);
		ball.render(g);

	}
	
	public void start() {
		player1=new Paddle(this, 1);
		player2=new Paddle(this,2);

	}
	
	public static void main(String[] args) {
		pong=new Pong();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	
		int id=arg0.getKeyCode();
		if(id==KeyEvent.VK_W) 
		{
			w=true;
		}
		if(id==KeyEvent.VK_S) 
		{
			s=true;
		}
		if(id==KeyEvent.VK_UP) 
		{
			up=true;
		}
		if(id==KeyEvent.VK_DOWN) 
		{
			down=true;
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		int id=arg0.getKeyCode();
		if(id==KeyEvent.VK_W) 
		{
			w=false;
		}
		if(id==KeyEvent.VK_S) 
		{
			s=false;
		}
		if(id==KeyEvent.VK_UP) 
		{
			up=false;
		}
		if(id==KeyEvent.VK_DOWN) 
		{
			down=false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        
		update();
		panel.repaint();
		
	}

	private void update() {

		if(s) 
		{
			player1.move(true);
		}
		if(w) 
		{
			player1.move(false);
		}
		if(up) 
		{
			player2.move(true);
		}
		if(down) 
		{
			player2.move(false);
		}
		ball.update(player1, player2);
		System.out.println("sss");

		
	}
	
	

}
