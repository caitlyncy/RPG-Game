import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.ArrayList;


public class Characters {
    private int x,y,w,h, speed, health, damage, stam, dx, dy;
    private ImageIcon pic;
    private String type;
    private ArrayList <Weapons> weaponList;
    private Weapons weap;

    public Characters() {
        x=0;
        y=0;
        w=0;
        h=0;
        speed=0;
        health=0;
        damage=0;
        stam=0;
        dx=0;
        dy=0;
        pic = new ImageIcon(); 
        type="";
    }
    public Characters(int xV, int yV, int width, int height, int sp, int hea, int dam, int st, ImageIcon p, Weapons we, ArrayList<Weapons> list){
        x=xV;
        y=yV;
        w=width;
        h=height;
        speed = sp;
        health = hea;
        damage= dam;
        stam= st;
        weap=we;
        pic= p;
        dx=0;
        dy=0;
        weaponList = list;
        }
        
        public Weapons getWeapon(){
            return weap;
        }
        public void setWeapons(ArrayList <Weapons> list){
        weaponList=list;
        }
    public Characters(int xV, int yV, int width, int height, int sp, int hea, int dam, int st, ImageIcon p, String t){
    x=xV;
    y=yV;
    w=width;
    h=height;
    speed = sp;
    health = hea;
    damage= dam;
    stam= st;
    pic= p;
    dx=0;
    dy=0;
    type=t;
    }
    public void drawChar (Graphics g2d) {
        g2d.drawImage(pic.getImage(),x,y,w,h,null);
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

    public int getHEA() {
        return this.health;
    }

    public int getDAM() {
        return this.damage;
    }
        
    public int getSTAM() {
        return this.stam;
    }

    public int getDX() {
        return this.dx;
    }

    public int getDY() {
        return this.dy;
    }

    public ImageIcon pic() {
        return this.pic;
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

    public void setHEA(int health) {
        this.health = health;
    }

    public void setDAM(int damage) {
        this.damage = damage;
    }

    public void setSTAM(int stam) {
        this.stam = stam;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public void setPIC(ImageIcon pic) {
        this.pic = pic;
    }

    public ImageIcon getPic(){
        return pic;
    }
    public void setPic (ImageIcon pic) {
        this.pic= pic;
    }
    
    public Characters dam(int dam){
        setDAM(dam);
        return this;
    }

    public Characters stam(int stam){
        setSTAM(stam);
        return this;
    }

    public Characters pic(ImageIcon pic) {
        setPIC(pic);
        return this;
    }
public String toString(){
    return "Haven't set toString Yet!";

}
 public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}