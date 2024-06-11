//Andrea Rojas
//Probabilidad y estadistica
public class DiscretsMaths {
    private double[] x, y;

    public DiscretsMaths(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    public DiscretsMaths() {
    }
//Retorna los arreglos
    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

//Este método calcula la suma de todos los elementos del arreglo x.
    public double SumX() {
        double sum = 0;
        for (double i : x)
            sum += i;
        return sum;
    }

//Este método calcula la suma de todos los elementos del arreglo y.
    public double SumY() {
        double sum = 0;
        for (double i : y)
            sum += i;
        return sum;
    }

//Este método calcula la suma de los cuadrados de todos los elementos del arreglo x.
    public double SumX2() {
        double sum = 0;
        for (double i : x)
            sum += Math.pow(i, 2);
        return sum;
    }

//Este método calcula la suma de los cubos de todos los elementos del arreglo x.
    public double SumX3() {
        double sum = 0;
        for (double i : x)
            sum += Math.pow(i, 3);
        return sum;
    }

//Este método calcula la suma de la cuarta potencia de todos los elementos del arreglo x.
    public double SumX4() {
        double sum = 0;
        for (double i : x)
            sum += Math.pow(i, 4);
        return sum;
    }

//Este método calcula la suma del producto de cada elemento de x con el elemento correspondiente de y.
    public double SumXY() {
        double sum = 0;
        int s = 0;
        for (double i : x) {
            sum += (i) * y[s];
            s++;
        }
        return sum;
    }

//Este método calcula la suma del producto del cuadrado de cada elemento de x con el elemento correspondiente de y.
    public double SumX2Y() {
        double sum = 0;
        int s = 0;
        for (double i : x) {
            sum += Math.pow(i, 2) * y[s];
            s++;
        }
        return sum;
    }
}
