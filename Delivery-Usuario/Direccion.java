
public class Direccion
{
    private String callePrincipal;
    private int nroCasa;
    private String referencias;
    
    public Direccion(){
        callePrincipal = "";
        nroCasa = 0;
        referencias = "";
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
