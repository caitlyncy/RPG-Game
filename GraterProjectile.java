import javax.swing.ImageIcon;

//copy this code to anoter class for another charactersw weapon.
//if enemy, speed should be negative

public class GraterProjectile extends Ranged{
    public GraterProjectile(){
        super();
    }

    public GraterProjectile(int x, int y){
        super(x,y,50,50,5,new ImageIcon("Grater.png"), "Aliki");
    }
}
