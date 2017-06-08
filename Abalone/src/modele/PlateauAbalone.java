package modele;
import java.util.ArrayList;

public class PlateauAbalone {
	private int[][] plateau;
	
	public PlateauAbalone(){
		int tableau[][] =   {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
							{5,5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5,5},
							{5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5},
							{5,5,3,5,0,5,0,5,2,5,2,5,2,5,0,5,0,5,3,5,5},
							{5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
							{3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3},
							{5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
							{5,5,3,5,0,5,0,5,1,5,1,5,1,5,0,5,0,5,3,5,5},
							{5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5},
							{5,5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5,5},
							{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
		
		this.plateau = tableau;
				
	}
	
	public void affichePlateau(){
		for (int i=0;i<11;i++){
			for (int j=0;j<21;j++){
				if (plateau[i][j] == 1){
					System.out.print(" 1");
				}
				else if (plateau[i][j] == 2){
					System.out.print(" 2");
				}
				else if (plateau[i][j] == 0){
					System.out.print(" *");
				}
				else 
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	public int[][] getPlateau(){
		return plateau;
	}

}