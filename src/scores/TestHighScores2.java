package scores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 * TestHighScores class part 2
 * @author Yves-alain Agbodjogbe and Nicolas Zambrano
 *
 */
public class TestHighScores2 {
	/**
	 * Procedure de recuperation de nom et de scores sur Thinkspeak
	 * @param args 
	 * Ne prend aucun arguments
	 */
	public static void main(String[] args){
		HighScore2 highScore2 = new HighScore2();
		String[] hs2=highScore2.getScores();

		System.out.println("Meilleurs scores :");
		for(int i=0;i<hs2.length;i++){
            System.out.println(hs2[i]);
		}
		System.out.println("Bonjour, veuillez inserer un nom de joueur s'il vous plait");
		Scanner scan = new Scanner(System.in);
		String playerName = scan.nextLine();
		String [] scores=new String[100];

	      // Nous déclarons nos objets en dehors du bloc try/catch

	         // On instancie nos objets :
	         // FileReader va ouvrir le fichier
					 // BufferedReader va lire le fichier
		try {
	    	  FileReader fichier = new FileReader("scoreSamples.txt");
	    	  BufferedReader readFile  = new BufferedReader(fichier);
	         String ligne;
	         int n = 0;

	         // Tant que l'affectation dans la variable est possible, on boucle
	         // Lorsque la lecture du fichier est termin�e l'affectation n'est
	         // plus possible !
	         // On sort donc de la boucle
	         while ((ligne = readFile.readLine()) != null) {
	               scores[n]=ligne;
	               n++;
	         }
					 //fermeture du fichier
	         readFile.close();
	         fichier.close();
	         System.out.println("Copie terminée !");


			//random pour trouver une case aleatoire du tableau de scores
	         int aleat = (int) (Math.random()*n);
	         System.out.println("Player : "+playerName+" Score : "+scores[aleat]);
		} catch (Exception e) {
			e.printStackTrace();
			}
		//Partie 2 projet
		BestPlayer[] toplayer = highScore2.tenBestScores(hs2);
		for(BestPlayer playerB : toplayer) {
			
			if (playerB != null){
				System.out.println(playerB.player);
	}
  }
 }
}
