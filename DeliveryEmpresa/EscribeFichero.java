import java.io.*;

public class EscribeFichero
{
    public static void main(String escribir, String doc)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(doc);
            pw = new PrintWriter(fichero);
            pw.println(escribir);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try{
               if (null != fichero)
                  fichero.close();
           }catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}