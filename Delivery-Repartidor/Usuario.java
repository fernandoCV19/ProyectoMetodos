import org.bson.Document;
public class Usuario
{
    private String nombre;
    private Direccion direccion;
    private int nroCi;
    private int nroCelular;
    
    public Usuario(){
        nombre="";
        direccion = null;
        nroCi = 0;
        nroCelular = 0;
    }
    
    public Document getDocument(){
        Document document = new Document("name", nombre);
                 document.append("direccion", direccion.getDocument());
                 document.append("CI", nroCi);
                 document.append("celular", nroCelular);
        return document;
    }
    public void setNombre(String nom){
        nombre = nom;
    }
    public void setDireccion(Direccion dir){
        direccion = dir;
    }
    public void setNroCi(int ci){
        nroCi = ci;
    }
    public void setNroCelular(int cel){
        nroCelular = cel;
    }
    public Usuario getUsuario(Document usu){
        Direccion dir = new Direccion();
        dir = dir.getDireccion((Document)usu.get("direccion"));
        Usuario u = new Usuario ();
                u.setDireccion(dir);
                u.setNombre(usu.get("name").toString());
                u.setNroCelular(Integer.parseInt(usu.get("celular").toString()));
                u.setNroCi(Integer.parseInt(usu.get("CI").toString()));
        return u;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Direccion getDireccion(){
        return direccion;
    }
    
    public int getNroCi(){
        return nroCi;
    }
    
    public int getNroCelular(){
        return nroCelular;
    }
}
