public abstract class Combatant {

    private String name;
    private int health;

    public Combatant(String n, int h) {
        name = n;
        health = h;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void subtractHealth(int damage) {
        health -= damage;
    }

    public abstract void speak();
    public abstract int getStartingHealth();
    public abstract int getAttackProb();
    public abstract int getAttackPower();

    public ActionResult getSpecialAttackResult(int attackRoll, Combatant defender) {
        SpecialAttack ch = (SpecialAttack)this;
        if(attackRoll <= ch.getSpecialAttackProb()) {
            return new ActionResult(ch.getSpecialAttackMessage(defender), ch.getSpecialAttackPower());
        }
        else {
            return null;
        }
    }

    public ActionResult getDefenseResult(int defenseRoll, Combatant attacker) {
        Defense b = (Defense)this;
        if(defenseRoll <= b.getDefenseProb()) {
            return new ActionResult(b.getDefenseMessage(attacker), 0);
        }
        else {
            return null;
        }
    }

    public String toString() {
		String msg = "";
		msg += this.name + "\n";
		msg += "Starting Health: " + this.getStartingHealth() + "\n";
		msg += "Attack Prob: " + this.getAttackProb()  + "\n";
		msg += "Attack Power: " + this.getAttackPower();
		return msg;
    }

}