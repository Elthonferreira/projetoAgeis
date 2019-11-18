package com.example.saude.services;

import com.example.saude.models.Especialidade;
import com.example.saude.repositories.EspecialidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public Especialidade save(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public List<Especialidade> getAll() {
        return especialidadeRepository.findAll();
    }
    
    public Especialidade getById(Long id) {return especialidadeRepository.findById(id);}

    public Especialidade update(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public void delete(Especialidade especialidade) {
        especialidadeRepository.delete(especialidade);
    }
}
