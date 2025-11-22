package org.exercicio.POO.Transacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private LocalDateTime data;
    private TipoTransacao tipo;
    private double valor;

    public Transacao(TipoTransacao tipo, double valor) {
        this.data = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return getTipo() == TipoTransacao.DEPOSITO?"Transação: " + getTipo() + " - R$ " + getValor() + " - Data: " + getData().format(formato):
                "Transação: " + getTipo() + " - R$ -" + getValor() + " - Data: " + getData().format(formato);
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
