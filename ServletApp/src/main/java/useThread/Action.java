package useThread;

public class Action {

    public void call() {

        /*
        Invoker invoker = new Invoker();
        invoker.execute( () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("run call");
            }
        });
         */

        // classic thread
        ConfigAction c1 = new ConfigAction( "image-1.jpg" );
        Thread th1 = new Thread(c1);

        ConfigAction c2 = new ConfigAction( "image-2.jpg" );
        Thread th2 = new Thread(c2);

        ConfigAction c3 = new ConfigAction( "image-3.jpg" );
        Thread th3 = new Thread(c3);

        //th1.start();
        //th2.start();
        //th3.start();

    }

}
