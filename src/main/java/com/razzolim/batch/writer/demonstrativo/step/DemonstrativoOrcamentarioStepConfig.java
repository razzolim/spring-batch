package com.razzolim.batch.writer.demonstrativo.step;

import com.razzolim.batch.writer.demonstrativo.domain.GrupoLancamento;
import com.razzolim.batch.writer.demonstrativo.reader.GrupoLancamentoReader;
import com.razzolim.batch.writer.demonstrativo.writer.DemonstrativoRodape;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemonstrativoOrcamentarioStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	/*@Bean
	public Step demonstrativoOrcamentarioStep(
			// Esse aqui lê dos arquivos
			//MultiResourceItemReader<GrupoLancamento> demonstrativoOrcamentarioReader,
			// Esse aqui lê do banco de dados
			GrupoLancamentoReader demonstrativoOrcamentarioReader,
			ItemWriter<GrupoLancamento> demonstrativoOrcamentarioWriter,
			DemonstrativoRodape rodapeCallback) {
		return stepBuilderFactory
				.get("demonstrativoOrcamentarioStep")
				.<GrupoLancamento,GrupoLancamento>chunk(100)
				.reader(demonstrativoOrcamentarioReader)
				.writer(demonstrativoOrcamentarioWriter)
				.listener(rodapeCallback)
				.build();
	}*/

	@Bean
	public Step demonstrativoOrcamentarioStep(
			// Esse aqui lê dos arquivos
			//MultiResourceItemReader<GrupoLancamento> demonstrativoOrcamentarioReader,
			// Esse aqui lê do banco de dados
			GrupoLancamentoReader demonstrativoOrcamentarioReader,
			MultiResourceItemWriter<GrupoLancamento> demonstrativoOrcamentarioWriter,
			DemonstrativoRodape rodapeCallback) {
		return stepBuilderFactory
				.get("demonstrativoOrcamentarioStep")
				.<GrupoLancamento,GrupoLancamento>chunk(1)
				.reader(demonstrativoOrcamentarioReader)
				.writer(demonstrativoOrcamentarioWriter)
				.listener(rodapeCallback)
				.build();
	}
}
