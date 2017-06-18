package modele;
import java.awt.Color;

import modele.Config.Direction;
import modele.Config.Possible;

public class Deplacement {
	public int number_pions(Pion p1,Pion p2,Pion p3){
		if (p2 == null && p3 == null)
			return 1;
		else if (p3 == null)
			return 2;
		else 
			return 3;
	}
	
	public boolean check_pion_selected_1(Pion p1,int joueur,int tab[][]){
		if (joueur == 1 && tab[p1.getX()][p1.getY()] == 1)
				return true;
		else if (joueur == 2 && tab[p1.getX()][p1.getY()] == 2)
			return true;
		else
			return false;	
	}
	
	public boolean check_pion_selected_2(Pion p1,Pion p2, int joueur,int tab[][]){
		if (!check_pion_selected_1(p1,joueur,tab))
			return false;
		if (joueur == 1 && tab[p2.getX()][p2.getY()] == 1)
				return true;
		else if (joueur == 2 && tab[p2.getX()][p2.getY()] == 2)
			return true;
		else
			return false;	
	}
	
	public boolean check_pion_selected_3(Pion p1,Pion p2,Pion p3,int joueur,int tab[][]){
		if (!check_pion_selected_1(p1,joueur,tab) || !check_pion_selected_2(p1,p2,joueur,tab))
			return false;
		if (joueur == 1 && tab[p2.getX()][p2.getY()] == 1)
				return true;
		else if (joueur == 2 && tab[p2.getX()][p2.getY()] == 2)
			return true;
		else
			return false;	
	}
	public Possible move_possible(Pion p1, Pion p2, Pion p3, Direction dir, int tab[][],int joueur){
		int nb;
		nb = number_pions(p1,p2,p3);
		switch (nb){
		case 1 : 
			return move_possible_1(p1,dir,tab,joueur);
		case 2 : 
			return move_possible_2(p1,p2,dir,tab,joueur);
		case 3 :
			return move_possible_3(p1,p2,p3,dir,tab,joueur);
		default : 
			return Possible.IMPOSSIBLE;
		}
	}
	
	public void move(Pion p1,Pion p2, Pion p3, Direction dir, int tab[][],Possible al){
		int nb; 
		nb = number_pions(p1,p2,p3);
		switch (nb){
		case 1 : 
			move_1(p1,dir,tab);
			break;
		case 2 : 
			move_2(p1,p2,dir,tab,al);
			break;
		case 3 :
			move_3(p1,p2,p3,dir,tab,al);
			break;
		default : 
			break;
		}
	}
	
	public Possible move_possible_1(Pion p1, Direction dir,int tab[][],int joueur)
	{
		if (!check_pion_selected_1(p1,joueur,tab))
			return Possible.IMPOSSIBLE;
			
		switch(dir)
		{
			case LEFT : return move_possible_left_1(p1,tab,joueur); 
			case RIGHT : return move_possible_right_1(p1,tab,joueur); 
			case UPLEFT : return move_possible_up_left_1(p1,tab,joueur); 	
			case UPRIGHT : return move_possible_up_right_1(p1,tab,joueur); 
			case DOWNLEFT : return move_possible_down_left_1(p1,tab,joueur); 
			case DOWNRIGHT : return move_possible_down_right_1(p1,tab,joueur); 
			default : return Possible.IMPOSSIBLE;
		}
	}
	public Possible move_possible_left_1(Pion p1,int tab[][],int joueur)
	{
		if (tab[p1.getX()][p1.getY()-2]==0) return	Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}
	
	public Possible move_possible_right_1(Pion p1,int tab[][],int joueur)
	{
		if (tab[p1.getX()][p1.getY()+2]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_left_1(Pion p1,int tab[][],int joueur)
	{
		if (tab[p1.getX()-1][p1.getY()-1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_right_1(Pion p1,int tab[][],int joueur)
	{
		if (tab[p1.getX()-1][p1.getY()+1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_left_1(Pion p1,int tab[][],int joueur)
	{
		if (tab[p1.getX()+1][p1.getY()-1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_right_1(Pion p1,int tab[][],int joueur)
	{
		if (tab[p1.getX()+1][p1.getY()+1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}
	
	public void move_1(Pion p1, Direction dir,int tab[][])
	{
		switch(dir)
		{
			case LEFT : move_left_1(p1,tab); 
				break;
			case RIGHT : move_right_1(p1,tab); 
				break;
			case UPLEFT : move_up_left_1(p1,tab); 	
				break;
			case UPRIGHT : move_up_right_1(p1,tab); 
				break;
			case DOWNLEFT : move_down_left_1(p1,tab); 
				break;
			case DOWNRIGHT : move_down_right_1(p1,tab); 
				break;
			default : break;
		}
	}
	public void move_left_1 (Pion p1,int tab[][]) 
	{
		tab[p1.getX()][p1.getY()-2]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	
	public void move_right_1 (Pion p1,int tab[][])
	{
		tab[p1.getX()][p1.getY()+2]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	
	public void move_up_left_1 (Pion p1,int tab[][])
	{
		tab[p1.getX()-1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	
	public void move_up_right_1 (Pion p1,int tab[][])	
	{			      
		tab[p1.getX()-1][p1.getY()+1]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	
	public void move_down_left_1 (Pion p1,int tab[][])
	{
		tab[p1.getX()+1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}

	public void move_down_right_1 (Pion p1,int tab[][])
	{
		tab[p1.getX()+1][p1.getY()+1]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	
	
	public Possible move_possible_2(Pion p1,Pion p2, Direction dir,int tab[][],int joueur)
	{
		if (!check_pion_selected_2(p1,p2,joueur,tab))
			return Possible.IMPOSSIBLE;
		switch(dir)
		{
			case LEFT : return move_possible_left_2(p1,p2,tab,joueur); 
			case RIGHT : return move_possible_right_2(p1,p2,tab,joueur); 
			case UPLEFT : return move_possible_up_left_2(p1,p2,tab,joueur); 	
			case UPRIGHT : return move_possible_up_right_2(p1,p2,tab,joueur); 
			case DOWNLEFT : return move_possible_down_left_2(p1,p2,tab,joueur); 
			case DOWNRIGHT : return move_possible_down_right_2(p1,p2,tab,joueur); 
			default : return Possible.IMPOSSIBLE;
		}

			
	}
	public Possible move_possible_left_2(Pion p1,Pion p2,int tab[][],int joueur)
	{
		if (p1.getY() < p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la même lignes, on verrifie donc s'il y a un sumito ou si la case à gauche est vide.
		{
			if ((tab[p1.getX()][p2.getY()-2]==0) || ((((joueur==1) && (tab[p1.getX()][p2.getY()-2]==2))||((joueur==2) && (tab[p1.getX()][p2.getY()-2]==1))) && ((tab[p1.getX()][p2.getY()-4]==0) || (tab[p1.getX()][p2.getY()-4]==3))) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases à gauche sont vides.
		{
			if ( (tab[p1.getX()][p1.getY()-2]==0) && (tab[p2.getX()][p2.getY()-2]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases à gauche sont vides.
		{
			if ( (tab[p1.getX()][p1.getY()-2]==0) && (tab[p2.getX()][p2.getY()-2]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_right_2(Pion p1,Pion p2,int tab[][],int joueur)
	{
		if (p1.getY() > p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la même lignes, on verrifie donc s'il y a un sumito ou si la case à gauche est vide.
		{
			if ((tab[p1.getX()][p2.getY()+2]==0) || ((((joueur==1) && (tab[p1.getX()][p2.getY()+2]==2))||((joueur==2) && (tab[p1.getX()][p2.getY()+2]==1))) && ((tab[p1.getX()][p2.getY()+4]==0) || (tab[p1.getX()][p2.getY()+4]==3))) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases à gauche sont vides.
		{
			if ( (tab[p1.getX()][p1.getY()+2]==0) && (tab[p2.getX()][p2.getY()+2]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases à gauche sont vides.
		{
			if ( (tab[p1.getX()][p1.getY()+2]==0) && (tab[p2.getX()][p2.getY()+2]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_left_2( Pion p1, Pion p2,int tab[][],int joueur)
	{
		if (p1.getY() > p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX())  //Les pions sont sur la même lignes, on verrifie donc que les 3 cases en haut à gauche sont vides.
		{
			if ( (tab[p1.getX()-1][p1.getY()-1]==0) && (tab[p2.getX()-1][p2.getY()-1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ( (tab[p1.getX()-1][p1.getY()-1]==0) && (tab[p2.getX()-1][p2.getY()-1]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ( (tab[p2.getX()-1][p2.getY()-1]==0) || ((((joueur==1) && (tab[p2.getX()-1][p2.getY()-1]==2))||((joueur==2) && (tab[p2.getX()-1][p2.getY()-1]==1))) && ((tab[p2.getX()-2][p2.getY()-2]==0) || (tab[p2.getX()-2][p2.getY()-2]==3))) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_right_2( Pion p1, Pion p2,int tab[][], int joueur)
	{
		if (p1.getY() < p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX())  //Les pions sont sur la même lignes, on verrifie donc que les 3 cases en haut à droite sont vides.
		{
			if ( (tab[p1.getX()-1][p1.getY()+1]==0) && (tab[p2.getX()-1][p2.getY()+1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) ) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) ) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ( (tab[p1.getX()-1][p1.getY()+1]==0) && (tab[p2.getX()-1][p2.getY()+1]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) ) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ( (tab[p2.getX()-1][p2.getY()+1]==0) || ((((joueur==1) && (tab[p2.getX()-1][p2.getY()+1]==2))||((joueur==2) && (tab[p2.getX()-1][p2.getY()+1]==1))) && ((tab[p2.getX()-2][p2.getY()+2]==0) || (tab[p2.getX()-2][p2.getY()+2]==3))) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_left_2( Pion p1, Pion p2,int tab[][],int joueur)
	{
		if (p1.getY() < p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la même lignes, on verrifie donc que les 3 cases en bas à gauche sont vides.
		{
			if ( (tab[p1.getX()+1][p1.getY()-1]==0) && (tab[p2.getX()+1][p2.getY()-1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) ) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) ) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ( (tab[p1.getX()+1][p1.getY()-1]==0) && (tab[p2.getX()+1][p2.getY()-1]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) ) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p2.getX()+1][p2.getY()-1]==0) || ((((joueur==1) && (tab[p2.getX()+1][p2.getY()-1]==2))||((joueur==2) && (tab[p2.getX()+1][p2.getY()-1]==1))) && ((tab[p2.getX()+2][p2.getY()-2]==0) || (tab[p2.getX()+2][p2.getY()-2]==3))) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_right_2( Pion p1, Pion p2,int tab[][],int joueur)
	{
		if (p1.getY() > p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la même lignes, on verrifie donc que les 3 cases en haut à gauche sont vides.
		{
			if ( (tab[p1.getX()+1][p1.getY()+1]==0) && (tab[p2.getX()+1][p2.getY()+1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1)  ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1)  )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ( (tab[p1.getX()+1][p1.getY()+1]==0) && (tab[p2.getX()+1][p2.getY()+1]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p2.getX()+1][p2.getY()+1]==0) || ((((joueur==1) && (tab[p2.getX()+1][p2.getY()+1]==2))||((joueur==2) && (tab[p2.getX()+1][p2.getY()+1]==1))) && ((tab[p2.getX()+2][p2.getY()+2]==0) || (tab[p2.getX()+2][p2.getY()+2]==3))) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}
	
	public void move_2(Pion p1, Pion p2, Direction dir,int tab[][], Possible alignment)
	{
		switch(dir)
		{
			case LEFT : move_left_2( p1, p2,tab, alignment); 
				break;
			case RIGHT : move_right_2( p1, p2,tab, alignment); 
				break;
			case UPLEFT : move_up_left_2(p1, p2,tab, alignment); 	
				break;
			case UPRIGHT : move_up_right_2( p1, p2,tab, alignment); 
				break;
			case DOWNLEFT : move_down_left_2( p1, p2,tab, alignment); 
				break;
			case DOWNRIGHT : move_down_right_2( p1, p2,tab, alignment); 
				break;
			default : break;
		}
	}
	
	public void move_left_2 (Pion p1,Pion p2,int tab[][],Possible al)
	{
		if (al != Possible.LINE)
		{
			tab[p1.getX()][p1.getY()-2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()][p2.getY()-2]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
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
			if (tab[p1.getX()][p1.getY()-2] != 0)
			{
				if (tab[p1.getX()][p1.getY()-4] == 0)
				{
					tab[p1.getX()][p1.getY()-4]=tab[p1.getX()][p1.getY()-2];
				}
			}
			tab[p1.getX()][p1.getY()-2]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}
	}
	public void move_right_2 (Pion p1,Pion p2,int tab[][],Possible alignment)
	{	
		int x,y;
		if (alignment != Possible.LINE)
		{
			tab[p1.getX()][p1.getY()+2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()][p2.getY()+2]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
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
			if (tab[p2.getX()][p2.getY()+2] != 0)
			{
				if (tab[p2.getX()][p2.getY()+4] == 0)
				{
					tab[p2.getX()][p2.getY()+4]=tab[p2.getX()][p2.getY()+2];
				}
			}
			tab[p2.getX()][p2.getY()+2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_up_left_2 (Pion p1, Pion p2,int tab[][],Possible alignment)
	{
		int x,y;
		if (alignment == Possible.LINE || alignment==Possible.DL) //Cas où les pions sont sur la même ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()-1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()-1][p2.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
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
			if (tab[p1.getX()-1][p1.getY()-1] != 0)
			{
				if (tab[p1.getX()-2][p1.getY()-2] == 0)
				{
					tab[p1.getX()-2][p1.getY()-2]=tab[p1.getX()-1][p1.getY()-1];
				}
			}
			tab[p1.getX()-1][p1.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}	
	}
	
	public void move_up_right_2 (Pion p1, Pion p2,int tab[][],Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment == Possible.DR) 
		//Cas où on les pions se trouvent sur la même ligne, ou en diagonale (pas sumito)
		{
			tab[p1.getX()-1][p1.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()-1][p2.getY()+1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
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
			if (tab[p2.getX()-1][p2.getY()+1] != 0)
			{
				if (tab[p2.getX()-2][p2.getY()+2] == 0)
				{
					tab[p2.getX()-2][p2.getY()+2]=tab[p2.getX()-1][p2.getY()+1];
				}	
			}
			tab[p2.getX()-1][p2.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}	
	}
	
	public void move_down_left_2 (Pion p1, Pion p2,int tab[][], Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DR) //Cas où on les pions se trouvent sur la même ligne,ou en diagonale (pas sumito)
		{
			tab[p1.getX()+1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()+1][p2.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p1.getX() < p2.getX())
			{
				x=p1.getX(); 	y=p1.getY();
				p1.setX(p2.getX());  p1.setY(p2.getY());
				p2.setX(x);     p2.setY(y);
			}
			if (tab[p1.getX()+1][p1.getY()-1] != 0)
			{
				if (tab[p1.getX()+2][p1.getY()-2] == 0)
				{
					tab[p1.getX()+2][p1.getY()-2]=tab[p1.getX()+1][p1.getY()-1];
				}
			tab[p1.getX()+1][p1.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
			}
		}	
	}

	public void move_down_right_2 (Pion p1, Pion p2,int tab[][],Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DL) 
		//Cas où on les pions se trouvent sur la même ligne, ou en diagonale (pas sumito)
		{
			tab[p1.getX()+1][p1.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()+1][p2.getY()+1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
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
			if (tab[p2.getX()+1][p2.getY()+1] != 0)
			{
				if (tab[p2.getX()+2][p2.getY()+2] == 0)
				{
					tab[p2.getX()+2][p2.getY()+2]=tab[p2.getX()+1][p2.getY()+1];
				}
			}
			tab[p2.getX()+1][p2.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}	
	}
	
	public Possible move_possible_3(Pion p1,Pion p2,Pion p3, Direction dir,int tab[][],int joueur)
	{
		if (!check_pion_selected_3(p1,p2,p3,joueur,tab))
			return Possible.IMPOSSIBLE;
		switch(dir)
		{
			case LEFT : return move_possible_left_3(p1,p2,p3,tab,joueur); 
			case RIGHT : return move_possible_right_3(p1,p2,p3,tab,joueur); 
			case UPLEFT : return move_possible_up_left_3(p1,p2,p3,tab,joueur); 	
			case UPRIGHT : return move_possible_up_right_3(p1,p2,p3,tab,joueur); 
			case DOWNLEFT : return move_possible_down_left_3(p1,p2,p3,tab,joueur); 
			case DOWNRIGHT : return move_possible_down_right_3(p1,p2,p3,tab,joueur); 
			default : return Possible.IMPOSSIBLE;
		}

			
	}
	public Possible move_possible_left_3( Pion p1, Pion p2, Pion p3,int tab[][],int joueur)
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
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la même lignes, on verrifie donc s'il y a un sumito ou si la case à gauche est vide.
		{
			if ((tab[p1.getX()][p3.getY()-2]==0) || ((((joueur==1) && (tab[p1.getX()][p3.getY()-2]==2))||((joueur==2) && (tab[p1.getX()][p3.getY()-2]==1))) && ((tab[p1.getX()][p3.getY()-4]==0) || (tab[p1.getX()][p3.getY()-4]==3))) || ((((joueur==1) && (tab[p1.getX()][p3.getY()-2]==2) && (tab[p1.getX()][p3.getY()-4]==2))||((joueur==2) && (tab[p1.getX()][p3.getY()-2]==1) && (tab[p1.getX()][p3.getY()-4]==1))) && ((tab[p1.getX()][p3.getY()-6]==0) || (tab[p1.getX()][p3.getY()-6]==3)))) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases à gauche sont vides.
		{
			if ((tab[p1.getX()][p1.getY()-2]==0) && (tab[p2.getX()][p2.getY()-2]==0) && (tab[p3.getX()][p3.getY()-2]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases à gauche sont vides.
		{
			if ((tab[p1.getX()][p1.getY()-2]==0) && (tab[p2.getX()][p2.getY()-2]==0) && (tab[p3.getX()][p3.getY()-2]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_right_3( Pion p1, Pion p2, Pion p3,int tab[][],int joueur)
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
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la même lignes, on verrifie donc s'il y a un sumito ou si la case à gauche est vide.
		{
			if ((tab[p1.getX()][p3.getY()+2]==0) || ((((joueur==1) && (tab[p1.getX()][p3.getY()+2]==2))||((joueur==2) && (tab[p1.getX()][p3.getY()+2]==1))) && ((tab[p1.getX()][p3.getY()+4]==0) || (tab[p1.getX()][p3.getY()+4]==3))) || ((((joueur==1) && (tab[p1.getX()][p3.getY()+2]==2) && (tab[p1.getX()][p3.getY()+4]==2))||((joueur==2) && (tab[p1.getX()][p3.getY()+2]==1) && (tab[p1.getX()][p3.getY()+4]==1))) && ((tab[p1.getX()][p3.getY()+6]==0) || (tab[p1.getX()][p3.getY()+6]==3)))) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases à gauche sont vides.
		{
			if ((tab[p1.getX()][p1.getY()+2]==0) && (tab[p2.getX()][p2.getY()+2]==0) && (tab[p3.getX()][p3.getY()+2]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases à gauche sont vides.
		{
			if ((tab[p1.getX()][p1.getY()+2]==0) && (tab[p2.getX()][p2.getY()+2]==0) && (tab[p3.getX()][p3.getY()+2]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_left_3( Pion p1, Pion p2, Pion p3,int tab[][],int joueur)
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
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la même lignes, on verrifie donc que les 3 cases en haut à gauche sont vides.
		{
			if ((tab[p1.getX()-1][p1.getY()-1]==0) && (tab[p2.getX()-1][p2.getY()-1]==0) && (tab[p3.getX()-1][p3.getY()-1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p1.getX()-1][p1.getY()-1]==0) && (tab[p2.getX()-1][p2.getY()-1]==0) && (tab[p3.getX()-1][p3.getY()-1]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p3.getX()-1][p3.getY()-1]==0) || ((((joueur==1) && (tab[p3.getX()-1][p3.getY()-1]==2))||((joueur==2) && (tab[p3.getX()-1][p3.getY()-1]==1))) && ((tab[p3.getX()-2][p3.getY()-2]==0) || (tab[p3.getX()-2][p3.getY()-2]==3))) || ((((joueur==1) && (tab[p3.getX()-1][p3.getY()-1]==2) && (tab[p3.getX()-2][p3.getY()-2]==2))||((joueur==2) && (tab[p3.getX()-1][p3.getY()-1]==1) && (tab[p3.getX()-2][p3.getY()-2]==1))) && ((tab[p3.getX()-3][p3.getY()-3]==0) || (tab[p3.getX()-3][p3.getY()-3]==3)))) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_right_3( Pion p1, Pion p2, Pion p3,int tab[][],int joueur)
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
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la même lignes, on verrifie donc que les 3 cases en haut à droite sont vides.
		{
			if ((tab[p1.getX()-1][p1.getY()+1]==0) && (tab[p2.getX()-1][p2.getY()+1]==0) && (tab[p3.getX()-1][p3.getY()+1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2)) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p1.getX()-1][p1.getY()+1]==0) && (tab[p2.getX()-1][p2.getY()+1]==0) && (tab[p3.getX()-1][p3.getY()+1]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2)) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p3.getX()-1][p3.getY()+1]==0) || ((((joueur==1) && (tab[p3.getX()-1][p3.getY()+1]==2))||((joueur==2) && (tab[p3.getX()-1][p3.getY()+1]==1))) && ((tab[p3.getX()-2][p3.getY()+2]==0) || (tab[p3.getX()-2][p3.getY()+2]==3))) || ((((joueur==1) && (tab[p3.getX()-1][p3.getY()+1]==2) && (tab[p3.getX()-2][p3.getY()+2]==2))||((joueur==2) && (tab[p3.getX()-1][p3.getY()+1]==1) && (tab[p3.getX()-2][p3.getY()+2]==1))) && ((tab[p3.getX()-3][p3.getY()+3]==0) || (tab[p3.getX()-3][p3.getY()+3]==3)))) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_left_3( Pion p1, Pion p2, Pion p3,int tab[][], int joueur)
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
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la même lignes, on verrifie donc que les 3 cases en bas à gauche sont vides.
		{
			if ((tab[p1.getX()+1][p1.getY()-1]==0) && (tab[p2.getX()+1][p2.getY()-1]==0) && (tab[p3.getX()+1][p3.getY()-1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2)) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p1.getX()+1][p1.getY()-1]==0) && (tab[p2.getX()+1][p2.getY()-1]==0) && (tab[p3.getX()+1][p3.getY()-1]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2)) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p3.getX()+1][p3.getY()-1]==0) || ((((joueur==1) && (tab[p3.getX()+1][p3.getY()-1]==2))||((joueur==2) && (tab[p3.getX()+1][p3.getY()-1]==1))) && ((tab[p3.getX()+2][p3.getY()-2]==0) || (tab[p3.getX()+2][p3.getY()-2]==3))) || ((((joueur==1) && (tab[p3.getX()+1][p3.getY()-1]==2) && (tab[p3.getX()+2][p3.getY()-2]==2))||((joueur==2) && (tab[p3.getX()+1][p3.getY()-1]==1) && (tab[p3.getX()+2][p3.getY()-2]==1))) && ((tab[p3.getX()+3][p3.getY()-3]==0) || (tab[p3.getX()+3][p3.getY()-3]==3)))) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_right_3( Pion p1, Pion p2, Pion p3,int tab[][],int joueur)
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
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la même lignes, on verrifie donc que les 3 cases en haut à gauche sont vides.
		{
			if ((tab[p1.getX()+1][p1.getY()+1]==0) && (tab[p2.getX()+1][p2.getY()+1]==0) && (tab[p3.getX()+1][p3.getY()+1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p1.getX()+1][p1.getY()+1]==0) && (tab[p2.getX()+1][p2.getY()+1]==0) && (tab[p3.getX()+1][p3.getY()+1]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2)) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p3.getX()+1][p3.getY()+1]==0) || ((((joueur==1) && (tab[p3.getX()+1][p3.getY()+1]==2))||((joueur==2) && (tab[p3.getX()+1][p3.getY()+1]==1))) && ((tab[p3.getX()+2][p3.getY()+2]==0) || (tab[p3.getX()+2][p3.getY()+2]==3))) || ((((joueur==1) && (tab[p3.getX()+1][p3.getY()+1]==2) && (tab[p3.getX()+2][p3.getY()+2]==2))||((joueur==2) && (tab[p3.getX()+1][p3.getY()+1]==1) && (tab[p3.getX()+2][p3.getY()+2]==1))) && ((tab[p3.getX()+3][p3.getY()+3]==0) || (tab[p3.getX()+3][p3.getY()+3]==3)))) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}
	
	public void move_3( Pion p1, Pion p2, Pion p3, Direction dir,int tab[][], Possible alignment)
	{
		switch(dir)
		{
			case LEFT : move_left_3( p1, p2, p3, tab,alignment); 
				break;
			case RIGHT : move_right_3( p1, p2, p3, tab,alignment); 
				break;
			case UPLEFT : move_up_left_3( p1, p2, p3, tab,alignment); 	
				break;
			case UPRIGHT : move_up_right_3( p1, p2, p3, tab,alignment); 
				break;
			case DOWNLEFT : move_down_left_3(p1, p2, p3, tab,alignment); 
				break;
			case DOWNRIGHT : move_down_right_3( p1, p2, p3, tab,alignment); 
				break;
			default : break;
		}
	}
	public void move_left_3 (Pion p1,Pion p2,Pion p3,int tab[][],Possible alignment)
	{
		int x,y;
		if (alignment != Possible.LINE)
		{
			tab[p1.getX()][p1.getY()-2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()][p2.getY()-2]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()][p3.getY()-2]=tab[p3.getX()][p3.getY()];
			tab[p3.getX()][p3.getY()]=0;
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
			if (tab[p3.getX()][p3.getY()-2] != 0)
			{
				if (tab[p3.getX()][p3.getY()-4] == 0)
				{
					tab[p3.getX()][p3.getY()-4]=tab[p3.getX()][p3.getY()-2];
				}
				else
				{
					tab[p3.getX()][p3.getY()-6]=tab[p3.getX()][p3.getY()-2];
				}
			}
			tab[p3.getX()][p3.getY()-2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_right_3 (Pion p1,Pion p2,Pion p3,int tab[][],Possible alignment)
	{
		int x,y;
		if (alignment != Possible.LINE)
		{
			tab[p1.getX()][p1.getY()+2] = tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()][p2.getY()+2] = tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()] = 0;
			tab[p3.getX()][p3.getY()+2] = tab[p3.getX()][p3.getY()];
			tab[p3.getX()][p3.getY()] = 0;
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
			if (tab[p3.getX()][p3.getY()+2] != 0)
			{
				if (tab[p3.getX()][p3.getY()+4] == 0)
				{
					tab[p3.getX()][p3.getY()+4]=tab[p3.getX()][p3.getY()+2];
				}
				else
				{
					tab[p3.getX()][p3.getY()+6]=tab[p3.getX()][p3.getY()+2];
				}
			}
			tab[p3.getX()][p3.getY()+2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_up_left_3 (Pion p1, Pion p2,Pion p3,int tab[][],Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DL) //Cas où les pions sont sur la même ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()-1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()-1][p2.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()-1][p3.getY()-1]=tab[p3.getX()][p3.getY()];
			tab[p3.getX()][p3.getY()]=0;
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
			if (tab[p3.getX()-1][p3.getY()-1] != 0)
			{
				if (tab[p3.getX()-2][p3.getY()-2] == 0)
				{
					tab[p3.getX()-2][p3.getY()-2]=tab[p3.getX()-1][p3.getY()-1];
				}
				else
				{
					tab[p3.getX()-3][p3.getY()-3]=tab[p3.getX()-1][p3.getY()-1];
				}
			}
			tab[p3.getX()-1][p3.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_up_right_3 (Pion p1, Pion p2,Pion p3,int tab[][],Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DR) //Cas où les pions sont sur la même ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()-1][p1.getY()+1]=tab[p1.getX()][p1.getY()];	tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()-1][p2.getY()+1]=tab[p2.getX()][p2.getY()];	tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()-1][p3.getY()+1]=tab[p3.getX()][p3.getY()];	tab[p3.getX()][p3.getY()]=0;
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
			if (tab[p3.getX()-1][p3.getY()+1] != 0)
			{
				if (tab[p3.getX()-2][p3.getY()+2] == 0)
				{
					tab[p3.getX()-2][p3.getY()+2]=tab[p3.getX()-1][p3.getY()+1];
				}
				else
				{
					tab[p3.getX()-3][p3.getY()+3]=tab[p3.getX()-1][p3.getY()+1];
				}
			}
			tab[p3.getX()-1][p3.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_down_left_3 (Pion p1, Pion p2,Pion p3,int tab[][], Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DR) //Cas où les pions sont sur la même ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()+1][p1.getY()-1]=tab[p1.getX()][p1.getY()];	tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()+1][p2.getY()-1]=tab[p2.getX()][p2.getY()];	tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()+1][p3.getY()-1]=tab[p3.getX()][p3.getY()];	tab[p3.getX()][p3.getY()]=0;
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
			if (tab[p3.getX()+1][p3.getY()-1] != 0)
			{
				if (tab[p3.getX()+2][p3.getY()-2] == 0)
				{
					tab[p3.getX()+2][p3.getY()-2]=tab[p3.getX()+1][p3.getY()-1];
				}
				else
				{
					tab[p3.getX()+3][p3.getY()-3]=tab[p3.getX()+1][p3.getY()-1];
				}
			}
			tab[p3.getX()+1][p3.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}

	public void move_down_right_3 (Pion p1, Pion p2,Pion p3,int tab[][],Possible alignment)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DL) //Cas où les pions sont sur la même ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()+1][p1.getY()+1]=tab[p1.getX()][p1.getY()];	tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()+1][p2.getY()+1]=tab[p2.getX()][p2.getY()];	tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()+1][p3.getY()+1]=tab[p3.getX()][p3.getY()];	tab[p3.getX()][p3.getY()]=0;
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
			if (tab[p3.getX()+1][p3.getY()+1] != 0)
			{
				if (tab[p3.getX()+2][p3.getY()+2] == 0)
				{
					tab[p3.getX()+2][p3.getY()+2]=tab[p3.getX()+1][p3.getY()+1];
				}
				else
				{
					tab[p3.getX()+3][p3.getY()+3]=tab[p3.getX()+1][p3.getY()+1];
				}
			}
			tab[p3.getX()+1][p3.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	

}

