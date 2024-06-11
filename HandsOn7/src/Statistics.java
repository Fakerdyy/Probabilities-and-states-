import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Statistics {
    public static double calculateMean(List<Double> data) {
        // Implementar el cálculo de la media para datos no agrupados
        return data.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public static double calculateMedian(List<Double> data) {
        // Implementar el cálculo de la mediana para datos no agrupados
        int size = data.size();
        data.sort(Double::compareTo);
        if (size % 2 == 0) {
            return (data.get(size / 2 - 1) + data.get(size / 2)) / 2;
        } else {
            return data.get(size / 2);
        }
    }

    public static double calculateMode(List<Double> data) {
        // Implementar el cálculo de la moda para datos no agrupados
        Map<Double, Long> frequencyMap = data.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        return frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    public static double calculateGroupedMean(Map<Double, Integer> groupedData) {
        // Implementar el cálculo de la media para datos agrupados
        double total = 0.0;
        int count = 0;
        for (Map.Entry<Double, Integer> entry : groupedData.entrySet()) {
            total += entry.getKey() * entry.getValue();
            count += entry.getValue();
        }
        return total / count;
    }

    public static double calculateGroupedMedian(Map<Double, Integer> groupedData) {
        // Implementar el cálculo de la mediana para datos agrupados
        // Esto es más complejo y generalmente requiere conocimiento de los intervalos
        // Aquí vamos a simplificar asumiendo que los puntos son los valores de la mediana
        List<Double> expandedData = groupedData.entrySet().stream()
                .flatMap(e -> Collections.nCopies(e.getValue(), e.getKey()).stream())
                .collect(Collectors.toList());

        return calculateMedian(expandedData);
    }

    public static double calculateGroupedMode(Map<Double, Integer> groupedData) {
        // Implementar el cálculo de la moda para datos agrupados
        return groupedData.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }
}