package com.mikezao.CadastroDeNinjas.Ninjas.Service;

import com.mikezao.CadastroDeNinjas.Missoes.Model.MissoesModel;
import com.mikezao.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import com.mikezao.CadastroDeNinjas.Ninjas.DTO.NinjaMapper;
import com.mikezao.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import com.mikezao.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// Anotation de service é necessaria, indicando que essa parte conterá a lógica dos endpoints
@Service
public class NinjaService {

    // Iniciando uma nova instancia do banco
    // Convenção iniciar a nova instancia em camelCase
    // Temos de fazer a injeção de dependencia para que o service tem permissão no banco
    private NinjaRepository ninjaRepository;

    // Inicializando mapper
    private NinjaMapper ninjaMapper;

    // A anotation @AutoWired tem a mesma funçao de inicializar um construtor
    // mas o mais usual é inicializar a injecao de depndencia simplesmente fazendo o construtor normalmente
    // Com isso finalmente o ninja service tera acesso ao banco
    // Criando outro construtor (overload) com mapper
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os ninjas
    // Queremos que ele serialize e coloque os ninjas em uma lista
    // Pegamos o metodo do findall porque extendemos o JpaRepository
    public List<NinjaModel> listarNinja(){
        return ninjaRepository.findAll();
    }

    // Criar um ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Listar ninjas por ID
    public NinjaModel listarNinjasPorId(long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Deletar ninja, tem que ser um void
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
