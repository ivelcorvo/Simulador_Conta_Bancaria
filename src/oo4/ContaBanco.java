
package oo4;

public class ContaBanco {
    private String dono;
    private String tipo;
    private int numConta;
    private float saldo;
    private boolean status;
    //=================================================================================
    // metodo construtor    
    public ContaBanco(){
        this.setStatus(false);
        this.setSaldo(0);
    }
    //=================================================================================
    // getters and setters    
    public String getDono(){
        return this.dono;
    }    
    public void setDono(String dono){
        this.dono = dono;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public int getNumConta(){
        return this.numConta;
    }
    public void setNumConta(int numConta){
        this.numConta = numConta;
    }
    
    public float getSaldo(){
        return this.saldo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    
    public boolean isStatus(){
        return this.status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    
    //=================================================================================
    // metodos     
    public void abrirConta(String t){    
        if(this.isStatus() == false){
            if(t.equals("CP")){
                this.setStatus(true);
                this.setTipo(t);
                this.setSaldo(150f);
                System.out.println("|| CONTA POUPANÇA ABERTA COM SUCESSO ||");
            }else if(t.equals("CC")){
                this.setStatus(true);
                this.setTipo(t);
                this.setSaldo(50f);
                System.out.println("|| CONTA CORRENTE ABERTA  COM SUCESSO ||");
            }else{
                System.out.println("|| --- ERRO. TIPO INVÁLIDO --- ||");
            }
        }else{
            System.out.println("|| CONTA JÁ ABERTA ||");
        }   
    }
    
    //=================================================================================
    public void fecharConta(){
        if(this.isStatus()==true){
            if(this.getSaldo() > 0){
                System.out.println("|| CONTA COM SALDO. NÃO É POSSÍVEL ENCERRAR ||\n");
            }else if(this.getSaldo() < 0){
                System.out.println("|| CONTA EM DÉBITO. NÃO É POSSÍVEL ENCERRAR ||\n");
            }else{
                System.out.println("|| CONTA ENCERRADA ||\n");
                this.setDono(null);
                this.setNumConta(0);
                this.setTipo(null);
                this.setStatus(false);
            }
        }else{
            System.out.println("|| CONTA JÁ ENCERRADA ||");
        }
    }
    
    //=================================================================================
    public void depositar(float v){
        if(this.isStatus() == true){
            this.setSaldo(this.getSaldo()+v);
            System.out.println("|| DEPOSITO DE: R$"+v+". NA CONTA DE "+this.getDono()+" ||\n");
        }else{
            System.out.println("|| CONTA ESTÁ FECHADA. IMPOSSÍVEL DEPOSITAR ||");
        }
    }
    
    //=================================================================================
    public void sacar(float v){
        if(this.isStatus() == true ){
            if(this.getSaldo() >= v){
                this.setSaldo(this.getSaldo() - v);
                System.out.println("|| SAQUE DE: R$"+v+". REALIZADO NA CONTA DE "+this.getDono()+" ||\n");
            }else{
                System.out.println("|| SALDO INSUFICIENTE ||");
            }
        }else{
            System.out.println("|| CONTA ESTÁ FECHADA. IMPOSSÍVEL SACAR ||");            
        }
    }
    
    //=================================================================================
    public void pagarMensal(){
        if(this.isStatus() == true){
            float v = 0;
            if(this.getTipo()=="CP"){
                v = 20;
            }else if(this.getTipo()=="CC"){
                v = 10;
            }
            if(this.getSaldo() >= v){
                this.setSaldo(getSaldo() - v);
                System.out.println("|| PAGAMENTO MENSAL REALIZADO ||");
            }else if(this.getSaldo()<v){
                System.out.println("|| SALDO INSUFICIENTE ||");
            }
        }else{
            System.out.println("|| CONTA ESTÁ FECHADA. IMPOSSÍVEL PAGA ||");
        }
    }
    
    //=================================================================================
    public void nome_numero(String nome, int numero){
        this.setDono(nome);
        this.setNumConta(numero);
    }
    
    //=================================================================================
    public void mostrarStatus(){
        System.out.println("++===============================\n"+
                           "|| DONO: "+this.getDono()+"\n"+
                           "|| NUMERO: "+this.getNumConta()+"\n"+
                           "|| TIPO: "+this.getTipo()+"\n"+
                           "|| STATUS: "+this.isStatus()+"\n"+
                           "|| SALDO: R$"+this.getSaldo()+"\n"+
                           "++===============================");
    }                      
}
