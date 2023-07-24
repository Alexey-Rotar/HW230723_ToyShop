package org.example;

public class Toy implements Comparable<Toy>{
    int id;
    String name;
    int dropFrequency;

    public Toy(int id, String name, int dropFrequency) {
        this.id = id;
        this.name = name;
        this.dropFrequency = dropFrequency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDropFrequency() {
        return dropFrequency;
    }

    public void setDropFrequency(int dropFrequency) {
        this.dropFrequency = dropFrequency;
    }

    @Override
    public int compareTo(Toy o) {
        return 0;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
