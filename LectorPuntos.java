import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorPuntos {
    public static List<Punto> leer(String path)
    {
        String line;
        List<Punto> listaPuntos = new ArrayList<Punto>();
        try
    {
        BufferedReader br = new BufferedReader(new FileReader(path));

        while((line = br.readLine()) != null)
        {
            String[] lectura = line.split(",");
            Punto p = new Punto(Double.parseDouble(lectura[0]),Double.parseDouble(lectura[1]));
            listaPuntos.add(p);
        }
    }
    catch(FileNotFoundException e)
    {
        e.printStackTrace();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    return listaPuntos;
    }
}
