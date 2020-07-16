import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

public class VentanaPedidoManual extends JFrame
{
    JTextField producto = new JTextField();
    JTextField cantidad = new JTextField();
    JTextField direccion = new JTextField();
    JTextArea observaciones = new JTextArea();
    JButton pedir;
    JButton regresar;
    JOptionPane confirmacion;
    
    public VentanaPedidoManual(){
        this.setSize(1200,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("PEDIDO MANUAL");
        this.setLocationRelativeTo(null);
        //iniciar botones
        iniciarBotonPedido();
        iniciarBotonRegresar();
        
        
        //panel boton regreso
        JPanel arriba=new JPanel();
        arriba.setLayout(new FlowLayout());
        arriba.add(regresar);
        
        //panel pedido
        JPanel centro = new JPanel();
        GridLayout grid = new GridLayout(9,1);
        centro.setLayout(grid);
        centro.add(new JLabel("Ingrese el producto deseado"));
        centro.add(producto);
        centro.add(new JLabel("Ingrese la cantidad"));
        centro.add(cantidad);
        centro.add(new JLabel("Ingrese la direccion"));
        centro.add(direccion);
        centro.add(new JLabel("Ingrese las observaciones"));
        centro.add(observaciones);
        centro.add(pedir);
        
        
        //añadir panales
        this.getContentPane().add(arriba,BorderLayout.NORTH);
        this.getContentPane().add(centro,BorderLayout.CENTER);
    }
    
    private void iniciarBotonPedido(){
        pedir = new JButton("Pedir");
    }
    
    private void iniciarBotonRegresar(){
        regresar = new JButton ("Regresar");
    }
    
    private void JOptionPane(){
        confirmacion = new JOptionPane();
        
    }
}
