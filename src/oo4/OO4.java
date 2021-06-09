package oo4;

import java.util.Scanner;

public class OO4 {

    public static void main(String[] args) {        
        
        ContaBanco c = new ContaBanco();
        
        Scanner scanOp     = new Scanner(System.in);
        Scanner scanTipo   = new Scanner(System.in);
        Scanner scanValor  = new Scanner(System.in);
        Scanner scanFechar = new Scanner(System.in);
        Scanner scanNome   = new Scanner(System.in);
        Scanner scanNumero = new Scanner(System.in);
                
        int op, numero;
        String tipo, fechar, nome;        
        float valor;
        boolean sistema    = true;  // o sistema funciona enquanto verdadeiro
        boolean validaTipo = false; // valida se o tipo de conta cc ou cp é verdadeiro                
        
        System.out.println("++------------------------++\n"+
                           "||++++ TIPOS DE CONTA ++++||\n"+ 
                           "++------------------------++\n"+
                           "|| CC - CONTA CONRRENTE   ||\n"+
                           "|| CP - CONTA POUPANÇA    ||\n"+
                           "++------------------------++\n"+
                           "||++++++++ OPÇÕES ++++++++||\n"+
                           "++------------------------++\n"+ 
                           "|| [1] - ABRIR CONTA      ||\n"+
                           "|| [2] - FECHAR CONTA     ||\n"+
                           "|| [3] - SACAR            ||\n"+
                           "|| [4] - DESPOSITAR       ||\n"+
                           "|| [5] - MOSTRAR STATUS   ||\n"+
                           "|| [6] - SAIR             ||\n"+
                           "++------------------------++");
        
        while(sistema){            
            System.out.print("\n|| OPÇÃO => ");
            op = scanOp.nextInt();
            if((op < 1) || (op > 6)){
                System.out.print("|| --- OPÇÃO INVÁLIDA --- || ");
            }else if(op == 1){
                validaTipo = false; // causo já tenha sido feito alguma vez a abertura enão tinnha fechado
                do{
                    System.out.print("|| TIPO DE CONTA => ");
                    tipo = scanTipo.nextLine();
                    tipo = tipo.toUpperCase();
                    if((tipo.equals("CC"))||(tipo.equals("CP"))){
                        //recebe o nome eo número
                        System.out.print("|| NOME DO PROPRIETÁRIO => ");
                        nome = scanNome.nextLine();
                        System.out.print("|| NÚMERO DA CONTA => ");
                        numero = scanNumero.nextInt();
                        c.nome_numero(nome, numero);
                        //abre a conta
                        c.abrirConta(tipo);                        
                        validaTipo = true;                        
                    }else{
                        System.out.println("|| --- TIPO INVÁLIDO --- ||");
                    }                                       
                }while(!validaTipo);                
            }else if(op == 2){
                System.out.print("|| DESEJA REALMENTE FECHAR A CONTA [S]-SIM/[N]-NÃO => ");
                fechar = scanFechar.nextLine();
                fechar = fechar.toUpperCase();
                if(fechar.equals("N")){
                    // não feha a conta . . .
                    System.out.println("|| . . . VOLTANDO AO MENU . . . ||");
                }else if(fechar.equals("S")){                 
                    c.fecharConta(); // só fecha a conta de acordo com as condições da função
                }else{
                    System.out.println("|| --- OPÇÃO DE FECHAR INVÁLIDA --- ||\n|| . . . VOLTANDO AO MENU . . . ||");
                }                
            }else if(op == 3){
                System.out.print("|| SACAR || QUANTIDADE => ");
                valor = scanValor.nextFloat();
                c.sacar(valor);
            }else if(op == 4){
                System.out.print("|| DEPOSITAR || QUANTIDADE => ");
                valor = scanValor.nextFloat();
                c.depositar(valor);
            }else if(op == 5){
                c.mostrarStatus();
            }else if(op == 6){
                sistema = false;
            }            
        }    
        
    }    
}
