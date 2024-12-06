import javax.swing.ImageIcon;
import java.util.ArrayList;
public class Campbell extends Characters {
    public Campbell(){
        super();

    }

    public Campbell(int x, int y){
       super(x,y, 100,100,2,7,76,36, new ImageIcon("Campbell.png"), "Campbell");
    }
    public String toString(){
        return "Campbell";
    }
}
   