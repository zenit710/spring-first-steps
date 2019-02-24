package pl.edu.wszib.springfirststeps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Order {

    private final Long amount;

    private final List<Position> positions = new ArrayList<>();

    public Order(Position ... positions) {
        Objects.requireNonNull(positions);
        this.positions.addAll(Arrays.asList(positions));
        this.amount = calculateAmount();
    }

    private Long calculateAmount() {
        return positions.stream()
                .mapToLong(position -> position.amount())
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", positions=" + positions +
                '}';
    }

    public static class Position {
        private final Long price;
        private final Long quantity;
        private final String name;

        public Position(Long price, Long quantity, String name) {
            this.price = price;
            this.quantity = quantity;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "price=" + price +
                    ", quantity=" + quantity +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Long amount() {
            return price * quantity / 1000;
        }
    }
}
