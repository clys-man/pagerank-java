package edu.unifor.clysman;

import edu.unifor.clysman.linear.Matrix;
import edu.unifor.clysman.pagerank.PageRank;
import edu.unifor.clysman.pagerank.RankingPrinter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Matrix matrix = new Matrix(10, 10, new double[][]{
//                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 1, 1, 1, 1, 0, 0, 1, 0, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
//        });

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantidade de páginas:");
        int pages = scanner.nextInt();

        System.out.println("Matrix de referências:");
        double[][] elements = new double[pages][pages];

        for (int i = 0; i < pages; i++) {
            for (int j = 0; j < pages; j++) {
                elements[i][j] = scanner.nextDouble();
            }
        }

        Matrix matrix = new Matrix(pages, pages, elements);
        PageRank pageRank = new PageRank(matrix);
        Matrix result = pageRank.calculate();

        System.out.println("Paginas desordenadas:");
        RankingPrinter.print(result);

        System.out.println("\nPaginas ordenadas:");
        RankingPrinter.printOrdered(result);
    }
}
