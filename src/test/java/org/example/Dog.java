package org.example;

public class Dog {

    private final String name;
    private final int age;

    Dog(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void bark() {
        System.out.println("Bark!");
    }

    public static void showDogDescription() {
        System.out.println("Dog is good, coz it bark!");
    }
}
