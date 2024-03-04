package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Repository
public class OrderRepository {
    private static int receiptIdCounter = 1; // Initialize a counter for receipt IDs
    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
            case "house blend":
                beverage = new HouseBlend();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            case "decaf":
                beverage = new Decaf();
                break;
            default:
                throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }

        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }

        for (String condiment : order.condiments()) {
            switch (condiment.toLowerCase()) {
                case "milk":
                    beverage = new Milk(beverage);
                    break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                case "whip":
                    beverage = new Whip(beverage);
                    break;
                case "soy":
                    beverage = new Soy(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }
        int generatedId = generateUniqueReceiptId();



        Receipt receipt = new Receipt(beverage.getDescription(), beverage.cost(), generatedId);
        saveOrderToTextFile(receipt);
        return receipt;

    }

    private synchronized int generateUniqueReceiptId() {
        return receiptIdCounter++;
    }

    private void saveOrderToTextFile(Receipt receipt) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("db.txt", true))) {

            writer.printf("%d, %.2f, %s%n", receipt.id(), receipt.cost(), receipt.description());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
