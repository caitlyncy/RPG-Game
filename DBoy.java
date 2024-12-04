import javax.swing.ImageIcon;

public class DBoy extends Weapons{

    private int width, height;

   

    public DBoy(int xV, int yV, int w, int h){
        super(xV, yV, 100, 100, 2, 2, 2, new ImageIcon("Tomato.png"), "Tomato", "DoughBoy");
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


}
