package personnages;

public class Ronin extends Humain {
	int honneur = 1;

	public Ronin(String nom, String boissonPref, int argent) {
		super(nom, boissonPref, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = argent * 1/10;
		parler(beneficiaire.getNom() + " prends ces " + don + " sous.");
		beneficiaire.recevoir(don);
		argent -= don;
	}
}
