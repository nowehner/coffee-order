package edu.iu.habahram.coffeeorder.model;

import edu.iu.habahram.coffeeorder.model.Beverage;

public class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public float cost() {
        return beverage.cost() + 0.8F;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}