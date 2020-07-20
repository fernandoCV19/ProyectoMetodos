import java.util.regex.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Traductor
{
    private static ArrayList <Producto> productos = MongoDB.getInstanceMongoDB().getInventario();
    /*
    public static Pedido traducir(Usuario usuario,String pedido){
        String [] text = pedido.split("[ ,.]");
        String nombreProducto = nombreProducto(text);
        Producto producto = buscarProducto(nombreProducto);
        int cantidad = conseguirCantidad(text);
        String observaciones = conseguirObservaciones(text);
        
        Pedido p = new Pedido(usuario,producto,cantidad,observaciones);
        
        return p;
    }
    */
    
    public static Producto nombreProducto(String pedido){
        String [] text = pedido.split("[ ,.]");
        String res = "";
        boolean comenzar = false;
        for (int i = 0; i<text.length;i++){
            if (!comenzar){
                if (producto(text[i])){
                    i = i + 1;
                    comenzar= !comenzar;
                }
            }   else{
                if (observaciones(text[i])){
                    break;
                }   else{
                    res = res+" "+text[i];
                }
            }
        }
        return buscarProducto(res);
    }
    
    private static Producto buscarProducto(String nombre){
        Producto p = null;
        for (Producto aux:productos){
            if (aux.getNombre().equals(nombre)){
                p = aux;
            }
        }
        return p;
    }
    
    public static int conseguirCantidad(String pedido){
        String [] text = pedido.split("[ ,.]");
        int cantidad = 0;
        for (int i = 0; i<text.length;i++){
            if (cantidad(text[i])){
                cantidad = Integer.parseInt(text[i]);
                break;
            }
        }
        
        if (cantidad==0){
            for (int j = 0;j<text.length;j++){
                cantidad = cardinal(text[0]);
                if (cantidad!=0){
                    break;
                }
            }
        }
        return cantidad;
    }
    
    public static String conseguirObservaciones (String pedido){
        String [] text = pedido.split("[ ,.]");
        String res = "";
        boolean formar = false;
        for (int i = 0; i<text.length;i++){
            if (!formar){
                if (observaciones(text[i])){
                    formar = !formar;
                    res = res + text[i];
                }
            }   else{
                res = res + " "+ text[i];
            }
        }
        return res;
    }
    
    private static boolean cantidad(String cant){
        Pattern pat = Pattern.compile("[1-9]{1}[0-9]?");
        Matcher mat = pat.matcher(cant);
        
        return mat.matches();
    }
    
    private static boolean producto(String palabra){
        Pattern pat = Pattern.compile("[Q|q]uiero|[N|n]ecesito|[M|m]ande(n)?(me)?|[E|e]nvie(n)?(me)|[R|r]equiero?");
        Matcher mat = pat.matcher(palabra);
        
        return mat.matches();
    }
    
    private static int cardinal(String palabra){
        HashMap <Pattern,Integer> numeros= new HashMap<>();
        Pattern pat1 = Pattern.compile("un(o|a)?");
        Pattern pat2 = Pattern.compile("dos");
        Pattern pat3 = Pattern.compile("tres");
        Pattern pat4 = Pattern.compile("cuatro");
        Pattern pat5 = Pattern.compile("cinco");
        Pattern pat6 = Pattern.compile("seis");
        Pattern pat7 = Pattern.compile("siete");
        Pattern pat8 = Pattern.compile("ocho");
        Pattern pat9 = Pattern.compile("nueve");
        Pattern pat10 = Pattern.compile("diez");
        numeros.put(pat1,1);
        numeros.put(pat2,2);
        numeros.put(pat3,3);
        numeros.put(pat4,4);
        numeros.put(pat5,5);
        numeros.put(pat6,6);
        numeros.put(pat7,7);
        numeros.put(pat8,8);
        numeros.put(pat9,9);
        numeros.put(pat10,10);
        
        for (Pattern p: numeros.keySet()){
            Matcher mat = p.matcher(palabra);
            if (mat.matches()){
                return numeros.get(p);
            }
        }
        return 0;
    }
    
    private static boolean observaciones (String palabra){
        Pattern pat = Pattern.compile("[P|p]ero|[C|c]on|[S|s]in|[A|a]demas|[Q|q]ue|[T|t]enga");
        Matcher mat = pat.matcher(palabra);
        
        return mat.matches();
    }
}
