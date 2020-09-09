package com.severo.step;

import com.severo.domain.Customer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step readerStep(ItemReader<Customer> readingDelimitedFileReader,
						   ItemWriter<Customer> readingDelimitedFileWriter) {
		return stepBuilderFactory
				.get("readerStep")
				.<Customer, Customer>chunk(1)
				.reader(readingDelimitedFileReader)
				.writer(readingDelimitedFileWriter)
				.build();
	}
}
