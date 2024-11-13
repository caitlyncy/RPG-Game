import javax.swing.ImageIcon;

public class Ranged extends Weapons {
    public Ranged(){
        super();
    }
    public Ranged(int x, int y, int w, int h, int d, int dur, int dp, ImageIcon p, String t, String c){
super(x,y,w,h ,d,dur,dp,p, t, c);

    }
    public void setDx(int Dx) {
    this.x=+Dx; 

}


}
