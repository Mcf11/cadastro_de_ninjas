package com.mikezao.CadastroDeNinjas.Missoes.Controller;

import com.mikezao.CadastroDeNinjas.Missoes.Model.MissoesModel;
import com.mikezao.CadastroDeNinjas.Missoes.Service.MissaoService;
import com.mikezao.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    // Adicionar missao (create)
    @PostMapping("/criar")
    public String criarMissoes(){
        return "Missao criada com sucesso!";
    }

    // Procurar todas os missoes (read)
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missaoService.listarMissoes();
    }

    // Alterar dados das missoes (update)
    @PutMapping("/alterar-missao")
    public String alterarMissao(){
        return "Missao atualizada com sucesso!";
    }

    // Deletar missao (delete)
    @DeleteMapping("/deletar-missao")
    public String deletarMissao(){
        return "Missao deletada com sucesso!";
    }
}
