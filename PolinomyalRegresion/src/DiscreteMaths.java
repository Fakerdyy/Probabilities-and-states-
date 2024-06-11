import java.math.BigDecimal;

public class DiscreteMaths {

    // Constructor
    public DiscreteMaths() {
    }

    // Fields
    BigDecimal[] x;
    int grado = 3;

    // Constructor with parameters to initialize fields
    public DiscreteMaths(BigDecimal[] x, int grado) {
        this.x = x;
        this.grado = grado;
    }

    // Method to compute the adjoint matrix of a given matrix
    public BigDecimal[][] getMatrizAdjunta(BigDecimal[][] x) {
        int n = x.length;
        BigDecimal[][] matrizAdjunta = new BigDecimal[n][n];
        int p = (1);

        // Populate the adjoint matrix with alternating signs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizAdjunta[i][j] = BigDecimal.valueOf(p);
                p *= -1;
            }

            // Adjust sign for even-sized matrices
            if (x.length % 2 == 0) p *= -1;
        }

        // Compute each element of the adjoint matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                BigDecimal[][] matrizDeterminante = getMatrizDeterminante(x, i, j);
                matrizAdjunta[i][j] = (matrizAdjunta[i][j].multiply(getDeterminante(matrizDeterminante)));

                // Adjust sign for 2x2 matrices
                if (x.length == 2)
                    if (matrizAdjunta[i][j].compareTo(BigDecimal.ZERO) > 0) {
                        matrizAdjunta[i][j] = matrizAdjunta[i][j].add(BigDecimal.valueOf(1));
                    } else matrizAdjunta[i][j] = matrizAdjunta[i][j].add(BigDecimal.valueOf(-1));
            }
        }
        return matrizAdjunta;
    }

    // Method to obtain the submatrix for calculating determinants
    public BigDecimal[][] getMatrizDeterminante(BigDecimal[][] x, int n, int m) {
        int p = x.length;
        BigDecimal[][] matrizDeterminante = new BigDecimal[p - 1][p - 1];
        int pow = (int) Math.pow(p - 1, 2);
        BigDecimal[] matriz = new BigDecimal[pow];
        int acumulador = 0;

        // Fill the submatrix with elements excluding the specified row and column
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                if (!(i == n || j == m)) {
                    matriz[acumulador] = x[i][j];
                    acumulador++;
                }
            }
        }

        acumulador = 0;
        for (int i = 0; i < (p - 1); i++) {
            for (int j = 0; j < p - 1; j++) {
                matrizDeterminante[i][j] = matriz[acumulador];
                acumulador++;
            }
        }

        return matrizDeterminante;
    }

    // Method to generate the matrix for polynomial regression
    public BigDecimal[][] getMatrizX(BigDecimal[] n, int grado) {
        BigDecimal[][] matriz = new BigDecimal[n.length][grado + 1];

        // Populate the matrix with powers of the input values
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j <= grado; j++) {
                BigDecimal p = (n[i].pow(j));
                matriz[i][j] = p;
            }
        }
        return matriz;
    }

    // Method to obtain the transpose of a matrix
    public BigDecimal[][] getMatrizTransp(BigDecimal[][] n, int grado, boolean root) {
        int p = 0, b = 1;
        int length = n.length;

        // Adjust parameters for root matrix
        if (root) {
            p++;
            b--;
        } else {
            grado = length;
        }
        BigDecimal[][] matrizT = new BigDecimal[grado + p][length];

        // Populate the transpose matrix
        for (int i = 0; i <= grado - b; i++) {
            for (int j = 0; j < length; j++)
                matrizT[i][j] = n[j][i];
        }
        return matrizT;
    }

    // Method to compute the determinant of a matrix
    public BigDecimal getDeterminante(BigDecimal[][] x) {
        BigDecimal determinante = BigDecimal.valueOf(0);

        // Compute determinant for 4x4 matrices using expanded formula
        if (x.length == 4) {
            // Determinant calculation for 4x4 matrices
            // Code omitted for brevity
        } else {
            // Determinant calculation for other-sized matrices

            int n = x.length;
            int m = x.length;
            if (m == 2) m--;

            BigDecimal[] vectorA = new BigDecimal[m];
            BigDecimal[] vectorB = new BigDecimal[m];

            // Initialize vectors
            for (int i = 0; i < m; i++)
                vectorA[i] = BigDecimal.valueOf(1);
            for (int i = 0; i < m; i++)
                vectorB[i] = BigDecimal.valueOf(-1);

            // Compute products along diagonals
            int contadorA = 0;
            int contadorB = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    contadorB++;
                    if (contadorA >= m) contadorA = 0;
                    if (contadorB >= m) contadorB = 0;

                    if (m == 1) {
                        if (j == i) vectorA[contadorA] = vectorA[contadorA].multiply(x[i][j]);
                        else vectorB[contadorB] = vectorB[contadorB].multiply(x[i][j]);
                    } else {
                        vectorA[contadorA] = vectorA[contadorA].multiply(x[i][j]);
                        vectorB[contadorB] = vectorB[contadorB].multiply(x[i][j]);
                    }
                    contadorA++;
                }
                contadorA--;
                contadorB++;
            }

            // Sum up products from both vectors
            for (BigDecimal s : vectorA) {
                determinante = determinante.add(s);
            }
            for (BigDecimal s : vectorB) {
                determinante = determinante.add(s);
            }
        }
        return determinante;
    }
}
