package com.pluralsight;

public class ModernPerson extends Human {
    private int tiktokUsagePerHour;
    private int stressLevel;

    public ModernPerson(String name, int age, int tiktokUsagePerHour, int stressLevel) {
        super(name, age);
        this.tiktokUsagePerHour = tiktokUsagePerHour;
        this.stressLevel = stressLevel;
    }

    public int getTiktokUsagePerHour() {
        return tiktokUsagePerHour;
    }

    public void setTiktokUsagePerHour(int tiktokUsagePerHour) {
        this.tiktokUsagePerHour = tiktokUsagePerHour;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(int stressLevel) {
        this.stressLevel = stressLevel;
    }

    @Override
    public void eat() {
        System.out.println("I am going to McDonalds to eat");
    }

    public void drive() {
        System.out.println("I am driving my car!");
    }
}
