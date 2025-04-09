package com.mikezao.CadastroDeNinjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    // Adicionar missao (create)
    @PostMapping("/criar")
    public String criarMissoes(){
        return "Missao criada com sucesso!";
    }

    // Procurar todas os missoes (read)
    @GetMapping("/listar")
    public String mostrarMissoes(){
        return "Lista de missoes";
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
