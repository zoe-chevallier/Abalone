package modele;

import java.awt.*;
import java.util.ArrayList;

public class Joueur {
	private int score;
	private String nom;
	private Color couleur;
	private ArrayList<Pion> listePions;
	
	public Joueur(String nom, Color couleur){
		this.score=0;
		this.nom=nom;
		this.couleur=couleur;
		listePions = new ArrayList<Pion>();
		if (couleur == Color.black){
			Pion p1 = new Pion(5,1,this);
			Pion p2 = new Pion(7,1,this);
			Pion p3 = new Pion(9,1,this);
			Pion p4 = new Pion(11,1,this);
			Pion p5 = new Pion(13,1,this);
			Pion p6 = new Pion(4,2,this);
			Pion p7 = new Pion(6,2,this);
			Pion p8 = new Pion(5,1,this);
			Pion p9 = new Pion(7,1,this);
			Pion p10 = new Pion(9,1,this);
			Pion p11 = new Pion(11,1,this);
			Pion p12 = new Pion(13,1,this);
			Pion p13 = new Pion(4,2,this);
			Pion p14 = new Pion(6,2,this);
		}
		else if (couleur == Color.white){
			
			}
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
	
	public ArrayList<Pion> getListePions(){
		return listePions;
	}
	
	public void afficheListe(){
		for (Pion p : listePions)
			System.out.println(p.toString());
	}
	
	public void modifiePion(Pion p, int modif){
		int i = listePions.indexOf(p);
		System.out.println(i);
		/*listePions.remove(i);
		p.setX(modif);
		listePions.add(p);*/
		
		
	}
}
