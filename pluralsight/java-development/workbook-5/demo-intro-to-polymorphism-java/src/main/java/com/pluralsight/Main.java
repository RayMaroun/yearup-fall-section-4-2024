package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Human");
        Human human = new Human("Ray", 55);
        //human.eat();
        feed("Human", human);

        System.out.println("=============================================================");

        System.out.println("Caveman");
        Caveman caveman = new Caveman("Crood", 35, 99, "Hunting");
        //caveman.eat();
        feed("Caveman", caveman);

        System.out.println("=============================================================");

        System.out.println("ModernPerson");
        ModernPerson modernPerson = new ModernPerson("Hank", 18, 99, 2147483647);
        //modernPerson.eat();
        feed("Modern Person", modernPerson);

        System.out.println("=============================================================");

        List<Human> people = new ArrayList<>();

        people.add(human);
        people.add(caveman);
        people.add(modernPerson);

        for (Human person : people) {
            if (person instanceof Caveman) {
                System.out.print("This is a Caveman. ");
            } else if (person instanceof ModernPerson) {
                System.out.print("This is a Modern Person. ");
                ModernPerson modernPerson1 = (ModernPerson) person;
                modernPerson1.drive();
            } else if (person instanceof Human) {
                System.out.print("This is a Human. ");
            }
            System.out.println();
        }

        for (Human person : people) {
            System.out.println(person.getClass().getSimpleName());
        }


/*
        Human human1;

        human1 = new ModernPerson("Paul", 57, 15, 80);
        human1 = new Caveman("John", 35, 50, "Hunting");
*/

/*        ModernPerson modernPerson1;
        Human firstHuman = new Human();

        modernPerson1 = (ModernPerson) firstHuman;*/
    }

    public static void feed(String label, Human human) {
        System.out.print(label + "--> ");
        human.eat();
    }
}
