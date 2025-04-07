package com.mikezao.CadastroDeNinjas.Missoes.Repository;

import com.mikezao.CadastroDeNinjas.Missoes.Model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
