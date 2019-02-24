package pl.edu.wszib.springfirststeps;

import org.springframework.boot.CommandLineRunner;

public class SpringFirstStepsRunner implements CommandLineRunner {

    private FileJsonReader fileJsonReader;

    public SpringFirstStepsRunner(FileJsonReader fileJsonReader) {
        this.fileJsonReader = fileJsonReader;
    }

    @Override
    public void run(String... args) {
        String json = fileJsonReader.readJson("order.txt");
//        objectMapper.readValue(json, Or)
        Order.Position position1 = new Order.Position(1000L, 1000L, "Test1");
        Order.Position position2 = new Order.Position(2000L, 1000L, "Test2");
        Order order = new Order(position1, position2);
        System.out.println("Order: " + order);
    }
}
