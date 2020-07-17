import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.*;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VentanaInventario extends JFrame
{
    private ArrayList<Producto> inventario;
    private JButton regreso;
    
    public VentanaInventario (){
        inventario = new ArrayList<>();
        rellenarLista();
        
        this.setSize(1200,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("CATALOGO");
        this.setLocationRelativeTo(null);
        
        //iniciarBotones
        iniciarBotonRegreso();
        
        //panel para el boton de regreso
        JPanel regreso = new JPanel();
        FlowLayout layout1 = new FlowLayout();
        regreso.setLayout(layout1);
        regreso.add(this.regreso);
        
        //panel de los productos
        JPanel productos = new JPanel();
        GridLayout grid = new GridLayout(0,4);
        grid.setHgap(7);
        grid.setVgap(7);
        productos.setLayout(grid);
        
        for (Producto p: inventario){
            CuadroDeProducto cdp = new CuadroDeProducto(p);
            productos.add(cdp);
        }
        
        JScrollPane produc = new JScrollPane(productos);
        //poner paneles
        this.getContentPane().add(regreso,BorderLayout.NORTH);
        this.getContentPane().add(produc,BorderLayout.CENTER);
        
        //visible
        this.setVisible(true);
    }
    
    private void iniciarBotonRegreso(){
        regreso = new JButton ("Regresar");
    }
    
    private void rellenarLista(){
        Producto p1 = new Producto(0,"Play","Bonito",130.5);
        Producto p2 = new Producto(0,"DVD","Ghingon",130.5);
        Producto p3 = new Producto(0,"Laptop","Chidori",130.5);
        Producto p4 = new Producto(0,"MP3","Mamalon",130.5);
        Producto p5 = new Producto(0,"Play","Bonito",130.5);
        Producto p6 = new Producto(0,"Play","Bonito",130.5);
        Producto p7 = new Producto(0,"Play","Bonito",130.5);
        Producto p8 = new Producto(0,"Play","Bonito",130.5);
        Producto p9 = new Producto(0,"Play","Bonito",130.5);
        Producto p10 = new Producto(0,"Play","Bonito",130.5);
        Producto p11 = new Producto(0,"Play","Bonito",130.5);
        Producto p12 = new Producto(0,"Play","Bonito",130.5);
        Producto p13 = new Producto(0,"Play","Bonito",130.5);
        Producto p14 = new Producto(0,"Play","Bonito",130.5);
        Producto p15 = new Producto(0,"Play","Bonito",130.5);
        Producto p16 = new Producto(0,"Play","Bonito",130.5);
        Producto p17 = new Producto(0,"Play","Bonito",130.5);
        Producto p18 = new Producto(0,"Play","Bonito",130.5);
        Producto p19 = new Producto(0,"Play","Bonito",130.5);
        Producto p20 = new Producto(0,"Play","Bonito",130.5);
        Producto p21 = new Producto(0,"Play","Bonito",130.5);
        
        inventario.add(p1);
        inventario.add(p2);
        inventario.add(p3);
        inventario.add(p4);
        inventario.add(p5);
        inventario.add(p6);
        inventario.add(p7);
        inventario.add(p8);
        inventario.add(p9);
        inventario.add(p10);
        inventario.add(p11);
        inventario.add(p12);
        inventario.add(p13);
        inventario.add(p14);
        inventario.add(p15);
        inventario.add(p16);
        inventario.add(p17);
        inventario.add(p18);
        inventario.add(p19);
        inventario.add(p20);
        inventario.add(p21);
        
    }
    
    private class CuadroDeProducto extends JPanel
    {
        private Producto producto;
        private JButton comprar;
        
        public CuadroDeProducto(Producto producto){
            this.producto = producto;
            this.setSize(200,300);
            this.setPreferredSize(new Dimension(200,300));
            //iniciar botones
            iniciarBotonCompra();
            
            //boton de compra
            JPanel compra = new JPanel();
            FlowLayout layout = new FlowLayout();
            compra.setLayout(layout);
            compra.add(comprar);
            
            //caracteristicas
            JPanel carac = new JPanel();
            GridLayout grid = new GridLayout(6,1);
            carac.setLayout(grid);
            
            JLabel nombre = new JLabel("Producto:");
            nombre.setPreferredSize(new Dimension(280,40));
            nombre.setHorizontalAlignment(2);
            
            JLabel nombrex = new JLabel(producto.getNombre());
            nombrex.setPreferredSize(new Dimension(280,40));
            nombrex.setHorizontalAlignment(0);
            
            JLabel caracteristicas = new JLabel("Caracteristicas:");
            caracteristicas.setPreferredSize(new Dimension(280,40));
            caracteristicas.setHorizontalAlignment(2);
            
            JLabel caracteristicasx = new JLabel(producto.getCarac());
            caracteristicasx.setPreferredSize(new Dimension(280,40));
            caracteristicasx.setHorizontalAlignment(0);
            
            JLabel precio = new JLabel("Precio");
            precio.setPreferredSize(new Dimension(280,40));
            precio.setHorizontalAlignment(2);
            
            JLabel preciox = new JLabel(producto.getPrecio()+"");
            precio.setPreferredSize(new Dimension(280,40));
            preciox.setHorizontalAlignment(0);
           
            //añadir
            carac.add(nombre);
            carac.add(nombrex);
            carac.add(caracteristicas);
            carac.add(caracteristicasx);
            carac.add(precio);
            carac.add(preciox);
            
            //borde
            this.setBorder(new BevelBorder(BevelBorder.RAISED));
            
            this.add(carac,BorderLayout.NORTH);
            this.add(compra,BorderLayout.CENTER);
            
           
            this.setVisible(true);
            
        }
        
        private void iniciarBotonCompra(){
            comprar = new JButton("Comprar");
        }
    }
}


