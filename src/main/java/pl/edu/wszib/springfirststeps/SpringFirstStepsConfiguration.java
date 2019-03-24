package pl.edu.wszib.springfirststeps;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFirstStepsConfiguration {

    @Bean
    public SpringFirstStepsRunner springFirstStepsRunner(ObjectMapper objectMapper) {
        FileJsonReader ioFileJsonReader = new NIOFileJsonReader();
        return new SpringFirstStepsRunner(ioFileJsonReader, objectMapper);
    }

}
