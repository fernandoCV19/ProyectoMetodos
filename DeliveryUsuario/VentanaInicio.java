import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class VentanaInicio extends JFrame implements Runnable
{
    JButton pedidoManual;
    JButton pedidoCatalogo;
    JButton pedidos;
    JPanel fondo;

    public VentanaInicio (){

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
                    VentanaPedidos p = new VentanaPedidos();
                    dispose();
                }
            };
        pedidos.addActionListener(l);
    }

    public void run(){
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
        Thread pro1 = new Thread(){
            public void run(){
                iniciarBotonPedidoCatalogo();
            }
        };

        Thread pro2 = new Thread(){
            public void run(){
                iniciarBotonPedidoManual();
            }
        };
        
        Thread pro3 = new Thread(){
            public void run(){
                iniciarBotonPedidos();
            }
        };
        

        pro1.start();
        pro2.start();
        pro3.start();
        //añadirBotones
       
        while(pro1.isAlive()||pro2.isAlive()||pro3.isAlive()){}
        fondo.add(pedidoManual);
        fondo.add(pedidoCatalogo);
        fondo.add(pedidos);

        this.getContentPane().add(fondo,BorderLayout.CENTER);
        this.setVisible(true);
    }
}
