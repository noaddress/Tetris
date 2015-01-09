//http://stackoverflow.com/questions/18877882/draw-rectangle-in-jpanel
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class RectDraw extends JPanel {
	int x;
	int y;
	Color color;
	public RectDraw(int x,int y,Color color){
		this.x=x;
		this.y=y;
		this.color=color;
	}
  protected void paintComponent(Graphics g,int x,int y,Color color) {
    super.paintComponent(g);  
    g.drawRect(x,y,30,30);  
    g.setColor(color);  
    g.fillRect(x,y,30,30);  
  }
  
public void clear(Graphics g){
	g.drawRect(0,0,300,600);  
    g.setColor(Color.black);  
    g.fillRect(0,0,300,600);  
}
}