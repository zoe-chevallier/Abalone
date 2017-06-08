package modele;
import java.awt.Color;
import modele.Config.Direction;

public class main {

	public static void main(String[] args) {
		PlateauAbalone jeu = new PlateauAbalone();
		Deplacement dep = new Deplacement();
		Pion p = new Pion(3,8);
		jeu.affichePlateau();
		dep.move_left_1(p,jeu);
		jeu.affichePlateau();
		
	}

}
