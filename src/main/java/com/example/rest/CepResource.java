package com.example.rest;

import com.example.cepservice.CepService;
import com.example.model.Endereco;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/endereco")
@RequestScoped
public class CepResource {

    @Inject
    CepService cepService;

    @GET
    @Path("{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco endereco(@PathParam("cep") final String cep) {
        return cepService.buscaEndereco(cep);
    }
}
