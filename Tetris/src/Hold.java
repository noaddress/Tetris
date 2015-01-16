import java.awt.Color;

public class Hold {
	int[][] Disp = new int[][] {{ 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }};
	int[] Form = new int[] { 0, 0, 0 };

	boolean used;
	int holdPart;
public Hold(){
	used=false;
}
public int swap(int x){
	int temp=holdPart;
	holdPart=x;
	return temp;
	
}
public boolean isUsed(){
	return used;
}
public void newSwap(int x){
	used=true;
	holdPart=x;

}
public void setDisp(){
	Disp = new int[][] {{ 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }, { 0, 0, 0, 0,0,0 }};
	for(int x=0;x<3;x++){
		switch (Form[x]) {
		case 1:// 0
			Disp[x*3+1][2] = 1;
			Disp[x*3+1][3] = 1;
			Disp[x*3+2][2] = 1;
			Disp[x*3+2][3] = 1;
			break;
		case 2:// I
			Disp[x*3+1][1] = 2;
			Disp[x*3+1][2] = 2;
			Disp[x*3+1][3] = 2;
			Disp[x*3+1][4] = 2;
			break;
		case 3:// S
			Disp[x*3+1][3] = 3;
			Disp[x*3+1][4] = 3;
			Disp[x*3+2][2] = 3;
			Disp[x*3+2][3] = 3;
			break;
		case 4:// Z
			Disp[x*3+1][2] = 4;
			Disp[x*3+1][3] = 4;
			Disp[x*3+2][3] = 4;
			Disp[x*3+2][4] = 4;
			break;
		case 5:// L
			Disp[x*3+1][2] = 5;
			Disp[x*3+1][3] = 5;
			Disp[x*3+1][4] = 5;
			Disp[x*3+2][2] = 5;
			break;
		case 6:// J
			Disp[x*3+2][2] = 6;
			Disp[x*3+2][3] = 6;
			Disp[x*3+2][4] = 6;
			Disp[x*3+1][2] = 6;
			break;
		case 7:// T
			Disp[x*3+1][2] = 7;
			Disp[x*3+1][3] = 7;
			Disp[x*3+1][4] = 7;
			Disp[x*3+2][3] = 7;
			break;
		}
		
	}
	
}
public Color getColor(int x, int y){
	switch(Disp[x][y]){
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
