package modele;

import java.awt.*;
import java.util.ArrayList;

public class Joueur {
	private int score;
	private String nom;
	private Color couleur;
	
	
	public Joueur(String nom, Color couleur){
		this.score=0;
		this.nom=nom;
		this.couleur=couleur;
	}

	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		this.score=score;
	}
	
	public String getNom(){
		return nom;
	}

	public void setNom(String nom){
		this.nom=nom;
	}
	
	public Color getCouleur(){
		return couleur;
	}
	
	public void setCouleur(){
		this.couleur=couleur;
	}
	
	public void calculeScore(PlateauAbalone jeu){
		int cpt = 0;
		int opponent;
		if (couleur == Color.BLACK)
			opponent =1;
		else 
			opponent =2;
		for (int i=0;i<11;i++){
			for (int j=0;j<21;j++){
				if (jeu.getPlateau()[i][j] == opponent)
					cpt++;
			}	
		}
		score = 14-cpt;
	}
}
