import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPedidoManual extends JFrame
{
    private JPanel panel;
    private JButton confirmar;
    private JTextArea pedir;
    private JTextField textNombre,textTelefono,textCi,textCalle,textNro,textRef;
    private Pedido pedido ;
    private JButton regresar;
    private JRadioButton inmediato,normal;

    public VentanaPedidoManual(){
        setTitle("PEDIDO MANUAL");
        setBounds(100,75,1200,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        this.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        //iniciar boton
        iniciarBotonRegreso();
        panel.add(regresar);

        JLabel ingresarPedido = new JLabel("Ingresa tu pedido:");
        ingresarPedido.setBounds(40,70,200,20);
        panel.add(ingresarPedido);

        pedir = new JTextArea();
        pedir.setBounds(50,100,500,300);
        panel.add(pedir);

        confirmar = new JButton("Continuar");
        confirmar.setBounds(280,320,100,25);
        panel.add(confirmar);

        //Lado derecho...

        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(640, 50,100,14);
        panel.add(nombre);

        JLabel direccion = new JLabel("Dirección");
        direccion.setBounds(640, 125,100,14);
        panel.add(direccion);
        JLabel calle = new JLabel("Calle:");
        calle.setBounds(770,100,75,20);
        panel.add(calle);
        JLabel nro = new JLabel("Nro:");
        nro.setBounds(930,100,50,20);
        panel.add(nro);
        JLabel ref = new JLabel("Referencias:");
        ref.setBounds(1020,90,150,20);
        panel.add(ref);

        JLabel telefono = new JLabel("Telefono de referencia:");
        telefono.setBounds(640,200,150,14);
        panel.add(telefono);

        JLabel ci = new JLabel("Cedula de Identidad:");
        ci.setBounds(640,250,150,20);
        panel.add(ci);

        textNombre = new JTextField ();
        textNombre.setBounds(800, 50, 300, 20);
        panel.add(textNombre);

        textCalle = new JTextField ();
        textCalle.setBounds(760, 125, 150, 20);
        panel.add(textCalle);
        textNro = new JTextField ();
        textNro.setBounds(930, 125, 50, 20);
        panel.add(textNro);
        textRef = new JTextField ();
        textRef.setBounds(1020, 125, 150, 20);
        panel.add(textRef);

        textTelefono = new JTextField ();
        textTelefono.setBounds(800, 200, 150, 20);
        panel.add(textTelefono);

        textCi = new JTextField();
        textCi.setBounds(800,250,150,20);
        panel.add(textCi);
        
        
        inmediato = new JRadioButton ("Inmediato",true);
        inmediato.setBounds(640,290,200,30);
        panel.add(inmediato);
        
        normal = new JRadioButton("Normal",false);
        normal.setBounds(640,330,200,30);
        panel.add(normal);
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(inmediato);
        grupo.add(normal);

        confirmar = new JButton("Confirmar");
        confirmar.setBounds(780,380,200,50);
        panel.add(confirmar);

        confirmar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    boolean enviar = false;
                    if (!ValidadorDatos.esNombre(textNombre.getText())){
                        JOptionPane.showMessageDialog(panel,"Ingrese un nombre valido por favor");
                    }
                    else {
                        if (!ValidadorDatos.esCalle(textCalle.getText())){
                            JOptionPane.showMessageDialog(panel,"Ingrese una calle valida por favor");
                        }
                        else{
                            if (!ValidadorDatos.esNroCasa(textNro.getText())){
                                JOptionPane.showMessageDialog(panel,"Ingrese un numero de calle valido por favor");
                            }
                            else{
                                if (!ValidadorDatos.esCelular(textTelefono.getText())){
                                    JOptionPane.showMessageDialog(panel,"Ingrese un numero de telefono valido por favor");
                                }
                                else{
                                    if(!ValidadorDatos.esCI(textCi.getText())){
                                        JOptionPane.showMessageDialog(panel,"Ingrese un numero de CI valido por favor");
                                    }
                                    else{
                                        Producto p = Traductor.nombreProducto(pedir.getText());
                                        if (p==null){
                                            JOptionPane.showMessageDialog(panel,"La tienda no cuenta con ese producto");
                                        }
                                        else{
                                            int cantidad = Traductor.conseguirCantidad(pedir.getText());
                                            if (cantidad==0){
                                                JOptionPane.showMessageDialog(panel,"Debe especificar la cantidad deseada");
                                            }
                                            else{
                                                Usuario u = conseguirUsuario();
                                                String observaciones = Traductor.conseguirObservaciones(pedir.getText());
                                                boolean aux = false;
                                                if (inmediato.isFocusOwner()){
                                                    aux = true;
                                                }
                                                
                                                
                                                Pedido ped = new Pedido(u,p,cantidad,observaciones,aux);
                                                MongoDB.insertarPedido(ped);
                                                
                                                //XML.añadirPedido(ped);

                                                JOptionPane.showMessageDialog(panel,"Pedido realizado");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            });

        this.setVisible(true);
    }

    private Usuario conseguirUsuario(){
        String calle = textCalle.getText();
        int nroCasa = Integer.parseInt(textNro.getText());
        String referencias = textRef.getText();
        Direccion d = new Direccion (calle,nroCasa,referencias);

        String nombre = textNombre.getText();
        int nroCi = Integer.parseInt(textCi.getText());
        int cel = Integer.parseInt(textTelefono.getText());

        return new Usuario(nombre,d,nroCi,cel);
    }

    private void iniciarBotonRegreso(){
        regresar = new JButton("Regresar");
        regresar.setBounds(40,10, 150,40);
        ActionListener l = new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    VentanaInicio m = new VentanaInicio();
                    m.run();
                    dispose();
                }
            };
        regresar.addActionListener(l);
    }
}
