public class Player {
    protected String name;

    protected int health;

    protected int hitPoints;

    public Player(String name, int health, int hitPoints) {
        this.name = name;
        this.health = health;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return getName() + "/" + getHitPoints() + "/" + getHealth();
    }
}
