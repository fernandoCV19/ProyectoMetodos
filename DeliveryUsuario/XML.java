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
import java.util.ArrayList;

public class XML
{
    public static void main (String [] args){
        Direccion d = new Direccion("Principal",446,"Rejasnegras");
        Usuario u = new Usuario("Fernando",d,7533,31413);
        Producto p = new Producto(3,"Play","1TB",340.6);
        Pedido ped = new Pedido (u,p,4,"rapido",true);
        añadirPedido(ped);
    }

    public static Pedido yuda(){
        Direccion d = new Direccion("Principal",446,"Rejasnegras");
        Usuario u = new Usuario("Fernando",d,7533,31413);
        Producto p = new Producto(3,"Play","1TB",340.6);
        Pedido ped = new Pedido (u,p,4,"rapido",true);
        return ped;
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
            nuevoPedido.appendChild(producto);

            nodoRaiz.appendChild(nuevoPedido);

            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Pedidos.xml"));

            transformer.transform(source,result);
        }catch(ParserConfigurationException parseE){
            System.out.println(parseE);
        }catch(SAXException saxE){
            System.out.println(saxE);
        }catch (IOException io){
            System.out.println(io);
        }catch (TransformerConfigurationException tce){
            System.out.println(tce.getCause());
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

    public static ArrayList<Pedido> getPedidos(){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse("Pedidos.xml");
            
            NodeList listaPedidos = documento.getElementsByTagName("Pedidos"); 
            
            for (int i = 0; i<listaPedidos.getLength();i++){
                Node nodo = listaPedidos.item(i);
                Element e = (Element) nodo; 
                NodeList pedido = e.getChildNodes();
                
                int cantidad = Integer.parseInt(pedido.item(0).getNodeValue());
                String observaciones = pedido.item(1).getNodeValue();
                boolean inme = Boolean.parseBoolean(pedido.item(2).getNodeValue()); 
                
                Node usuario = pedido.item(3);
                Element e1 = (Element) usuario;
                NodeList usua = e1.getChildNodes();
                
                String nombreUsuario = usua.item(0).getNodeValue();
                int ci = Integer.parseInt(usua.item(1).getNodeValue());
                int celular = Integer.parseInt(usua.item(2).getNodeValue());
                
                Node direccionNodo = pedido.item(4);
                Element e2 = (Element) direccionNodo;
                NodeList direccion = e2.getChildNodes();
                
                String calle = direccion.item(0).getNodeValue();
                int nroCasa = Integer.parseInt(direccion.item(1).getNodeValue());
                String referencias = direccion.item(2).getNodeValue();
                
                
                Node productoN = pedido.item(5);
                Element e3 = (Element) productoN;
                NodeList producto = e3.getChildNodes();
                
                String nombreProducto= producto.item(0).getNodeValue();
                String caracteristicas=producto.item(1).getNodeValue();
                Double precio = Double.parseDouble(producto.item(2).getNodeValue());
                
                
                Direccion d = new Direccion(calle,nroCasa,referencias);
                Usuario u = new Usuario(nombreUsuario,d,ci,celular);
                Producto p = new Producto(0,nombreProducto,caracteristicas,precio);
                Pedido ped = new Pedido(u,p,cantidad,observaciones,inme);
                
                pedidos.add(ped);
            }
        }catch(ParserConfigurationException pce){

        }catch (SAXException sae){

        }catch (IOException io){

        }
        return pedidos;
    }
}
