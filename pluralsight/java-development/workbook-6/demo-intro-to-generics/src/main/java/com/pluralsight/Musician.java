package com.pluralsight;

public class Musician {
    private String name;
    private String instrument;

    public Musician(String name, String instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void perform() {
        System.out.println("I am a musician and I am performing!");
    }
}
