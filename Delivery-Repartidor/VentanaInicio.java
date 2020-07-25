import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class VentanaInicio extends JFrame
{
    Dealer yo;
    JButton misPedidos;
    JButton solicitar;
    JPanel fondo;
    JPanel arriba;
    public VentanaInicio(Dealer yo){
        this.yo = yo;
        
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("VENTANA INICIO");
        this.setLocationRelativeTo(null);
        
        iniciarBotonMiPedidos();
        iniciarBotonSolicitar();
        
        GridLayout grid = new GridLayout(1,2);
        grid.setHgap(20);
        grid.setVgap(20);
        
        fondo = new JPanel();
        fondo.add(misPedidos);
        fondo.add(solicitar);
        fondo.setLayout(grid);
        
        this.getContentPane().add(fondo,BorderLayout.CENTER);
        
        arriba = new JPanel();
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(fl.LEFT);
        arriba.setLayout(fl);
        
        JLabel label = new JLabel("Bienvenido: "+ "tienes "+" pedidos pendientes.");
        label.setHorizontalAlignment(label.LEFT);
        label.setHorizontalTextPosition(label.LEFT);
        arriba.add(label,fl.LEFT);
        
        this.getContentPane().add(arriba,BorderLayout.NORTH);
        
        this.setVisible(true);
    }
    
    private void iniciarBotonMiPedidos(){
        misPedidos = new JButton ("Mis pedidos pendientes");
        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VentanaMisPedidos vent = new VentanaMisPedidos(yo);
            }
        };
        misPedidos.addActionListener(al);
    }
            
    private void iniciarBotonSolicitar(){
        solicitar = new JButton ("Pedir nueva orden");
        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Pedido p = MongoDB.buscarPedido(yo);
                if (p==null){
                    JOptionPane.showMessageDialog(fondo,"No hay nuevos pedidos disponibles. Intenta despues");
                }   else{
                    JOptionPane.showMessageDialog(fondo,"Se agrego un nuevo pedido a tu inventario");
                }
            }
        };
        solicitar.addActionListener(al);
    }
}
