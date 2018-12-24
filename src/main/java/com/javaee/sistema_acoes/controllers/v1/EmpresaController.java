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

import com.javaee.sistema_acoes.domain.Empresa;
import com.javaee.sistema_acoes.services.IEmpresaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Empresa")
@RestController
@RequestMapping(AcaoController.BASE_URL)
public class EmpresaController {

	public static final String BASE_URL = "/api/v1/empresa";

    private final IEmpresaService empresaService;

    public EmpresaController(IEmpresaService _empresaService) {
        this.empresaService = _empresaService;
    }

    @ApiOperation(value = "Obter todas empresas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Empresa> getAll(){
        return empresaService.retornar_todos();
    }
    
    @ApiOperation(value = "Criar uma nova empresa")
    @PostMapping({"/criar"})
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa create(@RequestBody Empresa empresa){
       return empresaService.criar_empresa(empresa);
    }

    @ApiOperation(value = "Alterar número máximo de ações")
    @PutMapping({"alterar_acoes/{idEmpresa}/{qtdAcao}"})
    @ResponseStatus(HttpStatus.OK)
    public Empresa alterarNumAcoes(@PathVariable String idEmpresa, @PathVariable int qtdAcao){
        return empresaService.atualizarQtdAcoes(idEmpresa, qtdAcao);
    }
}


