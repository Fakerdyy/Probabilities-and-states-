//Andrea Rojas
//Probabilidad y estadistica
public class DataSet {
    //Representan las variables exógena y endógena respectivamente.
    private double[] x;
    private double[] y;

    public DataSet() {
        //Inicializa con valores predefinidos
        x = new double[]{10, 15, 20, 24, 30, 34, 40, 45, 48, 50, 58, 60, 64};
        y = new double[]{115.6, 157.2, 189.2, 220.8, 253.8, 269.2, 284.8, 285.0, 277.4,269.2,244.2,231.4,180.4};
    }
//Devuelven los arreglos
    public double[] getX() {
        return this.x;
    }

    public double[] getY() {
        return this.y;
    }
}
