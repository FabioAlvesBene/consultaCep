package br.com.fabioalvesbene.consultacep.app;

import br.com.fabioalvesbene.consultacep.model.Endereco;
import br.com.fabioalvesbene.consultacep.util.MensagemEndereco;
import br.com.fabioalvesbene.consultacep.service.ConsultaCep;
import br.com.fabioalvesbene.consultacep.util.GeradorDeArquivo;

import javax.swing.*;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {

        ConsultaCep consultaCep = new ConsultaCep();
        String cepDigitado = JOptionPane.showInputDialog("Informe o cep para consulta");

        try {
            // Consulta o CEP digitado e retorna o endereço correspondente
            Endereco novoEndereco = consultaCep.buscaEndereco(cepDigitado);

            String mensagem = MensagemEndereco.formatar(novoEndereco);
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
