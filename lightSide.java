public class lightSide extends Combatant implements Defense {

    private static final int STARTING_HEALTH = 33;
    private static final int ATTACK_PROB = 67;
    private static final int ATTACK_POWER = 6;
    private static final int DEFENSE_PROB = 17;

    public lightSide(String n) {
        super(n, STARTING_HEALTH);
    }

    public lightSide(String n, int h) {
        super(n, h);
    }
    
    public void speak() {
        System.out.println(this.getName() + ": For Leia!");
    }

    public int getStartingHealth() {
        return STARTING_HEALTH;
    }

    public int getAttackProb() {
        return ATTACK_PROB;
    }

    public int getAttackPower() {
        return ATTACK_POWER;
    }

    public int getDefenseProb() {
        return DEFENSE_PROB;
    }

    public String getDefenseMessage(Combatant attacker) {
        String msg = "";
        msg += this.getName() + " uses a shield to BLOCK " + attacker.getName() + "'s attack!!!";
        return msg;
     }
}
