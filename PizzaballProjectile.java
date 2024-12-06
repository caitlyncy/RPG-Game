import javax.swing.ImageIcon;

//copy this code to anoter class for another charactersw weapon.
//if enemy, speed should be negative

public class PizzaballProjectile extends Ranged{
    public PizzaballProjectile(){
        super();
    }

    public PizzaballProjectile(int x, int y){
        super(x,y,50,50,8,new ImageIcon("pizzaball.png"), "Doughboy");
    }
}
