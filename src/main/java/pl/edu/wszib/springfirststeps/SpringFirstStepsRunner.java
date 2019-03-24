package pl.edu.wszib.springfirststeps;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;

public class SpringFirstStepsRunner implements CommandLineRunner {

    private FileJsonReader fileJsonReader;
    private ObjectMapper objectMapper;

    public SpringFirstStepsRunner(FileJsonReader fileJsonReader, ObjectMapper objectMapper) {
        this.fileJsonReader = fileJsonReader;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) {
        String json = fileJsonReader.readJson("order.txt");
        Order order = tryReadOrder(json);

        System.out.println("Order: " + order);
    }

    private Order tryReadOrder(String json) {
        try {
            return objectMapper.readValue(json, Order.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
