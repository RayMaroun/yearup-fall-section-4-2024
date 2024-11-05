package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
  /*      Pair<Integer> twoNumbs = new Pair<>(63, 65);
        System.out.println(twoNumbs.getLeftThing());
        twoNumbs.swap();
        System.out.println(twoNumbs.getLeftThing());


        Pair<String> twoWords = new Pair<>("Me", "You");
        System.out.println(twoWords.getLeftThing());
        twoWords.swap();
        System.out.println(twoWords.getLeftThing());*/

        System.out.println("======================================");

        displayWithLabel("Name", "Dana");

        displayWithLabel("Age", 55);

        System.out.println("==================================");

        Pair<Musician> duets = new Pair<>(new Cellist("Ray", "Cello"),
                new Violinist("Kate", "Violin"));

    }

    public static <T> void displayWithLabel(String label, T value) {
        System.out.println(label + ": " + value);
    }

/*    public static void displayWithLabel(String label, String value) {
        System.out.println(label + ": " + value);
    }

    public static void displayWithLabel(String label, int value) {
        System.out.println(label + ": " + value);
    }*/


}
