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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class VentanaInventario extends JFrame
{
    private ArrayList<Producto> inventario;
    private JButton regreso;

    public VentanaInventario (){
        inventario = MongoDB.getInstanceMongoDB().getInventario();
        
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
        ActionListener l = new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    VentanaInicio m = new VentanaInicio();
                    dispose();
                }
            };
        regreso.addActionListener(l);
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
            ActionListener oyente = new ActionListener(){
                    public void actionPerformed (ActionEvent e){
                        DatosYConfirmacion a = new DatosYConfirmacion(producto);
                    }
                };
            comprar.addActionListener(oyente);
        }

        private class DatosYConfirmacion extends JFrame{
            private JTextField nombre;
            private JTextField ci;
            private JTextField celular;
            private JTextField callePrincipal;
            private JTextField nroCasa;
            private JTextField referencias;
            private JTextArea observaciones;
            private JTextField cantidad;
            private JButton pedir;
            private JPanel fondo;

            Producto p;
            public DatosYConfirmacion(Producto p){
                this.p = p;
                this.setSize(700,650);
                this.setTitle("CATALOGO");
                this.setLocationRelativeTo(null);

                iniciarBotonPedir();

                fondo = new JPanel();
                fondo.setLayout(null);

                JLabel lDatos = new JLabel("Datos personales");
                lDatos.setBounds(300,20,200,30);

                JLabel lNombre = new JLabel ("Nombre:");
                lNombre.setBounds(20,50,100,30);

                nombre = new JTextField();
                nombre.setBounds(200,50,400,30);

                JLabel lCi = new JLabel("CI:");
                lCi.setBounds(20,100,100,30);

                ci = new JTextField();
                ci.setBounds(200,100,400,30);

                JLabel lCelular = new JLabel("Celular:");
                lCelular.setBounds(20,150,100,30);

                celular = new JTextField();
                celular.setBounds(200,150,400,30);

                JLabel lDireccion = new JLabel("Direccion");
                lDireccion.setBounds(300,200,100,30);

                JLabel lCallePrincipal = new JLabel ("Calle principal:");
                lCallePrincipal.setBounds(20,230,100,30);

                callePrincipal = new JTextField();
                callePrincipal.setBounds(200,230,400,30);

                JLabel lNroCasa = new JLabel("Nro Casa:");
                lNroCasa.setBounds(20,280,100,30);

                nroCasa = new JTextField();
                nroCasa.setBounds(200,280,400,30);

                JLabel lRef = new JLabel("Referencias:");
                lRef.setBounds(20,330,100,30);

                referencias = new JTextField();
                referencias.setBounds(200,330,400,30);

                JLabel lOtros = new JLabel("Otros");
                lOtros.setBounds(300,380,200,30);
                
                JLabel lCantidad = new JLabel("Cantidad:");
                lCantidad.setBounds(20,410,100,30);
                
                cantidad = new JTextField();
                cantidad.setBounds(200,410,400,30);
                
                JLabel lObservaciones = new JLabel("Observaciones:");
                lObservaciones.setBounds(20,460,100,30);
                
                observaciones = new JTextArea();
                observaciones.setBounds(200,460,400,80);
                
                //añadir todo
                fondo.add(lDatos);
                fondo.add(lNombre);
                fondo.add(nombre);
                fondo.add(lCi);
                fondo.add(ci);
                fondo.add(lCelular);
                fondo.add(celular);
                fondo.add(lDireccion);
                fondo.add(lCallePrincipal);
                fondo.add(callePrincipal);
                fondo.add(lNroCasa);
                fondo.add(nroCasa);
                fondo.add(lRef);
                fondo.add(referencias);
                fondo.add(pedir);
                fondo.add(lOtros);
                fondo.add(lCantidad);
                fondo.add(cantidad);
                fondo.add(lObservaciones);
                fondo.add(observaciones);

                this.getContentPane().add(fondo);
                this.setVisible(true);
            }

            private void iniciarBotonPedir(){
                pedir = new JButton("Pedir");
                pedir.setBounds(300,550,100,50);
                ActionListener l = new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            String nom = nombre.getText();
                            if (!ValidadorDatos.esNombre(nom)){
                                JOptionPane.showMessageDialog(fondo,"Ingrese un nombre valido por favor");
                            }
                            else{
                                String CI = ci.getText();  
                                if (!ValidadorDatos.esCI(CI)){
                                    JOptionPane.showMessageDialog(fondo,"Ingrese un numero de CI valido por favor");
                                }
                                else{
                                    String cel = celular.getText();  
                                    if (!ValidadorDatos.esCelular(cel)){
                                        JOptionPane.showMessageDialog(fondo,"Ingrese un numero de telefono valido por favor");
                                    }
                                    else{
                                        String calle = callePrincipal.getText();  
                                        if (!ValidadorDatos.esCalle(calle)){
                                            JOptionPane.showMessageDialog(fondo,"Ingrese una calle valida por favor");
                                        }
                                        else{
                                            String nro = nroCasa.getText();  
                                            if (!ValidadorDatos.esNroCasa(nro)){
                                                JOptionPane.showMessageDialog(fondo,"Ingrese un numero de calle valido por favor");
                                            }
                                            else{
                                                String ref = referencias.getText();
                                                Direccion d = new Direccion(calle,Integer.parseInt(nro),ref);
                                                Usuario u = new Usuario(nom,d,Integer.parseInt(CI),Integer.parseInt(cel));
                                                
                                                String cant = cantidad.getText();
                                                int canti = 1;
                                                if (!cant.equals("")){
                                                    canti = Integer.parseInt(cant);
                                                }
                                                
                                                String obser = observaciones.getText();
                                                
                                                Pedido ped = new Pedido(u,p,canti,obser);
                                                MongoDB.insertarPedido(ped);
                                                JOptionPane.showMessageDialog(fondo,"Pedido realizado");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    };
                pedir.addActionListener(l);
            }
        }
    }
}

