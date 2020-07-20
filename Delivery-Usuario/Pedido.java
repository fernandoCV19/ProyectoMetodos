import org.bson.Document;

public class Pedido
{
    private Usuario usuario;
    private Producto producto;
    private int cantidad;
    private String observaciones;
    private Object id;
    
    public Pedido(Usuario usuario,Producto producto, int cantidad,String observaciones){
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public Producto getProducto(){
        return producto;
    }
    public int getCantidad(){
        return cantidad;
    }
    public String getObs(){
        return observaciones;
    }
    public Object getId(){
        return id;
    }
    
    public void setUsuario(Usuario us){
        usuario = us;
    }
    public void setProducto(Producto prod){
        producto = prod;
    }
    public void setCantidad(int cant){
        cantidad = cant;
    }
    public void setObs(String obs){
        observaciones = obs;
    }
    
    
     public Document getDocument(){
        Document document = new Document("producto", producto.getDocument());
                 document.append("usuario", usuario.getDocument());
                 document.append("cantidad", cantidad);
                 document.append("observaciones", observaciones);
        return document;
    }
}
