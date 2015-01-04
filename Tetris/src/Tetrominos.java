import java.awt.Color;

public class Tetrominos {
	Color color;
	int[][] Form = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	int rot;
	int posX;
	int posY;
	int block;

	public Tetrominos(int x, int posX) {
		block = x;
		rot=0;
		this.posX=posX;
		this.posY=0;
		switch (x) {
		case 0:// 0
			Form[1][1] = 1;
			Form[1][2] = 1;
			Form[2][1] = 1;
			Form[2][2] = 1;
			color = Color.blue;
			break;
		case 1:// I
			Form[0][1] = 1;
			Form[1][1] = 1;
			Form[2][1] = 1;
			Form[3][1] = 1;
			color = Color.red;
			break;
		case 2:// S
			Form[2][1] = 1;
			Form[3][1] = 1;
			Form[1][2] = 1;
			Form[2][2] = 1;
			color = Color.green;
			break;
		case 3:// Z
			Form[1][1] = 1;
			Form[2][1] = 1;
			Form[2][2] = 1;
			Form[3][2] = 1;
			color = Color.cyan;
			break;
		case 4:// L
			Form[1][1] = 1;
			Form[2][1] = 1;
			Form[3][1] = 1;
			Form[1][2] = 1;
			color = Color.orange;
			break;
		case 5:// J
			Form[1][1] = 1;
			Form[2][1] = 1;
			Form[3][1] = 1;
			Form[3][2] = 1;
			color = Color.gray;
			break;
		case 6:// T
			Form[1][1] = 1;
			Form[2][1] = 1;
			Form[3][1] = 1;
			Form[2][2] = 1;
			color = Color.yellow;
			break;
		}

	}

	public void rot(int x) {// rotate left =0, right=1

	}

	public void move(int x) {// move left=0, down=1, right=2

	}

	public int getPosY() {
		return posY;
	}

	public int getPosX() {
		return posX;
	}

	public int[][] getForm() {
		return Form;
	}

	public Color getColor() {
		return color;
	}
}
