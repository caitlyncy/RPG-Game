import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    private BufferedImage back;
    private int key, x, y, Dx, Dy, bestTime, lastBestTime;
    private int timer;
    private int score;
    private double curtime;
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
    private ArrayList<Doughboy> DShip;

    private int i;
    private boolean win, moveRight;
    private Queue<Enemy> enemies;
    private ArrayList<Doughboy> Doughboy;
    private ArrayList<Ranged> rangeds; // List to hold projectiles

    private File saveFile;

    public Game() {
        new Thread(this).start();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        key = -1;
        x = 0;
        y = 0;
        curtime = 0;
         timer=0;
        // bestTime=0;
        curtime = timer;
        saveFile = new File("saved_file2.0.txt");
        // DBoy= new ArrayList <DBoy>();
        moveRight = true;
        win = false;

        background = new ImageIcon("Background.jpeg");
        // DShip = setDShips();
        weaponList = setWeaponList();

        campbellselected = false;
        alikiselected = false;
        caitlynselected = false;
        marinneselected = false;
        rangeds = new ArrayList<>();

        screen = "start";
        welcome = "Welcome to the Pizzeria";
        time = System.currentTimeMillis();

        charList = setCharList();
        enemies = setEs();
        System.out.println(enemies.size());
        
    }

    public void createFile() {

        try {
            if (saveFile.createNewFile()) {
                System.out.println("Successfully created file!");
            } else {
                System.out.println("File already exists");

            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void readFile() {
        Scanner sc;
        try {
            sc = new Scanner(saveFile);
            if (sc.hasNextInt()) {
                lastBestTime = sc.nextInt();
                if (lastBestTime < curtime) {

                    bestTime = (int) curtime;
                } else {
                    bestTime = lastBestTime;

                }
            }
            sc.close();

            // while (sc.hasNext()){
            // System.out.println(sc.nextLine());
            // }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }
    public void writeToFile() {
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(saveFile);
            myWriter.write((bestTime) + "\n");
             myWriter.write(new DecimalFormat("#0.00").format(curtime));
            myWriter.close();
            System.out.println("Successfully wrote to file");
        } catch (IOException e) {

            e.printStackTrace();
        }

        // write whatever you want

    }

    public Queue<Enemy> setEs() {
        Queue<Enemy> temp = new LinkedList<>();
        temp.add(new Doughboy(600, 400, 200, 200));
        temp.add(new Doughboy(720, 400, 200, 200));
        temp.add(new Doughboy(850, 700, 200, 200));
        temp.add(new Doughboy(950, 500, 200, 200));
        temp.add(new Doughboy(850, 200, 200, 200));
        temp.add(new Doughboy(950, 400, 200, 200));
        return temp;
    }

    public void shootWeapon() {
        // for (Ranged rang: rangeds){
        // // int startX = player.getX() + player.getW() - 400;
        // // int startY = player.getY() + player.getH() / 8;
        // // rangeds.setDx(-5);
        // // System.out.println("shooting");
        if (player.getType().equals("Caitlyn")) {
            rangeds.add(new TomatoProjectile(weapon.getX(), weapon.getY()));

        }
        if (player.getType().equals("Marinne")) {
            rangeds.add(new WaterProjectile(weapon.getX(), weapon.getY()));

        }if (player.getType().equals("Aliki")) {
            rangeds.add(new GraterProjectile(weapon.getX(), weapon.getY()));

        }if (player.getType().equals("Campbell")) {
            rangeds.add(new RollerProjectile(weapon.getX(), weapon.getY()));

        }


//if check weapon-> give the weapon its respective projectile.
    }
    private void pAttack(Graphics g2d){

    }
    private void updateWeapon(Graphics g2d) {
        for (int i = 0; i < rangeds.size(); i++) {
            Ranged rang = rangeds.get(i);
            Rectangle r = new Rectangle(rang.getX(), rang.getY(), rang.getW(), rang.getH());
            Rectangle e = new Rectangle(enemies.element().getX(), enemies.element().getY(), enemies.element().getW(), enemies.element().getH());
            rang.move(); // Move the weapon
            rang.drawProj(g2d);
                if (r.intersects(e)) {
                    enemies.remove(); // Remove the enemy on collision
                    rangeds.remove(i); // Remove the projectile on collision
                    i--;
                    System.out.println("this is working?a");
                    break; 
                }
            

            // Remove projectile if it goes off screen
            if (rang.isOffScreen(getWidth())) {
                rangeds.remove(i);
                i--; // Adjust index after removal
            }
        }
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
        welcome.substring(0, i);

        twoDgraph.drawImage(back, null, 0, 0);
    }

    public void checkWeap() {
        if (weapon != null && player != null) {
            weapon.setX(player.getX() + 60);
            weapon.setY(player.getY());


        }
        
    }
    /*
     * public void drawPW(Graphics g2d) {
     * for(Ranged pw: rangedWeap) {
     * g2d.drawImage(pw.getPic().getImage(), pw.getX(), pw.getY(), pw.getW(),
     * pw.getH(), this);
     * 
     * checkWeap();
     * 
     * }
     * }
     */

    public void drawScreens(Graphics g2d) {
        switch (screen) {
            case "start":
                drawStartScreen(g2d);
                drawTime(g2d);

                break;
            case "selection":
                drawSelectScreen(g2d);
                drawTime(g2d);
                break;
            case "weaponSelect":
                drawWeaponSelectScreen(g2d);
                drawTime(g2d);
                break;
            case "gameplay":
                drawGameScreen(g2d);
                drawTime(g2d);

        }
    }

    public void drawGameScreen(Graphics g2d) {
        if (player != null)

            // drawDoughboys(g2d);
            // moveDoughboy();
            player.setX(player.getX() + player.getDX());
        player.setY(player.getY() + player.getDY());
        player.drawChar(g2d);
        // if(!rangedWeap.isEmpty()){
        // loop draw all weapons

        // Handle key presses for selecting characters
        // Ensure player remains within screen bounds
        if (player.getX() < 0)
            player.setX(0);
        if (player.getY() < 0)
            player.setY(0);
        if (player.getX() > getWidth() - player.getW())
            player.setX(getWidth() - player.getW());
        if (player.getY() > getHeight() - player.getH())
            player.setY(getHeight() - player.getH());
        // Draw projectiles

        attack(g2d);



        // }
        if (enemies.peek() != null) {
            enemies.peek().drawChar(g2d);
            // enemies.element().Move();

        }
        // drawPW(g2d);
        weapon.drawWeap(g2d);

        checkWeap();

    }

    public void changeDxDoughboy(int dx) {
        for (Doughboy db : DShip) {
            db.setdx(dx);
        }
    }

    /*
     * public void moveDoughboy(){
     * if(checkDoughboyWall()) {
     * changeDxDoughboy(30);
     * changeDxDoughboy(0);
     * }
     * for (Doughboy db:DShip){
     * if (moveRight==true){
     * db.setdx(2);
     * changeDxDoughboy(0);
     * }
     * else {
     * db.setdx(-2);
     * changeDxDoughboy(0);
     * }
     * }
     * }
     * 
     * public boolean checkDoughboyWall(){
     * for (Doughboy db:DShip){
     * if (db.getX()+db.getW()>=getWidth() || db.getX()<=0){
     * moveRight=!moveRight;
     * return true;
     * }
     * }
     * return false;
     * }
     * 
     * 
     * public ArrayList <Doughboy> setDShips(){
     * ArrayList <Doughboy> temp = new ArrayList <Doughboy>();
     * int x=75;
     * int y=100;
     * for(int i=0; i<3; i++) {
     * for(int j=0; j<7; j++) {
     * temp.add(new Doughboy(x, i+y, 50, 50));
     * y+=100;
     * }
     * y+=50;
     * x=75;
     * }
     * return temp;
     * }
     */
    public void drawTime(Graphics g2d){
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Broadway", Font.BOLD, 75));
        curtime = ((System.currentTimeMillis() - time )/ 1000);
        g2d.drawString(new DecimalFormat("#0.00").format(curtime), 20, 90);
    }
    public void drawStartScreen(Graphics g2d) {
        g2d.setFont(new Font("Broadway", Font.BOLD, 75));
        g2d.drawString("Longest Time Taken: " + lastBestTime, 100, 500);
   
        for (Characters c : charList) {
            c.drawChar(g2d);

        }
        g2d.drawString(welcome.substring(0, i), 500, 400);
        if (i < welcome.length()) {
            if (System.currentTimeMillis() - time > 100) {
                time = System.currentTimeMillis();
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

        // g2d.drawString("Select your weapon", 100, 100);
        if (weapon != null) {
            weapon.drawWeap(g2d);
            g2d.drawString("This character uses " + weapon.toString(), 800, 200);
            g2d.drawString("Damage: " + weapon.getDam(), 800, 250);
            g2d.drawString("Durability: " + weapon.getDurability(), 800, 300);
            g2d.drawString("DPS: " + weapon.getDps(), 800, 350);
            // g2d.drawString("Press space to start", 800, 700);
            // g2d.drawString("Press esc to go back", 800, 750);
        }
    }

    public void getDoughboyMissile(Graphics g2d) {
        int randDoughboy = (int) (Math.random() * Doughboy.size());
        {
            Doughboy.add(new Doughboy(Doughboy.get(randDoughboy).getX() + (Doughboy.get(randDoughboy).getW()) / 2,
                    Doughboy.get(randDoughboy).getY() + Doughboy.get(randDoughboy).getH(), 30, 30));
        }
    }

    public void drawDoughboyMissile(Graphics g2d) {
        for (Doughboy db : Doughboy) {
            g2d.drawImage(db.getPic().getImage(), db.getX(), db.getY(), db.getW(), db.getH(), this);
            db.setdx(-2);
        }
    }

    public void drawDoughboys(Graphics g2d) {
        for (Doughboy db : DShip) {
            g2d.drawImage(db.getPic().getImage(), db.getX(), db.getY(), db.getW(), db.getH(), this);
        }
    }

    public void attack(Graphics g2d) {
        // if(player.getWeapon() instanceof Ranged){
        // rangedWeap.add(new Ranged(player.getWeapon().getDamage(),
        // player.getWeapon().getDurability(), player.getWeapon().getDPS(),
        // player.getWeapon().getPic()));
        // shootWeapon(); // Move and handle projectiles
        updateWeapon(g2d); // Move and handle projectiles

        

        
        System.out.println("Attacking");
    }

    // enemies.remove()
    // }
    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        System.out.println("Key pressed: " + key);

        if (key == KeyEvent.VK_D)
            player.setDX(2);

        if (key == KeyEvent.VK_W)
            player.setDY(-2);

        if (key == KeyEvent.VK_A)
            player.setDX(-2);

        if (key == KeyEvent.VK_S)
            player.setDY(2);

        if (key == 49) {
            screen = "selection";
            player = charList.get(0);
            caitlynselected = true;
            alikiselected = false;
            campbellselected = false;
            marinneselected = false;

        }
        if (key == 50) {
            screen = "selection";
            player = charList.get(3);
            caitlynselected = false;
            alikiselected = true;
            campbellselected = false;
            marinneselected = false;

        }
        if (key == 51) {
            screen = "selection";
            player = charList.get(1);
            caitlynselected = false;
            alikiselected = false;
            campbellselected = true;
            marinneselected = false;

        }
        if (key == 52) {
            screen = "selection";
            player = charList.get(2);
            caitlynselected = false;
            alikiselected = false;
            campbellselected = false;
            marinneselected = true;

        }
        if (key == 65 && screen == "weaponSelect") {
            screen = "gameplay";

        }
        
        if (screen == "gameplay" && key == 32) {
            shootWeapon();

        }

    }

    // Other required overrides for keyboard and mouse inputs
    @Override
    public void keyTyped(KeyEvent e) {
    }

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
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        /*
         * for (int i = 0; i < weaponList.size(); i++) {
         * if ((screen.equals("weaponSelect")) && (weaponList.get(i).getX() +
         * weaponList.get(i).getW() >= x && weaponList.get(i).getX() <= x &&
         * weaponList.get(i).getY() + weaponList.get(i).getH() >= y &&
         * weaponList.get(i).getY() <= y)) {
         * weapon = weaponList.get(i);
         * }
         * }/*
         */
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        for (int i = 0; i < charList.size(); i++) {
            if ((screen.equals("selection")) && (arg0.getButton() == 1)
                    && (charList.get(i).getX() + charList.get(i).getW() >= x && charList.get(i).getX() <= x
                            && charList.get(i).getY() + charList.get(i).getH() >= y && charList.get(i).getY() <= y)) {
                player = charList.get(i);
                screen = "weaponSelect";
            }
        }
        for (int i = 0; i < weaponList.size(); i++) {
            if ((screen.equals("weaponSelect")) && (arg0.getButton() == 1)
                    && (weaponList.get(i).getX() + weaponList.get(i).getW() >= x && weaponList.get(i).getX() <= x
                            && weaponList.get(i).getY() + weaponList.get(i).getH() >= y
                            && weaponList.get(i).getY() <= y)) {
                weapon = weaponList.get(i);
                // screen = "game";
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
