import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
public class VentanaEmpresa extends JFrame
{
    private JPanel panel;
    private JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8;
    private ImageIcon imagen;
    private Icon icono;
    private JLabel titulo;
    private MongoDB mongo;
    public VentanaEmpresa(){
        setTitle("EMPRESA AppDelivery");
        setBounds(100,75,800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        this.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);
        
        boton1 = new JButton("Producto mas Vendido");
        boton1.setBounds(190,170,200,50);
        imagen = new ImageIcon("masvendido.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
        boton1.setIcon(icono);
        ActionListener l1 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String aux = mongo.getInformeMasVendido();
                JOptionPane.showMessageDialog(panel,aux);
            }
        };
        boton1.addActionListener(l1);

        boton2 = new JButton("Mayor Vendedor");
        boton2.setBounds(190,240,200,50);
        imagen = new ImageIcon("mayorvendedor.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        boton2.setIcon(icono);
        ActionListener l2 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String aux = mongo.getInformeMasVendedor();
                JOptionPane.showMessageDialog(panel,aux);
            }
        };
        boton2.addActionListener(l2);
        
        boton3 = new JButton("Ganancias");
        boton3.setBounds(190,310,200,50);
        imagen = new ImageIcon("ganancias.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        boton3.setIcon(icono);
        ActionListener l3 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String aux = Double.toString(mongo.getGanancias());
                JOptionPane.showMessageDialog(panel,aux);
            }
        };
        boton3.addActionListener(l3);
         
        boton4 = new JButton();
        boton4.setBounds(190,380,200,50);
        ActionListener l4 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(panel,"");
            }
        };
        boton4.addActionListener(l4);
         
        boton5 = new JButton("Añadir Producto");
        boton5.setBounds(450,170,200,50);
        imagen = new ImageIcon("producto.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(40,30,Image.SCALE_DEFAULT));
        boton5.setIcon(icono);
        ActionListener l5 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                VentanaProducto n= new VentanaProducto();
                dispose();
            }
        };
        boton5.addActionListener(l5);
         
        boton6 = new JButton("Añadir Repartidor");
        boton6.setBounds(450,240,200,50);
        imagen = new ImageIcon("dealer.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        boton6.setIcon(icono);
        ActionListener l6 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                VentanaDatos n = new VentanaDatos();
                dispose();
            }
        };
        boton6.addActionListener(l6);
        
        boton7 = new JButton("");
        boton7.setBounds(450,310,200,50);
        ActionListener l7 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(panel,"");
            }
        };
        boton7.addActionListener(l7);
        
        boton8 = new JButton();
        boton8.setBounds(450,380,200,50);
        ActionListener l8 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(panel,"");
            }
        };
        boton8.addActionListener(l8);
        
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(boton5);
        panel.add(boton6);
        panel.add(boton7);
        panel.add(boton8);
        
        iniciarTitulo();
        this.setVisible(true);
    }
    private void iniciarTitulo(){
        titulo = new JLabel();
        titulo.setBounds(150,20,520,100);
        imagen = new ImageIcon("titulo.jpg");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(titulo.getWidth(),titulo.getHeight(),Image.SCALE_DEFAULT));
        titulo.setIcon(icono);
        panel.add(titulo);
    }
}
