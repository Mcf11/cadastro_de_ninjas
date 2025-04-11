package com.mikezao.CadastroDeNinjas.Ninjas.Controller;

import com.mikezao.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import com.mikezao.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import com.mikezao.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    // Instancia do ninja service para podermos usar os metodos do JPA
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/hello")
    public String boasVindas(){
        return "Hello World!";
    }

    // Adicionar ninja (create)
    // Envia no corpo da requisiçao o objeto ninja
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + novoNinja.getNome() + ", id: " + novoNinja.getId());
    }

    // Procurar todos os ninjas (read)
    // No service é list então aqui tem de ser list ja que instanciamos o objeto e chamamos o metodo
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinja(){
        List<NinjaDTO> ninjas = ninjaService.listarNinja();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por id (read)
    // Passamos um generic pois devolveremos diferentes tipos na resposta
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if(ninja != null){
            return ResponseEntity.ok("Ninja encontrado:\n" + ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + ninja.getId() + " não encontrado nos registros");
        }
    }

    // Alterar dados dos ninjas (update)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não encontrado");
        }
    }

    // Deletar ninja (delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if (ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja id: " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não encontrado");
        }
    }

}
