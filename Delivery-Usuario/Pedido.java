import org.bson.Document;

public class Pedido
{
    private Usuario usuario;
    private Producto producto;
    private int id;
    private int cantidad;
    private String observaciones;
    
    public Pedido(Usuario usuario,Producto producto, int cantidad,String observaciones){
        this.usuario = usuario;
        this.producto = producto;
        this.id = 0;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public Producto getProducto(){
        return producto;
    }
    public int getId(){
        return id;
    }
    public int getCantidad(){
        return cantidad;
    }
    public String getObs(){
        return observaciones;
    }
    
    public void setUsuario(Usuario us){
        usuario = us;
    }
    public void setProducto(Producto prod){
        producto = prod;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setCantidad(int cant){
        cantidad = cant;
    }
    public void setObs(String obs){
        observaciones = obs;
    }
    
     public Document getDocument(){
        Document document = new Document("_id", id);
                 document.append("producto", producto.getDocument());
                 document.append("usuario", usuario.getDocument());
                 document.append("cantidad", cantidad);
                 document.append("observaciones", observaciones);
        return document;
    }
}
