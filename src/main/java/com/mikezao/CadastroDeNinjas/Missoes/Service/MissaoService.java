package com.mikezao.CadastroDeNinjas.Missoes.Service;

import com.mikezao.CadastroDeNinjas.Missoes.Model.MissoesModel;
import com.mikezao.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    // Instanciando o repositorio com metodos do jpa
    // Injetando dependencia para dar acesso ao banco para o service
    private MissoesRepository missoesRepository;

    public MissaoService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Adicionar metodo para listar missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // Criar missoes
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }
}
