import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
public class MongoDB extends Thread
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

    public static void insertarPedido(Pedido p){
        MongoCollection collection = mongoDatabase.getCollection("Pedidos");        
        collection.insertOne(p.getDocument());
    }

    public static void insertarProductos(Producto p){
        MongoCollection collection = mongoDatabase.getCollection("Productos");        
        collection.insertOne(p.getDocument());
    }

    public static void insertarUsuario(Usuario u){
        MongoCollection collection = mongoDatabase.getCollection("Usuarios");        
        collection.insertOne(u.getDocument());
    }

    public static ArrayList<Producto> getInventario(){
        MongoCollection collection = mongoDatabase.getCollection("Productos");        
        ArrayList<Producto> lista = new ArrayList<>();
        FindIterable<Document> findIterable = collection.find();
        for(Document doc: findIterable){
            Producto p = new Producto();
            p.setNombre(doc.get("name").toString());
            p.setCarac(doc.get("features").toString());
            p.setPrecio(Double.parseDouble(doc.get("price").toString()));
            
            
            lista.add(p);
        }
        return lista;
    }
    
    public void run(){
        getInstanceMongoDB();
    }
}
