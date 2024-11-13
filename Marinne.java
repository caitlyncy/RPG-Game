import javax.swing.ImageIcon;
public class Marinne extends Characters{
    public Marinne(){
        super();

    }

    public Marinne(int x, int y){
        super(x,y,100,100,2,7,76,56, new ImageIcon("Marinne.png"));
    }
    public String toString(){
        return "Marinne";
    }
    }
