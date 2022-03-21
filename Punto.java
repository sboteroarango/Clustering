import java.lang.Math;
public class Punto {
    private double x;
    private double y;
    public Punto(double x,double y)
    {
        this.x = x;
        this.y = y;
    }
    public double getX()
    {
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public void show(){
        System.out.print("[");
        System.out.print(this.x);
        System.out.print(",");
        System.out.print(this.y);
        System.out.println("]");
    }
    public double distancia(Punto otro){
        return Math.sqrt(Math.pow(otro.x-this.x, 2)+Math.pow(otro.y-this.y, 2));
    }
}
