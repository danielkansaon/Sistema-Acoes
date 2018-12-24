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

    private final IAcaoService service;

    public AcaoController(IAcaoService _acaoService) {
        this.service = _acaoService;
    }

    @ApiOperation(value = "Obter todas as ações de empresas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Acao> getAll(){
        return service.lista_todas_acoes();
    }

    @ApiOperation(value = "Criar nova ação")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Acao create(@RequestBody Acao acao){
        return service.criar_acao(acao);
    }

    @ApiOperation(value = "Comprar uma ação")
    @PutMapping({"/comprar/{idAcao}/{idNovoComprador}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao comprarAcao(@PathVariable String idAcao, @PathVariable String idNovoComprador){
        return service.comprar_acao(idAcao, idNovoComprador);
    }

    @ApiOperation(value = "Vender uma ação")
    @PutMapping({"/vender/{idAcao}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao venderAcao(@PathVariable String idAcao){
        return service.vender_acao(idAcao);
    }    
}
