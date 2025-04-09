package com.mikezao.CadastroDeNinjas.Missoes.Service;

import com.mikezao.CadastroDeNinjas.Missoes.Model.MissoesModel;
import com.mikezao.CadastroDeNinjas.Missoes.Repository.MissoesRepository;

import java.util.List;

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
}
