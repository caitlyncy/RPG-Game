import javax.swing.ImageIcon;

public class Roller extends Weapons {
    public Roller(){
        super();
    }

    public Roller(int x, int y){
       super(x,y,100,100,100,2,159,new ImageIcon("Roller.png"),"Roller","Campbell");
    }
    public String toString(){
        return "Roller";
    }
}
                