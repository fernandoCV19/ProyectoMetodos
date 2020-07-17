import org.bson.Document;
public class Producto
{
    private int id;
    private String nombre;
    private String caracteristicas;
    private double precio;
    
    public Producto(){
        id = 0;
        nombre = "";
        caracteristicas = "";
        precio = 0.0;
    }
    
    public Document getDocument(){
        Document document = new Document("_id", id);
                 document.append("name", nombre);
                 document.append("features", caracteristicas);
                 document.append("price", precio);
        return document;
    }
    public void setId( int id){
        this.id = id;
    }
    public void setNombre(String nom){
        nombre = nom;
    }
    public void setCarac(String carac){
        caracteristicas = carac;
    }
    public void setPrecio(double prec){
        precio = prec;
    }
        
}
