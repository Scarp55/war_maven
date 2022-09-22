

public class Orc extends Player {

    public Orc(String name, int health, int hitPoints) {
        super(name, health, hitPoints);
    }

    public void attack(Orc defender, Human attacker, int isAttack, int isDef, double kof) {
        System.out.print(attacker.getName() + " атакует " + defender.getName());
        if (isAttack != isDef) {
            double damage = attacker.getHitPoints() * (1 - kof / 10);
            System.out.println(" и наносит " + damage + " урона");
            this.health -= damage;
            this.hitPoints *= 0.9;
            if (this.hitPoints == 0) {
                this.hitPoints += 1;
            }
        } else {
            System.out.println(" но удар заблокирован");
        }
    }
}
