package br.com.fiap.moop.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.moop.DTO.GalpaoDTO;
import br.com.fiap.moop.DTO.MotoDTO;
import br.com.fiap.moop.model.Galpao;
import br.com.fiap.moop.model.Moto;
import br.com.fiap.moop.repository.GalpaoRepository;

@Service
public class GalpaoService {

    @Autowired
    private GalpaoRepository galpaoRepository;

    // ---------- CRUD Básico ----------
    public Galpao save(Galpao galpao) {
        return galpaoRepository.save(galpao);
    }

    public Page<GalpaoDTO> findAll(Pageable pageable) {
        return galpaoRepository.findAll(pageable).map(this::convertToDTO);
    }

    @Cacheable("galpoes")
    public Page<GalpaoDTO> findByLocalizacao(String localizacao, Pageable pageable) {
        return galpaoRepository.findByLocalizacaoContaining(localizacao, pageable)
                .map(this::convertToDTO);
    }

    public Optional<Galpao> findById(Long id) {
        return galpaoRepository.findById(id);
    }

    public Galpao update(Long id, Galpao galpaoDetalhes) {
        Galpao galpaoExistente = galpaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Galpão não encontrado"));

        galpaoExistente.setNome(galpaoDetalhes.getNome());
        galpaoExistente.setLocalizacao(galpaoDetalhes.getLocalizacao());
        galpaoExistente.setCapacidade(galpaoDetalhes.getCapacidade());
        galpaoExistente.setMotosOcupadas(galpaoDetalhes.getMotosOcupadas());

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

    // ---------- Salvar ou atualizar via DTO ----------
    public GalpaoDTO saveFromDTO(GalpaoDTO dto) {
        Galpao galpao;

        if (dto.getId() != null) {
            galpao = galpaoRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Galpão não encontrado"));
        } else {
            galpao = new Galpao();
        }

        galpao.setNome(dto.getNome());
        galpao.setLocalizacao(dto.getLocalizacao());
        galpao.setCapacidade(dto.getCapacidade());
        galpao.setMotosOcupadas(dto.getMotosOcupadas());

        Galpao saved = galpaoRepository.save(galpao);
        return convertToDTO(saved);
    }

    // ---------- Converter Galpao para GalpaoDTO ----------
    private GalpaoDTO convertToDTO(Galpao galpao) {
        GalpaoDTO dto = new GalpaoDTO();
        dto.setId(galpao.getId());
        dto.setNome(galpao.getNome());
        dto.setLocalizacao(galpao.getLocalizacao());
        dto.setCapacidade(galpao.getCapacidade());

        // Calcula motos ocupadas
        dto.setMotosOcupadas(galpao.getMotos() != null ? galpao.getMotos().size() : 0);

        // Lista de motos -> converte para MotoDTO
        if (galpao.getMotos() != null) {
        	dto.setMotos(
        		    galpao.getMotos()
        		          .stream()
        		          .map(this::convertMotoToDTO)
        		          .collect(Collectors.toList())
        		);
        }

        return dto;
    }

    // ---------- Converter Moto para MotoDTO ----------
    private MotoDTO convertMotoToDTO(Moto moto) {
        MotoDTO dto = new MotoDTO();
        dto.setId(moto.getId());
        dto.setPlaca(moto.getPlaca());
        dto.setChassi(moto.getChassi());

        if (moto.getModelo() != null) {
            dto.setModelo(moto.getModelo().getDescricao());
        }
        if (moto.getStatus() != null) {
            dto.setStatus(moto.getStatus().getDescricao());
        }
        return dto;
    }

    public void deletarPorId(Long id) {
        galpaoRepository.deleteById(id);
    }
    
}