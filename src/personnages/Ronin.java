package personnages;

public class Ronin extends Humain {
	int honneur = 1;

	public Ronin(String nom, String boissonPref, int argent) {
		super(nom, boissonPref, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = getArgent() * 1/10;
		parler(beneficiaire.getNom() + " prends ces " + don + " sous.");
		beneficiaire.recevoir(don);
		perdreArgent(don);
	}
	
	public void provoquer(Yakuza adversaire) {
		int force = honneur*2;
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza!");
			gagnerArgent(adversaire.perdre());
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagnerArgent(getArgent());
			perdreArgent(getArgent());
		}
	}
}
