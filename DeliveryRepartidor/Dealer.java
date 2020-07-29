import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import org.bson.Document;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Dealer
{
    private int codigo;
    private String nombre;
    private PriorityQueue<Pedido> porEntregar;
    private Queue<Document> porEntregarDocument;
    public Dealer (){
        nombre = "";
        codigo = 0;
        Comparator <Pedido> comp = new ComparadorResultados();
        porEntregar = new PriorityQueue<>(comp);
    }

    public String getNombre(){
        return nombre;
    }

    public PriorityQueue<Pedido> getLista(){
        return porEntregar;
    }

    public Queue<Document> getDocumentList(){
        return porEntregarDocument;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setporEntregar(PriorityQueue<Pedido> list){
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
            Comparator <Pedido> comp = new ComparadorResultados();
            porEntregar = new PriorityQueue<>(comp);
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
