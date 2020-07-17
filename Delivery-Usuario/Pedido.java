import org.bson.Document;
public class Pedido
{
    private Usuario usuario;
    private Producto producto;
    private int id;
    private int cantidad;
    private String observaciones;
    
    public Pedido(){
        usuario = null;
        producto = null;
        id = 0;
        cantidad = 0;
        observaciones = "";
    }
     public Document getDocument(){
        Document document = new Document("_id", id);
                 document.append("producto", producto.getDocument());
                 document.append("usuario", usuario.getDocument());
                 document.append("cantidad", cantidad);
                 document.append("observaciones", observaciones);
        return document;
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
}
