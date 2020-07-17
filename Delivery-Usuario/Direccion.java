
public class Direccion
{
    private String callePrincipal;
    private int nroCasa;
    private String referencias;
    
    public Direccion(String callePrincipal, int nroCasa, String referencias){
        this.callePrincipal = callePrincipal;
        this.nroCasa = nroCasa;
        this.referencias = referencias;
    }
    public String getCalle(){
        return callePrincipal;
    }
    public int getNroCasa(){
        return nroCasa;
    }
    public String getRefer(){
        return referencias;
    }
    
    public void setCalle(String calle){
        callePrincipal = calle;
    }
    public void setNroCasa(int nro){
        nroCasa = nro;
    }
    public void setRefer(String refer){
        referencias = refer;
    }
}
