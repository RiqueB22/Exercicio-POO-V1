package org.exercicio.POO.Conta;

import org.exercicio.POO.Cliente.Cliente;
import org.exercicio.POO.Transacao.TipoTransacao;
import org.exercicio.POO.Transacao.Transacao;
import java.util.ArrayList;
import java.util.List;

//Classe abstrata Conta
abstract public class Conta {

    //Atributos
    private int numero;
    private double saldo;
    private Cliente titular;
    private final List<Transacao> transacoes;

    //Construtor
    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0;
        this.titular = new Cliente("João Antonio", "123.456.789-00", "xxxxx@gggg.ccc");
        this.transacoes = new ArrayList<>();
    }

    //Deposita dinheiro
    public void depositar(double valor){
        //Soma o valor do saldo mais o do parametro
        setSaldo(getSaldo() + valor);
        //Registra a transação
        registrarTransacao("deposito", valor);
        System.out.println("Depositado com sucesso!");
        System.out.println(" ");
    }

    //Saca dinheiro
    abstract public void sacar(double valor);

    //transfere dinheiro de uma conta para outra
    public void transferir(double valor, Conta destino){
        //Checa se o saldo é > ou = ao valor recebido pelo parametro
        if(getSaldo() >= valor){
            if(destino instanceof ContaPoupanca && valor <= 500){
                //Tira o valor na conta remetente
                setSaldo(getSaldo() - valor);
                //Registra a trasanção
                registrarTransacao("transferencia", valor);
                //Adiciona o valor na conta destinataria
                destino.setSaldo(destino.getSaldo() + valor);
                System.out.println("transferencia feita com sucesso!");
            } else if (destino instanceof ContaCorrente) {
                //Tira o valor na conta remetente
                setSaldo(getSaldo() - valor);
                //Registra a trasanção
                registrarTransacao("transferencia", valor);
                //Adiciona o valor na conta destinataria
                destino.setSaldo(destino.getSaldo() + valor);
                System.out.println("transferencia feita com sucesso!");
            }else{
                System.out.println("O valor está acima do permitido para transferir!");
            }
        }else {
            System.out.println("Saldo insuficiente!");
        }
        System.out.println(" ");
    }

    //Consulta saldo
    public void consultarSaldo(){
        System.out.println("Saldo atual: " + getSaldo());
    }

    //Registra transação
    public void registrarTransacao(String tipo, double valor){
        //Cria a transação
        Transacao t = new Transacao(TipoTransacao.valueOf(tipo.toUpperCase()), valor);
        //Adiciona a transação na lista de transações
        this.transacoes.add(t);
        System.out.println("Transação registrada com sucesso!");
    }

    //Colsulta extrato
    public void consultarTransacao(){
        for(Transacao t : transacoes){
            System.out.println(t.toString());
        }
    }

    //Get numero
    public long getNumero() {
        return numero;
    }

    //Set numero
    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Get saldo
    public double getSaldo() {
        return saldo;
    }

    //Set saldo
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Get titular
    public Cliente getTitular() {
        return titular;
    }

    //Set titular
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    //Get transacoes
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
