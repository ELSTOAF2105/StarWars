public class ActionResult {
    private String message;
    private int damage;

    public ActionResult(String m, int d) {
        message = m;
        damage = d;
    }

    public String getMessage() {
        return message;
    }

    public int getDamage() {
        return damage;
    }
}
