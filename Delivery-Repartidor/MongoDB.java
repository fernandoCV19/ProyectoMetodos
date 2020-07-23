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
    public static Dealer getDealer(String nombre){
        MongoCollection collection = mongoDatabase.getCollection("Dealers");        
        Document found = (Document) collection.find(new Document("name",nombre)).first();
        Dealer d = new Dealer();
        d.setCodigo(Integer.parseInt(found.get("codigo").toString()));
        d.setNombre(found.get("name").toString());
        d.setporEntregar((Queue)found.get("por entregar"));
        return d;
    }
    public static Pedido buscarPedido(Dealer dealer){
        MongoCollection collection = mongoDatabase.getCollection("Pedidos");        
        Document buscar = new Document("entregado",false);
                 buscar.append("inmediato", true);       
        Document found = (Document) collection.find(buscar).first();
        Pedido p = new Pedido();
        if(found==null){
            buscar = new Document("entregado",false);
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
            actualizarDealer(dealer, p);
        }
        
        return p;
    }
    public static void pedidoEntregado(Pedido p){
        MongoCollection collection = mongoDatabase.getCollection("Pedidos");        
        
        collection.updateOne(new Document("_id",p.getID()),new Document("$set", new Document("entregado", true)));
        
    }
    private static void actualizarDealer(Dealer d,Pedido p){
        MongoCollection collection = mongoDatabase.getCollection("Dealers");        
        MongoCollection collection1 = mongoDatabase.getCollection("Pedidos");
        collection1.updateOne(new Document("_id",p.getID()),new Document("$set", new Document("encargado", d)));
        collection.updateOne(new Document("nombre",d.getNombre()),new Document("$set", new Document("por entregar", d.getLista())));

    }
    public void insertDealer(Dealer d){
        MongoCollection collection = mongoDatabase.getCollection("Dealers");    
        collection.insertOne(d.getDocument());
    }
}
