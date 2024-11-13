import javax.swing.ImageIcon;

public class Water extends Weapons {
    public Water(){
        super();
    }

    public Water(int x, int y){
       super(x,y,100,100,100,2,159,new ImageIcon("Water.png"),"Water","Marinne");
    }
    public String toString(){
        return "Water";
    }
}
                