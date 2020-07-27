import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.HashMap;
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
    public static String getInformeMasVendido(){
        MongoCollection collection_Productos = mongoDatabase.getCollection("Productos");
        MongoCollection collection_Pedidos = mongoDatabase.getCollection("Pedidos");
        FindIterable<Document> productos = collection.find();
        HashMap<String, Long> informe = new HashMap<>();
        String res = "Lista de productos y su cantidad de productos: ";
        long mayor = 0;
        String nombreMayor = "No existe";
        for(Document d: productos){
            informe.put(d.get("name").toString(),new Long(0));
        }
        for(String s: informe.keySet()){
            long act = collection_Pedidos.count(new Document("name",s));
            informe.put(s, act);
            if(mayor<act){
                mayor = act;
                nombreMayor = s;
            }
            res = res + s + act + "\r";
        }
        res = res + "Mas vendido: ";
        EscribeFichero.main(res, "RegistroProductos.txt");
        return res;
    }
    public static String getInformeMasVendedor(){
        MongoCollection collection_Dealers = mongoDatabase.getCollection("Dealers");
        MongoCollection collection_Pedidos = mongoDatabase.getCollection("Pedidos");
        FindIterable<Document> dealers = collection.find();
        HashMap<String, Long> informe = new HashMap<>();
        String res = "Lista de productos y su cantidad de productos: ";
        long mayor = 0;
        String nombreMayor = "No existe";
        for(Document d: dealers){
            long act = collection_Pedidos.count(new Document("encargado",d));
            informe.put(d.get("name").toString(),act);
            if(mayor<act){
                mayor = act;
                nombreMayor = d.get("name").toString();
            }
            res = res +d.get("name").toString()+ act + "\r";
        }
        res = res + "Mas vendido: ";
        EscribeFichero.main(res, "RegistroProductos.txt");
        return res;
    }
    public static double getGanancias(){
        MongoCollection collection_Pedidos = mongoDatabase.getCollection("Pedidos");
        FindIterable<Document> productos = collection.find();
        double ganancia = 0.0;
        for(Document d: productos){
            Document doc = (Document)d.get("producto");
            ganancia = ganancia + Integer.parseInt(doc.get("price").toString());
        }
        return ganancia;
    }
}
