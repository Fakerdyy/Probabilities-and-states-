public class LinearRegression {
    private DataSet dataSet;

    public LinearRegression(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    //Realiza el calculo de la regresion lineal
    //utiliza datos para calcular los coeficientes de la regresión lineal (beta0 y beta1).
    public RegressionResult calculateRegression(){

        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumXX = 0;
        int n = dataSet.size();

        for (int i = 0; i < n; i++) {
            double x = dataSet.getAdvertising(i);
            double y = dataSet.getSales(i);
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumXX += x * x;
        }

        double beta1 = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
        double beta0 = (sumY - beta1 * sumX) / n;

        return new RegressionResult(beta0, beta1);
    }
}
