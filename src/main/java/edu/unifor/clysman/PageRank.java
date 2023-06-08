package edu.unifor.clysman;

import edu.unifor.clysman.linear.LinearAlgebra;
import edu.unifor.clysman.linear.Matrix;

public class PageRank {
    private final Matrix matrix;
    private final LinearAlgebra linearAlgebra;

    public PageRank(Matrix matrix) {
        this.matrix = matrix;
        this.linearAlgebra = new LinearAlgebra();
    }

    public Matrix calculate() {
        Matrix h = linearAlgebra.dot(matrix, calculateInitialAuthorityVector());
        double normalization = 1/linearAlgebra.norm(h);

        return linearAlgebra.times(h, normalization);
    }


    private Matrix calculateInitialCenterVector() {
        Matrix newMatrix = new Matrix(this.matrix.getRows(), 1);

        for (int i = 0; i < matrix.getRows(); i++) {
            double sum = 0;
            for (int j = 0; j < this.matrix.getCols(); j++) {
                sum += this.matrix.get(i, j);
            }

            newMatrix.set(i, 0, sum);
        }

        return newMatrix;
    }

    private Matrix calculateInitialAuthorityVector() {
        Matrix newMatrix = new Matrix(this.matrix.getRows(), 1);

        for (int i = 0; i < matrix.getRows(); i++) {
            double sum = 0;
            for (int j = 0; j < this.matrix.getCols(); j++) {
                sum += this.matrix.get(j, i);
            }

            newMatrix.set(i, 0, sum);
        }

        return newMatrix;
    }
}
