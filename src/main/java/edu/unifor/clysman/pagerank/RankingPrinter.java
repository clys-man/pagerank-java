package edu.unifor.clysman.pagerank;

import edu.unifor.clysman.linear.Matrix;

public class RankingPrinter {
    public static void print(Matrix m) {
        for (int i = 0; i < m.getRows(); i++) {
            System.out.println("Page " + (i + 1) + ": " + m.get(i, 0));
        }
    }

    public static void printOrdered(Matrix m) {
        for (int i = 0; i < m.getRows(); i++) {
            double max = m.get(i, 0);
            int index = i;
            for (int j = i + 1; j < m.getRows(); j++) {
                if (m.get(j, 0) > max) {
                    max = m.get(j, 0);
                    index = j;
                }
            }

            if (index != i) {
                double[] temp = m.get(i);
                m.set(i, m.get(index));
                m.set(index, temp);
            }

            System.out.println("Page " + (i + 1) + ": " + m.get(i, 0));
        }
    }
}
