import java.util.regex.*;

public class ValidadorDatos
{
    
    public static boolean esNombre(String nombre){
        Pattern pat = Pattern.compile("^[A-Z]{1}[a-z]{2,15}[ ]{1}[A-Z]{1}[a-z]{2,10}([ ]{1}[A-Z]{1}[a-z]{2,10}){0,2}$");
        Matcher mat = pat.matcher(nombre);
        
        return mat.matches();
    }
    
    public static boolean esCelular(String numero){
        Pattern celular = Pattern.compile("^[6|7|4]{1}[0-9]{5,7}");
        Matcher mat = celular.matcher(numero);
        
        return mat.matches();
    }
    
    public static boolean esCI(String CI){
        Pattern carnet = Pattern.compile("[0-9]{5,8}");
        Matcher mat = carnet.matcher(CI);
        
        return mat.matches();
    }
    
    public static boolean esNroCasa(String nro){
        Pattern nroCasa = Pattern.compile("[0-9]{1,4}");
        Matcher mat = nroCasa.matcher(nro);
        
        return mat.matches();
    }
    
    public static boolean esCalle(String calle){
        Pattern pat = Pattern.compile("^([A|a]v[.]?(enida)?)[ ]{1}[a-zA-Z1-9]{4,}$");
        Matcher mat = pat.matcher(calle);
        
        Pattern pat2 = Pattern.compile("^([C|c]alle|[C|c]l[.]?)[ ]{1}[a-zA-Z1-9]{4,}$");
        Matcher mat2 = pat2.matcher(calle);
        
        return mat.matches()||mat2.matches();
    }
}
