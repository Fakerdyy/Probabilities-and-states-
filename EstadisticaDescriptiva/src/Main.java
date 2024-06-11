//Andrea Rojas
//Probabilidad y estadistica
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto DataSetAnalyzer
        DataSetAnalyzer analyzer = new DataSetAnalyzer();

        // Imprimir títulos de la tabla
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-30s %n", "Límites de Clase", "Frecuencia Absoluta", "Punto Medio", "Frecuencia Acumulada", "Frecuencia Relativa", "Porcentaje Relativo");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        // Generar la tabla descriptiva
        analyzer.generateDescriptiveTable();
    }
}