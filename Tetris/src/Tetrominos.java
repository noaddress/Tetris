import java.awt.Color;

public class Tetrominos { 
	/* Zuständig für Eigenschaften des aktiven Tetr.
	 */
	int[][] Form = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } };// Define form and color of tetr.
	int[][] Form2 = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	int rot;
	int posX;//0=left
	int posY;//0=up 
	int block;

	public Tetrominos(int x) {//define form and color
		block = x;
		rot = 0;
		this.posX = 2;	//startpoint
		this.posY = 20;	//of new tetr.
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

	public void rot() {//rotate current tetr.
		this.rot = (this.rot + 1) % 4;
		for(int i=0;i<4;i++){//copy array
			for(int j=0;j<4;j++){
				Form2[i][j]=Form[i][j];
			}
		}
		if (this.block == 2) {
			if (this.rot % 2 == 0) {

				Form[2][0] = 0;
				Form[2][1] = 0;
				Form[2][2] = 0;
				Form[2][3] = 0;
				Form[0][1] = 2;
				Form[1][1] = 2;
				Form[2][1] = 2;
				Form[3][1] = 2;
			} else {

				Form[0][1] = 0;
				Form[1][1] = 0;
				Form[2][1] = 0;
				Form[3][1] = 0;
				Form[2][0] = 2;
				Form[2][1] = 2;
				Form[2][2] = 2;
				Form[2][3] = 2;
			}
		} else {
			
			for(int i=1;i<4;i++){//rotate array 90cw
				for(int j=0;j<3;j++){
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
	public void resetRot() {//reset rotation previousely done.
		for(int i=0;i<4;i++){//copy array
			for(int j=0;j<4;j++){
				Form[i][j]=Form2[i][j];
			}
		}
	}
	public Color getColor(int x, int y){//return color
		switch(Form[x][y]){
		case 1:
			return new Color(255, 250, 0);
		case 2:
			return Color.cyan;
		case 3:
			return Color.green;
		case 4:
			return Color.red;
		case 5:
			return Color.orange;
		case 6:
			return Color.blue;
		case 7:
			return Color.pink;
		}
		

	return Color.black;
	}

}
