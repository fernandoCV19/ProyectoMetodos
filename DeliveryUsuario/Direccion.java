import org.bson.Document;

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

    public Direccion(String callePrincipal, int nroCasa, String referencias){
        this.callePrincipal = callePrincipal;
        this.nroCasa = nroCasa;
        this.referencias = referencias;
    }

    public Document getDocument(){
        Document document = new Document("calle", callePrincipal);
        document.append("nroCasa", nroCasa);
        document.append("referencias", referencias);
        return document;
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

    public Direccion getDireccion(Document docu){
        Direccion d = new Direccion();
        d.setCalle(docu.get("calle").toString());
        d.setNroCasa(Integer.parseInt(docu.get("nroCasa").toString()));
        d.setRefer(docu.get("referencias").toString());
        return d;
    }
}
