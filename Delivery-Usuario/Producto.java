import org.bson.Document;
public class Producto
{
    private String nombre;
    private String caracteristicas;
    private double precio;
    
    public Producto(){
        nombre = "";
        caracteristicas = "";
        precio = 0.0;
    }
    
    public Document getDocument(){
        Document document = new Document("name", nombre);
                 document.append("features", caracteristicas);
                 document.append("price", precio);
        return document;
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
