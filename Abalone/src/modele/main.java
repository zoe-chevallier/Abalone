package modele;
import java.awt.Color;
import modele.Config.Possible;
import modele.Config.Direction;

public class main {

	public static void main(String[] args) {
		
		PlateauAbalone jeu = new PlateauAbalone();
		Deplacement dep = new Deplacement();
		Pion p1 = new Pion(3,8);
		Pion p2 = new Pion(3,10);
		jeu.affichePlateau();
		dep.move_left_2(p1,p2,jeu,Possible.LINE);
		jeu.affichePlateau();
		
	}

}
