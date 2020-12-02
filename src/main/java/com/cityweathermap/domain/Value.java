package com.cityweathermap.domain;

public class Value {

    private String name;
    private double value;

    public Value(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
