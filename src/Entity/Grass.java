package Entity;


public class Grass extends Entity {
    private int hp;

    public Grass(String sprite, int hp) {
        super(sprite);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}