import javax.swing.ImageIcon;
public class Caitlyn extends Characters{
    public Caitlyn(){
        super();

    }

    public Caitlyn(int x, int y){
        super(x,y, 100,100, 2,7,76,2, new ImageIcon("Caitlyn.png"));
    }
    public String toString(){
        return "Caitlyn";
    }
    
}
