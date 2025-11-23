package org.exercicio.POO;

/*
* Sistema bancario simplificado
*
* author: Henrique Bernardo
* */

import org.exercicio.POO.Conta.Conta;
import org.exercicio.POO.Conta.ContaCorrente;
import org.exercicio.POO.Conta.ContaPoupanca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variaveis
        Conta contaP = new ContaPoupanca(345);
        Conta contaC = new ContaCorrente(123);
        String opcao = "";

        //enquanto não for = à 0, ele fara o loop
        while(!opcao.equals("0")){
            //Input do Menu
            Scanner input = new Scanner(System.in);
            System.out.println("***************************************");
            System.out.println("Banco POO - Menu principal");
            System.out.println("***************************************");
            System.out.println("Conta: " + contaC.getNumero());
            System.out.println("Titular: " + contaC.getTitular().getNome());
            System.out.println(" ");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Consultar Transações");
            System.out.println("5 - Consultar Saldo");
            System.out.println("0 - Sair");
            System.out.println("Digite uma das opções: ");
            opcao = input.nextLine();

            //Checa se é numero inteiro
            if(opcao.matches(".*[0-9].*")){
                //Checa se é uma das opções do menu
                switch(opcao){
                    case "1":
                        //Input do deposito
                        Scanner inputDP = new Scanner(System.in);
                        System.out.println("***************************************");
                        System.out.println("Banco POO - Deposito");
                        System.out.println("***************************************");
                        System.out.println("Digite seu valor para depositar:");
                        String valor = inputDP.nextLine();

                        //Checa se é numero decimal
                        if(valor.matches(".*[0-9\\\\.].*")){
                            contaC.depositar(Double.parseDouble(valor));
                        }else{
                            System.out.println("Coloque apenas numeros!");
                        }
                        break;
                    case "2":
                        //Input de saque
                        Scanner inputSC = new Scanner(System.in);
                        System.out.println("***************************************");
                        System.out.println("Banco POO - Saque");
                        System.out.println("***************************************");
                        System.out.println("Digite seu valor para sacar:");
                        String quantia = inputSC.nextLine();

                        //Checa se é numero decimal
                        if(quantia.matches(".*[0-9\\\\.].*")){
                            contaC.sacar(Double.parseDouble(quantia));
                        }else{
                            System.out.println("Coloque apenas numeros!");
                        }
                        break;
                    case "3":
                        //Input de transferencia
                        Scanner inputTF = new Scanner(System.in);
                        System.out.println("***************************************");
                        System.out.println("Banco POO - Transferencia");
                        System.out.println("***************************************");
                        System.out.println("1 - De Conta Corrente para Poupança");
                        System.out.println("2 - Da Poupança para Conta Corrente");
                        System.out.println("Digite uma das opções acima para transferir:");
                        String escolha = inputTF.nextLine();

                        //Checa se é numero inteiro
                        if(escolha.matches(".*[0-9].*")){
                            //Checa se é uma das opções do menu
                            switch(escolha){
                                case "1":
                                    //Input de transferencia, de conta corrente para conta poupança
                                    Scanner inputCC = new Scanner(System.in);
                                    System.out.println("***************************************");
                                    System.out.println("Banco POO - Transferencia - De Conta Corrente para Poupança");
                                    System.out.println("***************************************");
                                    System.out.println("Digite seu valor para transferir:");
                                    String valorCC = inputCC.nextLine();

                                    //Checa se é numero decimal
                                    if(valorCC.matches(".*[0-9\\\\.].*")){
                                        contaC.transferir(Double.parseDouble(valorCC), contaP);
                                    }else{
                                        System.out.println("Coloque apenas numeros!");
                                    }
                                    break;
                                case "2":
                                    //Input de transferencia, de conta poupança para conta corrente
                                    Scanner inputCP = new Scanner(System.in);
                                    System.out.println("***************************************");
                                    System.out.println("Banco POO - Transferencia - Da Poupança para Conta Corrente");
                                    System.out.println("***************************************");
                                    System.out.println("Digite seu valor para transferir:");
                                    String valorCP = inputCP.nextLine();

                                    //Checa se é numero decimal
                                    if(valorCP.matches(".*[0-9\\\\.].*")){
                                        contaP.transferir(Double.parseDouble(valorCP), contaC);
                                    }else{
                                        System.out.println("Coloque apenas numeros!");
                                    }
                                    break;
                                default:
                                    System.out.println("Coloque um numero vindo do menu");
                            }
                        }else{
                            System.out.println("Coloque apenas numeros!");
                        }
                        break;
                    case "4":
                        System.out.println("***************************************");
                        System.out.println("Banco POO - Consulta Transações");
                        System.out.println("***************************************");
                        //Consulta as transações
                        contaC.consultarTransacao();
                        System.out.println("Consulta de transações feita com sucesso!");
                        System.out.println(" ");
                        break;
                    case "5":
                        System.out.println("***************************************");
                        System.out.println("Banco POO - Consultar Saldo");
                        System.out.println("***************************************");
                        //Consulta o saldo
                        contaC.consultarSaldo();
                        System.out.println("Consulta do saldo feita com sucesso!");
                        System.out.println(" ");
                        break;
                    case "0":
                        //Sai do programa
                        System.out.println("Obrigado por acessar nosso sistema!");
                        System.out.println("Finalizando o programa!");
                        break;
                    default:
                        System.out.println("Coloque um numero vindo do menu");
                }
            }else{
                System.out.println("Coloque apenas numeros!");
            }
        }
    }
}