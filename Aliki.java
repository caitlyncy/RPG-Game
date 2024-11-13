import javax.swing.ImageIcon;
public class Aliki extends Characters {
    public Aliki(){
        super();

    }

    public Aliki(int x, int y){
        super(x,y, 100,100,2,7,76,36, new ImageIcon("Aliki.png"));
    }
    public String toString(){
        return "Aliki";
    }
 }
