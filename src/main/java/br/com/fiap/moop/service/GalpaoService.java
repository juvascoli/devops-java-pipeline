package br.com.fiap.moop.service;

import br.com.fiap.moop.DTO.GalpaoDTO;
import br.com.fiap.moop.model.Galpao;
import br.com.fiap.moop.repository.GalpaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GalpaoService {

    @Autowired
    private GalpaoRepository galpaoRepository;

    // ---------- API REST ----------
    public Galpao save(Galpao galpao) {
        return galpaoRepository.save(galpao);
    }

    public Page<GalpaoDTO> findAll(Pageable pageable) {
        return galpaoRepository.findAll(pageable).map(this::convertToDTO);
    }

    @Cacheable("galpoes")
    public Page<GalpaoDTO> findByLocalizacao(String localizacao, Pageable pageable) {
        return galpaoRepository.findByLocalizacaoContaining(localizacao, pageable).map(this::convertToDTO);
    }

    public Optional<Galpao> findById(Long id) {
        return galpaoRepository.findById(id);
    }

    public Galpao update(Long id, Galpao galpaoDetalhes) {
        Galpao galpaoExistente = galpaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Galpão não encontrado"));

        galpaoExistente.setLocalizacao(galpaoDetalhes.getLocalizacao());
        galpaoExistente.setCapacidade(galpaoDetalhes.getCapacidade());

        return galpaoRepository.save(galpaoExistente);
    }

    public void delete(Long id) {
        if (galpaoRepository.existsById(id)) {
            galpaoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Galpão não encontrado");
        }
    }


    public List<GalpaoDTO> listarTodos() {
        return galpaoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<GalpaoDTO> buscarPorId(Long id) {
        return galpaoRepository.findById(id).map(this::convertToDTO);
    }

    public GalpaoDTO saveFromDTO(GalpaoDTO dto) {
        Galpao galpao = new Galpao();
        galpao.setLocalizacao(dto.getLocalizacao());
        galpao.setCapacidade(dto.getCapacidade());
        Galpao saved = galpaoRepository.save(galpao);
        return convertToDTO(saved);
    }


    private GalpaoDTO convertToDTO(Galpao galpao) {
        GalpaoDTO dto = new GalpaoDTO();
        dto.setId(galpao.getId());
        dto.setLocalizacao(galpao.getLocalizacao());
        dto.setCapacidade(galpao.getCapacidade());
        return dto;
    }


}
