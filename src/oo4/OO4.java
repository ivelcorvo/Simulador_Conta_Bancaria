package oo4;

import java.util.Scanner;

public class OO4 {

    public static void main(String[] args) {
        int iOpcao=0, x = 1, y = 0;
        String sTp;
        float s, d;
        
        ContaBanco c = new ContaBanco();

        Scanner scanner = new Scanner(System.in);
        Scanner tipo = new Scanner(System.in);
        Scanner dinheiro = new Scanner(System.in);
        
        System.out.println("++------------------------++\n"+
                           "|| [1] - ABRIR CONTA      ||\n"+
                           "|| [2] - FECHAR CONTA     ||\n"+
                           "|| [3] - SACAR            ||\n"+
                           "|| [4] - DESPOSITAR       ||\n"+
                           "|| [5] - MOSTRAR STATUS   ||\n"+
                           "|| [6] - SAIR             ||\n"+
                           "++------------------------++");
        
        while(x == 1){            
            System.out.print("\n|| OPÇÃO => ");
            iOpcao = scanner.nextInt();
            if((iOpcao < 1) || (iOpcao > 6)){
                System.out.print("|| --- OPÇÃO INVÁLIDA --- || ");
            }else if(iOpcao == 1){
                y = 0;
                do{
                    System.out.print("|| TIPO DE CONTA => ");
                    sTp = tipo.nextLine();  
                    sTp = sTp.toUpperCase();
                    //(("CC".equals(sTp))||("CP".equals(sTp)))
                    // precisa ser melhorado. o correto era passar sTp por parametro.
                    if(sTp.equals("CC")){
                        c.abrirConta("CC");
                        y = 1;
                    }else if(sTp.equals("CP")){
                        c.abrirConta("CP"); 
                        y = 1;
                    }else{
                        System.out.println("|| --- TIPO INVÁLIDO--- ||");
                    }
                }while(y == 0);
                
            }else if(iOpcao == 2){
                c.fecharConta();
            }else if(iOpcao == 3){
                System.out.print("|| SACAR || QUANTIDADE =>");
                s = dinheiro.nextFloat();
                c.sacar(s);
            }else if(iOpcao == 4){
                System.out.print("|| DEPOSITAR || QUANTIDADE =>");
                s = dinheiro.nextFloat();
                c.depositar(s);
            }else if(iOpcao == 5){
                c.mostrarStatus();
            }else if(iOpcao == 6){
                x = 0;
            }            
        }
        

       
        /*c.setDono("levi");
        c.setNumConta("1111");
        c.abrirConta("CP");
        c.mostrarStatus();
        c.sacar(150);
        c.fecharConta();

*/
      
    }
    
}
