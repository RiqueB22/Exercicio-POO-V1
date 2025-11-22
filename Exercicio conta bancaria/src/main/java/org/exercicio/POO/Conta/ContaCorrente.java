package org.exercicio.POO.Conta;

//Classe filha da Conta
public class ContaCorrente extends Conta {

    //Construtor Herdado pela herança
    public ContaCorrente(int numero) {
        super(numero);
    }

    //Saca dinheiro
    @Override
    public void sacar(double valor) {
        //variavel
        double desconto = valor * 1.1;
        //Checa se desconto é < ou igual ao saldo da conta
        if(desconto <= getSaldo()){
            //Tira o valor da conta
            setSaldo(getSaldo() - desconto);
            //Registra transação
            registrarTransacao("saque", valor);
            System.out.println("Sacado com sucesso!");
        }else {
            System.out.println("Saldo insuficiente!");
            System.exit(0);
        }
        System.out.println(" ");
    }
}
