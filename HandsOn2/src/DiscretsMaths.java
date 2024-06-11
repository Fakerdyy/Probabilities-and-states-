public class DiscretsMaths {
    //Declarar variables
    private double beta0;
    private double beta1;

    public DiscretsMaths(double beta0, double beta1) {
        this.beta0 = beta0;
        this.beta1 = beta1;
    }

    // Calculamos y devolvemos el valor de la función de predicción para el valor de x
    // utilizando la ecuación de regresión lineal simple
    public double predict(double x) {
        return beta0 + beta1 * x;
    }

    public void printRegressionEquation() {
        System.out.println("Regression Equation: Y = " + beta0 + " + " + beta1 + " * X");
    }
}
