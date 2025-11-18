package personnages;

public class Humain {
	private String nom;
	private String boissonPref;
	private int argent;
	protected int nbConnaissance = 0;
	private static final int MAX = 30;
	protected Humain[] memoire = new Humain[MAX];

	public Humain(String nom, String boissonPref, int argent) {
		super();
		this.nom = nom;
		this.boissonPref = boissonPref;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public String getBoissonPref() {
		return boissonPref;
	}

	public int getArgent() {
		return argent;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour! Je m'appelle " + nom + " et j'aime boire du " + boissonPref + ".");
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonPref + "! GLOUPS!");
	}

	protected void gagnerArgent(int gain) {
		this.argent += gain;
	}

	protected void perdreArgent(int perte) {
		this.argent -= perte;
	}

	public void acheter(String bien, int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent + " en poche. Je vais pouvoir m'offrir un " + bien + " à " + prix + " sous");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à " + prix + " sous");
		}
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaissance < MAX) {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		} else if (nbConnaissance == MAX){
			for (int i = 0; i<nbConnaissance-1; i++) {
				memoire[i] = memoire[i+1];
			}
			memoire[nbConnaissance-1] = humain;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		String noms = "";
		for (int i = 0; i < nbConnaissance; i++) {
			noms += memoire[i].getNom();
			if (i < nbConnaissance-1) {
				noms += ", ";
			}
		}
		parler("Je connais beaucoup de monde dont: " + noms);
	}

}

