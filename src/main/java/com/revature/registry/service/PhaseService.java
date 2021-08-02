package com.revature.registry.service;

import java.util.List;

import com.revature.registry.model.Phase;
import com.revature.registry.repository.PhaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhaseService {
    @Autowired
    private PhaseRepository phaseRepository;

    public List<Phase> getAllPhases() {
        return phaseRepository.findAll();
    }

    public Phase getPhaseById(int id) {
        return phaseRepository.findById(id).orElse(null);
    }
}
