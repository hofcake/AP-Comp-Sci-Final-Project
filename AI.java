public class AI
{
  
  public int play(){
	int coords = 0;
	if (defense() != 0){
		coords = defense();
	}
}
	
	public int defense(){
	if (gameBoard.checkForAlmost(1) != 0){
		int coordinates = gameBoard.checkForAlmost(1);
		return coordinates;
	}
		else{return 0;}
}
}
