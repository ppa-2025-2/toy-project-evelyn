package com.example.demo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.domain.IslandBusiness;
import com.example.demo.repository.entity.Workstation;

public class IslandApplication {
    @Autowired
    private IslandBusiness island;

    @Transactional
    public Workstation alocarWorkstationDisponivel(Long islandId, int userId) {

        Workstation workstationAlocada = island.alocarWorkstationDisponivel(userId);

        return workstationAlocada;

    }
}