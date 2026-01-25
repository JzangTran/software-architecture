public class Application {
    public static void main(String[] args) {
        Runnable singletonTest = () -> {
            Lamp lamp = Lamp.getInstance();
            System.out.println(lamp.hashCode());
            if(!lamp.getState()) lamp.active();
            System.out.println(lamp.getState() ? "Đèn đã được bật" : "Đèn chưa bật" );
        };

        Thread t1 = new Thread(singletonTest);
        Thread t2 = new Thread(singletonTest);
        Thread t3 = new Thread(singletonTest);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
