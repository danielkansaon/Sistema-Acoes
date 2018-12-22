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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Ação")
@RestController
@RequestMapping(AcaoController.BASE_URL)
public class AcaoController {

	public static final String BASE_URL = "/api/v1/acao";
    public static int numero_maximo_acoes = 5;

    private final IAcaoService service;

    public AcaoController(IAcaoService _acaoService) {
        this.service = _acaoService;
    }

    @Api(value = "Obter todas as ações")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Acao> getAll(){
        return service.lista_todas_acoes();
    }

    @Api(value = "Criar nova ação")
    @PostMapping({"/novo/{idComprador}"})
    @ResponseStatus(HttpStatus.CREATED)
    public Acao create(@RequestBody Acao acao){
        return service.criar_acao(acao);
    }

    @Api(value = "Comprar uma ação")
    @PutMapping({"/comprar/{idComprador}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao comprarAcao(@PathVariable Long idComprador, @RequestBody Acao acao){
        return service.comprar_acao(idComprador, acao);
    }

    @Api(value = "Vender uma ação")
    @PutMapping({"/vender/{idComprador}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao venderAcao(@RequestBody Acao acao){
        return service.vender_acao((long)0, acao);
    }

    @Api(value = "Alterar número máximo de ações")
    @PutMapping({"alterar_acoes/{numAcao}"})
    @ResponseStatus(HttpStatus.OK)
    public String alterarNumAcoes(int numAcao){
        numero_maximo_acoes = numAcao;
        return "Ok";
    }
}
