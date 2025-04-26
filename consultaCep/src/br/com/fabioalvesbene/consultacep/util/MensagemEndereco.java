package br.com.fabioalvesbene.consultacep.util;

import br.com.fabioalvesbene.consultacep.model.Endereco;

public class MensagemEndereco {
    public static String formatar(Endereco endereco) {
        return "Endereço encontrado:\n" +
                "CEP: " + endereco.cep() + "\n" +
                "Logradouro: " + endereco.logradouro() + "\n" +
                "Bairro: " + endereco.bairro() + "\n" +
                "Cidade: " + endereco.localidade() + "\n" +
                "Estado: " + endereco.uf();
    }
}
