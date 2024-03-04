package edu.iu.habahram.coffeeorder.model;

import edu.iu.habahram.coffeeorder.model.Beverage;

public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public float cost() {
        return beverage.cost() + 0.6F;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}