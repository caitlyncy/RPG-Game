import javax.swing.ImageIcon;
public class Doughboy extends Enemy {
    public Doughboy(){
        super();

    }

    public String toString(){
        return "Doughboy";

    }
public Doughboy(int x, int y){
    super(x,y,200,200,2,172,200,5, new ImageIcon("Doughboy.png"), new Tomato());
}
}
