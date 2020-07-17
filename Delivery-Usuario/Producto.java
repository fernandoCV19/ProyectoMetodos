
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
        
}
