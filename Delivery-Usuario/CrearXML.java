
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.io.*;

public class CrearXML
{
    private Document documento ;
    public CrearXML()throws ParserConfigurationException{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        documento = builder.newDocument(); 
    }
    
    private void anadirPedidos(Pedido ped){
        Element pedidos = documento.createElement("Pedidos");

        //for(int i =0;i<losPedidos.size();i++){
                //Pedido ped =  losPedidos.get(i); ArrayList<Pedido> losPedidos

                Element pedido = documento.createElement("Pedido");
                //nodo padre usuario
                Element usuario = documento.createElement("Usuario");
                //creamos nodos hijos de usuario
                Element nombreCliente = documento.createElement("Nombre_Cliente");
                Text textNom = documento.createTextNode(ped.getUsuario().getNombre());
                nombreCliente.appendChild(textNom);
                Element numCi = documento.createElement("Numero_Ci");
                Text textCi = documento.createTextNode(deInt(ped.getUsuario().getNroCi()));
                numCi.appendChild(textCi);
                Element numCel = documento.createElement("Numero_celular");
                Text textCel = documento.createTextNode(deInt(ped.getUsuario().getNroCelular()));
                numCel.appendChild(textCel);
                //agragamos nodos hijo a usuario
                usuario.appendChild(nombreCliente);
                usuario.appendChild(numCi);
                usuario.appendChild(numCel);
                //nodo padre direccion
                Element dir = documento.createElement("Direccion");
                //creamos nodos hijos de direccion
                Element calle = documento.createElement("Calle");
                Text textCalle = documento.createTextNode(ped.getUsuario().getDireccion().getCalle());
                calle.appendChild(textCalle);
                Element numCasa = documento.createElement("Numero_Casa");
                Text textNumCasa = documento.createTextNode(deInt(ped.getUsuario().getDireccion().getNroCasa()));
                numCasa.appendChild(textNumCasa);
                Element ref = documento.createElement("Referencias");
                Text textRef = documento.createTextNode(ped.getUsuario().getDireccion().getRefer());
                ref.appendChild(textRef);
                //agregamos nodos hijo a dir4eccion
                dir.appendChild(calle);
                dir.appendChild(numCasa);
                dir.appendChild(ref);
                //agregamos nodo direccion a usuario
                usuario.appendChild(dir);
                //nodo producto
                Element producto = documento.createElement("Producto");
                //creamos nodos hijo de producto
                Element idProd = documento.createElement("Id_Producto");
                Text textIdProd = documento.createTextNode(deInt(ped.getProducto().getId()));
                idProd.appendChild(textIdProd);
                Element nombreProd = documento.createElement("Nombre_Producto");
                Text textNombreProd = documento.createTextNode(ped.getProducto().getNombre());
                nombreProd.appendChild(textNombreProd);
                Element carac = documento.createElement("Caracteristicas");
                Text textCarac = documento.createTextNode(ped.getProducto().getCarac());
                carac.appendChild(textCarac);
                Element precio = documento.createElement("Precio");
                Text textPrecio = documento.createTextNode(deDouble(ped.getProducto().getPrecio()));
                precio.appendChild(textPrecio);
                //agregamos nodos hijo a producto
                producto.appendChild(idProd);
                producto.appendChild(nombreProd);
                producto.appendChild(carac);
                producto.appendChild(precio);
                //creamos nodos de pedido
                Element idPed = documento.createElement("Id_Pedido");
                Text textIdPed = documento.createTextNode(deInt(ped.getId()));
                idPed.appendChild(textIdPed);
                Element cantidad = documento.createElement("Cantidad");
                Text textCant = documento.createTextNode(deInt(ped.getCantidad()));
                cantidad.appendChild(textCant);
                Element observaciones = documento.createElement("Observaciones");
                Text textObs = documento.createTextNode(ped.getObs());
                observaciones.appendChild(textObs);
               
                pedido.appendChild(usuario);
                pedido.appendChild(producto);
                pedido.appendChild(idPed);
                pedido.appendChild(cantidad);
                pedido.appendChild(observaciones);
                
                pedidos.appendChild(pedido);
                documento.appendChild(pedidos);
    }
    private String deInt(int num){
        String res = Integer.toString(num);
        return res;
    }
    private String deDouble(double num){
        String res = Double.toString(num);
        return res;
    }
    private void generarXml() {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer trans = factory.newTransformer();
            Source source = new DOMSource(documento);
            File file = new File("pedidos.xml");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            Result resultado = new StreamResult(pw); 
            trans.transform(source,resultado);
        }catch( IOException | TransformerException ex){
             System.out.println(ex.getMessage());
        }
    }
    public void main(Pedido ped)throws Exception{
        CrearXML crear = new CrearXML();
        crear.anadirPedidos(ped);
        crear.generarXml();
    }
}
