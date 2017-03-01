package bowling;

public class ComputeScore {
	
	public static int computeScore(int[] liste) throws IllegalArgumentException{
		// variable pour calcul du score total
		int score = 0;
		// variable de vérification pour le spare
		int[] spareCheck = {0, 0};
		// variables pour spare
		int spareMultiplier = 1;   //multiplicateur
		int multStrike = 1; 
		int strike=10;
		boolean s=false;
		
		for(int i = 0; i < liste.length; ++i) {
			if (liste[i] < 10 && s == false) {
				// on test si il y a eu un spare
				updateSpareCheck(spareCheck, liste[i]);
				//incrémentation du score
				if (previousWasSpare(spareCheck)) {
					spareMultiplier = 2;
					score+=liste[i];
					continue; 
				}
				score+=liste[i]*spareMultiplier;
				spareMultiplier = 1;
			} else {
				s=true;
				score+=liste[i]*multStrike;
				multStrike = 2;				
			}
		}
		return score;
	}
	
	private static boolean verify(int[] liste){
		for(int i = 0; i < liste.length; i++)
			if(liste[i] < 0 || liste[i] > 10) return false;
		return true;
	}
	
	private static void updateSpareCheck(int[] spareCheck, int newVal) {
		spareCheck[0] = spareCheck[1];
		spareCheck[1] = newVal;
	}
	
	private static boolean previousWasSpare(int[] spareCheck) {
		return (spareCheck[0] + spareCheck[1] == 10);
	}
}
