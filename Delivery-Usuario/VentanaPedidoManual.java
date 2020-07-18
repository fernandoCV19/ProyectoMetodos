import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPedidoManual extends JFrame
{
    private JPanel panel;
    private JButton confirmar;
    private JTextArea pedir;
    private JTextField cant,obs,textNombre,textTelefono,textCi,textCalle,textNro,textRef;
    private JRadioButton opcion1,opcion2,opcion3;
    private Pedido pedido ;
    public VentanaPedidoManual(){
        setTitle("PEDIDO MANUAL");
        setBounds(100,75,1200,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);
        
        JLabel ingresarPedido = new JLabel("Ingresa tu pedido:");
        ingresarPedido.setBounds(40,20,200,20);
        panel.add(ingresarPedido);
        
        JLabel cantidad = new JLabel("Cantidad:");
        cantidad.setBounds(65,380,100,20);
        panel.add(cantidad);
        
        JLabel observaciones = new JLabel("Observaciones:");
        observaciones.setBounds(250,380,100,20);
        panel.add(observaciones);
        
        pedir = new JTextArea();
        pedir.setBounds(50,50,500,300);
        panel.add(pedir);
        
        cant = new JTextField();
        cant.setBounds(70,420,100,20);
        panel.add(cant);
        
        obs = new JTextField();
        obs.setBounds(255,420,300,60);
        panel.add(obs);
        
        confirmar = new JButton("Continuar");
        confirmar.setBounds(250,320,100,25);
        panel.add(confirmar);
        
        //Lado derecho...
        
        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(640, 20,100,14);
        panel.add(nombre);
        
        JLabel direccion = new JLabel("Dirección");
        direccion.setBounds(640, 95,100,14);
        panel.add(direccion);
        JLabel calle = new JLabel("Calle:");
        calle.setBounds(770,70,75,20);
        panel.add(calle);
        JLabel nro = new JLabel("Nro:");
        nro.setBounds(930,70,50,20);
        panel.add(nro);
        JLabel ref = new JLabel("Referencias:");
        ref.setBounds(1020,70,150,20);
        panel.add(ref);
        
        JLabel pago = new JLabel("Forma de Pago:");
        pago.setBounds(640,130,100,14);
        panel.add(pago);
        
        JLabel telefono = new JLabel("Telefono de referencia:");
        telefono.setBounds(640,270,150,14);
        panel.add(telefono);
        
        JLabel ci = new JLabel("Cedula de Identidad:");
        ci.setBounds(640,320,150,20);
        panel.add(ci);
        
        textNombre = new JTextField ();
        textNombre.setBounds(800, 20, 300, 20);
        panel.add(textNombre);

        textCalle = new JTextField ();
        textCalle.setBounds(760, 95, 150, 20);
        panel.add(textCalle);
        textNro = new JTextField ();
        textNro.setBounds(930, 95, 50, 20);
        panel.add(textNro);
        textRef = new JTextField ();
        textRef.setBounds(1020, 95, 150, 20);
        panel.add(textRef);
        
        textTelefono = new JTextField ();
        textTelefono.setBounds(800, 270, 150, 20);
        panel.add(textTelefono);
        
        textCi = new JTextField();
        textCi.setBounds(800,320,150,20);
        panel.add(textCi);
        
        opcion1 = new JRadioButton("Tarjeta de Credito");
        opcion1.setBounds(680,160,200,14);
        panel.add(opcion1);
        
        opcion2 = new JRadioButton("Tarjeta de Debito");
        opcion2.setBounds(680,190,200,14);
        panel.add(opcion2);
        
        opcion3 = new JRadioButton("Pagar al recibir");
        opcion3.setBounds(680,220,200,14);
        panel.add(opcion3);
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcion1);
        grupo.add(opcion2);
        grupo.add(opcion3);
        
        confirmar = new JButton("Confirmar");
        confirmar.setBounds(640,420,200,50);
        panel.add(confirmar);
        
        confirmar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               JOptionPane.showMessageDialog(panel,"Pedido realizado");
               pedido = devolverPedido();
           }
        });
    }
    public Pedido devolverPedido(){
        Pedido res = new Pedido(null,null,0,0,"");
        int num=0;
        try{
            num=Integer.parseInt(cant.getText());
        }catch(Exception a){
                    
        }
        res.setCantidad(num);
        res.setObs(obs.getText());
        res.setUsuario(devolverUsuario());
        return res;
    }
    private Usuario devolverUsuario(){
        Usuario res = new Usuario("",null,0,0);
        Direccion dir = new Direccion("",0,"");
        int cid=0,cel=0,nro=0;
        try{
            cid=Integer.parseInt(textCi.getText());
            cel=Integer.parseInt(textTelefono.getText());
            nro=Integer.parseInt(textNro.getText());
        }catch(Exception a){
                    
        }
        dir.setCalle(textCalle.getText());
        dir.setNroCasa(nro);
        dir.setRefer(textRef.getText());
        res.setNombre(textNombre.getText());
        res.setDireccion(dir);
        res.setNroCi(cid);
        res.setNroCelular(cel);
        return res;
    }

    public static void main(String [] args){
        new VentanaPedidoManual().setVisible(true);
    }
}
