import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class VentanaInicio extends JFrame 
{
    JButton pedidoManual;
    JButton pedidoCatalogo;
    JButton pedidos;
    JPanel fondo;
    
    public VentanaInicio (){
        this.setSize(1200,700);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("INICIO");
        this.setLocationRelativeTo(null);
        
        //Añadir panel de fondo
        fondo = new JPanel();
        GridLayout layout = new GridLayout(1,3);
        layout.setHgap(20);
        layout.setVgap(20);
        fondo.setLayout(layout);
        
        //iniciar botones
        iniciarBotonPedidoCatalogo();
        iniciarBotonPedidoManual();
        iniciarBotonPedidos();
        
        //añadirBotones
        fondo.add(pedidoManual);
        fondo.add(pedidoCatalogo);
        fondo.add(pedidos);
        
        this.getContentPane().add(fondo,BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    private void iniciarBotonPedidoManual(){
        pedidoManual = new JButton ("Pedido Manual");
    }
    
    private void iniciarBotonPedidoCatalogo(){
        pedidoCatalogo = new JButton ("Pedido Catalogo");
    }
    
    private void iniciarBotonPedidos(){
        pedidos = new JButton ("Mis Pedidos");
    }
}
