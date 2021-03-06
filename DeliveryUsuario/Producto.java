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

    public Producto getProducto(Document prod){
        Producto p = new Producto();
        p.setCarac(prod.get("features").toString());
        p.setNombre(prod.get("name").toString());
        p.setPrecio(Double.parseDouble(prod.get("price").toString()));
        return p;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCaracteristicas(){
        return caracteristicas;
    }

    public double getPrecio(){
        return precio;
    }

}
