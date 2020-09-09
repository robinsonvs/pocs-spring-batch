package com.severo.writer;

import com.severo.domain.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfig {
	@Bean
	public ItemWriter<Customer> readingFixedWidthFileWriter() {
		return items -> items.forEach(System.out::println);
	}
}
