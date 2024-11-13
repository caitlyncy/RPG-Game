import javax.swing.ImageIcon;

public class Grater extends Weapons {
    public Grater(){
        super();
    }

    public Grater(int x, int y){
       super(x,y,100,100,100,2,159,new ImageIcon("Grater.png"),"Grater","Aliki");
    }
    public String toString(){
        return "Grater";
    }
}
                