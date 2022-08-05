package useThread;

public class ConfigAction implements Runnable {

    String imagePath = "";
    public ConfigAction( String imagePath ) {
        this.imagePath = imagePath;
    }

    @Override
    public void run() {
       while (true) {
           try {
               Thread.sleep(500);
               System.out.println("imageUpload - " + imagePath);
           }catch (Exception ex) {}
       }
    }

}
