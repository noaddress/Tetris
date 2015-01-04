import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPanel;

public class Main {
	public Main() {
		final Frame window = new Frame();
		JPanel pGame = new JPanel(); // PREFERRED!
		JPanel pNext = new JPanel();
		JPanel pHold = new JPanel();
		JPanel pScore = new JPanel();
		JPanel pStat = new JPanel();
		window.setSize(600, 600);
		pGame.setSize(400, 600);
		pNext.setSize(100, 100);
		pHold.setSize(100, 100);
		pScore.setSize(100, 100);
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
		Main a = new Main();
	}

}
