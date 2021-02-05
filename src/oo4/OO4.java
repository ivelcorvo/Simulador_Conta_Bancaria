package oo4;

public class OO4 {

    public static void main(String[] args) {
        //incira um dos tippos
        // CP - conta poupança 
        // CC - conta corente
        
        /*
        ContaBanco c1 = new ContaBanco();
        c1.abrirConta("CP");
        c1.setDono("levi");
        c1.setNumConta(1300);
        c1.mostrarStatus();
        c1.sacar(200);
        c1.depositar(150);
        c1.sacar(200);
        c1.pagarMensal();
        c1.fecharConta();
        c1.sacar(90);
        c1.sacar(80);
        c1.fecharConta();
        c1.depositar(10);
        c1.mostrarStatus();
*/
       /*
        ContaBanco c1 = new ContaBanco();
        c1.setDono("levi Alves Junior");
        c1.setNumConta("0013");
        c1.abrirConta("CP");
        c1.mostrarStatus();
        */
       
       ContaBanco c = new ContaBanco();
       c.setDono("levi");
       c.setNumConta("1111");
       c.abrirConta("CP");
       c.mostrarStatus();
       c.sacar(150);
       c.fecharConta();
       
        
      
    }
    
}
