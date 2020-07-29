import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class VentanaAutentificacion extends JFrame
{
    JTextField nombre;
    JTextField autentificacion;
    JButton ingresar;
    JPanel fondo;
    public VentanaAutentificacion(){
        this.setSize(700,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("AUTENTIFICACION");
        this.setLocationRelativeTo(null);
        
        
        iniciarBotonRegreso();
        
        fondo = new JPanel(); 
        fondo.setLayout(null);
        
        JLabel lnombre = new JLabel("Ingresa tu nombre:");
        lnombre.setBounds(100,190,300,30);
        
        nombre = new JTextField();
        nombre.setBounds(150,230,400,30);
        
        JLabel lautentificacion = new JLabel ("Ingresa tu ID de repartidor");
        lautentificacion.setBounds(100,270,300,30);
        
        autentificacion = new JTextField();
        autentificacion.setBounds(150,300,400,30);
        
        fondo.add(lnombre);
        fondo.add(nombre);
        fondo.add(lautentificacion);
        fondo.add(autentificacion);
        fondo.add(ingresar);
        
        this.getContentPane().add(fondo);
        
        this.setVisible(true);
    }
    
    private void iniciarBotonRegreso(){
        ingresar = new JButton("Ingresar");
        ingresar.setBounds(300,350,100,50);
        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Dealer yo = MongoDB.getDealer(nombre.getText(),Integer.parseInt(autentificacion.getText()));
                if (yo==null)
                    JOptionPane.showMessageDialog(fondo,"Ingresa un nombre de usuario o id valido");
                    else{
                        VentanaInicio ini = new VentanaInicio(yo);
                        dispose();
                    }
            }
        };
        ingresar.addActionListener(al);
    }
}
