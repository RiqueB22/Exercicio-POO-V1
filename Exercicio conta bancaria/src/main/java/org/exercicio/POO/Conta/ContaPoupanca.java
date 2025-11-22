package org.exercicio.POO.Conta;

//Classe filha da Conta
public class ContaPoupanca extends Conta {

    //Construtor Herdado pela herança
    public ContaPoupanca(int numero) {
        super(numero);
    }

    //Saca dinheiro
    @Override
    public void sacar(double valor) {
        //Checa se valor do parametro é < ou = ao saldo da conta
        if(valor <= getSaldo()){
            //Tira o valor da conta
            setSaldo(getSaldo() - valor);
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
