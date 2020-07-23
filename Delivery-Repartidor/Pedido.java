import org.bson.Document;
import java.util.ArrayList;
import org.bson.types.ObjectId;
public class Pedido
{
    private Usuario usuario;
    private Producto producto;
    private ObjectId id;
    private int cantidad;
    private String observaciones;
    private boolean entregaInmediata;
    private boolean entregado;
    private Dealer dealerAsignado;
    
    public Pedido(){
        usuario = null;
        producto = null;
        cantidad = 0;
        observaciones = "";
        entregado = false;
        dealerAsignado = null;
        id = null;
    }
     public Document getDocument(){
        Document document = new Document("producto", producto.getDocument());
                 document.append("usuario", usuario.getDocument());
                 document.append("cantidad", cantidad);
                 document.append("observaciones", observaciones);
                 document.append("inmediato", entregaInmediata);
                 document.append("entregado", entregado);
                 document.append("encargardo", dealerAsignado.getDocument());
        return document;
    }
    public void setID(ObjectId id){
        this.id = id;
    }
    public ObjectId getID(){
        return id;
    }
    public void setDealer(Dealer encargado){
        dealerAsignado = encargado;
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
    public void setInmediato(boolean inmediato){
        entregaInmediata = inmediato;
    }
    public void setObs(String obs){
        observaciones = obs;
    }
}
