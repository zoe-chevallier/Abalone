package modele;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import modele.Config.Possible;
import modele.Config.Direction;
import modele.Config.PositionDepart;

public class main {

	public static void main(String[] args) throws SQLException {
		Joueur j1 = new Joueur("Zoé", Color.BLACK);
		Joueur j2 = new Joueur("Baptiste",Color.WHITE);
		PlateauAbalone jeu = new PlateauAbalone(PositionDepart.STANDARD,j1,j2,0);
		Deplacement dep = new Deplacement();
		Possible pos;
		
		
		
		jeu.affichePlateau();
		Pion p1 = new Pion(1,8);
		Pion p2 = new Pion(2,9);
		Pion p3 = new Pion(3,10);
		pos = dep.move_possible(p1, p2, p3, Direction.DOWNRIGHT, jeu.getPlateau(), 2);
		System.out.println(pos);
		if (pos != Possible.IMPOSSIBLE)
			dep.move(p1, p2, p3, Direction.DOWNRIGHT, jeu.getPlateau(), pos);
		jeu.affichePlateau();
		
		
		/*Ia ia = new Ia(jeu);
		ia.test_ia();*/
		
		
		
		
		
	}

}
