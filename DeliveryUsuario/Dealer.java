import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import org.bson.Document;
public class Dealer
{
    private int codigo;
    private String nombre;
    private Queue<Pedido> porEntregar;
    public Dealer (){
        nombre = "";
        codigo = 0;
        porEntregar = new LinkedList<>();
    }
    public String getNombre(){
        return nombre;
    }
    public Queue<Pedido> getLista(){
        return porEntregar;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setporEntregar(Queue<Pedido> list){
        porEntregar = list;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public Document agregarPedido(Pedido p){
        porEntregar.add(p);
        return p.getDocument();
    }
    public Document getDocument(){
        Document document = new Document("name", nombre);
                 document.append("codigo", codigo);
                 document.append("por entregar",porEntregar);
        return document;
    }
    public Pedido pedidoEntregado(Pedido p){
        porEntregar.remove(p);
        return p;
    }
}
