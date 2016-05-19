package scores;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author Othniel Agbodjogbe and Nicolas Zambrano
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class HighScore4 {
	/**
	 * 
	 * @return Array of String 
	 * it's an array of scores from the csv on thinkspeak
	 */
	public String[] getScores(){
		try{
			String url = "https://api.thingspeak.com/channels/112126/feeds.csv"; //url de notre channel

			URL obj = new URL(url); //creation d'un objet URL
			HttpURLConnection con = (HttpURLConnection) obj.openConnection(); //ouverture de la connexion
			int responseCode = con.getResponseCode(); //demande d'un get sur la connexion
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); //lecture du flux de la connexion
			String inputLine=in.readLine(); //lecture du resultat
			String[] scores=new String[100];
			int n = 0;
			while ((inputLine = in.readLine()) != null) {
				scores[n]=inputLine;
				n++;
			}
			//affectation du tableau de score dans un tableau avec la bonne longueur;
			String[] score=new String [n-1];
			for(int i=0;i<n-1;i++){
				score[i]=scores[i];
			}
			return score;

		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}


	public BestPlayer[] tenBestScores(String[] readScores){
		String name;
		ArrayList<BestPlayer> allBest = new ArrayList<BestPlayer>();
		for (String ligne : readScores) {
			String[] score = ligne.split(",");
			if(score.length!=1){
				if(score.length==4){
					name = score[3];
				}else{
					name="";
				}
				int playerScore = Integer.parseInt(score[2]);
				/* Creating BestPlayer object*/
				BestPlayer p = new BestPlayer(name, playerScore);
				allBest.add(p);
			}
		}
		Collections.sort(allBest,Collections.reverseOrder());
		BestPlayer[] top10 = new BestPlayer[10];
		int i=0;
		while(i < 10 && i < allBest.size()){
			top10[i] = allBest.get(i);
			i++;
		}//end while: i==10 or i==allBest.size()

		return top10;
	}

	public void sendScores(BestPlayer p){
		try{
			String url = "https://api.thingspeak.com/update?api_key=84ZFWY283ES507G8&field1="+ p.getScore() +"&field2=" + p.getName(); //url de notre channel

			URL obj = new URL(url); //creation d'un objet URL
			HttpURLConnection con = (HttpURLConnection) obj.openConnection(); //ouverture de la connexion
			int responseCode = con.getResponseCode(); //demande d'un get sur la connexion

		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}

