//Andrea Rojas

import java.util.ArrayList;
class DataSet {
    // Datos que se ingresan y almacenan en el arraylist para obtener el tamaño de los datos siguientes
    ArrayList<Double> sales;
    ArrayList<Double> advertising;

    public DataSet() {
        sales = new ArrayList<>();
        advertising = new ArrayList<>();

        // Agregar datos de ventas
        sales.add(651.00); sales.add(762.00); sales.add(856.00); sales.add(1063.00);
        sales.add(1190.00); sales.add(1298.00); sales.add(1421.00); sales.add(1440.00); sales.add(1518.00);
        //Agregar datos de publicidad
        advertising.add(23.00); advertising.add(26.00); advertising.add(30.00); advertising.add(34.00);
        advertising.add(43.00); advertising.add(48.00); advertising.add(52.00); advertising.add(57.00);
        advertising.add(58.00);
    }

    //Devuelve el tamaño del arraylist, que es la cantidad de elemtos que tiene
    public int size() {
        return sales.size();
    }

    //Devuelve el valor de sales
    public double getSales(int index) {
        return sales.get(index);
    }

    //Devuelve el valor Advertising
    public double getAdvertising(int index) {
        return advertising.get(index);
    }
}
