import javax.swing.ImageIcon;

//copy this code to anoter class for another charactersw weapon.
//if enemy, speed should be negative

public class RollerProjectile extends Ranged{
    public RollerProjectile(){
        super();
    }

    public RollerProjectile(int x, int y){
        super(x,y,50,50,5,new ImageIcon("Roller.png"), "Campbell");
    }
}
