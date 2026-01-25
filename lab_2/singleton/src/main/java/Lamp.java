public class Lamp {
    private boolean isActive;

    private Lamp() {}

    private static final class InstanceHolder {
        private static final Lamp instance = new Lamp();
    }

    public static Lamp getInstance() {
        return InstanceHolder.instance;
    }

    public boolean getState() {
        return isActive;
    }

    public void active() {
        this.isActive = !isActive;
    }
}
