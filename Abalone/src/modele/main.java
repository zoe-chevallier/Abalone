package modele;
import java.awt.Color;
import modele.Config.Possible;
import modele.Config.Direction;
import modele.Config.PositionDepart;

public class main {

	public static void main(String[] args) {
		Joueur j1 = new Joueur("Zoé", Color.BLACK);
		Joueur j2 = new Joueur("Baptiste",Color.WHITE);
		PlateauAbalone jeu = new PlateauAbalone(PositionDepart.STANDARD,j1,j2);
		Deplacement dep = new Deplacement();
		Possible pos;
		Pion p1 = new Pion(9,10);
		Pion p2 = new Pion(0,0);
		Pion p3 = new Pion(0,0);
		
		jeu.affichePlateau();
		/*pos = dep.move_possible(p1, p2, p3, Direction.LEFT, jeu.getPlateau(), j1);
		System.out.println(pos);
		if (pos != Possible.IMPOSSIBLE)
			dep.move(p1, p2, p3, Direction.LEFT, jeu.getPlateau(), pos, j1);*/
		
		
		Ia ia = new Ia(jeu);
		ia.test_ia();
		
	}

}
