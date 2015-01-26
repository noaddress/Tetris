import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;

public class Game {
	/* Spielablauf
	 * Aktion bei Tastendruck
	 * Aufruf anderer Klassen
	 */
	Tetrominos tetr;
	Background backgr;
	Main main;
	Preview prev = new Preview();
	Hold hold = new Hold();
	int pause = 800; // step duration in ms
	int clearedRow = 0;// consecutively cleared --> combo
	int clearedRowInst = 0;// instantly cleared
	int score = 0;
	boolean tetris = false; // for rows at the same time
	boolean p = false;// true when paused
	boolean wait = false;// short pause before setting tetr.
	/*
	 * each tetromino set:1
	 * single line cleared: 5
	 * double line cleared: 15
	 * triple line cleared: 25
	 * tetris (4lines cld): 50
	 * combo bonus: combo nr*10
	 * tetris back2back bonus: 20
	 */
	boolean isHold = false;
	int high = 0;

	public Game() {

		backgr = new Background();
		main = new Main(this);
		gentetr();//generate tetr.
		backgr.init();//initialize background
		gethigh();//read highscore in file
		sethigh(main.setScore(score, high));//display highscore
		while (true) { //periodically exec step
			try {
				if(wait){
					Thread.sleep(100);
				}
				Thread.sleep(pause);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
				step();
			
		}
	}

	public void up() {//rotate tetr.
		if (!p) {// if not paused
			tetr.rot();
			if (!check(tetr.getPosX(), tetr.getPosY())) {// if rotation not
															// possible
				tetr.resetRot(); //reset rotation
			}
			draw();
		}
	}


	public void left() {//move left
		if (!p) {

			if (check(tetr.getPosX() - 1, tetr.getPosY())) {//check if left possible
				tetr.move(0);
			}
			draw();
		}
	}

	public void right() {//move right
		if (!p) {

			if (check(tetr.getPosX() + 1, tetr.getPosY())) {//check if right possible
				tetr.move(2);
			}
			draw();
		}
	}

	public void hold() {//hold
		if (!p) {
			if (!isHold) {// hold possible only once until tetr. set
				isHold = true;
				if (hold.isUsed()) {
					tetr = new Tetrominos(hold.swap(tetr.getForm(2, 1)));// (2|1) is rotation point--> always filled
					for (int x = 0; x < 10; x++) {// draw in hold field
						for (int y = 0; y < 6; y++) {
							main.setPixelhold(x, y, hold.getColor(x, y));
						}
					}
				} else {// first time hold in game
					hold.newSwap(tetr.getForm(2, 1));// (2|1) is rotation point
					for (int x = 0; x < 10; x++) {// draw in hold field
						for (int y = 0; y < 6; y++) {
							main.setPixelhold(x, y, hold.getColor(x, y));
						}
					}
					gentetr();// create new tetr.
				}
			}
		}
	}

	public boolean check(int x, int y) { // check if tetr. position possible
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {// foreach "pixel" of tetr
				if (tetr.getForm(i, j) != 0) {
					if (x + i > 9 | x + i < 0 | y - j < 0 | y - j > 19) {// check if out of bounds
						return false;

					} else if (backgr.getaZ(x + i, y - j) != 0) {// check if already blocked pixel
						return false;
					}
				}
			}
		}
		return true;
	}

	public void draw() {//display background and current tetr.

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 20; y++) {
				main.setPixel(x, y, backgr.getColor(x, y));// foreach on gamefiled print backgr
			}
		}
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (tetr.getForm(x, y) != 0) {
					main.setPixel(x + tetr.getPosX(), tetr.getPosY() - y,
							tetr.getColor(x, y));// print tetr.
				}
			}
		}
	}

	public void step() {
		if (!p) {
			if (check(tetr.getPosX(), tetr.getPosY() - 1)) {// check if step possible
				tetr.move(1);
				wait=false;
			} else {// next round
				if (!wait) {
					wait = true;
				} 
				else{ // set tetr., generate new, add score, speedup
					wait=false;
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							if (tetr.Form[i][j] != 0) {
								backgr.setaZ(tetr.getPosX() + i, tetr.getPosY() - j, tetr.Form[i][j]);

							}
						}
					}
					gentetr();
					score++;
					isHold = false;
					clearedRowInst = 0;
					for (int y = 0; y < 20; y++) {
						if (backgr.checkLine(y)) {
							backgr.delLine(y);
							y--;
							clearedRowInst++;
							score = score + clearedRow * 10;
							clearedRow++;
							speedup(90);
						}
					}
					switch (clearedRowInst) {// check if tetris
					case 0:
						clearedRow = 0;
						break;
					case 1:
						score += 5;
						tetris = false;
						break;
					case 2:
						score += 5;
						tetris = false;
						break;
					case 3:
						score += 5;
						tetris = false;
						break;
					case 4:
						if (tetris) {// additional if 2 tetris back2back
							score += 20;
						}
						score += 20;
						tetris = true;
						break;
					}
					// bonus combo
					speedup(99);// pause 99% as long as before

					sethigh(main.setScore(score, high));
					if (!check(tetr.getPosX(), tetr.getPosY())) {// check if gameover
						gameover();
					}

				}
			}
			draw();
		}
	}

	public void gentetr() {//generate new tetr.
		tetr = new Tetrominos(prev.next());

		for (int x = 0; x < 10; x++) {//draw preview
			for (int y = 0; y < 6; y++) {
				main.setPixelprev(x, y, prev.getColor(x, y));
			}
		}

	}

	public void pause() {//toggle pause
		p = !p;
	}

	public void gameover() {//TODO: gameover screen
		System.exit(0);
	}

	public void speedup(int x) {
		pause = pause * x / 100;
	}

	public void gethigh() {//read highscore from file
		try {
			Scanner scanner = new Scanner(new File("filename.txt"));
			high = scanner.nextInt();
		} catch (FileNotFoundException e) {
			high = 0;
		}
	}

	public void sethigh(int f) {//write highscore to file

		high = f;
		try {
			PrintWriter out = new PrintWriter("filename.txt");
			out.print(Integer.toString(high));
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
