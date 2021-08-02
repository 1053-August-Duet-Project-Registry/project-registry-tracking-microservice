package com.revature.registry.service;

import java.util.List;
import java.util.Optional;

import com.revature.registry.model.Iteration;
import com.revature.registry.repository.IterationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IterationService {
    @Autowired
    private IterationRepository iterationRepository;

    public List<Iteration> getAllIterations() {
        return iterationRepository.findAll();
    }

    public Iteration getIterationById(int id) {
        return iterationRepository.findById(id).orElse(null);
    }

    public Iteration createIteration(Iteration iteration) {
        return iterationRepository.save(iteration);
    }

    public Iteration updateIterationById(int id, Iteration newIteration) {
        Optional<Iteration> iteration = iterationRepository.findById(id);
        if (iteration.isPresent()) {
            newIteration.setId(id);
            Iteration saved = iterationRepository.save(newIteration);
            return saved;
        }

        return null;
    }

    public boolean deleteIterationById(int id) {
        Optional<Iteration> iteration = iterationRepository.findById(id);
        if (iteration.isPresent()) {
            iterationRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
