import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.GridLayout;

public class VentanaMisPedidos extends JFrame
{
    Dealer yo;
    JPanel fondo;
    JButton regresar;

    public VentanaMisPedidos(){
        this.yo = yo;

        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("MIS PEDIDOS");
        this.setLocationRelativeTo(null);

        for (Pedido p: yo.getLista()){
            Especificaciones esp = new Especificaciones(p);
            fondo.add(esp);
        } 
        this.setVisible(true);
    }

    public class Especificaciones extends JPanel
    {
        Pedido pedido;
        JPanel fondo;
        JButton reproducir;
        JButton entregado;

        public Especificaciones (Pedido p){
            this.pedido = pedido;

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
            JLabel nombrex = new JLabel("El nombre es");
            JLabel celularx = new JLabel ("El celular es");
            JLabel cix = new JLabel ("El ci es");

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
            JLabel callex = new JLabel("La calle es");
            JLabel ncasax = new JLabel("El numero de casa es");
            JLabel referenciasx = new JLabel("Las referenicas son");

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
            JLabel productox = new JLabel("El producto es");
            JLabel caractx = new JLabel("Las caracteristicas son");

            medio.add(producto);
            medio.add(caract);
            medio.add(productox);
            medio.add(caractx);

            JPanel medioInf = new JPanel();
            GridLayout grid4 = new GridLayout(1,4);
            medioInf.setLayout(grid4);

            JLabel cantidad = new JLabel("Cantidad:");
            JLabel precio = new JLabel("Precio:");
            JLabel cantidadx = new JLabel("La cantidad es");
            JLabel preciox = new JLabel("El precio es");

            medioInf.add(cantidad);
            medioInf.add(precio);
            medioInf.add(cantidadx);
            medioInf.add(preciox);

            JPanel inferior = new JPanel();
            GridLayout grid5 = new GridLayout(1,2);
            inferior.setLayout(grid5);

            JPanel infIzq = new JPanel();
            GridLayout grid6 = new GridLayout(2,1);
            infIzq.setLayout(grid6);

            JLabel observaciones = new JLabel("Observaciones:");
            JLabel observacionesx = new JLabel("Las observaciones son");

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

            this.setVisible(true);
        }

        private void iniciarBotonReproducir(){
            reproducir = new JButton("Reproducir");
            ActionListener al = new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        
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
                    }
                };
            entregado.addActionListener(al);
        }
    }
}

