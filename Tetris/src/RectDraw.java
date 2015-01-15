import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class RectDraw extends JPanel {
	Graphics g;
	int x = 30;
	int y = 30;

	public void paint(Graphics g) {
		g.fillRect(x, y, 30, 30);
		//g.fillRect(x, y, 30, 30);
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Graphics get() {
		return g;
	}
}
class WinDraw extends JFrame {


	public void paint(Graphics g) {
	}
}