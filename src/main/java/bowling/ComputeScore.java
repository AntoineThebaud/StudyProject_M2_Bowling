package bowling;

public class ComputeScore {
	
	public static int computeScore(int[] liste) throws IllegalArgumentException{
		// variable pour calcul du score total
		int score = 0;
		// variables pour spare
		int[] spareCheck = {-1, -1};	//vérification
		int spareMultiplier = 1;		//multiplicateur
		// variables pour strike
		int strikeCheck = 0;			//vérification
		int strikeMultiplier = 1;		//multiplicateur
		
		for(int i = 0; i < liste.length; ++i) {
			if (notValid(liste[i])) throw new IllegalArgumentException();
			// mise à jour des variables de vérif
			spareCheck = updateSpareCheck(spareCheck, liste[i]);
			strikeCheck = updateStrikeCheck(strikeCheck, liste[i]);
			//incrémentation du score
			score += liste[i] * spareMultiplier * strikeMultiplier;
			// mise à jour des multiplicateurs pour le(s) prochain(s) lancer(s)
			spareMultiplier = (isSpare(spareCheck) ? 2 : 1);
			strikeMultiplier = (isStrike(strikeCheck) ? 2 : 1);
		}
		return score;
	}
	
	private static boolean notValid(int val) {
		return (val < 0 || val > 10);
	}

	private static boolean verify(int[] liste){
		for(int i = 0; i < liste.length; i++)
			if(liste[i] < 0 || liste[i] > 10) return false;
		return true;
	}
	
	private static int[] updateSpareCheck(int[] spareCheck, int val) {
		//garde les deux derniers lancers en mémoire
		spareCheck[0] = spareCheck[1];
		spareCheck[1] = val;
		return spareCheck;
	}
	
	private static boolean isSpare(int[] spareCheck) {
		//cas particulier à gérer : 10 suivi d'un 0 n'est pas un spare
		return (spareCheck[0] + spareCheck[1] == 10
				&& !(spareCheck[0] == 10 && spareCheck[1] == 0));
	}
	
	private static int updateStrikeCheck(int strikeCheck, int val) {
		if (val == 10) {
			strikeCheck = 2;
		} 
		else if(strikeCheck > 0 
				//cas particulier à gérer : le multiplicateur est conservé tant qu'on fait des 0
				&& val != 0) {
			strikeCheck--;
		}
		return strikeCheck;
	}
	
	private static boolean isStrike(int strikeCheck) {
		return (strikeCheck > 0);
	}
}
