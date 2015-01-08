public class Tetrominos {
	int[][] Form = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	int[][] Form2 = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	int rot;
	int posX;
	int posY;
	int block;

	public Tetrominos(int x) {
		block = x;
		rot = 0;
		this.posX = 2;
		this.posY = 19;
		switch (x) {
		case 1:// 0
			Form[1][1] = 1;
			Form[1][2] = 1;
			Form[2][1] = 1;
			Form[2][2] = 1;
			break;
		case 2:// I
			Form[0][1] = 2;
			Form[1][1] = 2;
			Form[2][1] = 2;
			Form[3][1] = 2;
			break;
		case 3:// S
			Form[2][1] = 3;
			Form[3][1] = 3;
			Form[1][2] = 3;
			Form[2][2] = 3;
			break;
		case 4:// Z
			Form[1][1] = 4;
			Form[2][1] = 4;
			Form[2][2] = 4;
			Form[3][2] = 4;
			break;
		case 5:// L
			Form[1][1] = 5;
			Form[2][1] = 5;
			Form[3][1] = 5;
			Form[1][2] = 5;
			break;
		case 6:// J
			Form[1][1] = 6;
			Form[2][1] = 6;
			Form[3][1] = 6;
			Form[3][2] = 6;
			break;
		case 7:// T
			Form[1][1] = 7;
			Form[2][1] = 7;
			Form[3][1] = 7;
			Form[2][2] = 7;
			break;
		}

	}

	public void rot() {
		this.rot = (this.rot + 1) % 4;
		if (this.block == 2) {
			if (this.rot % 2 == 0) {
				Form[0][1] = 2;
				Form[1][1] = 2;
				Form[2][1] = 2;
				Form[3][1] = 2;
			} else {
				Form[2][0] = 2;
				Form[2][1] = 2;
				Form[2][2] = 2;
				Form[2][3] = 2;
			}
		} else {
			for(int i=0;i<4;i++){//copy array
				for(int j=0;j<4;j++){
					Form2[i][j]=Form[i][j];
				}
			}
			
			for(int i=0;i<4;i++){//rotate array 90cw
				for(int j=0;j<4;j++){
					Form[3-j][i-1]=Form2[i][j];
				}
			}

		}
	}

	public void move(int x) {// move left=0, down=1, right=2
		switch (x) {
		case 0:// left
			this.posX--;
			break;
		case 1:// down
			this.posY--;
			break;
		case 2:// right
			this.posX++;
			break;
		}
	}

	public int getPosY() {
		return posY;
	}

	public int getPosX() {
		return posX;
	}

	public int getForm(int x, int y) {
		return Form[x][y];
	}

}
