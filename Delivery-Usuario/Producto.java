import org.bson.Document;

public class Producto
{
    private int id;
    private String nombre;
    private String caracteristicas;
    private double precio;

    public Producto(int id, String nombre, String caracteristicas,double precio){
        this.id = id;
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
    }

    public Producto(){
        
    }
    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCarac(){
        return caracteristicas;
    }

    public double getPrecio(){
        return precio;
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

    public Document getDocument(){
        Document document = new Document("name", nombre);
        document.append("features", caracteristicas);
        document.append("price", precio);
        return document;
    }
}
