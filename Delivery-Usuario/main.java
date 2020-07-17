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
        m.insertar(usuario.getDocument(), "Usuarios");
    }
}
