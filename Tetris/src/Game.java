import java.util.Random;

public class Game {
	Tetrominos tetr;
	Background backgr;
	Main main;
	int pause = 800;
	int pausedef = pause;
	RectDraw rect;

	public Game() {
		gentetr();
		backgr = new Background();
		main = new Main(this);
		draw();
		step();
		draw();
	}

	public void up() {
		tetr.rot();
		if (!check(tetr.getPosX(), tetr.getPosY())) {
			tetr.resetRot();
		}
	}

	public void down() {
		pause = pausedef / 2;
	}

	public void left() {
		if (check(tetr.getPosX() - 1, tetr.getPosY())) {
			tetr.move(0);
		}

	}

	public void right() {
		if (check(tetr.getPosX() + 1, tetr.getPosY())) {
			tetr.move(2);
		}
	}

	public void hold() {

	}

	public boolean check(int x, int y) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tetr.getForm(i, j) != 0) {
					if (backgr.getaZ(x + i, y - j) != 0 | x + i > 9 | x < 0
							| y - j < 0 | y - j > 19) {// check if out of bounds
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
				if (backgr.getaZ(x, y) != 0) {
			        main.pGame.add(new RectDraw(x*30,y*30,backgr.getColor(x, y)));
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
					backgr.state[tetr.getPosX() + i][tetr.getPosY() - j] = tetr.Form[i][j];
				}
			}
			gentetr();
		}
		pause = pausedef;
	}

	public void gentetr() {
		Random rand = new Random();
		tetr = new Tetrominos(rand.nextInt(7) + 1);
	}
}
