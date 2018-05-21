import java.awt.Color;
import java.awt.Graphics2D;

public class Paddle {
	public int paddlenumber;
	public int x,y,width=50,height=280;
	public int score;
	
	public Paddle(Pong pong,int paddlenumber) 
	{
		this.paddlenumber=paddlenumber;
		
		if(paddlenumber==1)
		{
			this.x=0;
		}
		if(paddlenumber==2)
		{
			this.x=pong.width-width;
		}
		this.y=pong.height/2 -this.height/2;
		
		
		
	}
	
	public void render(Graphics2D g) 
	{ 
		
		if(paddlenumber==1)
		{
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		}
		else if(paddlenumber==2)
		{
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		}
		
		
	}

	public void move(boolean up) {

		int speed = 10;
		if(up) 
		{
			if(y-speed>0) 
			{
				y-=speed;
			}
			else 
			{
				y=0;
			}
		}
		else 
		{
			if(y+speed+height<Pong.pong.height) 
			{
				y+=speed;
			}
			else 
			{
			 y=Pong.pong.height-height;	
			}
		}
		
	}
	

}
