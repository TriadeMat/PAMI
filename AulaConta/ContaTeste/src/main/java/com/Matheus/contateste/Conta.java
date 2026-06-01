package com.Matheus.contateste;

import javax.swing.JOptionPane;

public class Conta {
 private String cliente;
 private double saldo;

 void transferirPara(Conta destino, double valor){
     this.sacar(valor);
     destino.depositar(valor);
     
     JOptionPane.showMessageDialog(null,this.cliente+
   "\nTransferência de R$: "+ valor+
             "\n"+"Para: "+destino.cliente);
 }
    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
 
 public void exibirSaldo(){
   
     JOptionPane.showMessageDialog(null,cliente + "\nSaldo é R$: "+saldo);
 }
 void sacar(double valor){
     JOptionPane.showMessageDialog(null,cliente+"\nSaldo é R$: " + saldo);
     saldo -= valor;
     JOptionPane.showMessageDialog(null,cliente+
             "\nOperação de Saque R$: "
             + saldo);
    }
 void depositar(double valor){
     JOptionPane.showMessageDialog(null,cliente+"\nSaldo é R$: " + saldo);
     saldo += valor;
     JOptionPane.showMessageDialog(null,cliente+
        "\nOperação de Deposito R$: "
        + saldo);
    }
}
