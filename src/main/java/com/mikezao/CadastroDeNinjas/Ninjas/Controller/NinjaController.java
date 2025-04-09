package com.mikezao.CadastroDeNinjas.Ninjas.Controller;

import com.mikezao.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import com.mikezao.CadastroDeNinjas.Ninjas.Service.NinjaService;
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
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado com sucesso!";
    }

    // Procurar todos os ninjas (read)
    // No service é list então aqui tem de ser list ja que instanciamos o objeto e chamamos o metodo
    @GetMapping("/listar")
    public List<NinjaModel> listarNinja(){
        return ninjaService.listarNinja();
    }

    // Mostrar ninja por id (read)
    @GetMapping("/buscar-id")
    public String idNinja(){
        return "Mostrando ninja por id";
    }

    // Alterar dados dos ninjas (update)
    @PutMapping("/atualizar-ninja")
    public String atualizarNinja(){
        return "Ninja atualizado com sucesso!";
    }

    // Deletar ninja (delete)
    @DeleteMapping("/deletar-ninja")
    public String deletarNinja(){
        return "Ninja deletado com sucesso!";
    }

}
