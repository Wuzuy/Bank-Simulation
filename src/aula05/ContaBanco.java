/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula05;

/**
 *
 * @author Wuzuy
 */
public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    
    public void estadoAtual(){
        System.out.println("------------------------------");
        System.out.println("Conta: "+ this.getNumConta());
        System.out.println("Tipo: "+ this.getTipo());
        System.out.println("Dono: "+ this.getDono());
        System.out.println("Saldo: "+ this.getSaldo());
        System.out.println("Status: "+ this.getStatus());
    }
    
    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);
        if(t == "CC"){
            setSaldo(50);
        }else if(t == "CP"){
            setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso.");
    }
    public void fecharConta(){
        if(this.getSaldo() > 0){
            System.out.println("Conta não pode ser fechada por ainda ter dinheiro.");
        }else if(this.getSaldo() < 0){
            System.out.println("Conta não pode ser fechada pois está em débito.");
        }else{
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
        
    }
    public void depositar(float v){
        if(this.getStatus() == true){
            this.setSaldo(this.getSaldo()+ v);
            System.out.println("Depositado realizado com sucesso na conta de "+ this.getDono());
        }else {
            System.out.println("Impossível depositar em uma conta fechada.");
        }
        
    }
    public void sacar(float v){
        if(this.getStatus() == true){
            if( this.getSaldo() >= v){
                this.setSaldo(this.getSaldo()-v);
                System.out.println("Saldo realizado com sucesso na conta de "+ this.getDono());
            }else{
                System.out.println("Saldo insuficiente.");
            }
        }else{
            System.out.println("Conta fechada, impossível sacar.");
        }
    }
    public void pagarMensal(){
        int v = 0;
        if (this.getTipo() == "CC") {
            v = 12;
        }else if(this.getTipo() == "CP"){
            v = 20;
        }
        if(this.getStatus() == true){
            this.setSaldo(this.getSaldo()- v);
            System.out.println("Mensalidade paga com sucesso por "+ this.getDono());
        }else{
            System.out.println("Impossível pagar com a conta fechada.");
        }
        
    }

    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
