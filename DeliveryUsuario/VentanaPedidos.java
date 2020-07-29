import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class VentanaPedidos extends JFrame
{
    private JPanel superior;
    private JPanel medio;
    private ArrayList<Pedido> pedidos;
    private JButton regresar;
    public VentanaPedidos(){
        this.setSize(1200,700);
        
        iniciarBotonRegresar();
        pedidos = XML.getPedidos();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("MIS PEDIDOS");
        this.setLocationRelativeTo(null);
        
        superior = new JPanel();
        superior.add(regresar,BorderLayout.NORTH);
        
        medio = new JPanel();
        GridLayout grid = new GridLayout(0,1);
        medio.setLayout(grid);
        for(Pedido p: pedidos){
            Inventario nuevo = new Inventario(p);
            medio.add(nuevo);
        }
        JScrollPane produc = new JScrollPane(medio);
        
        this.getContentPane().add(superior,BorderLayout.NORTH);
        this.getContentPane().add(produc,BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    private void iniciarBotonRegresar(){
        regresar = new JButton("Regresar");
        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VentanaInicio m = new VentanaInicio();
                m.run();
                dispose();
            }
        };
        regresar.addActionListener(al);
    }
    
    
    public class Inventario extends JPanel{
        private Pedido pedido;
        public Inventario(Pedido p){
            pedido = p;
            this.setSize(200,300);
            this.setPreferredSize(new Dimension(200,300));
            //iniciar botones


            //usuarios
            JPanel usuario = new JPanel();
            GridLayout grid = new GridLayout(1,6);
            grid.setHgap(10);
            usuario.setLayout(grid);
            
            JLabel datosPersonales = new JLabel("Datos personales");
            
            JLabel nombreUsuarioE = new JLabel("Nombre:");
            JLabel nombreUsuario = new JLabel(pedido.getUsuario().getNombre());
            JLabel ciUsuarioE = new JLabel("CI:");
            JLabel ciUsuario = new JLabel(pedido.getUsuario().getNroCi()+"");
            JLabel celE = new JLabel("Celular:");
            JLabel cel = new JLabel (pedido.getUsuario().getNroCelular()+"");

            usuario.add(nombreUsuarioE);
            usuario.add(nombreUsuario);
            usuario.add(ciUsuarioE);
            usuario.add(ciUsuario);
            usuario.add(celE);
            usuario.add(cel);
           
            //direccion
            JPanel direccion = new JPanel();
            GridLayout grid2 = new GridLayout(1,6);
            grid2.setHgap(10);
            direccion.setLayout(grid2);
            
            JLabel direccionE = new JLabel("Direccion");
            
            JLabel calleE = new JLabel("Direccion:");
            JLabel calle = new JLabel(pedido.getUsuario().getDireccion().getCalle());
            JLabel nroCasaE = new JLabel ("Nro Casa:");
            JLabel nroCasa = new JLabel (pedido.getUsuario().getDireccion().getNroCasa()+"");
            JLabel refE = new JLabel("Referencias");
            JLabel ref = new JLabel(pedido.getUsuario().getDireccion().getRefer());
            
            direccion.add(calleE);
            direccion.add(calle);
            direccion.add(nroCasaE);
            direccion.add(nroCasa);
            direccion.add(refE);
            direccion.add(ref);
            
            //producto
            JPanel producto = new JPanel();
            GridLayout grid3 = new GridLayout(1,6);
            grid3.setVgap(10);
            producto.setLayout(grid3);
            
            JLabel datosProducto = new JLabel("Producto");
            
            JLabel nombreProE = new JLabel("Nombre:");
            JLabel nombrePro = new JLabel(pedido.getProducto().getNombre());
            JLabel caracE = new JLabel("Caracteristicas:");
            JLabel carac = new JLabel(pedido.getProducto().getCaracteristicas());
            JLabel precioE = new JLabel("Precio:");
            JLabel precio = new JLabel(pedido.getProducto().getPrecio()+"");
            
            producto.add(nombreProE);
            producto.add(nombrePro);
            producto.add(caracE);
            producto.add(carac);
            producto.add(precioE);
            producto.add(precio);
            
            
            //detalles pedido
            JPanel pedidoPanel = new JPanel();
            GridLayout grid4 = new GridLayout(1,8);
            grid4.setHgap(10);
            pedidoPanel.setLayout(grid4);
            
            JLabel detallesPedido = new JLabel("Detalles pedido");
            
            JLabel cantidadE = new JLabel("Cantidad:");
            JLabel cantidad = new JLabel(pedido.getCantidad()+"");
            JLabel observacionesE = new JLabel("Observaciones:");
            JLabel observaciones = new JLabel(pedido.getObservaciones()+"");
            JLabel inmediatoE = new JLabel("Inmediato");
            JLabel inmediato;
            if (pedido.getEntregaInmediata())
                inmediato = new JLabel("Si");
            else
                inmediato = new JLabel("No");
            JLabel costoE = new JLabel ("Costo");
            JLabel costo = new JLabel((pedido.getCantidad()*pedido.getProducto().getPrecio())+"");
            
            
            pedidoPanel.add(cantidadE);
            pedidoPanel.add(cantidad);
            pedidoPanel.add(observacionesE);
            pedidoPanel.add(observaciones);
            pedidoPanel.add(inmediatoE);
            pedidoPanel.add(inmediato);
            pedidoPanel.add(costoE);
            pedidoPanel.add(costo);
            //añadir
            GridLayout gridFondo = new GridLayout(8,1);
            gridFondo.setVgap(10);
            
            this.setLayout(gridFondo);
            this.add(datosPersonales);
            this.add(usuario);
            this.add(direccionE);
            this.add(direccion);
            this.add(datosProducto);
            this.add(producto);
            this.add(detallesPedido);
            this.add(pedidoPanel);
            
            //borde
            this.setBorder(new BevelBorder(BevelBorder.RAISED));


            this.setVisible(true);
        }
    }
}
