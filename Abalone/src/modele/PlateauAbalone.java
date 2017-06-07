package modele;
import java.util.ArrayList;

public class PlateauAbalone {
	private int nbjoueurs;
	private ArrayList<Pion> casesvides;
	
	public PlateauAbalone(){
		this.nbjoueurs = 2;
		casesvides = new ArrayList<Pion>();
		for (int i=3;i<=5;i=i+2){
			Pion c = new Pion(i,3,null);
			casesvides.add(c);
			Pion ca = new Pion(i,7,null);
			casesvides.add(ca);			
		}
		for (int i=13;i<=15;i=i+2){
			Pion c = new Pion(i,3,null);
			casesvides.add(c);
			Pion ca = new Pion(i,7,null);
			casesvides.add(ca);			
		}
		for (int i=2;i<=16;i=i+2){
			Pion c = new Pion(i,4,null);
			casesvides.add(c);
			Pion ca = new Pion(i,6,null);
			casesvides.add(ca);
		}
		for (int i=1;i<=17;i=i+2){
			Pion c = new Pion(i,5,null);
			casesvides.add(c);
		}		
	}
	
	public void affichePlateau(Joueur j1, Joueur j2){
		for (int i=1;i<=9;i++){
			for (int j=1;j<=17;j++){
				int ca = 0;
				for (Pion p : casesvides){
					if (p.getX() == j && p.getY()==i){
						System.out.print(" *");
						ca=1;
						break;
					}
				}
				for (Pion p : j1.getListePions()){
					if (p.getX()== j && p.getY() == i){
						System.out.print(" 1");
						ca=1;
						break;
					}						
				}
				for (Pion p : j2.getListePions()){
					if (p.getX()== j && p.getY() == i){
						System.out.print(" 2");
						ca=1;
						break;
					}						
				}
				if (ca == 0){
					System.out.print("  ");
				}
			}
			System.out.println();
			
			
		}
	}	
}