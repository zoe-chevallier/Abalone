package modele;

public class Pion {
	private int x; //Corresponds aux coordonées
	private int y;
	private Joueur joueur;
	
	public Pion(int x,int y, Joueur joueur){
		this.x=x;
		this.y=y;
		this.joueur=joueur;
	}
	
	public Joueur getJoueur(){
		return joueur;
	}
	
	public void setJoueur(Joueur joueur){
		this.joueur=joueur;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}

	public String toString() {
		return "Pion [x=" + x + ", y=" + y +"]";
	}
}
