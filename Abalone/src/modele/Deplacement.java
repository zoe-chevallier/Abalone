package modele;
import modele.Config.Direction;

public class Deplacement {

	void move_left_1 (Pion p1,PlateauAbalone jeu) 
	{
		jeu.getPlateau()[p1.getX()][p1.getY()-2]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
}
