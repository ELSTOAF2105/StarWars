public interface Defense {
    ActionResult getDefenseResult(int defenseRoll, Combatant attacker);
    String getDefenseMessage(Combatant attacker);
    int getDefenseProb();
}