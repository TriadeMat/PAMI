/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.Matheus.contateste;

import javax.swing.JOptionPane;

/**
 *
 * @author android
 */
public class ContaTeste {

    public static void main(String[] args) {
        Conta conta = new Conta();

        String cli = JOptionPane.showInputDialog("Qual o nome do cliente? ");
        conta.setCliente(cli);
        String saldo = JOptionPane.showInputDialog("Qual o saldo?");
        double d = Double.parseDouble(saldo);
        conta.setSaldo(d);
        
        conta.exibirSaldo();
        
        Conta conta2 = new Conta();

        

    }

}
