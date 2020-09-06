package com.severo.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintOddPairStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step printOddPairStep(ItemReader<Integer> countToTenReader,
                                  ItemProcessor<Integer, String> oddPairProcessor,
                                  ItemWriter<String> printWriter) {
        return stepBuilderFactory
                .get("printOddPairStep")
                .<Integer, String>chunk(1)
                .reader(countToTenReader)
                .processor(oddPairProcessor)
                .writer(printWriter)
                .build();
    }
}
