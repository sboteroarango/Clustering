import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import edu.princeton.cs.algs4.StdDraw;
import java.awt.Color;
public class Graficador {
    private List<Punto> puntos = new ArrayList<>();
    private Integer[] clusters;

    public Graficador(List<Punto> puntos,Integer[] clusters){
        this.puntos = puntos;
        this.clusters = clusters;
    }

    public void show(){
        StdDraw.setXscale(-2, 2);
        StdDraw.setYscale(-2, 2);
        StdDraw.setPenRadius(0.009);
        List<Color> colores = new ArrayList<>();
        colores.add(Color.BLUE);
        colores.add(Color.CYAN);
        colores.add(Color.GREEN);
        colores.add(Color.MAGENTA);
        colores.add(Color.ORANGE);
        colores.add(Color.PINK);
        colores.add(Color.RED);
        colores.add(Color.YELLOW);
        colores.add(Color.DARK_GRAY);
        colores.add(Color.GRAY);
        colores.add(Color.BLACK);
        colores.add(Color.LIGHT_GRAY);
        int n = this.clusters.length;
        HashMap<Integer, Boolean> mp = new HashMap<>();
        List<Integer> clustersSinDuplicados = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (mp.get(this.clusters[i]) == null)
            {
                clustersSinDuplicados.add(this.clusters[i]);
                mp.put(this.clusters[i], true);
            }
        }
        if(clustersSinDuplicados.size()>13)throw new IndexOutOfBoundsException("no se permiten más de 12 clusters para graficar por la limitante de la cantidad de colores disponibles");
        for(int i = 0;i < n;i++){
            int posClusterEnSinDuplicados = clustersSinDuplicados.indexOf(clusters[i]);
            StdDraw.setPenColor(colores.get(posClusterEnSinDuplicados));
            StdDraw.point(puntos.get(i).getX(),puntos.get(i).getY());
        }
    }
}

