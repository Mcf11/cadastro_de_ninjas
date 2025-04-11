package com.mikezao.CadastroDeNinjas.Missoes.DTO;

import com.mikezao.CadastroDeNinjas.Missoes.Model.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setNinja(missoesDTO.getNinja());
        missoesModel.setRank(missoesDTO.getRank());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setNinja(missoesModel.getNinja());
        missoesDTO.setRank(missoesModel.getRank());

        return missoesDTO;
    }
}
