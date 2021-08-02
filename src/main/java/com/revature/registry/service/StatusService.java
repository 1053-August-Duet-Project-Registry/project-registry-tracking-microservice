package com.revature.registry.service;

import java.util.List;

import com.revature.registry.model.Status;
import com.revature.registry.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Status getStatusById(int id) {
        return statusRepository.findById(id).orElse(null);
    }
}
