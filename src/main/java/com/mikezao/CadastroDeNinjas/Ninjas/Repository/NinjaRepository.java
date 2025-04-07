package com.mikezao.CadastroDeNinjas.Ninjas.Repository;

import com.mikezao.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
