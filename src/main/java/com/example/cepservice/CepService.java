package com.example.cepservice;

import com.example.model.Endereco;

public interface CepService {

    Endereco buscaEndereco(String cep);
}
