package com.mikezao.CadastroDeNinjas.Missoes.Controller;

import com.mikezao.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import com.mikezao.CadastroDeNinjas.Missoes.Model.MissoesModel;
import com.mikezao.CadastroDeNinjas.Missoes.Service.MissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO novaMissao = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão " + novaMissao.getNome() + ", id " + novaMissao.getId() + " inserida com sucesso");
    }

    // Procurar todas os missoes (read)
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missaoService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    // Alterar dados das missoes (update)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missao = missaoService.atualizarMissao(id, missaoAtualizada);
        if(missao != null){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o id " + id + " não encontrada");
        }
    }

    // Deletar missao (delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missaoService.listarMissoesPorId(id) != null){
            missaoService.deletarMissao(id);
            return ResponseEntity.ok("Missão com o id: " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não encontrada");
        }
    }
}
