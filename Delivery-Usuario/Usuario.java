import org.bson.Document;

public class Usuario
{
    private String nombre;
    private Direccion direccion;
    private int nroCi;
    private int nroCelular;
    
    public Usuario(String nombre, Direccion direccion, int nroCi, int nroCelular){
        this.nombre = nombre;
        this.direccion = direccion;
        this.nroCi = nroCi;
        this.nroCelular = nroCelular;
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
    
    public Document getDocument(){
        Document document = new Document("name", nombre);
                 document.append("direccion", direccion.getDocument());
                 document.append("CI", nroCi);
                 document.append("celular", nroCelular);
        return document;
    }
}
