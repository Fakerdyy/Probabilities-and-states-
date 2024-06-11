import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Andrea Rojas Garcia
//Hands-On 7
//Para calcular la media se suman todos los datos y dividirlos por la cantidad de datos.
//Para calcular la mediana  se ordenan datos de menor a mayor y se elige justo el numero que se encuntra en la mitad de todos
//Para calcular la moda se elige el dato que mas se repite
public class Main {
    public static void main(String[] args) {
        // Datos no agrupados
        List<Double> ungroupedData = Arrays.asList(1.0, 2.0, 2.0, 3.0, 4.0);
        DataSet ungroupedDataSet = new UngroupedDataSet(ungroupedData);
        System.out.println("Datos Agrupados");
        System.out.println("Media: " + ungroupedDataSet.calculateMean());
        System.out.println("Mediana: " + ungroupedDataSet.calculateMedian());
        System.out.println("Moda: " + ungroupedDataSet.calculateMode());


        // Datos agrupados
        Map<Double, Integer> groupedData = new HashMap<>();
        groupedData.put(1.0, 1);
        groupedData.put(2.0, 3);
        groupedData.put(3.0, 1);
        groupedData.put(4.0, 1);
        DataSet groupedDataSet = new GroupedDataSet(groupedData);
        System.out.println("Datos No Agrupados");
        System.out.println("Grouped Media: " + groupedDataSet.calculateMean());
        System.out.println("Grouped Mediana: " + groupedDataSet.calculateMedian());
        System.out.println("Grouped Moda: " + groupedDataSet.calculateMode());
    }
}