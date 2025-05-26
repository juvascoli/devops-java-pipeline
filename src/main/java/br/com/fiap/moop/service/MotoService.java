package br.com.fiap.moop.service;

import br.com.fiap.moop.model.Moto;
import br.com.fiap.moop.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public Moto save(Moto moto) {
        return motoRepository.save(moto);
    }

    public List<Moto> findAll() {
        return motoRepository.findAll();
    }

    public Optional<Moto> findById(Long id) {
        return motoRepository.findById(id);
    }

    public List<Moto> findByPlaca(String placa) {
        return motoRepository.findByPlacaContaining(placa);
    }

    public Moto update(Long id, Moto motoDetalhes) {
        if (motoRepository.existsById(id)) {
            Moto motoExistente = motoRepository.findById(id).get();
            motoExistente.setPlaca(motoDetalhes.getPlaca());
            motoExistente.setChassi(motoDetalhes.getChassi());
            motoExistente.setModelo(motoDetalhes.getModelo());
            motoExistente.setStatus(motoDetalhes.getStatus());
            motoRepository.save(motoExistente);
        } else {
            throw new RuntimeException("Moto não encontrada");
        }
        return motoDetalhes;
    }

    public void delete(Long id) {
        if (motoRepository.existsById(id)) {
            motoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Moto não encontrada");
        }
    }
}