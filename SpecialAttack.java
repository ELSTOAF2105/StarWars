public interface SpecialAttack {
    ActionResult getSpecialAttackResult(int attackRoll, Combatant defender);
    String getSpecialAttackMessage(Combatant defender);
    int getSpecialAttackProb();
    int getSpecialAttackPower();
}