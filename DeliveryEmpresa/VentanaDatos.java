import javax.swing.*;
import java.awt.event.*;
import java.awt.Image;

public class VentanaDatos extends JFrame
{
    private JTextField textNombre,textApellido,textCi;
    private JButton agregar,regresar;
    private JPanel panel;
    private Dealer nuevo = new Dealer();
    private ImageIcon imagen;
    private Icon icono;
    public VentanaDatos(){
        setTitle("Llenar Datos");
        setBounds(100,75,600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        this.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);
        
        iniciarBotonAgregar();
        iniciarBotonRegresar();
        
        JLabel nombres = new JLabel("Nombre:");
        nombres.setBounds(20,50,100,30);
        panel.add(nombres);
        
        JLabel apellidos = new JLabel("Apellidos:");
        apellidos.setBounds(20,100,100,30);
        panel.add(apellidos);
        
        JLabel ci = new JLabel("Ci: ");
        ci.setBounds(20,150,100,30);
        panel.add(ci);
        
        textNombre = new JTextField();
        textNombre.setBounds(200,50,300,30);
        panel.add(textNombre);
        
        textApellido = new JTextField();
        textApellido.setBounds(200,100,300,30);
        panel.add(textApellido);
        
        textCi = new JTextField();
        textCi.setBounds(200,150,300,30);
        panel.add(textCi);
        
        this.setVisible(true);
    }
    private void iniciarBotonAgregar(){
        agregar = new JButton("Agregar");
        agregar.setBounds(300,300,150,40);
        imagen = new ImageIcon("check.png");
        icono = new ImageIcon(imagen.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        agregar.setIcon(icono);
        ActionListener l = new ActionListener(){
             public void actionPerformed (ActionEvent e){
                agregarDealer();
                MongoDB.agregarDealer(nuevo);
                JOptionPane.showMessageDialog(panel,"Dealer Agregado");
            }
        };
        panel.add(agregar);
    }
    private void agregarDealer(){
        String nom = textNombre.getText()+" "+textApellido.getText();
        nuevo.setNombre(nom);
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
