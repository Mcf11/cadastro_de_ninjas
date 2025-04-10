package com.mikezao.CadastroDeNinjas.Ninjas.Repository;

import com.mikezao.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import com.mikezao.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

// O Jpa já contem diversos metodos para interacao com banco de dados

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
