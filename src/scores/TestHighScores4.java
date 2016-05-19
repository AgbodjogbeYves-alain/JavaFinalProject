package scores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TestHighScores4 {
	/**
	 * Procedure de recuperation de nom et de scores sur Thinkspeak
	 * @param args 
	 * Ne prend aucun arguments
	 */
	public static void main(String[] args){
		HighScore4 highScore4 = new HighScore4();
		String[] hs4=highScore4.getScores();
		System.out.println("Meilleurs scores :");
		hs4=highScore4.getScores();
		Scanner scan = new Scanner(System.in);
		BestPlayer[] topPlayer = highScore4.tenBestScores(hs4);
		for(BestPlayer playerB : topPlayer) {

			if (playerB != null){
				System.out.println(playerB.getName()+" : "+playerB.getScore());
			}
		}	
		System.out.println("Bonjour, voulez-vous jouer une partie ? oui/non");
		String play = scan.nextLine();
		while(play.equals("oui")){
		System.out.println("veuillez inserer un nom de joueur s'il vous plait");
		
		String playerName = scan.nextLine();
		String [] scores=new String[100];

		// Nous dÃ©clarons nos objets en dehors du bloc try/catch

		// On instancie nos objets :
		// FileReader va ouvrir le fichier
		// BufferedReader va lire le fichier
		try {
			FileReader fichier = new FileReader("scoreSamples.txt");
			BufferedReader readFile  = new BufferedReader(fichier);
			String ligne;
			int n = 0;

			// Tant que l'affectation dans la variable est possible, on boucle
			// Lorsque la lecture du fichier est terminï¿½e l'affectation n'est
			// plus possible !
			// On sort donc de la boucle
			while ((ligne = readFile.readLine()) != null) {
				scores[n]=ligne;
				n++;
			}
			//fermeture du fichier
			readFile.close();
			fichier.close();
			System.out.println("Copie terminÃ©e !");


			//random pour trouver une case aleatoire du tableau de scores
			int aleat = (int) (Math.random()*n);
			System.out.println("Player : "+playerName+" Score : "+scores[aleat]);


			//Partie 2 projet
			System.out.println("Anciens scores :");
			System.out.println();
			topPlayer = highScore4.tenBestScores(hs4);
			boolean inTop=false;
			BestPlayer player=new BestPlayer(playerName,Integer.parseInt(scores[aleat]));
			for(BestPlayer playerB : topPlayer) {

				if (playerB != null){
					if(playerB.getScore()<player.getScore()){
						inTop=true;
					}
					System.out.println(playerB.getName()+" : "+playerB.getScore());
				}
			}	
			if(inTop){
				System.out.println();
				System.out.println("Félicitation votre score de "+player.getScore()+" vous permet de figurer dans le top 10 !");
				highScore4.sendScores(player);
				System.out.println();
				System.out.println("Nouveaux scores :");
				System.out.println();
				hs4=highScore4.getScores();
				topPlayer = highScore4.tenBestScores(hs4);
				for(BestPlayer playerB : topPlayer) {

					if (playerB != null){
						System.out.println(playerB.getName()+" : "+playerB.getScore());
					}
				}	
			}else{
				System.out.println();
				System.out.println("Désolé votre score de "+player.getScore()+" ne vous permet pas de figurer dans le top 10 !");

			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("voulez-vous rejouer une partie ? oui/non");
		play = scan.nextLine();

	}
		System.out.println();
		System.out.println("Merci d'avoir joué avec nous ! bonne journée !");

		}
}
