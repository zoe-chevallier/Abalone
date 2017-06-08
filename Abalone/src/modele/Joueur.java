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
	
	
}
