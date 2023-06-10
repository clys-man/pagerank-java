package edu.unifor.clysman.pagerank;

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
        Matrix initialAuthorityVector = initialAuthorityVector();
        double scalar = calculateNormalizedScalar(initialAuthorityVector);
        Matrix a = linearAlgebra.times(initialAuthorityVector, scalar);

        Matrix transposed = linearAlgebra.transpose(this.matrix);
        transposed = linearAlgebra.dot(transposed, this.matrix);

        for (int i = 0; i < matrix.getRows(); i++) {
            a = linearAlgebra.dot(transposed, a);
            scalar = calculateNormalizedScalar(a);
            a = linearAlgebra.times(a, scalar);
        }

        return a;
    }

    public Matrix initialCenterVector() {
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

    public Matrix initialAuthorityVector() {
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

    private double calculateNormalizedScalar(Matrix matrix) {
        return 1/linearAlgebra.norm(matrix);
    }
}
