import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Queue;
import java.util.LinkedList;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    private BufferedImage back;
    private int key, x, y;
    private ArrayList<Characters> charList;
    private ArrayList<Weapons> weaponList;
    private String screen;
    private Characters player;
    private ImageIcon background;
    private boolean campbellselected;
    private boolean alikiselected;
    private boolean caitlynselected;
    private boolean marinneselected;
    private Weapons weapon;
    private String welcome;
    private double time;
    private int i;
    private ArrayList <Ranged> rangedWeap;
    private Queue <Enemy> enemies;

    public Game() {
        new Thread(this).start();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        key = -1;
        x = 0;
        y = 0;

        background = new ImageIcon("Background.jpeg");

        weaponList = setWeaponList();

        campbellselected = false;
        alikiselected = false;
        caitlynselected = false;
        marinneselected = false;

      rangedWeap= new ArrayList <Ranged>();
        screen = "start";
        welcome = "Welcome to the Pizzeria";
		time=System.currentTimeMillis();
        
        charList = setCharList();
        enemies = setEs();
        System.out.println(enemies.size());
    }
public Queue <Enemy> setEs(){
    Queue <Enemy> temp = new LinkedList<>();
    temp.add(new Doughboy(600,400));
    temp.add(new Doughboy(720,400));
    temp.add(new Doughboy(850,400));
    return temp;
}
  



    public ArrayList<Characters> setCharList() {
        ArrayList<Characters> temp = new ArrayList<>();
        temp.add(new Caitlyn(50, 100));
        temp.add(new Campbell(220, 100));
        temp.add(new Marinne(330, 100));
        temp.add(new Aliki(140, 100));
        return temp;
    }

    public ArrayList<Weapons> setWeaponList() {
        ArrayList<Weapons> temp = new ArrayList<Weapons>();
        temp.add(new Roller(230, 100));
        temp.add(new Tomato(55, 100));
        temp.add(new Grater(150, 100));
        temp.add(new Water(340, 100));
        return temp;
    }
    public void run() {
        try {
            while (true) {
                Thread.sleep(5);  
                repaint();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void paint(Graphics g) {
        Graphics2D twoDgraph = (Graphics2D) g;
        if (back == null) {
            back = (BufferedImage) createImage(getWidth(), getHeight());
        }

        Graphics g2d = back.createGraphics();

    
        g2d.clearRect(0, 0, getSize().width, getSize().height);

       
        if (background != null) {
            g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
        }

        
        drawScreens(g2d);
        welcome.substring(0,i);
    
        twoDgraph.drawImage(back, null, 0, 0);
    }
    public void drawPW(Graphics g2d) {
        for(Ranged pw: rangedWeap) {
          g2d.drawImage(pw.getPic().getImage(), pw.getX(), pw.getY(), pw.getW(), pw.getH(), this);
     
          pw.setDx(3);
        }
    }

    public void drawScreens(Graphics g2d) {
        switch (screen) {
            case "start":
                drawStartScreen(g2d);
                break;
            case "selection":
                drawSelectScreen(g2d);
                break;
                case "weaponSelect":
                drawWeaponSelectScreen(g2d);
                break;
                case "gameplay":
                drawGameScreen(g2d);
        }
    }
    public void drawGameScreen(Graphics g2d){
       if (player!=null)

       player.setX(player.getX()+player.getDX());
       player.setY(player.getY()+player.getDY());

        player.drawChar(g2d); 
      //  if(!rangedWeap.isEmpty()){
            //loop draw all weapons
        
       // }
        if (enemies.peek() != null) {
			enemies.peek().drawChar(g2d);
		}
        drawPW(g2d);

    }
    
    public void drawStartScreen(Graphics g2d) {
        g2d.setFont(new Font("Broadway", Font.BOLD, 100));

        for (Characters c : charList) {
            c.drawChar(g2d);
            
        }
        g2d.drawString(welcome.substring(0,i),500,400);
        if (i<welcome.length()){
            if (System.currentTimeMillis()-time>100){
                time=System.currentTimeMillis();
                i++;
            }
        }
    }

    
    public void drawSelectScreen(Graphics g2d) {
        if (player != null) {
            player.drawChar(g2d);
            g2d.setFont(new Font("Broadway", Font.BOLD, 50));
            g2d.drawString("You picked " + player.toString(), 200, 500);
        }
    }
    public void drawWeaponSelectScreen(Graphics g2d) {
    g2d.setFont(new Font("Broadway", Font.BOLD, 50));

      //  g2d.drawString("Select your weapon", 100, 100);
        if (weapon != null) {
            weapon.drawWeap(g2d);
            g2d.drawString("This character uses " + weapon.toString(), 800, 200);
            g2d.drawString("Damage: " + weapon.getDam(), 800, 250);
            g2d.drawString("Durability: " + weapon.getDurability(), 800, 300);
            g2d.drawString("DPS: " + weapon.getDps(), 800, 350);
            //g2d.drawString("Press space to start", 800, 700);
           // g2d.drawString("Press esc to go back", 800, 750);
        }
    }
    public void attack(){
        //System.out.println("hello");

       // if (player.getWeapon() instanceof Ranged){
            rangedWeap.add(new Ranged(player.getX(),player.getY(), player.getW(), player.getH(), weapon.getDam(), weapon.getDurability(),weapon.getDps(),weapon.getPic(), weapon.getType(), weapon.getCharacter()));
            System.out.println("attacking");
            enemies.remove();

       // }
       // else{
            
        //}
    }
    // Handle key presses for selecting characters
    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        System.out.println("Key pressed: " + key);

        if (key == KeyEvent.VK_D )
            player.setDX(2);

        if (key == KeyEvent.VK_W)
            player.setDY(-2);

         if (key == KeyEvent.VK_A)
            player.setDX(-2);

        if (key == KeyEvent.VK_S)
            player.setDY(2);

        if(key==49){
                screen = "selection";
                player = charList.get(0);  
                caitlynselected = true;
                alikiselected = false;
                campbellselected = false;
                marinneselected = false;
                
		}
		if(key==50){
			screen = "selection";
			player = charList.get(3);  
			caitlynselected = false;
			alikiselected = true;
			campbellselected = false;
			marinneselected = false;
			
	}
		if(key==51){  
                screen = "selection";
                player = charList.get(1);  
                caitlynselected = false;
                alikiselected = false;
                campbellselected = true;
                marinneselected = false;
               
		}
		if(key==52){ 
                screen = "selection";
                player = charList.get(2);  
                caitlynselected = false;
                alikiselected = false;
                campbellselected = false;
                marinneselected = true;
               
		}
		if(key==65&& screen=="weaponSelect"){
            screen= "gameplay";
        }

        if (screen=="gameplay" && key== 32){
            attack();
        }
    
    }


    // Other required overrides for keyboard and mouse inputs
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) {
        if (key == KeyEvent.VK_D)
        player.setDX(0);
        
        if (key == KeyEvent.VK_W)
            player.setDY(0);
            if (key == KeyEvent.VK_A)
            player.setDX(0);

        if (key == KeyEvent.VK_S)
            player.setDY(0);
     }
    @Override
    public void mouseDragged(MouseEvent e) { }
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        /*for (int i = 0; i < weaponList.size(); i++) {
            if ((screen.equals("weaponSelect")) && (weaponList.get(i).getX() + weaponList.get(i).getW() >= x && weaponList.get(i).getX() <= x && weaponList.get(i).getY() + weaponList.get(i).getH() >= y && weaponList.get(i).getY() <= y)) {
                weapon = weaponList.get(i);
            }
         }/* */
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        for (int i = 0; i < charList.size(); i++) {
            if ((screen.equals("selection")) && (arg0.getButton() == 1) && (charList.get(i).getX() + charList.get(i).getW() >= x && charList.get(i).getX() <= x && charList.get(i).getY() + charList.get(i).getH() >= y && charList.get(i).getY() <= y)) {
                player = charList.get(i);
                screen = "weaponSelect";
            }
        }
        for (int i = 0; i < weaponList.size(); i++) {
            if ((screen.equals("weaponSelect")) && (arg0.getButton() == 1) && (weaponList.get(i).getX() + weaponList.get(i).getW() >= x && weaponList.get(i).getX() <= x && weaponList.get(i).getY() + weaponList.get(i).getH() >= y && weaponList.get(i).getY() <= y)) {
                weapon = weaponList.get(i);
                //screen = "game";
            }
        }
    }


     
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
}
