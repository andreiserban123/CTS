package teme.pregatire.test1.s5.clasa;

public class Singleton {

    private Singleton() {
    }

    public static Singleton getInstance() {
        return HelperClass.instance;
    }


    private static class HelperClass {
        private static final Singleton instance = new Singleton();
    }
}
