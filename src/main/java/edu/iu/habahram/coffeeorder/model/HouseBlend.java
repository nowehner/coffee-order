package edu.iu.habahram.coffeeorder.model;

import edu.iu.habahram.coffeeorder.model.Beverage;

public class HouseBlend extends Beverage {
    @Override
    public float cost() {
        return 2.99F;
    }

    @Override
    public String getDescription() {
        return "House Blend";
    }
}
