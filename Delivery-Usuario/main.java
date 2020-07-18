    public class main
{
    public static void main (String [] args){
        //VentanaInicio ventana = new VentanaInicio();
        MongoDB m = MongoDB.getInstanceMongoDB();
        Usuario usuario = new Usuario();
        Direccion dir = new Direccion();
        dir.setCalle("a");
        dir.setNroCasa(123);
        dir.setRefer("azul");
        usuario.setDireccion(dir);
        usuario.setNombre("Dilan");
        usuario.setNroCelular(79795112);
        usuario.setNroCi(123123123);
        m.insertarUsuario(usuario);
        Producto prod = new Producto();
        prod.setCarac("asdf");
        prod.setNombre("pique");
        prod.setPrecio(70.0);
        Pedido p = new Pedido();
        p.setCantidad(1);
        p.setId(1);
        p.setObs("que sea rico");
        p.setProducto(prod);
        p.setUsuario(usuario);
        m.insertarPedido(p);
    }
    public static void main2(){
        MongoDB m = MongoDB.getInstanceMongoDB();

        for(Producto p: m.getInventario()){
            System.out.println(p.getDocument());
        }
    }
}
