package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Автобус движется");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Пассажиров в автобусе: " + count);
    }

    @Override
    public int refuel(int fuel) {
        int tank = 0;
        return tank + fuel;
    }
}