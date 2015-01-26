import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main {
	ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	ArrayList<JPanel> prevList = new ArrayList<JPanel>();
	ArrayList<JPanel> holdList = new ArrayList<JPanel>();
	JFrame mainFrame = new JFrame();
	JPanel game = new JPanel();
	JPanel stat = new JPanel();
	JPanel hold = new JPanel();
	JPanel preview = new JPanel();
	JPanel score = new JPanel();
	JLabel labela = new JLabel("  Highscore:", SwingConstants.LEFT);
	JLabel label = new JLabel("  Score: ", SwingConstants.LEFT);
	JLabel labelb = new JLabel("00", SwingConstants.RIGHT);
	JLabel labelc = new JLabel("00", SwingConstants.RIGHT);
	public Main(final Game g) { // Graphics

		mainFrame.setPreferredSize(new Dimension(600, 600));
		game.setLayout(new GridLayout(20, 10));
		mainFrame.setLayout(new GridLayout(1, 2));
		stat.setLayout(new GridLayout(3, 1));
		preview.setLayout(new GridLayout(6, 10));
		hold.setLayout(new GridLayout(6, 10));
		score.setLayout(new GridLayout(4, 1));

		game.setSize(300, 600);
		stat.setSize(300, 600);
		hold.setBackground(Color.black);
		game.setBackground(Color.black);
		stat.setBackground(Color.black);
		preview.setBackground(Color.black);
		score.setBackground(Color.black);
		score.add(label);
		score.add(labelb);
		score.add(labela);
		score.add(labelc);
		label.setSize(300, 200);
		label.setFont(new Font("Courier new", 1, 30));
		labela.setFont(new Font("Courier new", 1, 30));
		labelb.setFont(new Font("Courier new", 1, 30));
		labelc.setFont(new Font("Courier new", 1, 30));
		for (int x = 0; x < 200; x++) { // "pixels" for Game
			panelList.add(new JPanel());
			JPanel panel = panelList.get(x);
			panel.setSize(30, 30);
			panel.setBackground(Color.yellow);
			panel.setBorder(new LineBorder(Color.gray, 1));
			game.add(panel);
		}
		for (int x = 0; x < 10 * 6; x++) {// "pixels" for preview
			prevList.add(new JPanel());
			JPanel panelp = prevList.get(x);
			panelp.setSize(30, 30);
			panelp.setBackground(Color.yellow);
			panelp.setBorder(new LineBorder(Color.gray, 0));
			preview.add(panelp);
		}
		for (int x = 0; x < 10 * 6; x++) {// "pixels" for hold
			holdList.add(new JPanel());
			JPanel panelh = holdList.get(x);
			panelh.setSize(30, 30);
			panelh.setBackground(Color.black);
			panelh.setBorder(new LineBorder(Color.gray, 0));
			hold.add(panelh);
		}
		stat.add(preview);
		stat.add(hold);
		stat.add(score);
		mainFrame.add(game);
		mainFrame.add(stat);
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:// rotate
					g.up();
					break;
				case KeyEvent.VK_DOWN:// accelerate
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
				case KeyEvent.VK_P:// pause
					g.pause();
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
		panelList.get(x + ((19 - y) * 10)).setBackground(color);
	}

	public void setPixelprev(int x, int y, Color color) {
		prevList.get(x + ((5 - y) * 10)).setBackground(color);
		if (color == Color.black) {
			prevList.get(x + ((5 - y) * 10)).setBorder(
					new LineBorder(Color.gray, 0));
		} else {
			prevList.get(x + ((5 - y) * 10)).setBorder(
					new LineBorder(Color.black, 1));
		}
	}

	public void setPixelhold(int x, int y, Color color) {
		holdList.get(x + ((5 - y) * 10)).setBackground(color);
		if (color == Color.black) {
			holdList.get(x + ((5 - y) * 10)).setBorder(
					new LineBorder(Color.gray, 0));
		} else {
			holdList.get(x + ((5 - y) * 10)).setBorder(
					new LineBorder(Color.black, 1));
		}
	}

	public static void main(String[] args) {
		Game a = new Game();
	}

	public int setScore(int x, int y) {
		labelb.setText(Integer.toString(x)+"  ");
		if (x > y) {
			labelc.setText(Integer.toString(x)+"  ");
			return x;
		} else {
			labelc.setText(Integer.toString(y)+"  ");
			return y;
		}
	}
}
