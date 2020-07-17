import org.bson.Document;
public class Usuario
{
    private String nombre;
    private Direccion direccion;
    private Pedido pedido;
    private int nroCi;
    private int nroCelular;
    
    public Usuario(){
        nombre="";
        direccion = null;
        nroCi = 0;
        nroCelular = 0;
        pedido = null;
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
}
