import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparadorResultados implements Comparator<Pedido>
{
    public int compare(Pedido x,Pedido y){
        if (x.getEntregaInmediata()&&!y.getEntregaInmediata()){
            return -1;
        }
        if (!x.getEntregaInmediata()&&y.getEntregaInmediata()){
            return 1;
        }
        if(x.getEntregaInmediata()&&y.getEntregaInmediata()){
            return 1;
        }
        if(!x.getEntregaInmediata()&&!y.getEntregaInmediata()){
            return 1;
        }
        return 0;
    }
}
