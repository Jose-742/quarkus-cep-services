package com.example.cepservice;

public final class PostmonService extends AbstractCepService {
    private static final String DOMINIO = "https://api.postmon.com.br/";

    public PostmonService(){
        super(DOMINIO);
    }

    @Override
    protected String buildPath(final String cep) {
        return "v1/cep/" + cep;
    }
}
