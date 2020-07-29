import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import org.bson.Document;
public class Dealer
{
    private int codigo;
    private String nombre;
    private Queue<Pedido> porEntregar;
    private Queue<Document> porEntregarDocument;
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
    public Queue<Document> getDocumentList(){
        return porEntregarDocument;
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
    public void agregarPedido(Pedido p){
        if(porEntregar == null){
            porEntregar = new LinkedList<>();
        }
        if(porEntregarDocument == null){
            porEntregarDocument = new LinkedList<>();
        }
        porEntregar.add(p);
        porEntregarDocument.add(p.getDocument());
        //return p.getDocument();
    }
    public Document getDocument(){
        Document document = new Document("name", nombre);
                 document.append("codigo", codigo);
                 document.append("por entregar",porEntregarDocument);
        return document;
    }
    public Pedido pedidoEntregado(Pedido p){
        porEntregar.remove(p);
        return p;
    }
}
