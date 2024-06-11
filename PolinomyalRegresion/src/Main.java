import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // Create instances of DataSet, DiscreteMaths, and PolynomialRegression
        DataSet dataSet = new DataSet();
        DiscreteMaths dm = new DiscreteMaths();
        PolynomialRegression pr = new PolynomialRegression();

        // Arrays to hold dataset X and Y values
        BigDecimal[][] conjuntoDataSetX = new BigDecimal[5][];
        BigDecimal[][][] conjuntoDataSetY = new BigDecimal[5][][];

        // Populate arrays with dataset X and Y values
        for (int i = 0; i < conjuntoDataSetX.length; i++) {
            conjuntoDataSetX[i] = dataSet.getX(i + 1);
            conjuntoDataSetY[i] = dataSet.getY(i + 1);
        }

        // Perform polynomial regression for each dataset
        for (int i = 0; i < conjuntoDataSetX.length; i++) {
            // Print header for fitted line plot
            System.out.println("*******************************************************Fitted Line Plot***************************************************************************");

            // Iterate over polynomial degrees (1, 2, 3)
            for (int j = 1; j <= 3; j++) {
                System.out.println();
                System.out.println("Grado: " + j);

                // Generate matrix X for polynomial regression
                BigDecimal[][] matriz = dm.getMatrizX(conjuntoDataSetX[i], j);

                // Get transpose of matrix X
                BigDecimal[][] matrizTranspuesta = dm.getMatrizTransp(matriz, j, true);

                // Compute X_transpose * X
                BigDecimal[][] matrizXTranspX = pr.getXtranpX(matriz, matrizTranspuesta, j);

                // Compute the inverse of X_transpose * X
                BigDecimal[][] matrizInversa = pr.getMatrizInversa(matrizXTranspX);

                // Compute X_transpose * Y
                BigDecimal[][] matrizXtranspY = pr.getMultiplicacionMatrices(matrizTranspuesta, conjuntoDataSetY[i]);

                // Compute regression coefficients B
                BigDecimal[][] bMayor = pr.getMultiplicacionMatrices(matrizInversa, matrizXtranspY);

                // Compute R-squared value
                BigDecimal rSquared = pr.rSquared(conjuntoDataSetY[i], conjuntoDataSetX[i], bMayor, j);

                // Compute correlation coefficient r
                BigDecimal r = pr.r(rSquared);

                // Print R-squared and r values
                System.out.println();
                System.out.println("R_Squared: " + rSquared + "                      r: " + r);

                // Print regression equation for each polynomial degree
                switch (j) {
                    case 1:
                        System.out.println("Machine Efficiency %= " + bMayor[0][0] + " + " + bMayor[1][0] + " Batch Size");

                        // Print predicted values for given X values
                        for (int p = 0; p < 5; p++) {
                            BigDecimal xIncognit = BigDecimal.valueOf(65).add(BigDecimal.valueOf(p));
                            System.out.println("Si X= " + xIncognit);
                            BigDecimal yB0 = bMayor[0][0];
                            BigDecimal yB1 = bMayor[1][0].multiply(xIncognit);
                            System.out.println("YHat= " + yB0.add(yB1));
                        }
                        System.out.println();
                        break;

                    case 2:
                        System.out.println("Machine Efficiency %= " + bMayor[0][0] + " + " + bMayor[1][0] + " Batch Size " + bMayor[2][0] + " Batch Size^2");

                        // Print predicted values for given X values
                        for (int p = 0; p < 5; p++) {
                            BigDecimal xIncognit = BigDecimal.valueOf(65).add(BigDecimal.valueOf(p));
                            System.out.println("Si X= " + xIncognit);
                            BigDecimal yB0 = bMayor[0][0];
                            BigDecimal yB1 = bMayor[1][0].multiply(xIncognit);
                            BigDecimal yB2 = bMayor[2][0].multiply(xIncognit.pow(2));
                            System.out.println("YHat= " + yB0.add(yB1).add(yB2));
                        }
                        System.out.println();
                        break;

                    case 3:
                        System.out.println("Machine Efficiency %= " + bMayor[0][0] + " + " + bMayor[1][0] + " Batch Size " + bMayor[2][0] + " Batch Size^2 " + bMayor[3][0] + " Batch Size^3");

                        // Print predicted values for given X values
                        for (int p = 0; p < 5; p++) {
                            BigDecimal xIncognit = BigDecimal.valueOf(65).add(BigDecimal.valueOf(p));
                            System.out.println("Si X= " + xIncognit);
                            BigDecimal yB0 = bMayor[0][0];
                            BigDecimal yB1 = bMayor[1][0].multiply(xIncognit);
                            BigDecimal yB2 = bMayor[2][0].multiply(xIncognit.pow(2));
                            BigDecimal yB3 = bMayor[3][0].multiply(xIncognit.pow(3));
                            System.out.println("YHat= " + yB0.add(yB1).add(yB2).add(yB3));
                        }
                        System.out.println();
                        break;
                }
            }
        }
    }
}
