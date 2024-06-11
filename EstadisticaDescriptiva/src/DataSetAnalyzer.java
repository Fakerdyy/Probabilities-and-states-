import java.util.ArrayList;
import java.util.Collections;

class DataSetAnalyzer {
    private ArrayList<Double> data;
    private int numClasses;
    private double classWidth;
    private double range;

    public DataSetAnalyzer() {
        data = new ArrayList<>();
        // Agregar datos al ArrayList
        Collections.addAll(data,
                86.0, 86.0, 86.0, 87.0, 87.0, 89.0, 89.0, 90.0, 91.0, 91.0,
                92.0, 93.0, 96.0, 96.0, 95.0, 95.0, 95.0, 105.0, 97.0, 98.0,
                99.0, 99.0, 100.0, 100.0, 101.0, 101.0, 103.0, 103.0, 103.0,
                104.0, 106.0, 106.0, 106.0, 107.0, 107.0, 107.0, 109.0, 110.0,
                110.0, 110.0);

        calculateRange();
        calculateNumClasses();
        calculateClassWidth();
    }

    private void calculateRange() {
        this.range = Collections.max(data) - Collections.min(data);
    }

    private void calculateNumClasses() {
        // Regla de Sturges para calcular el número de clases
        this.numClasses = (int) Math.ceil(1 + 3.322 * Math.log10(data.size()));
    }

    private void calculateClassWidth() {
        // Calcula la amplitud del intervalo
        this.classWidth = range / numClasses;
    }

    public void generateDescriptiveTable() {
        // Ordenar los datos
        Collections.sort(data);

        // Calcular los límites de clase
        double lowerBound = Collections.min(data);
        double upperBound = lowerBound + classWidth;
        double[] classLimits = new double[numClasses];
        for (int i = 0; i < numClasses; i++) {
            classLimits[i] = upperBound;
            upperBound += classWidth;
        }

        // Inicializar variables para los cálculos de la tabla
        int[] frequencies = new int[numClasses];
        double[] midpoints = new double[numClasses];
        int cumulativeFrequency = 0;
        double totalRelativeFrequency = 0;

        // Calcular la frecuencia absoluta y los puntos medios de cada clase
        for (int i = 0; i < numClasses; i++) {
            int frequency = 0;
            double midpoint = (classLimits[i] + (i == 0 ? lowerBound : classLimits[i - 1])) / 2;
            for (Double value : data) {
                if (value >= (i == 0 ? lowerBound : classLimits[i - 1]) && value < classLimits[i]) {
                    frequency++;
                }
            }
            frequencies[i] = frequency;
            midpoints[i] = midpoint;
            cumulativeFrequency += frequency;

            // Calcular la frecuencia relativa de esta clase
            double relativeFrequency = (double) frequency / data.size();
            totalRelativeFrequency += relativeFrequency;

            // Imprimir la fila de la tabla
            double percentage = relativeFrequency * 100;
            System.out.printf("%-20s %-20s %-20s %-20s %-20.4f %-30.2f%% %n", String.format("%.2f - %.2f", (i == 0 ? lowerBound : classLimits[i - 1]), classLimits[i]), frequency, midpoint, cumulativeFrequency, relativeFrequency, percentage);
        }

        // Imprimir el total
        System.out.println("Total:              " + data.size() + "            " + totalRelativeFrequency + "                " + totalRelativeFrequency * 100 + "%");
    }

}
