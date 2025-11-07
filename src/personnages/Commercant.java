package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer() {
		int ret = argent;
		argent = 0;
		parler("J'ai tout perdu! Le monde est trop injuste...");
		return ret;
	}
	
	public void recevoir(int argent) {
		this.argent += argent;
		parler(argent + " sous ! Je te remercie généreux donateur!");
	}

}
