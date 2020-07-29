 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.Image;
 
public class VentanaProducto extends JFrame
{
    private JTextField textNombre,textId,textCaracteristicas,textPrecio;
    private JButton agregar,regresar;
    private JPanel panel;
    private ImageIcon imagen;
    private Icon icono;
    private Producto nuevo;
    
    public VentanaProducto(){
        setTitle("Llenar Datos de Producto");
        setBounds(100,75,600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        this.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel); 
        iniciar();
        this.setVisible(true);
    }
    public void iniciar(){
        iniciarBotonAgregar();
        iniciarBotonRegresar();
        
        JLabel nombres = new JLabel("Nombre del Producto:");
        nombres.setBounds(20,50,150,30);
        panel.add(nombres);
        
        JLabel apellidos = new JLabel("Id del producto:");
        apellidos.setBounds(20,100,100,30);
        panel.add(apellidos);
        
        JLabel ci = new JLabel("Caracteristicas: ");
        ci.setBounds(20,150,100,30);
        panel.add(ci);
        
        JLabel precio = new JLabel("Precio: ");
        precio.setBounds(20,200,70,30);
        panel.add(precio);
        
        textNombre = new JTextField();
        textNombre.setBounds(200,50,300,30);
        panel.add(textNombre);
        
        textId = new JTextField();
        textId.setBounds(200,100,300,30);
        panel.add(textId);
        
        textCaracteristicas = new JTextField();
        textCaracteristicas.setBounds(200,150,300,30);
        panel.add(textCaracteristicas);
        
        textPrecio = new JTextField();
        textPrecio.setBounds(200,200,150,30);
        panel.add(textPrecio);
    }
    private void agregarProducto(){
        nuevo.setNombre(textNombre.getText());
        nuevo.setId(Integer.parseInt(textId.getText()));
        nuevo.setCarac(textCaracteristicas.getText());
        nuevo.setPrecio(Double.parseDouble(textPrecio.getText()));
    }
     private void iniciarBotonAgregar(){
        agregar = new JButton("Agregar");
        agregar.setBounds(250,300,150,40);
        imagen = new ImageIcon("check.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        agregar.setIcon(icono);
        ActionListener l = new ActionListener(){
             public void actionPerformed (ActionEvent e){
                nuevo = new Producto();
                agregarProducto();
                MongoDB.agregarProducto(nuevo);
                JOptionPane.showMessageDialog(panel,"Producto Agregado");
            }
        };
        panel.add(agregar);
    }
    private void iniciarBotonRegresar(){
        regresar = new JButton();
        regresar.setBounds(20,300,100,40);
        imagen = new ImageIcon("flecha1.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(regresar.getWidth(),regresar.getHeight(),Image.SCALE_DEFAULT));
        regresar.setIcon(icono);
        ActionListener l = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VentanaEmpresa n = new VentanaEmpresa();
                dispose();
            }
        };
        regresar.addActionListener(l);
        panel.add(regresar);
    }
}


