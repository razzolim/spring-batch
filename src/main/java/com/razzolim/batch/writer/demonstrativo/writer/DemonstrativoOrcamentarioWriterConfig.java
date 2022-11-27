package com.razzolim.batch.writer.demonstrativo.writer;

import com.razzolim.batch.writer.demonstrativo.domain.GrupoLancamento;
import com.razzolim.batch.writer.demonstrativo.domain.Lancamento;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.batch.item.file.ResourceSuffixCreator;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class DemonstrativoOrcamentarioWriterConfig {

	@Bean
	@StepScope
	public MultiResourceItemWriter<GrupoLancamento> multiDemonstrativoWriter(
			@Value("#{jobParameters['outputs']}") Resource outputs,
			FlatFileItemWriter<GrupoLancamento> writer) {
		return new MultiResourceItemWriterBuilder<GrupoLancamento>()
				.name("multiDemonstrativoWriter")
				.resource(outputs)
				.delegate(writer)
				.resourceSuffixCreator(suffixCreator())
				.itemCountLimitPerResource(1)
				.build();
	}

	private ResourceSuffixCreator suffixCreator() {
		return index -> index + ".txt";
	}

	@Bean
	@StepScope
	public FlatFileItemWriter<GrupoLancamento> demonstrativoWriter(
			@Value("#{jobParameters['output']}") Resource output,
			DemonstrativoRodape rodapeCallback) {
		return new FlatFileItemWriterBuilder<GrupoLancamento>()
				.name("demonstrativoWriter")
				.resource(output)
				.lineAggregator(lineAggregator())
				.headerCallback(cabecalhoCallback())
				.footerCallback(rodapeCallback)
				.build();
	}

	private FlatFileHeaderCallback cabecalhoCallback() {
		return new FlatFileHeaderCallback() {
			@Override
			public void writeHeader(Writer writer) throws IOException {System.out.println("\n");
				writer.append(String.format("SISTEMA INTEGRADO: XPTO \t\t\t\t DATA: %s\n", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				writer.append(String.format("MÓDULO: ORÇAMENTO \t\t\t\t\t\t HORA: %s\n", new SimpleDateFormat("HH:MM").format(new Date())));
				writer.append(String.format("\t\t\tDEMONSTRATIVO ORCAMENTARIO\n"));
				writer.append(String.format("----------------------------------------------------------------------------\n"));
				writer.append(String.format("CODIGO NOME VALOR\n"));
				writer.append(String.format("\t Data Descricao Valor\n"));
				writer.append(String.format("----------------------------------------------------------------------------\n"));
			}
		};
	}

	private LineAggregator<GrupoLancamento> lineAggregator() {
		return new LineAggregator<GrupoLancamento>() {
			@Override
			public String aggregate(GrupoLancamento grupoLancamento) {
				String formatGrupoLancamento = String.format("[%d] %s - %s\n", grupoLancamento.getCodigoNaturezaDespesa(),
						grupoLancamento.getDescricaoNaturezaDespesa(),
						NumberFormat.getCurrencyInstance().format(grupoLancamento.getTotal()));

				StringBuilder stringBuilder = new StringBuilder();
				for (Lancamento lancamento : grupoLancamento.getLancamentos()) {
					stringBuilder.append(
							String.format("\t [%s] %s - %s\n",
									new SimpleDateFormat("dd/MM/yyyy").format(lancamento.getData()),
									lancamento.getDescricao(),
									NumberFormat.getCurrencyInstance().format(lancamento.getValor()))
					);
				}

				String formatLancamento = stringBuilder.toString();
				return formatGrupoLancamento + formatLancamento;
			}
		};
	}
}
