import javax.swing.ImageIcon;

public class Tomato extends Weapons {
    public Tomato(){
        super();
    }

    public Tomato(int x, int y){
       super(x,y,100,100,100,200, 75,new ImageIcon("Tomato.png"),"Tomato","Caitlyn");
    }
    public String toString(){
        return "Tomato";
    }
}
                