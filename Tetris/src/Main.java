import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main {
	ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	
	public Main(final Game g) {
		JFrame mainFrame = new JFrame();
		mainFrame.setPreferredSize(new Dimension(300,600));
		mainFrame.setLayout(new GridLayout(20, 10));
		for (int x = 0; x < 200; x++) {
			
				panelList.add(new JPanel());
				JPanel panel = panelList.get(x);
				
				panel.setSize(30, 30);
				if(0==0){
				panel.setBackground(Color.yellow);
				panel.setBorder(new LineBorder(Color.gray,1));
				}
				else
				{
					panel.setBackground(Color.black);

				}
				mainFrame.add(panel);
		}

		
		
		mainFrame.pack();
		mainFrame.setVisible(true);

		/*fa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// fb.setBounds(0, 0, 30, 30);

		fb.setVisible(true);
		fb.setBackground(Color.YELLOW); // Whatever color
		fa.add(fb);
		fa.setVisible(true);

		/*
		 * for (int x = 0; x < 10; x++) { for (int y = 0; y < 20; y++) {
		 * q.fillRect(x * 30, y * 30, 30, 30); } }
		 */

		mainFrame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					g.up();
					break;
				case KeyEvent.VK_DOWN:
					g.step();
					break;
				case KeyEvent.VK_LEFT:
					g.left();
					break;
				case KeyEvent.VK_RIGHT:
					g.right();
					break;
				case KeyEvent.VK_SPACE:
					g.hold();
					break;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	
	public void setPixel(int x, int y, Color color) {
		panelList.get(x+((19-y)*10)).setBackground(color);
	}

	
	public static void main(String[] args) {
		Game a = new Game();
	}

}
