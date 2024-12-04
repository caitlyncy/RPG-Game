import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Weapons {
int x, y, w, h,dam, durability, dps;
private ImageIcon pic;
private String type, character;
private int dx;
private int dy;

public Weapons(){
x=0;
y=0;
w=0;
h=0;
dx=0;
dy=0;
dam=0;
durability=0;
dps=0;
pic = new ImageIcon(); 
type ="";
character ="";



}
public Weapons(int xV, int yV, int wV, int hV, int d, int dur, int dp, ImageIcon p, String t, String c){
    x=xV;
    y=yV;
    w=wV;
    h=hV;
    dx=0;
    dy=0;
    dam= d;
    durability = dur;
    pic=p;
    dps=dp;
    type =t;
    character = c;

}
public int getDx() {
    return this.dx;
  }
  public void setDx(int value) {
    this.dx = value;
  }

  public int getDy() {
    return this.dy;
  }
  public void setDy(int dy) {
    y+= dy;
  }
public void drawWeap (Graphics g2d) {
    g2d.drawImage(pic.getImage(),x,y,w,h,null);

}
public String getCharacter(){
    return character;
}
public void setCharacter(String character){
    this.character= character;
}
public int getDam() {
    return dam;
}

public void setDamage(int damage) {
    this.dam = damage;
}

public int getDurability() {
    return durability;
}

public void setDurability(int dur) {
    this.durability = dur;
}

public int getDps() {
    return dps;
}

public void setDps(int dps) {
    this.dps = dps;
}
public int getX() {
    return this.x;
}

public int getY() {
    return this.y;
}

public void setX(int x) {
    this.x = x;
}

public void setY(int y) {
    this.y = y;
}
public int getW() {
    return this.w;
}

public int getH() {
    return this.h;
}
public void setW(int w) {
    this.w = w;
}

public void setH(int h) {
    this.h = h;
}
public String getType() {
    return type;
}
public void setType(String type){
    this.type = type;
}
public ImageIcon getPic(){
    return pic;
}
public void setPic (ImageIcon pic) {
    this.pic= pic;
}
public String toString(){
    return "Haven't set toString Yet!";

}
    
}
