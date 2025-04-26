package br.com.fabioalvesbene.consultacep.app;

import br.com.fabioalvesbene.consultacep.model.Endereco;
import br.com.fabioalvesbene.consultacep.service.ConsultaCep;
import br.com.fabioalvesbene.consultacep.util.GeradorDeArquivo;

import javax.swing.*;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {

        ConsultaCep consultaCep = new ConsultaCep();
        String cepDigitado = JOptionPane.showInputDialog("Informe o cep para consulta");

        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cepDigitado);

            // Monta a mensagem usando o record
            String mensagem = "Endereço encontrado:\n" +
                    "CEP: " + novoEndereco.cep() + "\n" +
                    "Logradouro: " + novoEndereco.logradouro() + "\n" +
                    "Cidade: " + novoEndereco.localidade() + "\n" +
                    "Estado: " + novoEndereco.uf();

            JOptionPane.showMessageDialog(null, mensagem);

            //System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.gravaJson(novoEndereco);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}
