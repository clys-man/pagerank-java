package edu.unifor.clysman.pagerank;

public class Page {
    private final String name;
    private final int index;

    public Page(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
