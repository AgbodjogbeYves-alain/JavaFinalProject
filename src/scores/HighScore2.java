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

public class HighScore2 {
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
		ArrayList<BestPlayer> allBest = new ArrayList<BestPlayer>();
		String[] scores;
		for (int i = 0; i < readScores.length-1; i++) {
			System.out.println(readScores[i]);
			scores = readScores[i].split(",");
			int points = Integer.parseInt(scores[2]);
			String name = scores[0];
			if(name!=null){
				allBest.add(new BestPlayer(name,points));
			}

		}
		Collections.sort(allBest,Collections.reverseOrder());
		BestPlayer[] top10 = new BestPlayer[10];
		for (int j = 0; j < 10; j++) {
			top10[j] = allBest.get(j);
		}
		return top10;
	}
}

