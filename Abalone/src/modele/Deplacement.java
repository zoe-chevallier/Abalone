package modele;
import modele.Config.Direction;
import modele.Config.Possible;

public class Deplacement {
	
	void move_1(Pion p1, Direction dir,PlateauAbalone jeu)
	{
		switch(dir)
		{
			case LEFT : move_left_1( p1,jeu); 
				break;
			case RIGHT : move_right_1( p1,jeu); 
				break;
			case UPLEFT : move_up_left_1( p1,jeu); 	
				break;
			case UPRIGHT : move_up_right_1( p1,jeu); 
				break;
			case DOWNLEFT : move_down_left_1( p1,jeu); 
				break;
			case DOWNRIGHT : move_down_right_1( p1,jeu); 
				break;
			default : break;
		}
	}
	void move_left_1 (Pion p1,PlateauAbalone jeu) 
	{
		jeu.getPlateau()[p1.getX()][p1.getY()-2]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
	void move_right_1 (Pion p1,PlateauAbalone jeu)
	{
		jeu.getPlateau()[p1.getX()][p1.getY()+2]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
	void move_up_left_1 (Pion p1,PlateauAbalone jeu)
	{
		jeu.getPlateau()[p1.getX()-1][p1.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
	void move_up_right_1 (Pion p1,PlateauAbalone jeu)	
	{			      
		jeu.getPlateau()[p1.getX()-1][p1.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
	void move_down_left_1 (Pion p1,PlateauAbalone jeu)
	{
		jeu.getPlateau()[p1.getX()+1][p1.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}

	void move_down_right_1 (Pion p1,PlateauAbalone jeu)
	{
		jeu.getPlateau()[p1.getX()+1][p1.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
	/*void move_2( COORD p1, COORD p2, MOVEMENT mov, POSSIBLE alignment,CASE T[11][21],BOOL butter)
	{
		switch(mov)
		{
			case left : move_left_2( p1, p2, alignment,T, butter); 
				break;
			case right : move_right_2( p1, p2, alignment,T, butter); 
				break;
			case up_left : move_up_left_2( p1, p2, alignment,T, butter); 	
				break;
			case up_right : move_up_right_2( p1, p2, alignment,T, butter); 
				break;
			case down_left : move_down_left_2( p1, p2, alignment,T, butter); 
				break;
			case down_right : move_down_right_2( p1, p2, alignment,T, butter); 
				break;
			default : break;
		}
	}*/
	
void move_left_2 (Pion p1,Pion p2,PlateauAbalone jeu,Possible al)
	{
		if (al != LINE)
		{
			jeu.getPlateau()[p1.getX()][p1.getY()-2]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()][p2.getY()-2]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
		}
		else
		{
			if (p2.getY() < p1.getY())
			{
				int x=p1.getX(); 	int y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
				}
			if (jeu.getPlateau()[p1.getX()][p1.getY()-2] != 0)
			{
				if (jeu.getPlateau()[p1.getX()][p1.getY()-4] == 0)
				{
					jeu.getPlateau()[p1.getX()][p1.getY()-4]=jeu.getPlateau()[p1.getX()][p1.getY()-2];
				}
				/*else if(!butter)
				{
					score[current_player-1]++;
					display_pawn_eject(current_player, score);
				}*/
			}
			jeu.getPlateau()[p1.getX()][p1.getY()-2]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
		}
	}
}
