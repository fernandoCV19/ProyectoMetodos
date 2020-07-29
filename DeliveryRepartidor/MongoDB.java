import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.Queue;
public final class MongoDB
{
    private static MongoDB instance;
    private static String uri;
    private static MongoClientURI clientURI;
    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;
    private static MongoCollection collection;
    private MongoDB()
    {
        uri = "mongodb+srv://test:root@cluster0.tlfcn.gcp.mongodb.net/<dbname>?retryWrites=true&w=majority";
        clientURI = new MongoClientURI(uri);
        mongoClient = new MongoClient (clientURI);
        mongoDatabase = mongoClient.getDatabase("Delivery");
    }
    public static MongoDB getInstanceMongoDB(){
        if(instance == null){
            instance = new MongoDB();
        }
        return instance;
    }
    public static Dealer getDealer(String nombre, int codigo){
        MongoCollection collection = mongoDatabase.getCollection("Dealers");
        Document doc = new Document("name",nombre);
                 doc.append("codigo", codigo);
        Document found = (Document) collection.find(doc).first();
        Dealer d = new Dealer();
        if(found != null){
            d = new Dealer();
            d.setCodigo(Integer.parseInt(found.get("codigo").toString()));
            d.setNombre(found.get("name").toString());
            //d.setporEntregar((Queue)found.get("Pedidos por entregar"));
        }
        return d;
    }
    public static Pedido buscarPedido(Dealer dealer){
        MongoCollection collection = mongoDatabase.getCollection("Pedidos");        
        Document buscar = new Document("entregado",false);
                 buscar.append("inmediato", true);
                 buscar.append("encargado", null);
        Document found = (Document) collection.find(buscar).first();
        Pedido p = new Pedido();
        if(found==null){
            buscar = new Document("entregado",false);
            buscar.append("encargado",null);
            found =(Document) collection.find(buscar).first();
        }
        if(found != null){
            p.setCantidad(Integer.parseInt(found.get("cantidad").toString()));
            p.setObs(found.get("observaciones").toString());
            
            Usuario u = new Usuario();
            p.setUsuario(u.getUsuario((Document)found.get("usuario")));
            
            Producto prod = new Producto();
            p.setProducto(prod.getProducto((Document)found.get("producto")));
            
            p.setInmediato(Boolean.parseBoolean(found.get("inmediato").toString()));
            p.setID(found.getObjectId("_id"));
            dealer.agregarPedido(p);
            actualizarDealer(dealer, found);
            
        } 
        return p;
    }
    public static void pedidoEntregado(Pedido p){
        MongoCollection collection = mongoDatabase.getCollection("Pedidos");        
        
        collection.updateOne(new Document("_id",p.getID()),new Document("$set", new Document("entregado", true)));
        
    }
    private static void actualizarDealer(Dealer d,Document p){
        MongoCollection collection = mongoDatabase.getCollection("Dealers");        
        MongoCollection collection_Pedidos = mongoDatabase.getCollection("Pedidos");
        collection_Pedidos.updateOne(p,new Document("$set", new Document("encargado", d.getDocument())));
        System.out.print(collection.updateOne(new Document("name", d.getNombre()),
                    new Document("$set", new Document("Pedidos sin entregar", d.getDocumentList()))));
        

    }
    public void insertDealer(Dealer d){
        MongoCollection collection = mongoDatabase.getCollection("Dealers");    
        collection.insertOne(d.getDocument());
    }
}
