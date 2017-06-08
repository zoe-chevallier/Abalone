package modele;

public class Pion {
	private int x; //Corresponds aux coordonées
	private int y;

	
	public Pion(int x,int y){
		this.x=x;
		this.y=y;
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
	
	public void modifieX(int valeur){
		x+=valeur;
	}
	public void modifieY(int valeur){
		y+=valeur;
	}
}
