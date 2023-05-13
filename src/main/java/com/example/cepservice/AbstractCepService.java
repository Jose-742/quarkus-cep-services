package com.example.cepservice;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.example.model.Endereco;

import java.util.Objects;
import java.util.logging.Logger;

public abstract class AbstractCepService implements CepService {
    private final static Logger LOGGER = Logger.getLogger(CepService.class.getSimpleName());

    private final WebTarget target;

    private final String dominio;

  
    protected AbstractCepService(final String dominio) {
        this.dominio = insertTrailingSlash(Objects.requireNonNull(dominio));

        final Client client = ClientBuilder.newClient();
        this.target = client.target(dominio);
    }

    private String insertTrailingSlash(final String url) {
        return url.endsWith("/") ? url : url + "/";
    }

    @Override
    public Endereco buscaEndereco(final String cep) {
        Objects.requireNonNull(cep, "CEP não pode ser nulo");
        LOGGER.info("Enviando requisição para " + getFullPath(cep));

        return target.path(buildPath(cep)).request().get(Endereco.class);
    }

    private String getFullPath(final String cep){
        return dominio + buildPath(cep);
    }

    protected abstract String buildPath(String cep);
}
