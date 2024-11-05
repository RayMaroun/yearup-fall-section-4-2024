package com.pluralsight;

public class Violinist extends Musician {
    public Violinist(String name, String instrument) {
        super(name, instrument);
    }

    @Override
    public void perform() {
        System.out.println("I am a violinist and I am performing!");
    }
}
