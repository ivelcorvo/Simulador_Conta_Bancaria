
package oo4;

public class ContaBanco {
    private String dono;
    private String tipo;
    private String numConta;
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
    
    public String getNumConta(){
        return this.numConta;
    }
    public void setNumConta(String numConta){
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
        //modo que fiz mais simples
        /*
        this.setTipo(t);
        this.setStatus(true);
        if(this.getTipo()=="CP"){
            this.setSaldo(150);
        }else if(this.getTipo()=="CC"){
            this.setSaldo(50);
        } */
    
        if(t == "CP"){
            this.setTipo(t);
            if(this.isStatus() == false){
                this.setStatus(true);
                System.out.println("|| CONTA POUPANÇA ABERTA  COM SUCESSO ||");
                this.setSaldo(150f);
            }else{
                System.out.println("|| CONTA JÁ ABERTA ||");
            }
        }else if(t == "CC"){
            this.setTipo(t);
            if(this.isStatus() == false){
                this.setStatus(true);
                System.out.println("|| CONTA CORRENTE ABERTA  COM SUCESSO ||");                
                this.setSaldo(50f);
            }else{
                System.out.println("|| CONTA JÁ ABERTA ||");
            }
        }else{
            System.out.println(" +++ ERRO. TIPO INVÁLIDO +++ ");
        }   
    }
    
    //=================================================================================
    public void fecharConta(){
        if(this.isStatus()==true){
            if(this.getSaldo() > 0){
                System.out.println("|| CONTA COM SALDO. NÃO É  POSSÍVEL ENCERRAR ||\n");
            }else if(this.getSaldo() < 0){
                System.out.println("|| CONTA EM DÉBITO. NÃO É POCIVEL ENCERRAR ||\n");
            }else{
                System.out.println("|| CONTA ENCERRADA ||\n");
                this.setStatus(false);
            }
        }else{
            System.out.println("|| CONTA JÁ ENCERRADA ||");
        }
    }
    
    //=================================================================================
    public void depositar(float v){
        if(this.isStatus() == true){
            this.setSaldo(getSaldo()+v);
            System.out.println("|| deposito de: R$"+v+" na conta de "+this.getDono()+" ||\n");
        }else{
            System.out.println("|| IMPOSSÍVEL DEPOSITAR ||");
            System.out.println("|| CONTA ESTÁ FECHADA ||");
        }
    }
    
    //=================================================================================
    public void sacar(float v){
        if(this.isStatus() == true ){
            if(getSaldo()>=v){
                this.setSaldo(getSaldo()-v);
                System.out.println("|| Saque de: R$"+v+" feito na conte de "+this.getDono()+" ||\n");
            }else{
                System.out.println("|| SALDO INSUFICIENTE ||");
            }
        }else{
            System.out.println("|| CONTA ESTÁ FECHADA ||");
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
            if(this.getSaldo()>=v){
                this.setSaldo(getSaldo()-v);
                System.out.println("|| PAGAMENTO MENSAL REALIZADO ||");
            }else if(this.getSaldo()<v){
                System.out.println("|| SALDO INSUFICIENTE ||");
            }
        }else{
            System.out.println("|| CONTA ESTÁ FECHADA. IMPOSSÍVEL PAGA ||");
        }
    }
    
    //=================================================================================
    public void mostrarStatus(){
        System.out.println("=================================");
        System.out.println("| DONO: "+this.getDono()+"\n"+
                           "| NUMERO: "+this.getNumConta()+"\n"+
                           "| TIPO: "+this.getTipo()+"\n"+
                           "| STATUS: "+this.isStatus()+"\n"+
                           "| SALDO: R$"+this.getSaldo());
        System.out.println("=================================");
    }

    
    
            
    

}
