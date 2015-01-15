import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

public class Game {
	Tetrominos tetr;
	Background backgr;
	Main main;
	int pause = 800;
	//int pausedef = pause;

	public Game() {
		gentetr();
		backgr = new Background();
		main = new Main(this);
		backgr.init();
		while(true){
            try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            step();
		}
		/*
		 * draw(); step(); draw();
		 */
	}

	public void up() {
		tetr.rot();
		if (!check(tetr.getPosX(), tetr.getPosY())) {
			tetr.resetRot();
		}
		draw();
	}

	/*public void down() {
		pause = pausedef / 2;

	}
*/
	public void left() {
		if (check(tetr.getPosX() - 1, tetr.getPosY())) {
			tetr.move(0);
		}
		draw();
	}

	public void right() {
		if (check(tetr.getPosX() + 1, tetr.getPosY())) {
			tetr.move(2);
		}
		draw();
	}

	public void hold() {

	}

	public boolean check(int x, int y) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tetr.getForm(i, j) != 0) {
					if (x + i > 9 | x + i< 0 | y - j < 0 | y - j > 19) {// check if out of bounds
						return false;

					} else if (backgr.getaZ(x + i, y - j) != 0) {
						return false;
					}
				}

			}
		}
		return true;
	}

	public void draw() {

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 20; y++) {
				main.setPixel(x, y, backgr.getColor(x, y));
			}
		}
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (tetr.getForm(x, y) != 0) {
					main.setPixel(x + tetr.getPosX(), tetr.getPosY() - y,
							tetr.getColor(x, y));
				}
			}
		}
	}

	public void step() {
		if (check(tetr.getPosX(), tetr.getPosY() - 1)) {
			tetr.move(1);
		} else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if(tetr.Form[i][j]!=0){
					backgr.setaZ(tetr.getPosX() + i,tetr.getPosY() - j,tetr.Form[i][j]);
					}
				}
			}
			gentetr();
			for (int y=0; y<20; y++){
				if(backgr.checkLine(y)){
					backgr.delLine(y);
				}
			}
		}
	//	pause = pausedef;
		draw();
	}

	public void gentetr() {
		Random rand = new Random();
		tetr = new Tetrominos(rand.nextInt(7) + 1);
	}
}
