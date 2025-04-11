package com.mikezao.CadastroDeNinjas.Ninjas.Controller;

import com.mikezao.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import com.mikezao.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import com.mikezao.CadastroDeNinjas.Ninjas.Service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Imprime mensagem de boas vindas", description = "Rota que devolve a mensagem de hello world quando acessada")
    public String boasVindas(){
        return "Hello World!";
    }

    // Adicionar ninja (create)
    // Envia no corpo da requisiçao o objeto ninja
    @PostMapping("/criar")
    @Operation(summary = "Cria novo ninja", description = "Rota para criação de um novo ninja e insere no banco de dados in memory salvo localmente")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + novoNinja.getNome() + ", id: " + novoNinja.getId());
    }

    // Procurar todos os ninjas (read)
    // No service é list então aqui tem de ser list ja que instanciamos o objeto e chamamos o metodo
    @GetMapping("/listar")
    @Operation(summary = "Lista ninjas", description = "Lista todos os ninjas cadastrados no banco de dados")
    public ResponseEntity<List<NinjaDTO>> listarNinja(){
        List<NinjaDTO> ninjas = ninjaService.listarNinja();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por id (read)
    // Passamos um generic pois devolveremos diferentes tipos na resposta
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista ninjas baseado no ID fornecido", description = "Busca ninjas com ID fornecido no banco de dados in memory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id do ninja fornecido não encontrado no banco de dados")
    })
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
    @Operation(summary = "Atualiza informações do ninja", description = "Altera ninja com id fornecido no path url e descrição no corpo da requisição")
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
    @Operation(summary = "Deleta ninja", description = "Deleta ninja baseado no id fornecido")
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
