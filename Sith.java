public class Sith extends Combatant implements SpecialAttack {

    private static final int STARTING_HEALTH = 42;
    private static final int ATTACK_PROB = 83;
    private static final int ATTACK_POWER = 4;
    private static final int SPECIAL_PROB = 17;
    private static final int SPECIAL_POWER = 8;

    public Sith(String n) {
        super(n, STARTING_HEALTH);
    }

    public Sith(String n, int h) {
        super(n, h);
    }
    
    public void speak() {
        System.out.println(this.getName() + ": For the empire!");
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

    public int getSpecialProb() {
        return SPECIAL_PROB;
    }

    public int getSpecialPower() {
        return SPECIAL_POWER;
    }

    public int getSpecialAttackProb() {
        return SPECIAL_PROB;
    }

    public int getSpecialAttackPower() {
        return SPECIAL_POWER;
    }

     public String getSpecialAttackMessage(Combatant defender) {
        String msg = "";
        msg += this.getName() + " strikes " + defender.getName() + " with a LIGHTING SPECIAL ATTACK!!!";
        return msg;
     }

}