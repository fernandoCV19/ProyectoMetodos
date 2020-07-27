import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class XML
{
    public static void main (String [] args){
        Direccion d = new Direccion("Principal",446,"Rejasnegras");
        Usuario u = new Usuario("Fernando",d,7533,31413);
        Producto p = new Producto(3,"Play","1TB",340.6);
        Pedido ped = new Pedido (u,p,4,"rapido",true);
        añadirPedido(ped);
    }

    public static void añadirPedido(Pedido p){
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.parse(new File("Pedidos.xml"));

            doc.getDocumentElement().normalize();

            Node nodoRaiz = doc.getDocumentElement();

            Element nuevoPedido = doc.createElement("Pedido");
            Element cantidad = doc.createElement("Cantidad");
            Text textCant = doc.createTextNode(p.getCantidad()+"");
            cantidad.appendChild(textCant);
            Element observaciones = doc.createElement("Observaciones");
            Text textObs = doc.createTextNode(p.getObservaciones());
            observaciones.appendChild(textObs);
            Element entregaInmediata = doc.createElement("Inmediato");
            Text entInm = doc.createTextNode(p.getEntregaInmediata()+"");
            entregaInmediata.appendChild(entInm);

            Element producto = doc.createElement("Producto");
            Element nomProducto = doc.createElement("Nombre");
            Text textNomP = doc.createTextNode(p.getProducto().getNombre());
            nomProducto.appendChild(textNomP);
            Element caracteristicas = doc.createElement("Caracteristicas");
            Text car = doc.createTextNode(p.getProducto().getCaracteristicas());
            caracteristicas.appendChild(car);
            Element precio = doc.createElement("Precio");
            Text textPre = doc.createTextNode(p.getProducto().getPrecio()+"");
            precio.appendChild(textPre);
            producto.appendChild(nomProducto);
            producto.appendChild(caracteristicas);
            producto.appendChild(precio);

            Element usuario = doc.createElement("Usuario");
            Element nombre = doc.createElement("Nombre");
            Text textNom = doc.createTextNode(p.getUsuario().getNombre());
            nombre.appendChild(textNom);
            Element nroCi = doc.createElement("CI");
            Text textCi = doc.createTextNode(p.getUsuario().getNroCi()+"");
            nroCi.appendChild(textCi);
            Element nroCelular = doc.createElement("Celular");
            Text textCel = doc.createTextNode(p.getUsuario().getNroCelular()+"");
            nroCelular.appendChild(textCel);
            usuario.appendChild(nombre);
            usuario.appendChild(nroCi);
            usuario.appendChild(nroCelular);

            Element direccion = doc.createElement("Direccion");
            Element calle = doc.createElement("Calle");
            Text textCal = doc.createTextNode(p.getUsuario().getDireccion().getCalle());
            calle.appendChild(textCal);
            Element nroCasa = doc.createElement("NroCasa");
            Text textNroCasa = doc.createTextNode(p.getUsuario().getDireccion().getNroCasa()+"");
            nroCasa.appendChild(textNroCasa);
            Element referencias = doc.createElement("Referencias");
            Text textRef = doc.createTextNode(p.getUsuario().getDireccion().getRefer());
            referencias.appendChild(textRef);
            direccion.appendChild(calle);
            direccion.appendChild(nroCasa);
            direccion.appendChild(referencias);

            nuevoPedido.appendChild(cantidad);
            nuevoPedido.appendChild(observaciones);
            nuevoPedido.appendChild(entregaInmediata);
            nuevoPedido.appendChild(usuario);
            nuevoPedido.appendChild(direccion);

            nodoRaiz.appendChild(nuevoPedido);

            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Pedidos.xml"));

            transformer.transform(source,result);
        }catch(ParserConfigurationException parseE){
            System.out.println("1");
        }catch(SAXException saxE){
            System.out.println("2");
        }catch (IOException io){
            System.out.println("3");
        }catch (TransformerConfigurationException tce){
            System.out.println("4");
        }catch (TransformerException te){

            System.out.println(te.getCause());
        }
    }

    public static void crearXML() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null,"Pedidos", null);
            document.setXmlVersion("1.0");

            // NODO RAIZ
            Element raiz = document.getDocumentElement();

            Element pedidos = document.createElement("Pedidos");
            
            raiz.appendChild(pedidos);

            // GENERA XML
            Source source = new DOMSource(document);

            // DONDE SE GUARDARA
            Result result = new StreamResult(new java.io.File("Pedidos" + ".xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch(ParserConfigurationException e) {

        }
    }
}
