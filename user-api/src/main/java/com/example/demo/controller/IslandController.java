package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.NewAllocateWorkstationDTO;
import com.example.demo.controller.dto.NewIslandDTO;
import com.example.demo.domain.IslandService;
import com.example.demo.repository.IslandRepository;
import com.example.demo.repository.entity.Island;

@RestController
@RequestMapping("/api/v1/islands")
public class IslandController {

    private IslandRepository islandRepository;
    private IslandService islandService;

    public IslandController(
            IslandRepository islandRepository,
            IslandService islandService) {
        this.islandRepository = islandRepository;
        this.islandService = islandService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Island>> getIslands() {
        return ResponseEntity.ok(islandRepository.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void newIsland(@RequestBody NewIslandDTO dto) {
        islandService.createIsland(dto);
    }

    @PatchMapping(path = "/allocate", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void AlocarWorkstation(@RequestBody NewAllocateWorkstationDTO dto) {
        islandService.alocarWorkstationDisponivel(dto.userId());
    }
}
