package com.razzolim.batch.writer.demonstrativo.writer;

import com.razzolim.batch.writer.demonstrativo.domain.GrupoLancamento;
import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.List;

@Component
public class DemonstrativoRodape implements FlatFileFooterCallback {

    private double totalGeral;
    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.append("\n");
        writer.append(String.format("\t\t\t\t\t\t\t  Total: %s\n", NumberFormat.getCurrencyInstance().format(totalGeral)));
        writer.append(String.format("\t\t\t\t\t\t\t  Código de Autenticação: %s", "fkyew6868fewjfhjjewf"));
    }

    @BeforeWrite
    public void beforeWrite(List<GrupoLancamento> grupos) {
        for (GrupoLancamento grupo: grupos) {
            totalGeral += grupo.getTotal();
        }
    }
}
