package edu.unifor.clysman;

import edu.unifor.clysman.linear.LinearAlgebra;
import edu.unifor.clysman.linear.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 4, new double[][]{
                {0, 0, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 0}
        });

        PageRank pageRank = new PageRank(matrix);
        Matrix result = pageRank.calculate();

        System.out.println(result);
    }
}
