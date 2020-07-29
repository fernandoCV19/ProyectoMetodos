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
        FindIterable<Document> productos = collection_Productos.find();
        FindIterable<Document> pedidos = collection_Pedidos.find();
        HashMap<String, Long> informe = new HashMap<>();
        long mayor = 0;
        String nombreMayor = "No existe";
        String res= "LISTA DE PRODUCTOS Y LAS VECES QUE SE HAN VENDIDO\r";
        for(Document d: productos){
            long act = collection_Pedidos.count(d);
            res = res + "Nombre del producto: " + d.get("name").toString();
            res = res + "Cantidad de ventas: " + act + "\r";
            if(mayor<act){
                mayor = act;
                nombreMayor = d.get("name").toString();
            }
        }
        res = res + "Mas vendido: " + nombreMayor+"\r";
        EscribeFichero.main(res, "RegistroProductos.txt");
        return res;
    }
    public static String getInformeMasVendedor(){
        MongoCollection collection_Dealers = mongoDatabase.getCollection("Dealers");
        MongoCollection collection_Pedidos = mongoDatabase.getCollection("Pedidos");
        FindIterable<Document> dealers = collection_Dealers.find();
        HashMap<String, Long> informe = new HashMap<>();
        String res = "Lista de dealers y su cantidad de productos vendidos: \r";
        long mayor = 0;
        String nombreMayor = "No existe";
        for(Document d: dealers){
            long act = collection_Pedidos.count(new Document("encargado",d));
            informe.put(d.get("name").toString(),act);
            if(mayor<act){
                mayor = act;
                nombreMayor = d.get("name").toString();
            }
            res = res + "Nombre: " +d.get("name").toString()+ act + "\r";
        }
        res = res + "Mas vendido: "+nombreMayor;
        EscribeFichero.main(res, "Mas vendedor.txt");
        return res;
    }
    public static double getGanancias(){
        MongoCollection collection_Pedidos = mongoDatabase.getCollection("Pedidos");
        FindIterable<Document> productos = collection_Pedidos.find();
        double ganancia = 0.0;
        for(Document d: productos){
            Document doc = (Document)d.get("producto");
            ganancia = ganancia + Double.parseDouble(doc.get("price").toString());
        }
        return ganancia;
    }
    public static String getVentas(){
        MongoCollection collection_Pedidos = mongoDatabase.getCollection("Pedidos");
        FindIterable<Document> productos = collection_Pedidos.find();
        String res = "";
        for(Document d: productos){
            Document producto = (Document)d.get("producto");
            Document usuario = (Document)d.get("usuario");
            Document direccion = (Document)usuario.get("direccion");
            res = res + d.getObjectId("_id").getDate().toString()+ "\r";
            res = res + "PRODUCTO" + "\r";
            res = res + "nombre: "+producto.get("name").toString()+ "\r";
            res = res + "caracteristicas"+producto.get("features").toString()+ "\r";
            res = res + "precio: "+producto.get("price").toString()+ "\r";
            res = res + "USUARIO"+ "\r";
            res = res + "nombre: "+usuario.get("name").toString()+ "\r";
            res = res + "CI: "+usuario.get("CI").toString()+ "\r";
            res = res + "celular: "+usuario.get("celular").toString()+ "\r";
            res = res + "DIRECCION" + "\r";
            res = res + "calle: "+direccion.get("calle").toString()+ "\r";
            res = res + "nroCasa: "+direccion.get("nroCasa").toString()+ "\r";
            res = res + "referencias: "+direccion.get("referencias").toString()+ "\r";
            res = res + "CANTIDAD: "+d.get("cantidad").toString()+ "\r";
            res = res + "OBSERVACIONES: "+d.get("observaciones").toString()+ "\r";
        }
        EscribeFichero.main(res, "Pedidos.txt");
        return res;
    }
    public static String getInventario(){
        MongoCollection collection_Productos = mongoDatabase.getCollection("Productos");
        FindIterable<Document> productos = collection_Productos.find();
        String res = "";
        for(Document d: productos){
            res = res + d.getObjectId("_id").getDate().toString()+ "\r";
            res = res + "PRODUCTO" + "\r";
            res = res + "nombre: "+d.get("name").toString()+ "\r";
            res = res + "caracteristicas"+d.get("features").toString()+ "\r";
            res = res + "precio: "+d.get("price").toString()+ "\r";
        }
        EscribeFichero.main(res, "Inventario.txt");
        return res;
    }
    public static String getDealers(){
        MongoCollection collection_Dealers = mongoDatabase.getCollection("Dealers");
        FindIterable<Document> dealers = collection_Dealers.find();
        String res = "";
        for(Document d: dealers){
            res = res + d.getObjectId("_id").getDate().toString()+ "\r";
            res = res + "DEALER" + "\r";
            res = res + "nombre: "+d.get("name").toString()+ "\r";
            res = res + "codigo"+d.get("codigo").toString()+ "\r";
        }
        EscribeFichero.main(res, "Dealers.txt");
        return res;
    }
    public static String getUsuarios(){
        MongoCollection collection_Pedidos = mongoDatabase.getCollection("Usuarios");
        FindIterable<Document> usuarios = collection_Pedidos.find();
        String res = "";
        for(Document usuario: usuarios){
            Document direccion = (Document)usuario.get("direccion");
            res = res + usuario.getObjectId("_id").getDate().toString()+ "\r";
            res = res + "USUARIO"+ "\r";
            res = res + "nombre: "+usuario.get("name").toString()+ "\r";
            res = res + "CI: "+usuario.get("CI").toString()+ "\r";
            res = res + "celular: "+usuario.get("celular").toString()+ "\r";
            res = res + "DIRECCION" + "\r";
            res = res + "calle: "+direccion.get("calle").toString()+ "\r";
            res = res + "nroCasa: "+direccion.get("nroCasa").toString()+ "\r";
            res = res + "referencias: "+direccion.get("referencias").toString()+ "\r";
        }
        EscribeFichero.main(res, "Usuarios.txt");
        return res;
    }
}
