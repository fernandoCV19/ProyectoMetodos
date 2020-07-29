public class Main
{
    public static void main(String [] args){
        Thread hilo1 = new Thread(){
            public void run(){
                VentanaAutentificacion nuevo = new VentanaAutentificacion();
            }
        };
        
        Thread hilo2 = new Thread(){
            public void run(){
                MongoDB.getInstanceMongoDB();
            }
        };
        
        hilo1.start();
        hilo2.start();
    }
}
