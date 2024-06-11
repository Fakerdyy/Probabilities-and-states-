import java.util.ArrayList;
class DiscretsMaths {
    // Lista de valores de la variable independiente (X)
    private ArrayList<Double> xValues;
    // Lista de valores de la variable dependiente (Y)
    private ArrayList<Double> yValues;

    // Constructor que inicializa las listas de valores de X e Y
    public DiscretsMaths(ArrayList<Double> xValues, ArrayList<Double> yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
    }

    // Método para calcular la media de los valores de X
    public double calculateMean() {
        double sum = 0;
        // Sumar todos los valores de X
        for (double value : xValues) {
            sum += value;
        }
        // Calcular la media dividiendo la suma total entre el número de elementos
        return sum / xValues.size();
    }

    // Método para calcular la desviación estándar de los valores de X
    public double calculateStandardDeviation() {
        // Calcular la media de los valores de X
        double mean = calculateMean();
        double sumSquaredDiff = 0;
        // Sumar las diferencias al cuadrado entre cada valor de X y la media
        for (double value : xValues) {
            sumSquaredDiff += Math.pow(value - mean, 2);
        }
        // Calcular la varianza dividiendo la suma de las diferencias al cuadrado entre el número de elementos
        double variance = sumSquaredDiff / xValues.size();
        // La desviación estándar es la raíz cuadrada de la varianza
        return Math.sqrt(variance);
    }

    // Método para calcular el coeficiente de correlación entre los valores de X e Y
    public double calculateCorrelationCoefficient() {
        // Verificar que ambas listas tengan la misma longitud
        if (xValues.size() != yValues.size()) {
            throw new IllegalArgumentException("Ambos arrays deben tener la misma longitud");
        }
        double sumX = 0;
        double sumY = 0;
        // Calcular la suma de los valores de X y de Y
        for (double value : xValues) {
            sumX += value;
        }
        for (double value : yValues) {
            sumY += value;
        }
        // Calcular la media de los valores de X e Y
        double meanX = sumX / xValues.size();
        double meanY = sumY / yValues.size();

        double numerator = 0;
        double denominatorX = 0;
        double denominatorY = 0;
        // Calcular los términos del numerador y los denominadores de la fórmula del coeficiente de correlación
        for (int i = 0; i < xValues.size(); i++) {
            numerator += (xValues.get(i) - meanX) * (yValues.get(i) - meanY);
            denominatorX += Math.pow(xValues.get(i) - meanX, 2);
            denominatorY += Math.pow(yValues.get(i) - meanY, 2);
        }

        // Calcular el coeficiente de correlación dividiendo el numerador entre la raíz cuadrada del producto de los denominadores
        return numerator / Math.sqrt(denominatorX * denominatorY);
    }
}
