package com.mikezao.CadastroDeNinjas.Missoes.Service;

import com.mikezao.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import com.mikezao.CadastroDeNinjas.Missoes.DTO.MissoesMapper;
import com.mikezao.CadastroDeNinjas.Missoes.Model.MissoesModel;
import com.mikezao.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import com.mikezao.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    // Instanciando o repositorio com metodos do jpa
    // Injetando dependencia para dar acesso ao banco para o service
    private MissoesRepository missoesRepository;

    // Mapper
    private MissoesMapper missoesMapper;

    // Construtor precisa ser atualizado quando incluido o mapper
    public MissaoService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }

    // Adicionar metodo para listar missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // Metodo para listar missoes por id para validação
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    // Criar missoes
    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    // Deletar missoes
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    // Atualizar missoes
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

}
