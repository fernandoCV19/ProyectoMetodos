import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
public class VentanaEmpresa extends JFrame
{
    private JPanel panel;
    private JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9;
    private ImageIcon imagen;
    private Icon icono;
    private JLabel titulo;
    private MongoDB mongo;
    public VentanaEmpresa(){
        setTitle("EMPRESA AppDelivery");
        setBounds(100,75,800,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        this.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);
        
        boton1 = new JButton("Producto mas Vendido");
        boton1.setBounds(190,160,200,45);
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
        boton2.setBounds(190,230,200,45);
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
        boton3.setBounds(190,295,200,45);
        imagen = new ImageIcon("ganancias.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        boton3.setIcon(icono);
        ActionListener l3 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                System.out.print(mongo.getGanancias());
                String aux = Double.toString(mongo.getGanancias());
                JOptionPane.showMessageDialog(panel,aux);
            }
        };
        boton3.addActionListener(l3);
         
        boton4 = new JButton("Ventas");
        boton4.setBounds(190,360,200,45);
        imagen = new ImageIcon("ventas.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        boton4.setIcon(icono);
        ActionListener l4 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String aux = mongo.getVentas();
                JOptionPane.showMessageDialog(panel,aux);
            }
        };
        boton4.addActionListener(l4);
         
        boton5 = new JButton("Repartidores");
        boton5.setBounds(450,160,200,45);
        imagen = new ImageIcon("dealers.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        boton5.setIcon(icono);
        ActionListener l5 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String aux = mongo.getDealers();
                JOptionPane.showMessageDialog(panel,aux);
            }
        };
        boton5.addActionListener(l5);
         
        boton6 = new JButton("Usuarios");
        boton6.setBounds(450,230,200,45);
        imagen = new ImageIcon("usuarios.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        boton6.setIcon(icono);
        ActionListener l6 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String aux = mongo.getUsuarios();
                JOptionPane.showMessageDialog(panel,aux);
            }
        };
        boton6.addActionListener(l6);
        
        boton7 = new JButton("Añadir Producto");
        boton7.setBounds(450,295,200,45);
        imagen = new ImageIcon("producto.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(40,30,Image.SCALE_DEFAULT));
        boton7.setIcon(icono);
        ActionListener l7 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                VentanaProducto n= new VentanaProducto();
                dispose();
            }
        };
        boton7.addActionListener(l7);
        
        boton8 = new JButton("Añadir Repartidor");
        boton8.setBounds(450,360,200,45);
        imagen = new ImageIcon("dealer.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        boton8.setIcon(icono);
        ActionListener l8 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                VentanaDatos n = new VentanaDatos();
                dispose();
            }
        };
        boton8.addActionListener(l8);
        
        boton9 = new JButton("Inventario");
        boton9.setBounds(320,425,200,45);
        imagen = new ImageIcon("inventario.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        boton9.setIcon(icono);
        ActionListener l9 = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String aux = mongo.getInventario();
                JOptionPane.showMessageDialog(panel,aux);
            }
        };
        boton9.addActionListener(l9);
        
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(boton5);
        panel.add(boton6);
        panel.add(boton7);
        panel.add(boton8);
        panel.add(boton9);
        
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
