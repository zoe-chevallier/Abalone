package modele;
import java.awt.Color;
import modele.Config.Direction;

public class main {

	public static void main(String[] args) {
		PlateauAbalone jeu = new PlateauAbalone();
		
		Joueur j1 = new Joueur("Zoe", Color.black);
		Joueur j2 = new Joueur("Adja", Color.white);
		jeu.affichePlateau(j1,j2);
		Pion p = new Pion(7,3,j1);
		Deplacement dep = new Deplacement(p,Direction.LEFT,j1);
		System.out.println();
		jeu.affichePlateau(j1,j2);
		System.out.println(j1.getListePions());
		
	}

}
