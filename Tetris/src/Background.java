import java.awt.Color;

public class Background{
int[][] state;//10*20, saves background filled with tetr.

public Background(){
	/* Zuständig für gesetzte Tetr.
	 */
	this.init();
	
}
public void setaZ(int x, int y, int color){
	state[x][y]=color;
}

public int getaZ(int x, int y){
	return state[x][y];
}
public void init(){
	state=new int[][] {{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
}

public boolean checkLine(int y){//check if line filled
	for(int i=0;i<10;i++){
		if(state[i][y]==0){
			return false;
		}
	}
	return true;
}

public void delLine(int y){//delete line, moves tiles above 1 line down.
	for (int i=0;i<10;i++){
		for (int j=y;j<19;j++){
			state[i][j]=state[i][j+1];
		}
		state[i][19]=0;
	}
	
}
public Color getColor(int x, int y){//return Color
	switch(state[x][y]){
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