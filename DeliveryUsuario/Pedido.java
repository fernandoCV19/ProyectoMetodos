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
        entregaInmediata = false;
        id = null;
    }

    public Pedido(Usuario usuario,Producto producto, int cantidad,String observaciones,boolean inmediato){
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
        this.entregaInmediata = inmediato;
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
        document.append("encargardo", null);
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

    public Usuario getUsuario(){
        return usuario;
    }

    public Producto getProducto(){
        return producto;
    }

    public int getCantidad(){
        return cantidad;
    }

    public String getObservaciones(){
        return observaciones;
    }

    public boolean getEntregaInmediata(){
        return entregaInmediata;
    }

    public Dealer getDealer(){
        return dealerAsignado;
    }


}
