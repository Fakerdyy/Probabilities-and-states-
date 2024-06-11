//Andrea Rojas
//Probabilidad y estadistica
public class Main {
    public static void main(String[] args) {
        DataSet ds = new DataSet();
        DiscretsMaths dm = new DiscretsMaths(ds.getX(), ds.getY());
        QuadraticLinearRegresion qlr = new QuadraticLinearRegresion(dm);

        // Se imprimen los coeficientes de la regresión cuadrática
        System.out.println("Ecuación de Regresión Cuadrática:");
        System.out.println("y = B0 + B1*X + B2*X^2");
        System.out.println("");
        Object b0 = qlr.B0();
        System.out.println("B0 = " + b0);
        Object b1 = qlr.B1();
        System.out.println("B1 = " + b1);
        Object b2 = qlr.B2();
        System.out.println("B2 = " + b2);
        System.out.println("");

        // Se realizan predicciones para valores conocidos y desconocidos de la variable exógena
        double[] knownXValues = {-3.0, 0.0, 3.0}; // Valores conocidos de X
        double[] unknownXValues = {-1.0, 2.0}; // Valores desconocidos de X

        for (double x : knownXValues) {
            double predictedY = (double) b0 + (double) b1 * x + (double) b2 * Math.pow(x, 2);
            System.out.println("Predicted Y for X = " + x + ": " + predictedY);
        }

        for (double x : unknownXValues) {
            double predictedY = (double) b0 + (double) b1 * x + (double) b2 * Math.pow(x, 2);
            System.out.println("Predicted Y for X = " + x + ": " + predictedY);
        }
    }
}