package com.razzolim.batch.processor.validation.processor;

import com.razzolim.batch.processor.validation.domain.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ValidationProcessorProcessorConfig {

	private Set<String> emails = new HashSet<>();

	@Bean
	public ItemProcessor<Cliente, Cliente> validationProcessor() throws Exception {
		return new CompositeItemProcessorBuilder<Cliente, Cliente>()
				.delegates(beanValidateProcessor(), emailValidatingItemProcessor())
				.build();
	}

	private BeanValidatingItemProcessor<Cliente> beanValidateProcessor() throws Exception {
		BeanValidatingItemProcessor processor = new BeanValidatingItemProcessor<Cliente>();
		processor.setFilter(true);
		processor.afterPropertiesSet();
		return processor;
	}

	private ValidatingItemProcessor<Cliente> emailValidatingItemProcessor() {
		ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>();
		processor.setValidator(validator());
		processor.setFilter(true); // não interrompe a execução do job...
		return processor;
	}

	private Validator<Cliente> validator() {
		return new Validator<Cliente>() {
			@Override
			public void validate(Cliente cliente) throws ValidationException {
				if (emails.contains(cliente.getEmail())) {
					throw new ValidationException(
							String.format("O cliente %s já foi processado.", cliente.getEmail()));
				}
			}
		};
	}
}
