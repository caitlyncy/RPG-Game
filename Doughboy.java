import javax.swing.ImageIcon;
public class Doughboy extends Enemy {
    public Doughboy(){
        super();

    }

    public String toString(){
        return "Doughboy";

    }
public Doughboy(int x, int y, int w, int h){
    super(x,y,200,200,2,172,200,5, new ImageIcon("Doughboy.png"), new Tomato(), "Doughboy");
}
public void setdx(int dx1){
    move(dx1);
    //super.setY(dx1);
}
public void setdy(int dy1){
  moveY(dy1);
    // super.setY(dy1);
}   
 public void move(int dx1){
  super.setX(super.getX()+dx1);
//  y+=dy;
}

public void moveY(int dy1){
super.setY(super.getY()+dy1);
//  y+=dy;
}


    // super.setY(dy1);
}   

