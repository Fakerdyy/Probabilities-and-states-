import java.math.BigDecimal;
import java.math.RoundingMode;

public class PolynomialRegression {

    public PolynomialRegression() {
    }

    // Method to compute the product of the matrix X and its transpose
    // This is used in polynomial regression calculation
    public BigDecimal[][] getXtranpX(BigDecimal[][] x, BigDecimal[][] xTransp, int grado) {

        BigDecimal[][] xXtransp = new BigDecimal[grado + 1][grado + 1];

        for (int i = 0; i < xXtransp.length; i++) {
            for (int j = 0; j < xXtransp.length; j++) {
                BigDecimal sum = BigDecimal.valueOf(0.0);
                for (int k = 0; k < x.length; k++) {
                    sum = sum.add(x[k][i].multiply(xTransp[j][k]));
                }

                xXtransp[i][j] = sum;
            }
        }

        return xXtransp;
    }

    // Method to perform matrix multiplication
    public static BigDecimal[][] getMultiplicacionMatrices(BigDecimal[][] n, BigDecimal[][] m) {
        // Dimensions of matrices
        int filasA = n.length;
        int columnasA = n[0].length;
        int filasB = m.length;
        int columnasB = m[0].length;

        // Verify if matrix multiplication can be performed
        if (columnasA != filasB) {
            System.out.println("Datos incorrectos"); // Incorrect data
            return null;
        }

        // Resultant matrix
        BigDecimal[][] multiplicacionMatrices = new BigDecimal[filasA][columnasB];

        // Perform matrix multiplication
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                BigDecimal sum = BigDecimal.ZERO;
                for (int k = 0; k < columnasA; k++) {
                    sum = sum.add(n[i][k].multiply(m[k][j]));
                }
                multiplicacionMatrices[i][j] = sum;
            }
        }

        return multiplicacionMatrices;
    }


    // Method to compute the inverse of a matrix
    public BigDecimal[][] getMatrizInversa(BigDecimal[][] x) {
        int n = x.length;

        DiscreteMaths dm = new DiscreteMaths();
        BigDecimal[][] MatrizInversa = new BigDecimal[n][n];

        BigDecimal Determinante = dm.getDeterminante(x);
        BigDecimal[][] MatrizTranspuesta = dm.getMatrizTransp(x, n, false);
        BigDecimal[][] MatrizAdjunta = dm.getMatrizAdjunta(MatrizTranspuesta);

        // Compute elements of the inverse matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                MatrizInversa[i][j] = (MatrizAdjunta[i][j]).divide(Determinante, 33, RoundingMode.HALF_UP);
            }
        }

        return MatrizInversa;
    }

    // Method to compute the correlation coefficient (Pearson's r)
    public BigDecimal r(BigDecimal rSquared){
        if (rSquared.compareTo(BigDecimal.ZERO) < 0){
            // If r^2 is negative, compute square root and multiply by -1
            BigDecimal rNegativo= BigDecimal.valueOf(Math.sqrt((rSquared.divide(BigDecimal.valueOf(100))).doubleValue()));
            return  rNegativo.multiply(BigDecimal.valueOf(-1));
        }
        else
            // Otherwise, compute square root
            return BigDecimal.valueOf(Math.sqrt((rSquared.divide(BigDecimal.valueOf(100))).doubleValue()));
    }

    // Method to compute the coefficient of determination (r^2)
    public BigDecimal rSquared(BigDecimal[][] y, BigDecimal[] x, BigDecimal[][] B, int grado) {
        BigDecimal n= BigDecimal.valueOf(y.length);
        BigDecimal sumY = BigDecimal.ZERO;
        BigDecimal rSquared = null;
        BigDecimal[] prediccion = new BigDecimal[x.length];

        // Calculate sum of y values
        for (int i = 0; i < prediccion.length; i++) {
            prediccion[i] = BigDecimal.ZERO;
            sumY=sumY.add(y[i][0]);
        }
        BigDecimal Ytotal=sumY.divide(n, 33, RoundingMode.HALF_UP);

        // Compute predicted y values
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j <= grado; j++) {
                if (j == 0)
                    prediccion[i] = prediccion[i].add(B[j][0]);
                else
                    prediccion[i] = prediccion[i].add((B[j][0]).multiply(x[i].pow(j)));
            }
        }

        BigDecimal sct=BigDecimal.ZERO,scr=BigDecimal.ZERO;

        // Compute total sum of squares (sct) and residual sum of squares (scr)
        for (int i=0;i<y.length;i++){
            sct=sct.add(((y[i][0].subtract(Ytotal))).pow(2));
            scr=scr.add(((y[i][0].subtract(prediccion[i]))).pow(2));
            i++;
        }

        // Compute r^2
        rSquared =BigDecimal.valueOf(1).subtract(scr.divide(sct, 33, RoundingMode.HALF_UP));
        if (rSquared.compareTo(BigDecimal.ZERO) < 0) rSquared=rSquared.multiply(BigDecimal.valueOf(-1));
        return rSquared.multiply(BigDecimal.valueOf(100));
    }
}
