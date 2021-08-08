package com.revature.registry.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.revature.registry.ProjectRegistryTrackingApplication;
import com.revature.registry.model.Phase;
import com.revature.registry.repository.PhaseRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = ProjectRegistryTrackingApplication.class)
@ExtendWith(SpringExtension.class)
class PhaseServiceTest {

    private Phase phase1, phase2;
    private List<Phase> phaseList;

    @Autowired
    private PhaseService phaseService;

    @MockBean
    private PhaseRepository phaseRepo;

    @BeforeEach
    public void setup() {
        phaseList = new ArrayList<>();

        phase1 = new Phase(1, "test phase kind", "test phase description", new ArrayList<>());
        phase2 = new Phase(2, "test phase kind2", "test phase description2", new ArrayList<>());
        phaseList.add(phase1);
        phaseList.add(phase2);
    }

    @Test
    void getAllPhaseTest1() {
        when(phaseRepo.findAll()).thenReturn(phaseList);
        assertEquals(2, phaseService.getAllPhases().size());
    }

    @Test
    void getPhaseByIdTest() {
        when(phaseRepo.findById(1)).thenReturn(Optional.of(phase1));
        assertEquals(phase1, phaseService.getPhaseById(1));
    }
}
