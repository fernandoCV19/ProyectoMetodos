import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
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
    public void insertar(Document document, String collectionName){
        
        MongoCollection collection = mongoDatabase.getCollection(collectionName);        
        collection.insertOne(document);
    }
}
