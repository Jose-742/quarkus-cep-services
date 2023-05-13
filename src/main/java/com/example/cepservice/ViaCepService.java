package com.example.cepservice;

import javax.enterprise.context.Dependent;


@Dependent
public final class ViaCepService extends AbstractCepService {
    private static final String DOMINIO = "https://viacep.com.br/";

    public ViaCepService(){
        super(DOMINIO);
    }

    @Override
    protected String buildPath(final String cep) {
        return "ws/" + cep + "/json";
    }
}
