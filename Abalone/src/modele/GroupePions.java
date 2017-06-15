package modele;

public class GroupePions {
	@Override
	public String toString() {
		return "GroupePions [p1=" + p1.toString() + ", p2=" + p2.toString() + ", p3=" + p3.toString() + "]";
	}
	private Pion p1;
	private Pion p2;
	private Pion p3;
	
	public GroupePions(Pion p1,Pion p2,Pion p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	public Pion getP1() {
		return p1;
	}
	public void setP1(Pion p1) {
		this.p1 = p1;
	}
	public Pion getP2() {
		return p2;
	}
	public void setP2(Pion p2) {
		this.p2 = p2;
	}
	public Pion getP3() {
		return p3;
	}
	public void setP3(Pion p3) {
		this.p3 = p3;
	}
	
	
}
