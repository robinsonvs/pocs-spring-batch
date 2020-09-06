package com.severo.processor;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OddPairProcessorConfig {

    @Bean
    public FunctionItemProcessor<Integer, String> oddPairProcessor() {
        return new FunctionItemProcessor<Integer, String>(item -> item % 2 == 0 ?
                String.format("Item %s is pair", item) : String.format("Item %s is odd", item));
    }
}
