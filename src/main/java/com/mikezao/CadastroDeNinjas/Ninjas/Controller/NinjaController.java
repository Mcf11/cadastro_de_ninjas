package com.mikezao.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninja")
public class NinjaController {

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
    @GetMapping("/todos")
    public String mostrarNinja(){
        return "Lista de ninjas";
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
