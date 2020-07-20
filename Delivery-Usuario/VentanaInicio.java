import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JOptionPane;

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
        ActionListener l = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VentanaPedidoManual m = new VentanaPedidoManual();
                dispose();
            }
        };
        pedidoManual.addActionListener(l);
    }
    
    private void iniciarBotonPedidoCatalogo(){
        pedidoCatalogo = new JButton ("Pedido Catalogo");
        ActionListener l = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VentanaInventario m = new VentanaInventario();
                dispose();
            }
        };
        pedidoCatalogo.addActionListener(l);
    }
    
    private void iniciarBotonPedidos(){
        pedidos = new JButton ("Mis Pedidos");
        ActionListener l = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(fondo,"Porximamente...");
            }
        };
        pedidos.addActionListener(l);
    }
}
