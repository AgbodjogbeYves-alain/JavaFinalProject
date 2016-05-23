package scores;

import java.util.ArrayList;

/**
 * Best Player Class
 * @author Agbodjogbe Yves-alain and Nicolas Zaambrano
 *
 */
public class BestPlayer  implements Comparable<BestPlayer>{
	String player;
	int score;
	
	/**
	 * Constructor
	 * @param player String
	 * @param score Int
	 */
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

	/**
	 * Function for get the name of a player
	 * @return name string
	 */
	public String getName() {
		return player;
	}

	/**
	 * Function for get the score of a player
	 * @return score int
	 */
	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}
	
	 
	
	
}
