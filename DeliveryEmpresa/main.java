
public class main
{
    public static void main (String [] args){
        Thread hilo1 = new Thread (){
            public void run (){
                VentanaEmpresa ventana = new VentanaEmpresa();
            }
        };
        
            
        Thread hilo2 = new Thread (){
            public void run (){
                MongoDB.getInstanceMongoDB();
            }
        };
        
        hilo1.start();
        hilo2.start();
        
        
    }
}