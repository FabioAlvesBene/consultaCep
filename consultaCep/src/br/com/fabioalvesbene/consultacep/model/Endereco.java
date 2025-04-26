package br.com.fabioalvesbene.consultacep.model;

public record Endereco(String cep, String logradouro, String complemento,
                       String localidade, String uf) {
}
