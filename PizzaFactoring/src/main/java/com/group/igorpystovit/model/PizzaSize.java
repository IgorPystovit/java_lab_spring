package com.group.igorpystovit.model;

public enum PizzaSize {
    SMALL(1),
    MEDIUM(1.5),
    LARGE(2);

    double coefficient;
    PizzaSize(double coefficient){
        this.coefficient = coefficient;
    }
    PizzaSize(){}
    public double getCoefficient() {
        return coefficient;
    }
}
