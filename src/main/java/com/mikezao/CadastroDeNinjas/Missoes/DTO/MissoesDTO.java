package com.mikezao.CadastroDeNinjas.Missoes.DTO;

import com.mikezao.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private List<NinjaModel> ninja;
    private String rank;
}
