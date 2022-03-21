import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

class Taller3
{
static Integer[] clustering(List<Punto> puntos)
{
    int n = puntos.size();
    WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(n);
    for(int i = 0;i < n-1;i++){
        for(int j = i+1;j < n;j++){
            if(puntos.get(i).distancia(puntos.get(j))<= DMAX){
                wqu.union(i, j);
            }
        }
    }
    Integer[] clusters = new Integer[n];
    for(int i = 0;i<n;i++){
        clusters[i] = wqu.find(i);
    }
    return clusters;
}
static final double DMAX = 0.2;
public static void main(String[] args) {
    String path = args[0]; 
    List<Punto> puntosIniciales = LectorPuntos.leer(path);
    Integer[] clusters = clustering(puntosIniciales);
    Graficador g = new Graficador(puntosIniciales, clusters);
    System.out.println("Cluster al que pertenece cada punto: ");
    System.out.println("[");
    for (Integer cluster : clusters) {
        System.out.println(cluster);
    }
    System.out.println("]");
    HashMap<Integer, Boolean> mp = new HashMap<>();
    int n = clusters.length;
    List<Integer> clustersSinDuplicados = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
        if (mp.get(clusters[i]) == null)
        {
            clustersSinDuplicados.add(clusters[i]);
            mp.put(clusters[i], true);
        }
    }
    System.out.println("cantidad de clusters encontrados: ");
    System.out.println(clustersSinDuplicados.size());
    System.out.println("cantidad de puntos por cluster: ");
    int contador = 0;
    for (Integer clusterSingular : clustersSinDuplicados) {
        for (Integer cluster : clusters) {
            if (clusterSingular == cluster)
            {
                contador++;
            }
        }
    System.out.print(clusterSingular);
    System.out.print(" : ");
    System.out.println(contador);
    contador = 0;
    }
    g.show();

}
}