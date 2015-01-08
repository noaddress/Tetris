public class Game {
	Tetrominos tetr;
	Background backgr;

public Game(){
	tetr = new Tetrominos(5);
	backgr = new Background();

	//test3
}
public boolean check(){
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			if(tetr.getForm(i,j)!=0){
				if(backgr.getaZ(tetr.getPosX()+i, tetr.getPosY()-j)!=0|tetr.getPosX()+i>9|tetr.getPosX()<0|tetr.getPosY()-j<0|tetr.getPosY()-j>19){
					return false;
				}
			}
			
		}
	}
	return true;
}
}
