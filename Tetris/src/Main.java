import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPanel;

public class Main {
	
	JPanel pGame = new JPanel();
	JPanel pNext = new JPanel();
	JPanel pHold = new JPanel();
	JPanel pScore = new JPanel();
	JPanel pStat = new JPanel();
	Frame window = new Frame();

	public Main(final Game g) {

		window.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
			    switch( keyCode ) { 
			        case KeyEvent.VK_UP:
			        	g.up();
			            break;
			        case KeyEvent.VK_DOWN:
			        	g.down();
			            break;
			        case KeyEvent.VK_LEFT:
			        	g.left();
			            break;
			        case KeyEvent.VK_RIGHT :
			        	g.right();
			            break;
			        case KeyEvent.VK_SPACE :
			        	g.hold();
			            break;
			     }			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		window.setSize(600, 600);
		pGame.setSize(300, 600);
		pNext.setSize(300, 200);
		pHold.setSize(300, 200);
		pScore.setSize(300, 200);
		window.add(pGame);
		pStat.add(pNext);
		pStat.add(pHold);
		pStat.add(pScore);
		window.add(pStat);
		pGame.setBackground(Color.black);
		pNext.setBackground(Color.red);
		pHold.setBackground(Color.green);
		pScore.setBackground(Color.yellow);
		GridLayout grid;
		window.setLayout(grid = new GridLayout());
		window.setTitle("Tetris");
		pStat.setLayout(new GridLayout(3, 1));
		window.setBackground(Color.black);
		window.setResizable(false);
		window.addWindowListener(new WindowListener() {
			public void windowActivated(WindowEvent arg0) {
			}

			public void windowClosed(WindowEvent arg0) {
			}

			public void windowClosing(WindowEvent arg0) {
				window.dispose();
			}

			public void windowDeactivated(WindowEvent arg0) {
			}

			public void windowDeiconified(WindowEvent arg0) {
			}

			public void windowIconified(WindowEvent arg0) {
			}

			public void windowOpened(WindowEvent arg0) {
			}
		});
		window.setVisible(true);

	}

	public static void main(String[] args) {
		Game a = new Game();	
		}

}
