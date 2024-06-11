import java.util.ArrayList;

class EstadisticaDescriptiva {
    // Constructor por defecto
    public EstadisticaDescriptiva() {
    }

    // Método para calcular la media de un conjunto de datos
    public double calcularMedia(ArrayList<Double> datos) {
        double sum = 0;
        // Sumar todos los valores del conjunto de datos
        for (double dato : datos) {
            sum += dato;
        }
        // Calcular la media dividiendo la suma total entre el número de elementos
        return sum / datos.size();
    }

    // Método para calcular la desviación estándar de un conjunto de datos
    public double calcularDesviacionEstandar(ArrayList<Double> datos) {
        // Calcular la media del conjunto de datos
        double media = calcularMedia(datos);
        double sumSquaredDiff = 0;
        // Sumar las diferencias al cuadrado entre cada dato y la media
        for (double dato : datos) {
            sumSquaredDiff += Math.pow(dato - media, 2);
        }
        // Calcular la varianza dividiendo la suma de las diferencias al cuadrado entre el número de elementos
        double varianza = sumSquaredDiff / datos.size();
        // La desviación estándar es la raíz cuadrada de la varianza
        return Math.sqrt(varianza);
    }

    // Método para calcular el coeficiente de correlación entre dos conjuntos de datos
    public double calcularCoeficienteCorrelacion(ArrayList<Double> xValues, ArrayList<Double> yValues) {
        // Verificar que ambos conjuntos de datos tengan la misma longitud
        if (xValues.size() != yValues.size()) {
            throw new IllegalArgumentException("Ambos arrays deben tener la misma longitud");
        }
        double sumX = 0;
        double sumY = 0;
        // Calcular la suma de los valores de cada conjunto de datos
        for (double value : xValues) {
            sumX += value;
        }
        for (double value : yValues) {
            sumY += value;
        }
        // Calcular la media de cada conjunto de datos
        double mediaX = sumX / xValues.size();
        double mediaY = sumY / yValues.size();

        double numerador = 0;
        double denominadorX = 0;
        double denominadorY = 0;
        // Calcular los términos del numerador y los denominadores de la fórmula del coeficiente de correlación
        for (int i = 0; i < xValues.size(); i++) {
            numerador += (xValues.get(i) - mediaX) * (yValues.get(i) - mediaY);
            denominadorX += Math.pow(xValues.get(i) - mediaX, 2);
            denominadorY += Math.pow(yValues.get(i) - mediaY, 2);
        }

        // Calcular el coeficiente de correlación dividiendo el numerador entre la raíz cuadrada del producto de los denominadores
        return numerador / Math.sqrt(denominadorX * denominadorY);
    }
}
