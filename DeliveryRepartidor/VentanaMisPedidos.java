import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.*;

public class VentanaMisPedidos extends JFrame
{
    Dealer yo;
    JPanel fondo;
    JButton regresar;

    public VentanaMisPedidos(Dealer yo){
        this.yo = yo;

        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("MIS PEDIDOS");
        this.setLocationRelativeTo(null);
        
        iniciarBotonRegreso();
        
        fondo = new JPanel();
        GridLayout grid = new GridLayout(0,1);
        fondo.setLayout(grid);
        for (Pedido p: yo.getLista()){
            Especificaciones esp = new Especificaciones(p);
            fondo.add(esp);
        } 
        
        JScrollPane nuevo = new JScrollPane(fondo);
        
        this.getContentPane().add(regresar,BorderLayout.NORTH);
        this.getContentPane().add(nuevo,BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void iniciarBotonRegreso(){
        regresar = new JButton("Regresar");
        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent a){
                VentanaInicio vi = new VentanaInicio(yo);
                dispose();
            }
        };
        regresar.addActionListener(al);
    }
    public class Especificaciones extends JPanel
    {
        Pedido pedido;
        JPanel fondo;
        JButton reproducir;
        JButton entregado;

        public Especificaciones (Pedido p){
            pedido = p;
            
            
            //this.setSize(200,300);
            //this.setPreferredSize(new Dimension(200,300));
            
            fondo = new JPanel();
            GridLayout grid = new GridLayout(5,1);
            fondo.setLayout(grid);

            iniciarBotonReproducir();
            iniciarBotonEntregado();

            JPanel superior = new JPanel();
            GridLayout grid1 = new GridLayout(2,3);
            superior.setLayout(grid1);
            JLabel nombre = new JLabel("Nombre:");
            JLabel celular = new JLabel("Nro celular:");
            JLabel ci = new JLabel("CI:");
            JLabel nombrex = new JLabel(pedido.getUsuario().getNombre());
            JLabel celularx = new JLabel (pedido.getUsuario().getNroCelular()+"");
            JLabel cix = new JLabel (pedido.getUsuario().getNroCi()+"");

            superior.add(nombre);
            superior.add(celular);
            superior.add(ci);
            superior.add(nombrex);
            superior.add(celularx);
            superior.add(cix);

            
            
            JPanel medioSup = new JPanel();
            GridLayout grid2 = new GridLayout(2,3);
            medioSup.setLayout(grid2);
            JLabel calle = new JLabel("Calle:");
            JLabel ncasa = new JLabel("Nro Casa:");
            JLabel referencias = new JLabel ("Referencias:");
            JLabel callex = new JLabel(pedido.getUsuario().getDireccion().getCalle());
            JLabel ncasax = new JLabel(pedido.getUsuario().getDireccion().getNroCasa()+"");
            JLabel referenciasx = new JLabel(pedido.getUsuario().getDireccion().getRefer());

            medioSup.add(calle);
            medioSup.add(ncasa);
            medioSup.add(referencias);
            medioSup.add(callex);
            medioSup.add(ncasax);
            medioSup.add(referenciasx);

            
            
            JPanel medio = new JPanel();
            GridLayout grid3 = new GridLayout(2,2);
            medio.setLayout(grid3);

            JLabel producto = new JLabel("Producto:");
            JLabel caract = new JLabel("Caracteristicas:");
            JLabel productox = new JLabel(pedido.getProducto().getNombre());
            JLabel caractx = new JLabel(pedido.getProducto().getCaracteristicas());

            medio.add(producto);
            medio.add(caract);
            medio.add(productox);
            medio.add(caractx);

            
            
            JPanel medioInf = new JPanel();
            GridLayout grid4 = new GridLayout(1,6);
            medioInf.setLayout(grid4);

            JLabel cantidad = new JLabel("Cantidad:");
            JLabel precio = new JLabel("Precio:");
            JLabel inmediato = new JLabel("Es inmediato:");
            JLabel cantidadx = new JLabel(pedido.getCantidad()+"");
            double costo = pedido.getCantidad() * pedido.getProducto().getPrecio();
            JLabel preciox = new JLabel(costo+"");
            JLabel inmediatox;
            if (pedido.getEntregaInmediata())
                inmediatox = new JLabel("Si");
                else
                    inmediatox = new JLabel("No");

            medioInf.add(cantidad);
            medioInf.add(cantidadx);
            medioInf.add(precio);
            medioInf.add(preciox);
            medioInf.add(inmediato);
            medioInf.add(inmediatox);

            
            
            JPanel inferior = new JPanel();
            GridLayout grid5 = new GridLayout(1,2);
            inferior.setLayout(grid5);

            JPanel infIzq = new JPanel();
            GridLayout grid6 = new GridLayout(2,1);
            infIzq.setLayout(grid6);

            JLabel observaciones = new JLabel("Observaciones:");
            JLabel observacionesx = new JLabel(pedido.getObservaciones());

            infIzq.add(observaciones);
            infIzq.add(observacionesx);

            JPanel infDer = new JPanel();
            GridLayout grid7 = new GridLayout(2,1);
            infDer.setLayout(grid7);

            infDer.add(reproducir);
            infDer.add(entregado);

            inferior.add(infIzq);
            inferior.add(infDer);

            
            
            fondo.add(superior);
            fondo.add(medioSup);
            fondo.add(medio);
            fondo.add(medioInf);
            fondo.add(inferior);

            this.add(fondo);
            this.setBorder(new BevelBorder(BevelBorder.RAISED));
            this.setVisible(true);
        }

        private void iniciarBotonReproducir(){
            reproducir = new JButton("Reproducir");
            ActionListener al = new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Reconocedor voz = new Reconocedor();
                        Usuario u = pedido.getUsuario();
                        Direccion d = u.getDireccion();
                        Producto p = pedido.getProducto();
                        int cantidad = pedido.getCantidad();
                        String obs = pedido.getObservaciones();
                        
                        String texto = "Pedido para "+u.getNombre()+" de CI " + u.getNroCi() + " y celular " + u.getNroCelular();
                        String texto1 = "Vive en "+d.getCalle()+" numero de casa "+d.getNroCasa()+" "+d.getRefer();
                        String texto2 = "El producto es "+p.getNombre()+" "+p.getCaracteristicas();
                        String texto3 = "La cantidad es "+cantidad+" y el precio es "+(cantidad*p.getPrecio());
                        String texto4 = "Las observaciones son "+obs;
                        
                        voz.hablar(texto);
                        voz.hablar(texto1);
                        voz.hablar(texto2);
                        voz.hablar(texto3);
                        voz.hablar(texto4);
                    }
                };
            reproducir.addActionListener(al);
        }
        
        private void iniciarBotonEntregado(){
            entregado = new JButton("Entregado");
            ActionListener al = new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        MongoDB.pedidoEntregado(pedido);
                        yo.pedidoEntregado(pedido);
                        dispose();
                    }
                };
            entregado.addActionListener(al);
        }
    }
}

