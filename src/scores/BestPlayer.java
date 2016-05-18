package scores;

import java.util.ArrayList;

public class BestPlayer {
	String player;
	int score;
	
	public BestPlayer(String player,int score){
		this.player = player;
		this.score = score;
	}
	
	public int compareTo(BestPlayer bp){
		
		int result = 0;
		if (this.score == bp.score){
			result = 0;
		}
		else if(this.score < bp.score ){
			result =-1;
		}
		else{
			result = 1;
		}
		return result ;
	}
	
	 
	
	
}
