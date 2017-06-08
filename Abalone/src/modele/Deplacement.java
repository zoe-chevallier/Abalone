package modele;
import modele.Config.Direction;
import modele.Config.Possible;

public class Deplacement {
	
	public Possible move_possible_1(Pion p1, Direction dir,PlateauAbalone jeu)
	{

		switch(dir)
		{
			case LEFT : return move_possible_left_1(p1,jeu); 
			case RIGHT : return move_possible_right_1(p1,jeu); 
			case UPLEFT : return move_possible_up_left_1(p1,jeu); 	
			case UPRIGHT : return move_possible_up_right_1(p1,jeu); 
			case DOWNLEFT : return move_possible_down_left_1(p1,jeu); 
			case DOWNRIGHT : return move_possible_down_right_1(p1,jeu); 
			default : return Possible.IMPOSSIBLE;
		}

			
	}
	public Possible move_possible_left_1(Pion p1,PlateauAbalone jeu)
	{
		if (jeu.getPlateau()[p1.getX()][p1.getY()-2]==0) return	Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}
	
	public Possible move_possible_right_1(Pion p1,PlateauAbalone jeu)
	{
		if (jeu.getPlateau()[p1.getX()][p1.getY()+2]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_left_1(Pion p1,PlateauAbalone jeu)
	{
		if (jeu.getPlateau()[p1.getX()-1][p1.getY()-1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_right_1(Pion p1,PlateauAbalone jeu)
	{
		if (jeu.getPlateau()[p1.getX()-1][p1.getY()+1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_left_1(Pion p1,PlateauAbalone jeu)
	{
		if (jeu.getPlateau()[p1.getX()+1][p1.getY()-1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_right_1(Pion p1,PlateauAbalone jeu)
	{
		if (jeu.getPlateau()[p1.getX()+1][p1.getY()+1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}
	
	public void move_1(Pion p1, Direction dir,PlateauAbalone jeu)
	{
		switch(dir)
		{
			case LEFT : move_left_1(p1,jeu); 
				break;
			case RIGHT : move_right_1(p1,jeu); 
				break;
			case UPLEFT : move_up_left_1(p1,jeu); 	
				break;
			case UPRIGHT : move_up_right_1(p1,jeu); 
				break;
			case DOWNLEFT : move_down_left_1(p1,jeu); 
				break;
			case DOWNRIGHT : move_down_right_1(p1,jeu); 
				break;
			default : break;
		}
	}
	public void move_left_1 (Pion p1,PlateauAbalone jeu) 
	{
		jeu.getPlateau()[p1.getX()][p1.getY()-2]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
	public void move_right_1 (Pion p1,PlateauAbalone jeu)
	{
		jeu.getPlateau()[p1.getX()][p1.getY()+2]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
	public void move_up_left_1 (Pion p1,PlateauAbalone jeu)
	{
		jeu.getPlateau()[p1.getX()-1][p1.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
	public void move_up_right_1 (Pion p1,PlateauAbalone jeu)	
	{			      
		jeu.getPlateau()[p1.getX()-1][p1.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	
	public void move_down_left_1 (Pion p1,PlateauAbalone jeu)
	{
		jeu.getPlateau()[p1.getX()+1][p1.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}

	public void move_down_right_1 (Pion p1,PlateauAbalone jeu)
	{
		jeu.getPlateau()[p1.getX()+1][p1.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
		jeu.getPlateau()[p1.getX()][p1.getY()]=0;
	}
	public Possible move_possible_2(Pion p1,Pion p2, Direction dir,PlateauAbalone jeu)
	{

		switch(dir)
		{
			case LEFT : return move_possible_left_2(p1,p2,jeu); 
			case RIGHT : return move_possible_right_2(p1,p2,jeu); 
			case UPLEFT : return move_possible_up_left_2(p1,p2,jeu); 	
			case UPRIGHT : return move_possible_up_right_2(p1,p2,jeu); 
			case DOWNLEFT : return move_possible_down_left_2(p1,p2,jeu); 
			case DOWNRIGHT : return move_possible_down_right_2(p1,p2,jeu); 
			default : return Possible.IMPOSSIBLE;
		}

			
	}
	public Possible move_possible_left_2(Pion p1,Pion p2,PlateauAbalone jeu)
	{
		if (p1.getY() < p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la m�me lignes, on verrifie donc s'il y a un sumito ou si la case � gauche est vide.
		{
			if ((jeu.getPlateau()[p1.getX()][p2.getY()-2]==0) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p1.getX()][p2.getY()-2]==2))||(/*(player==player2) && */(jeu.getPlateau()[p1.getX()][p2.getY()-2]==1))) && ((jeu.getPlateau()[p1.getX()][p2.getY()-4]==0) || (jeu.getPlateau()[p1.getX()][p2.getY()-4]==3))) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ( (jeu.getPlateau()[p1.getX()][p1.getY()-2]==0) && (jeu.getPlateau()[p2.getX()][p2.getY()-2]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ( (jeu.getPlateau()[p1.getX()][p1.getY()-2]==0) && (jeu.getPlateau()[p2.getX()][p2.getY()-2]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_right_2(Pion p1,Pion p2,PlateauAbalone jeu)
	{
		if (p1.getY() > p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la m�me lignes, on verrifie donc s'il y a un sumito ou si la case � gauche est vide.
		{
			if ((jeu.getPlateau()[p1.getX()][p2.getY()+2]==0) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p1.getX()][p2.getY()+2]==2))||(/*(player==player2) && */(jeu.getPlateau()[p1.getX()][p2.getY()+2]==1))) && ((jeu.getPlateau()[p1.getX()][p2.getY()+4]==0) || (jeu.getPlateau()[p1.getX()][p2.getY()+4]==3))) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ( (jeu.getPlateau()[p1.getX()][p1.getY()+2]==0) && (jeu.getPlateau()[p2.getX()][p2.getY()+2]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ( (jeu.getPlateau()[p1.getX()][p1.getY()+2]==0) && (jeu.getPlateau()[p2.getX()][p2.getY()+2]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_left_2( Pion p1, Pion p2,PlateauAbalone jeu)
	{
		if (p1.getY() > p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX())  //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � gauche sont vides.
		{
			if ( (jeu.getPlateau()[p1.getX()-1][p1.getY()-1]==0) && (jeu.getPlateau()[p2.getX()-1][p2.getY()-1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ( (jeu.getPlateau()[p1.getX()-1][p1.getY()-1]==0) && (jeu.getPlateau()[p2.getX()-1][p2.getY()-1]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ( (jeu.getPlateau()[p2.getX()-1][p2.getY()-1]==0) || (((/*(player==player1) && */(jeu.getPlateau()[p2.getX()-1][p2.getY()-1]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p2.getX()-1][p2.getY()-1]==1))) && ((jeu.getPlateau()[p2.getX()-2][p2.getY()-2]==0) || (jeu.getPlateau()[p2.getX()-2][p2.getY()-2]==3))) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_right_2( Pion p1, Pion p2,PlateauAbalone jeu)
	{
		if (p1.getY() < p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX())  //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � droite sont vides.
		{
			if ( (jeu.getPlateau()[p1.getX()-1][p1.getY()+1]==0) && (jeu.getPlateau()[p2.getX()-1][p2.getY()+1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) ) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) ) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ( (jeu.getPlateau()[p1.getX()-1][p1.getY()+1]==0) && (jeu.getPlateau()[p2.getX()-1][p2.getY()+1]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) ) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ( (jeu.getPlateau()[p2.getX()-1][p2.getY()+1]==0) || (((/*(player==player1) && */(jeu.getPlateau()[p2.getX()-1][p2.getY()+1]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p2.getX()-1][p2.getY()+1]==1))) && ((jeu.getPlateau()[p2.getX()-2][p2.getY()+2]==0) || (jeu.getPlateau()[p2.getX()-2][p2.getY()+2]==3))) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_left_2( Pion p1, Pion p2,PlateauAbalone jeu)
	{
		if (p1.getY() < p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en bas � gauche sont vides.
		{
			if ( (jeu.getPlateau()[p1.getX()+1][p1.getY()-1]==0) && (jeu.getPlateau()[p2.getX()+1][p2.getY()-1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) ) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) ) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ( (jeu.getPlateau()[p1.getX()+1][p1.getY()-1]==0) && (jeu.getPlateau()[p2.getX()+1][p2.getY()-1]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) ) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p2.getX()+1][p2.getY()-1]==0) || (((/*(player==player1) && */(jeu.getPlateau()[p2.getX()+1][p2.getY()-1]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p2.getX()+1][p2.getY()-1]==1))) && ((jeu.getPlateau()[p2.getX()+2][p2.getY()-2]==0) || (jeu.getPlateau()[p2.getX()+2][p2.getY()-2]==3))) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_right_2( Pion p1, Pion p2,PlateauAbalone jeu)
	{
		if (p1.getY() > p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � gauche sont vides.
		{
			if ( (jeu.getPlateau()[p1.getX()+1][p1.getY()+1]==0) && (jeu.getPlateau()[p2.getX()+1][p2.getY()+1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1)  ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1)  )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ( (jeu.getPlateau()[p1.getX()+1][p1.getY()+1]==0) && (jeu.getPlateau()[p2.getX()+1][p2.getY()+1]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p2.getX()+1][p2.getY()+1]==0) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p2.getX()+1][p2.getY()+1]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p2.getX()+1][p2.getY()+1]==1))) && ((jeu.getPlateau()[p2.getX()+2][p2.getY()+2]==0) || (jeu.getPlateau()[p2.getX()+2][p2.getY()+2]==3))) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}
	
	public void move_2(Pion p1, Pion p2, Direction dir,PlateauAbalone jeu, Possible alignment)
	{
		switch(dir)
		{
			case LEFT : move_left_2( p1, p2,jeu, alignment); 
				break;
			case RIGHT : move_right_2( p1, p2,jeu, alignment); 
				break;
			case UPLEFT : move_up_left_2(p1, p2,jeu, alignment); 	
				break;
			case UPRIGHT : move_up_right_2( p1, p2,jeu, alignment); 
				break;
			case DOWNLEFT : move_down_left_2( p1, p2,jeu, alignment); 
				break;
			case DOWNRIGHT : move_down_right_2( p1, p2,jeu, alignment); 
				break;
			default : break;
		}
	}
	
	public void move_left_2 (Pion p1,Pion p2,PlateauAbalone jeu,Possible al)
	{
		if (al != Possible.LINE)
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
				int x=p1.getX(); 	
				int y=p1.getY();
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
	public void move_right_2 (Pion p1,Pion p2,PlateauAbalone jeu,Possible alignment)
	{	
		int x,y;
		if (alignment != Possible.LINE)
		{
			jeu.getPlateau()[p1.getX()][p1.getY()+2]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()][p2.getY()+2]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
		}
		else
		{
			if (p2.getY() < p1.getY())
			{
				x=p1.getX(); 	y=p1.getY();
				p1.setX(p2.getX());  
				p1.setY(p2.getY());
				p2.setX(x);     
				p2.setY(y);
			}
			if (jeu.getPlateau()[p2.getX()][p2.getY()+2] != 0)
			{
				if (jeu.getPlateau()[p2.getX()][p2.getY()+4] == 0)
				{
					jeu.getPlateau()[p2.getX()][p2.getY()+4]=jeu.getPlateau()[p2.getX()][p2.getY()+2];
				}
				/*else if(!butter)
				{
					score[current_player-1]++;
					display_pawn_eject(current_player, score);
				}*/
			}
			jeu.getPlateau()[p2.getX()][p2.getY()+2]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_up_left_2 (Pion p1, Pion p2,PlateauAbalone jeu,Possible alignment)
	{
		int x,y;
		if (alignment == Possible.LINE || alignment==Possible.DL) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			jeu.getPlateau()[p1.getX()-1][p1.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()-1][p2.getY()-1]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getX() < p1.getX())
			{
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (jeu.getPlateau()[p1.getX()-1][p1.getY()-1] != 0)
			{
				if (jeu.getPlateau()[p1.getX()-2][p1.getY()-2] == 0)
				{
					jeu.getPlateau()[p1.getX()-2][p1.getY()-2]=jeu.getPlateau()[p1.getX()-1][p1.getY()-1];
				}
				/*else if(!butter)
				{
					score[current_player-1]++;
					display_pawn_eject(current_player, score);
				}*/
			}
			jeu.getPlateau()[p1.getX()-1][p1.getY()-1]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
		}	
	}
	
	public void move_up_right_2 (Pion p1, Pion p2,PlateauAbalone jeu,Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment == Possible.DR) 
		//Cas o� on les pions se trouvent sur la m�me ligne, ou en diagonale (pas sumito)
		{
			jeu.getPlateau()[p1.getX()-1][p1.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()-1][p2.getY()+1]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getY() < p1.getY())
			{
				x=p1.getX(); 	y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (jeu.getPlateau()[p2.getX()-1][p2.getY()+1] != 0)
			{
				if (jeu.getPlateau()[p2.getX()-2][p2.getY()+2] == 0)
				{
					jeu.getPlateau()[p2.getX()-2][p2.getY()+2]=jeu.getPlateau()[p2.getX()-1][p2.getY()+1];
				}
				/*else if(!butter)
				{
					score[current_player-1]++;
					display_pawn_eject(current_player, score);
				}*/
			}
			jeu.getPlateau()[p2.getX()-1][p2.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
		}	
	}
	
	public void move_down_left_2 (Pion p1, Pion p2,PlateauAbalone jeu, Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DR) //Cas o� on les pions se trouvent sur la m�me ligne,ou en diagonale (pas sumito)
		{
			jeu.getPlateau()[p1.getX()+1][p1.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()+1][p2.getY()-1]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p1.getX() < p2.getX())
			{
				x=p1.getX(); 	y=p1.getY();
				p1.setX(p2.getX());  p1.setY(p2.getY());
				p2.setX(x);     p2.setY(y);
			}
			if (jeu.getPlateau()[p1.getX()+1][p1.getY()-1] != 0)
			{
				if (jeu.getPlateau()[p1.getX()+2][p1.getY()-2] == 0)
				{
					jeu.getPlateau()[p1.getX()+2][p1.getY()-2]=jeu.getPlateau()[p1.getX()+1][p1.getY()-1];
				}
				/*else if(!butter)
				{
					score[current_player-1]++;
					display_pawn_eject(current_player, score);
				}*/
			}
			jeu.getPlateau()[p1.getX()+1][p1.getY()-1]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
		}	
	}

	public void move_down_right_2 (Pion p1, Pion p2,PlateauAbalone jeu,Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DL) 
		//Cas o� on les pions se trouvent sur la m�me ligne, ou en diagonale (pas sumito)
		{
			jeu.getPlateau()[p1.getX()+1][p1.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()+1][p2.getY()+1]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getY() < p1.getY())
			{
				x=p1.getX(); 	y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (jeu.getPlateau()[p2.getX()+1][p2.getY()+1] != 0)
			{
				if (jeu.getPlateau()[p2.getX()+2][p2.getY()+2] == 0)
				{
					jeu.getPlateau()[p2.getX()+2][p2.getY()+2]=jeu.getPlateau()[p2.getX()+1][p2.getY()+1];
				}
				/*else if(!butter)
				{
					score[current_player-1]++;
					display_pawn_eject(current_player, score);
				}*/
			}
			jeu.getPlateau()[p2.getX()+1][p2.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
		}	
	}
	
	public Possible move_possible_3(Pion p1,Pion p2,Pion p3, Direction dir,PlateauAbalone jeu)
	{

		switch(dir)
		{
			case LEFT : return move_possible_left_3(p1,p2,p3,jeu); 
			case RIGHT : return move_possible_right_3(p1,p2,p3,jeu); 
			case UPLEFT : return move_possible_up_left_3(p1,p2,p3,jeu); 	
			case UPRIGHT : return move_possible_up_right_3(p1,p2,p3,jeu); 
			case DOWNLEFT : return move_possible_down_left_3(p1,p2,p3,jeu); 
			case DOWNRIGHT : return move_possible_down_right_3(p1,p2,p3,jeu); 
			default : return Possible.IMPOSSIBLE;
		}

			
	}
	public Possible move_possible_left_3( Pion p1, Pion p2, Pion p3,PlateauAbalone jeu)
	{
		int x,y;
		if (p2.getY() < p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() < p2.getY()){
			if (p1.getY() < p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}	
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc s'il y a un sumito ou si la case � gauche est vide.
		{
			if ((jeu.getPlateau()[p1.getX()][p3.getY()-2]==0) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p1.getX()][p3.getY()-2]==2))||(/*(player==player2) && */(jeu.getPlateau()[p1.getX()][p3.getY()-2]==1))) && ((jeu.getPlateau()[p1.getX()][p3.getY()-4]==0) || (jeu.getPlateau()[p1.getX()][p3.getY()-4]==3))) || (((/*(player==player1) && */(jeu.getPlateau()[p1.getX()][p3.getY()-2]==2) && (jeu.getPlateau()[p1.getX()][p3.getY()-4]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p1.getX()][p3.getY()-2]==1) && (jeu.getPlateau()[p1.getX()][p3.getY()-4]==1))) && ((jeu.getPlateau()[p1.getX()][p3.getY()-6]==0) || (jeu.getPlateau()[p1.getX()][p3.getY()-6]==3)))) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ((jeu.getPlateau()[p1.getX()][p1.getY()-2]==0) && (jeu.getPlateau()[p2.getX()][p2.getY()-2]==0) && (jeu.getPlateau()[p3.getX()][p3.getY()-2]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ((jeu.getPlateau()[p1.getX()][p1.getY()-2]==0) && (jeu.getPlateau()[p2.getX()][p2.getY()-2]==0) && (jeu.getPlateau()[p3.getX()][p3.getY()-2]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_right_3( Pion p1, Pion p2, Pion p3,PlateauAbalone jeu)
	{
		int x,y;
		if (p2.getY() > p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() > p2.getY()){
			if (p1.getY() > p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc s'il y a un sumito ou si la case � gauche est vide.
		{
			if ((jeu.getPlateau()[p1.getX()][p3.getY()+2]==0) || (((/*(player==player1) && */(jeu.getPlateau()[p1.getX()][p3.getY()+2]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p1.getX()][p3.getY()+2]==1))) && ((jeu.getPlateau()[p1.getX()][p3.getY()+4]==0) || (jeu.getPlateau()[p1.getX()][p3.getY()+4]==3))) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p1.getX()][p3.getY()+2]==2) && (jeu.getPlateau()[p1.getX()][p3.getY()+4]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p1.getX()][p3.getY()+2]==1) && (jeu.getPlateau()[p1.getX()][p3.getY()+4]==1))) && ((jeu.getPlateau()[p1.getX()][p3.getY()+6]==0) || (jeu.getPlateau()[p1.getX()][p3.getY()+6]==3)))) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ((jeu.getPlateau()[p1.getX()][p1.getY()+2]==0) && (jeu.getPlateau()[p2.getX()][p2.getY()+2]==0) && (jeu.getPlateau()[p3.getX()][p3.getY()+2]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ((jeu.getPlateau()[p1.getX()][p1.getY()+2]==0) && (jeu.getPlateau()[p2.getX()][p2.getY()+2]==0) && (jeu.getPlateau()[p3.getX()][p3.getY()+2]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_left_3( Pion p1, Pion p2, Pion p3,PlateauAbalone jeu)
	{
		int x,y;
		if (p2.getY() < p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() < p2.getY()){
			if (p1.getY() < p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}	
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � gauche sont vides.
		{
			if ((jeu.getPlateau()[p1.getX()-1][p1.getY()-1]==0) && (jeu.getPlateau()[p2.getX()-1][p2.getY()-1]==0) && (jeu.getPlateau()[p3.getX()-1][p3.getY()-1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p1.getX()-1][p1.getY()-1]==0) && (jeu.getPlateau()[p2.getX()-1][p2.getY()-1]==0) && (jeu.getPlateau()[p3.getX()-1][p3.getY()-1]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p3.getX()-1][p3.getY()-1]==0) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p3.getX()-1][p3.getY()-1]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p3.getX()-1][p3.getY()-1]==1))) && ((jeu.getPlateau()[p3.getX()-2][p3.getY()-2]==0) || (jeu.getPlateau()[p3.getX()-2][p3.getY()-2]==3))) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p3.getX()-1][p3.getY()-1]==2) && (jeu.getPlateau()[p3.getX()-2][p3.getY()-2]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p3.getX()-1][p3.getY()-1]==1) && (jeu.getPlateau()[p3.getX()-2][p3.getY()-2]==1))) && ((jeu.getPlateau()[p3.getX()-3][p3.getY()-3]==0) || (jeu.getPlateau()[p3.getX()-3][p3.getY()-3]==3)))) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_right_3( Pion p1, Pion p2, Pion p3,PlateauAbalone jeu)
	{
		int x,y;
		if (p2.getY() > p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() > p2.getY()){
			if (p1.getY() > p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � droite sont vides.
		{
			if ((jeu.getPlateau()[p1.getX()-1][p1.getY()+1]==0) && (jeu.getPlateau()[p2.getX()-1][p2.getY()+1]==0) && (jeu.getPlateau()[p3.getX()-1][p3.getY()+1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2)) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p1.getX()-1][p1.getY()+1]==0) && (jeu.getPlateau()[p2.getX()-1][p2.getY()+1]==0) && (jeu.getPlateau()[p3.getX()-1][p3.getY()+1]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2)) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p3.getX()-1][p3.getY()+1]==0) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p3.getX()-1][p3.getY()+1]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p3.getX()-1][p3.getY()+1]==1))) && ((jeu.getPlateau()[p3.getX()-2][p3.getY()+2]==0) || (jeu.getPlateau()[p3.getX()-2][p3.getY()+2]==3))) || (((/*(player==player1) && */(jeu.getPlateau()[p3.getX()-1][p3.getY()+1]==2) && (jeu.getPlateau()[p3.getX()-2][p3.getY()+2]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p3.getX()-1][p3.getY()+1]==1) && (jeu.getPlateau()[p3.getX()-2][p3.getY()+2]==1))) && ((jeu.getPlateau()[p3.getX()-3][p3.getY()+3]==0) || (jeu.getPlateau()[p3.getX()-3][p3.getY()+3]==3)))) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_left_3( Pion p1, Pion p2, Pion p3,PlateauAbalone jeu)
	{
		int x,y;
		if (p2.getY() > p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() > p2.getY()){
			if (p1.getY() > p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en bas � gauche sont vides.
		{
			if ((jeu.getPlateau()[p1.getX()+1][p1.getY()-1]==0) && (jeu.getPlateau()[p2.getX()+1][p2.getY()-1]==0) && (jeu.getPlateau()[p3.getX()+1][p3.getY()-1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2)) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p1.getX()+1][p1.getY()-1]==0) && (jeu.getPlateau()[p2.getX()+1][p2.getY()-1]==0) && (jeu.getPlateau()[p3.getX()+1][p3.getY()-1]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2)) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p3.getX()+1][p3.getY()-1]==0) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p3.getX()+1][p3.getY()-1]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p3.getX()+1][p3.getY()-1]==1))) && ((jeu.getPlateau()[p3.getX()+2][p3.getY()-2]==0) || (jeu.getPlateau()[p3.getX()+2][p3.getY()-2]==3))) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p3.getX()+1][p3.getY()-1]==2) && (jeu.getPlateau()[p3.getX()+2][p3.getY()-2]==2))||(/*(player==player2) && */(jeu.getPlateau()[p3.getX()+1][p3.getY()-1]==1) && (jeu.getPlateau()[p3.getX()+2][p3.getY()-2]==1))) && ((jeu.getPlateau()[p3.getX()+3][p3.getY()-3]==0) || (jeu.getPlateau()[p3.getX()+3][p3.getY()-3]==3)))) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_right_3( Pion p1, Pion p2, Pion p3,PlateauAbalone jeu)
	{
		int x,y;
		if (p2.getY() < p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() < p2.getY()){
			if (p1.getY() < p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}	
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � gauche sont vides.
		{
			if ((jeu.getPlateau()[p1.getX()+1][p1.getY()+1]==0) && (jeu.getPlateau()[p2.getX()+1][p2.getY()+1]==0) && (jeu.getPlateau()[p3.getX()+1][p3.getY()+1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p1.getX()+1][p1.getY()+1]==0) && (jeu.getPlateau()[p2.getX()+1][p2.getY()+1]==0) && (jeu.getPlateau()[p3.getX()+1][p3.getY()+1]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2)) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((jeu.getPlateau()[p3.getX()+1][p3.getY()+1]==0) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p3.getX()+1][p3.getY()+1]==2))||(/*(player==player2) && */(jeu.getPlateau()[p3.getX()+1][p3.getY()+1]==1))) && ((jeu.getPlateau()[p3.getX()+2][p3.getY()+2]==0) || (jeu.getPlateau()[p3.getX()+2][p3.getY()+2]==3))) || (((/*(player==player1) &&*/ (jeu.getPlateau()[p3.getX()+1][p3.getY()+1]==2) && (jeu.getPlateau()[p3.getX()+2][p3.getY()+2]==2))||(/*(player==player2) &&*/ (jeu.getPlateau()[p3.getX()+1][p3.getY()+1]==1) && (jeu.getPlateau()[p3.getX()+2][p3.getY()+2]==1))) && ((jeu.getPlateau()[p3.getX()+3][p3.getY()+3]==0) || (jeu.getPlateau()[p3.getX()+3][p3.getY()+3]==3)))) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}
	
	public void move_3( Pion p1, Pion p2, Pion p3, Direction dir,PlateauAbalone jeu, Possible alignment)
	{
		switch(dir)
		{
			case LEFT : move_left_3( p1, p2, p3, jeu,alignment); 
				break;
			case RIGHT : move_right_3( p1, p2, p3, jeu,alignment); 
				break;
			case UPLEFT : move_up_left_3( p1, p2, p3, jeu,alignment); 	
				break;
			case UPRIGHT : move_up_right_3( p1, p2, p3, jeu,alignment); 
				break;
			case DOWNLEFT : move_down_left_3(p1, p2, p3, jeu,alignment); 
				break;
			case DOWNRIGHT : move_down_right_3( p1, p2, p3, jeu,alignment); 
				break;
			default : break;
		}
	}
	public void move_left_3 (Pion p1,Pion p2,Pion p3,PlateauAbalone jeu,Possible alignment)
	{
		int x,y;
		if (alignment != Possible.LINE)
		{
			jeu.getPlateau()[p1.getX()][p1.getY()-2]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()][p2.getY()-2]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
			jeu.getPlateau()[p3.getX()][p3.getY()-2]=jeu.getPlateau()[p3.getX()][p3.getY()];
			jeu.getPlateau()[p3.getX()][p3.getY()]=0;
		}
		else
		{
			//Aligner les pions
			if (p2.getY() < p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() < p2.getY()){
				if (p1.getY() < p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}	
			if (jeu.getPlateau()[p3.getX()][p3.getY()-2] != 0)
			{
				if ((jeu.getPlateau()[p3.getX()][p3.getY()-4] != 0) && (jeu.getPlateau()[p3.getX()][p3.getY()-6] == 3))
				{
					/*score[current_player-1]++;
					display_pawn_eject(current_player, score);*/
				}
				else if (jeu.getPlateau()[p3.getX()][p3.getY()-4] == 0)
				{
					jeu.getPlateau()[p3.getX()][p3.getY()-4]=jeu.getPlateau()[p3.getX()][p3.getY()-2];
				}
				else
				{
					jeu.getPlateau()[p3.getX()][p3.getY()-6]=jeu.getPlateau()[p3.getX()][p3.getY()-2];
				}
			}
			jeu.getPlateau()[p3.getX()][p3.getY()-2]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_right_3 (Pion p1,Pion p2,Pion p3,PlateauAbalone jeu,Possible alignment)
	{
		int x,y;
		if (alignment != Possible.LINE)
		{
			jeu.getPlateau()[p1.getX()][p1.getY()+2] = jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()][p2.getY()+2] = jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()] = 0;
			jeu.getPlateau()[p3.getX()][p3.getY()+2] = jeu.getPlateau()[p3.getX()][p3.getY()];
			jeu.getPlateau()[p3.getX()][p3.getY()] = 0;
		}
		else
		{
			if (p2.getY() > p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() > p2.getY()){
				if (p1.getY() > p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}
			if (jeu.getPlateau()[p3.getX()][p3.getY()+2] != 0)
			{
				if ((jeu.getPlateau()[p3.getX()][p3.getY()+4] != 0) && (jeu.getPlateau()[p3.getX()][p3.getY()+6] == 3))
				{
					/*score[current_player-1]++;
					display_pawn_eject(current_player, score);*/
				}
				else if (jeu.getPlateau()[p3.getX()][p3.getY()+4] == 0)
				{
					jeu.getPlateau()[p3.getX()][p3.getY()+4]=jeu.getPlateau()[p3.getX()][p3.getY()+2];
				}
				else
				{
					jeu.getPlateau()[p3.getX()][p3.getY()+6]=jeu.getPlateau()[p3.getX()][p3.getY()+2];
				}
			}
			jeu.getPlateau()[p3.getX()][p3.getY()+2]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_up_left_3 (Pion p1, Pion p2,Pion p3,PlateauAbalone jeu,Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DL) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			jeu.getPlateau()[p1.getX()-1][p1.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()-1][p2.getY()-1]=jeu.getPlateau()[p2.getX()][p2.getY()];
			jeu.getPlateau()[p2.getX()][p2.getY()]=0;
			jeu.getPlateau()[p3.getX()-1][p3.getY()-1]=jeu.getPlateau()[p3.getX()][p3.getY()];
			jeu.getPlateau()[p3.getX()][p3.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			//Aligner les pions
			if (p2.getY() < p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() < p2.getY()){
				if (p1.getY() < p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}
			if (jeu.getPlateau()[p3.getX()-1][p3.getY()-1] != 0)
			{
				if ((jeu.getPlateau()[p3.getX()-2][p3.getY()-2] != 0) && (jeu.getPlateau()[p3.getX()-3][p3.getY()-3] == 3))
				{
					/*score[current_player-1]++;  
					display_pawn_eject(current_player, score);*/
				}
				else if (jeu.getPlateau()[p3.getX()-2][p3.getY()-2] == 0)
				{
					jeu.getPlateau()[p3.getX()-2][p3.getY()-2]=jeu.getPlateau()[p3.getX()-1][p3.getY()-1];
				}
				else
				{
					jeu.getPlateau()[p3.getX()-3][p3.getY()-3]=jeu.getPlateau()[p3.getX()-1][p3.getY()-1];
				}
			}
			jeu.getPlateau()[p3.getX()-1][p3.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_up_right_3 (Pion p1, Pion p2,Pion p3,PlateauAbalone jeu,Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DR) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			jeu.getPlateau()[p1.getX()-1][p1.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];	jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()-1][p2.getY()+1]=jeu.getPlateau()[p2.getX()][p2.getY()];	jeu.getPlateau()[p2.getX()][p2.getY()]=0;
			jeu.getPlateau()[p3.getX()-1][p3.getY()+1]=jeu.getPlateau()[p3.getX()][p3.getY()];	jeu.getPlateau()[p3.getX()][p3.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getY() > p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() > p2.getY()){
				if (p1.getY() > p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}
			if (jeu.getPlateau()[p3.getX()-1][p3.getY()+1] != 0)
			{
				if ((jeu.getPlateau()[p3.getX()-2][p3.getY()+2] != 0) && (jeu.getPlateau()[p3.getX()-3][p3.getY()+3] == 3))
				{
					/*score[current_player-1]++;  
					display_pawn_eject(current_player, score);*/
				}
				else if (jeu.getPlateau()[p3.getX()-2][p3.getY()+2] == 0)
				{
					jeu.getPlateau()[p3.getX()-2][p3.getY()+2]=jeu.getPlateau()[p3.getX()-1][p3.getY()+1];
				}
				else
				{
					jeu.getPlateau()[p3.getX()-3][p3.getY()+3]=jeu.getPlateau()[p3.getX()-1][p3.getY()+1];
				}
			}
			jeu.getPlateau()[p3.getX()-1][p3.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_down_left_3 (Pion p1, Pion p2,Pion p3,PlateauAbalone jeu, Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DR) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			jeu.getPlateau()[p1.getX()+1][p1.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];	jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()+1][p2.getY()-1]=jeu.getPlateau()[p2.getX()][p2.getY()];	jeu.getPlateau()[p2.getX()][p2.getY()]=0;
			jeu.getPlateau()[p3.getX()+1][p3.getY()-1]=jeu.getPlateau()[p3.getX()][p3.getY()];	jeu.getPlateau()[p3.getX()][p3.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			//Aligner les pions
			if (p2.getY() < p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() < p2.getY()){
				if (p1.getY() < p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}	
			if (jeu.getPlateau()[p3.getX()+1][p3.getY()-1] != 0)
			{
				if ((jeu.getPlateau()[p3.getX()+2][p3.getY()-2] != 0) && (jeu.getPlateau()[p3.getX()+3][p3.getY()-3] == 3))
				{
					/*score[current_player-1]++;
					display_pawn_eject(current_player, score);*/
				}
				else if (jeu.getPlateau()[p3.getX()+2][p3.getY()-2] == 0)
				{
					jeu.getPlateau()[p3.getX()+2][p3.getY()-2]=jeu.getPlateau()[p3.getX()+1][p3.getY()-1];
				}
				else
				{
					jeu.getPlateau()[p3.getX()+3][p3.getY()-3]=jeu.getPlateau()[p3.getX()+1][p3.getY()-1];
				}
			}
			jeu.getPlateau()[p3.getX()+1][p3.getY()-1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
		}
	}

	public void move_down_right_3 (Pion p1, Pion p2,Pion p3,PlateauAbalone jeu,Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DL) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			jeu.getPlateau()[p1.getX()+1][p1.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];	jeu.getPlateau()[p1.getX()][p1.getY()]=0;
			jeu.getPlateau()[p2.getX()+1][p2.getY()+1]=jeu.getPlateau()[p2.getX()][p2.getY()];	jeu.getPlateau()[p2.getX()][p2.getY()]=0;
			jeu.getPlateau()[p3.getX()+1][p3.getY()+1]=jeu.getPlateau()[p3.getX()][p3.getY()];	jeu.getPlateau()[p3.getX()][p3.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getY() > p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() > p2.getY()){
				if (p1.getY() > p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}
			if (jeu.getPlateau()[p3.getX()+1][p3.getY()+1] != 0)
			{
				if ((jeu.getPlateau()[p3.getX()+2][p3.getY()+2] != 0) && (jeu.getPlateau()[p3.getX()+3][p3.getY()+3] == 3))
				{
					/*score[current_player-1]++; 
					display_pawn_eject(current_player, score);*/
				}
				else if (jeu.getPlateau()[p3.getX()+2][p3.getY()+2] == 0)
				{
					jeu.getPlateau()[p3.getX()+2][p3.getY()+2]=jeu.getPlateau()[p3.getX()+1][p3.getY()+1];
				}
				else
				{
					jeu.getPlateau()[p3.getX()+3][p3.getY()+3]=jeu.getPlateau()[p3.getX()+1][p3.getY()+1];
				}
			}
			jeu.getPlateau()[p3.getX()+1][p3.getY()+1]=jeu.getPlateau()[p1.getX()][p1.getY()];
			jeu.getPlateau()[p1.getX()][p1.getY()]=0;
		}
	}
	
}
