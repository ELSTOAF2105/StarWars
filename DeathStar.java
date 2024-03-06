import java.util.ArrayList;

public class DeathStar {

    private static int darkWins = 0;
    private static int lightWins = 0;

    public static void main(String[] args) {
        runSimulations(10);
    }

    public static ArrayList<Combatant> createCombatants() {

        ArrayList<Combatant> combatants = new ArrayList<Combatant>();
        combatants.add(new Sith("Darth Maul"));
        combatants.add(new Sith("Darth Vadar"));

        combatants.add(new Jedi("Luke Skywalker"));
        combatants.add(new Jedi("Anakin Skywalker"));

        combatants.add(new lightSide("Han Solo"));
        combatants.add(new lightSide("Ray"));

        combatants.add(new Flametrooper("Flametrooper"));

        combatants.add(new Crimson("Crimson Storm Trooper"));

        return combatants;

    }

    public static void delay(int milli) {
		try {
	        Thread.sleep(milli); 
	   } 
		catch (Exception e) {
	        e.printStackTrace();
	   }
    }

    public static void battle(Combatant attacker, Combatant defender) {
        ActionResult attackResult = null;
        ActionResult specialAttackResult = null;
        ActionResult defenseResult = null;

        String missMsg = attacker.getName() + " missed " + defender.getName() + " because they suck!";
        String hitMsg = attacker.getName() + " attacked and hit " + defender.getName() + " because they don't suck!";

        int roll = (int)(Math.random() * 100 + 1);
        
        if (roll > attacker.getAttackProb()) {
            attackResult = new ActionResult(missMsg, 0);
		}
        else {
            attackResult = new ActionResult(hitMsg, attacker.getAttackPower());
            if (attacker instanceof SpecialAttack) {
                specialAttackResult = attacker.getSpecialAttackResult(roll, defender);
			}
            if (defender instanceof Defense) {
                int defenseRoll = (int)(Math.random() * 100 + 1);
                defenseResult = defender.getDefenseResult(defenseRoll, attacker);
			}
        }
        int finalDamage = 0;

        if (specialAttackResult != null && defenseResult == null) {
            System.out.println(specialAttackResult.getMessage());
            finalDamage = specialAttackResult.getDamage();
		}
        else if (specialAttackResult != null && defenseResult != null) {
            System.out.println(specialAttackResult.getMessage());
            System.out.println(defenseResult.getMessage());
            finalDamage = defenseResult.getDamage();
        }
        else if (attackResult != null && defenseResult != null) {
            System.out.println(attackResult.getMessage());
            System.out.println(defenseResult.getMessage());
            finalDamage = defenseResult.getDamage();
		}
        else if (attackResult != null && defenseResult == null) {
            System.out.println(attackResult.getMessage());
            finalDamage = attackResult.getDamage();
		}
        else  {
            System.out.println(attackResult.getMessage());
            finalDamage = attackResult.getDamage();
		}
        defender.subtractHealth(finalDamage);

    }

    public static void runSimulations(int numTimes) {
        for(int i = 0; i < numTimes; i++) {
            ArrayList<Combatant> combatants = createCombatants();
            simWar(combatants);
        }

        System.out.println("Dark Side: " + Math.round(100.0 * darkWins/numTimes) + "%");
        System.out.println("Light Side: " + Math.round(100.0 * lightWins/numTimes) + "%");
    }

    public static Combatant getAttacker(ArrayList<Combatant> combatants) { 
        int index = (int)(Math.random() * combatants.size());
        return combatants.get(index);
    } 
        
         
        
    public static Combatant getDefender(ArrayList<Combatant> combatants, Combatant attacker) { 
        int index = (int)(Math.random() * combatants.size());
        Combatant defender = combatants.get(index);
        while (defender.equals(attacker)) { 
            index = (int)(Math.random() * combatants.size());
            defender = combatants.get(index);
        } 
        
        return defender;
    }

    public static void printHealths(ArrayList<Combatant> combatants) {
        System.out.println();
        System.out.println("***HEALTHBOARD***");

        for(Combatant c: combatants){
            System.out.print(c.getName());
            System.out.print("\t");
            for(int i = 0; i < c.getHealth(); i++) {
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void simWar(ArrayList<Combatant> combatants) {
        Combatant attacker;
        Combatant defender;
        while(combatants.size() > 1) {
            printHealths(combatants);
            attacker = getAttacker(combatants);
            defender = getDefender(combatants, attacker);
            battle(attacker, defender);
            if(defender.getHealth() <= 0) {
                System.out.println(attacker.getName() + " has defeated " + defender.getName());
                combatants.remove(defender);
            }
        }
        if(combatants.size() == 1) {
            System.out.println(combatants.get(0).getName() + " has won and rules over the Death Star!");
            if(combatants.get(0) instanceof Sith) {
                darkWins++;
                System.out.println("The Dark Side now has " + darkWins + " win(s)! And The Light Side only had " + lightWins + " win(s)!");
            }
            else if(combatants.get(0) instanceof StormTrooper) {
                darkWins++;
                System.out.println("The Dark Side now has " + darkWins + " win(s)! And The Light Side only had " + lightWins + " win(s)!");
            }
            else if(combatants.get(0) instanceof Jedi) {
                lightWins++;
                System.out.println("The Light Side now has " + lightWins + " win(s)! And The Dark Side only had " + darkWins + " win(s)!");
                }
            else if(combatants.get(0) instanceof lightSide) {
                lightWins++;
                System.out.println("The Light Side now has " + lightWins + " win(s)! And The Dark Side only had " + darkWins + " win(s)!");
            }
            }
        }
    }