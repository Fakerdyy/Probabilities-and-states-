//Andrea Rojas
//Probabilidad y estadistica
public class QuadraticLinearRegresion {
    private double dt = 0.0;
    private double SumX, SumY, SumX2, SumX3, SumX4, SumXY, SumX2Y, ds;
    private DiscretsMaths n;

    public QuadraticLinearRegresion(DiscretsMaths n) {
        //Calcula sumatorias
        this.n = n;
        SumX = n.SumX();
        SumY = n.SumY();
        SumX2 = n.SumX2();
        SumX3 = n.SumX3();
        SumX4 = n.SumX4();
        SumXY = n.SumXY();
        SumX2Y = n.SumX2Y();
        //Calcula sumas acumuladas
        ds = (n.getX().length * SumX2 * SumX4) + (SumX * SumX3 * SumX2) + (SumX2 * SumX * SumX3) - (SumX2 * SumX2 * SumX2) - (SumX3 * SumX3 * n.getX().length) - (SumX4 * SumX * SumX);
    }

    //El método B0,B1 Y B2 calcula el coeficiente B0 de la regresión cuadrática.
    //Realiza algunos cálculos basados en las sumas acumuladas y ds,
    //y luego devuelve el resultado.
    public Object B0() {
        if (ds != 0) {
            double r = ((SumY * SumX2 * SumX4) + (SumX * SumX3 * SumX2Y) + (SumX2 * SumXY * SumX3)) - ((SumX2Y * SumX2 * SumX2) + (SumX3 * SumX3 * SumY) + (SumX4 * SumXY * SumX));
            dt = r / ds;
        } else return null;
        return dt;
    }

    public Object B1() {
        if (ds != 0) {
            double r = (n.getX().length * SumXY * SumX4) + (SumY * SumX3 * SumX2) + (SumX2 * SumX * SumX2Y) - (SumX2 * SumXY * SumX2) - (n.getX().length * SumX2Y * SumX3) - (SumX4 * SumX * SumY);
            dt = r / ds;
        } else return null;
        return dt;
    }

    public Object B2() {
        if (ds != 0) {
            double r = (n.getX().length * SumX2 * SumX2Y) + (SumX * SumXY * SumX2) + (SumY * SumX * SumX3) - (SumX2 * SumX2 * SumY) - (n.getX().length * SumX3 * SumXY) - (SumX2Y * SumX * SumX);
            dt = r / ds;
        } else return null;
        return dt;
    }
}