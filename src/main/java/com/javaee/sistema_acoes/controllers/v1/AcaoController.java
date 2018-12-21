package com.javaee.sistema_acoes.controllers.v1;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.sistema_acoes.domain.Acao;
import com.javaee.sistema_acoes.services.IAcaoService;

@RestController
@RequestMapping(AcaoController.BASE_URL)
public class AcaoController {

	public static final String BASE_URL = "/api/v1/acao";
    public static int numero_maximo_acoes = 5;

    private final IAcaoService service;

    public AcaoController(IAcaoService _acaoService) {
        this.service = _acaoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Acao> getAll(){
        return service.lista_todas_acoes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Acao create(@RequestBody Acao acao){
        return service.criar_acao(acao);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao comprarAcao(@PathVariable Long id_novo_cliente, @RequestBody Acao acao){
        return service.comprar_acao(id_novo_cliente, acao);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao venderAcao(@PathVariable Long id_novo_cliente, @RequestBody Acao acao){
        return service.vender_acao(id_novo_cliente, acao);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public String alterarNumAcoes(int id){
        numero_maximo_acoes = id;
        return "Ok";
    }
}
