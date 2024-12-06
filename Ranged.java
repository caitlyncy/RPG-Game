import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Ranged {
    private int x, y,w,h;
    private int speed;
    private ImageIcon image;
    private String type;

    public Ranged() {
        x=0;
        y=0;
        w=0;
        h=0;
        speed=0;
        type = "";

        image = new ImageIcon(); 
    }

    public Ranged(int xV, int yV, int wV, int hV, int s, ImageIcon p,String t) {
        x=xV;
        y=yV;
        w=wV;
        h=hV;
        speed=s;
        image=p;
        type = t;

    }

    public void drawProj (Graphics g2d) {
        g2d.drawImage(image.getImage(),x,y,w,h,null);
    
    }

    //  public void setDx(int Dx) {
    //      this.x = +Dx;

    //  }

    // public Ranged(int startX, int startY) {
    //     this.x = startX;
    //     this.y = startY;
    //     this.speed = 3;
    //     this.image = new ImageIcon();
    // }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void move() {
        x += speed; // Move weapon to the left
    }

    public void draw(Graphics g) {
        g.drawImage(image.getImage(), x, y, null);
    }

    // public int getX() {
    //     return x;
    // }


    // public int getY() {
    //     return y;
    // }

    public boolean isOffScreen(int width) {
        return x > width; // Check if the projectile is off-screen
    }

    public static void add(Ranged ranged) {

    }


    public int getX() {
        return this.x;
        //check for mousecollision
    }

    public int getY() {
        return this.y;
    }

    public int getW() {
        return this.w;
    }

    public int getH() {
        return this.h;
    }

    public int getSP() {
        return this.speed;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setSP(int speed) {
        this.speed = speed;
    }

    public ImageIcon getPic(){
        return image;
    }
    public void setPic (ImageIcon image) {
        this.image= image;
    }

}
