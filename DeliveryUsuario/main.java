public class main
{
    public static void main (String [] args){
        Thread proceso1 = new Thread(new VentanaInicio());
        Thread proceso2 = new Thread(new Proceso2());
        /*Thread proceso3 = new Thread(){
            public void run (){
                Vista animacion = new Vista();
                Vista.main();
            }
        };
        */
        proceso1.start();
        proceso2.start();
        //proceso3.start();
    }
    
    public static class Proceso2 implements Runnable {
        public void run(){
            MongoDB.getInstanceMongoDB();
        }
    }
}
