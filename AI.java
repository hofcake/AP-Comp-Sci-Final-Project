public class AI
{
  
  public int play(){
	int coords = 0;
	if (defense() != 0){
		coords = defense();
	}
	else if (offense != 0){
		coords = offense();
	}
	else{
		coords = 01;
	}
}
	
	public int defense(){
	if (gameBoard.checkForAlmost(1) != 0){
		int coordinates = gameBoard.checkForAlmost(1);
		return coordinates;
	}
		else{
			return 0;}
}
	public int offense(){
	if (gameBoard.checkForAlmost(2) != 0){
		int coordinates = gameBoard.checkForAlmost(2);
		return coordinates;
	}
		else{
			return 0;}
	}
}
