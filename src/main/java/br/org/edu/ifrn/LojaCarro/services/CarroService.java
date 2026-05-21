package br.org.edu.ifrn.LojaCarro.services;

import br.org.edu.ifrn.LojaCarro.model.Carro;
import br.org.edu.ifrn.LojaCarro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    public CarroRepository carroRepository;

    public Carro save(Carro c) {
        return carroRepository.save(c);
    }

    public void deleteById(Long id) {
        carroRepository.deleteById(id);
    }

    public Optional<Carro> findById(Long id) {
        return carroRepository.findById(id);
    }

    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    // Verifica se o ID existe antes de salvar — lança exceção se não encontrar
    public Carro update(Carro c) {
        if (!carroRepository.existsById(c.getId())) {
            throw new RuntimeException("Carro não encontrado: " + c.getId());
        }
        return carroRepository.save(c);
    }
}