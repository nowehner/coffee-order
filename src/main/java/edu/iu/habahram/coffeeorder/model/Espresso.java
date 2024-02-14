package edu.iu.habahram.coffeeorder.model;

import edu.iu.habahram.coffeeorder.model.Beverage;

public class Espresso extends Beverage {
    @Override
    public float cost() {
        return 2.00F;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
