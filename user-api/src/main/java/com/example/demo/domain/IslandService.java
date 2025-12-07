package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.controller.dto.NewIslandDTO;
import com.example.demo.domain.exceptions.NotFoundException;
import com.example.demo.repository.IslandRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.Island;
import com.example.demo.repository.entity.Workstation;

import jakarta.validation.Valid;

@Service
@Validated
public class IslandService {

    private final IslandRepository islandRepository;
    private final UserRepository userRepository;

    public IslandService(
        IslandRepository islandRepository,
        UserRepository userRepository
    ) {
        this.islandRepository = islandRepository;
        this.userRepository = userRepository;
    }

    public void createIsland(@Valid NewIslandDTO dto) {
        LocalDateTime now = LocalDateTime.now();
        Island island = new Island();
        island.setCreatedAt(now);
        island.setUpdatedAt(now);

        Set<Workstation> workstations = new HashSet<>();
        dto.workstations().forEach(wsDto -> {
            Workstation ws = new Workstation();
            ws.setId(UUID.randomUUID().toString().substring(0, 8));
            ws.setSpecs(wsDto.specs());
            ws.setIsland(island);
            ws.setCreatedAt(now);
            ws.setUpdatedAt(now);
            workstations.add(ws);
        });

        island.setDisposition(dto.disposition());
        island.setDescription(dto.description());
        island.setWorkstations(workstations);
        islandRepository.save(island);
    }

    // Application Service, interface entre o serviço e o domínio
    // Domain Service, ele é o próprio domínio
    public void alocarWorkstationDisponivel(@NonNull Integer userId) {

        final var user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException());

        // POO: agregação vs composição (aggregation vs composition)
        final var islands = islandRepository.findIslandWithAvailableWorkstations();

        if (islands.isEmpty()) {
            throw new IllegalStateException("Workstations not available");
        }

        // island 0 square 2/4
        // island 1 triangular 2/3
        // island 3 rectangular 1/6

        // busca ilhas começando por uma ws livre, depois duas, ...
        Island freeIsland = islands.getFirst();
        for (int slots = 1; slots < Island.Disposition.CIRCULAR.getPlacements(); slots++) {
            final int positions = slots;
            var possibleIsland = islands.stream()
                    .filter(i -> i.getWorkstations().stream()
                            .map(Workstation::getUser)
                            .filter(Objects::nonNull)
                            .count() == positions)
                    .findFirst();
            if (possibleIsland.isPresent()) {
                freeIsland = possibleIsland.get();
                break;
            }
        }

        // primeira workstation livre e seta o usuário
        freeIsland.getWorkstations().stream()
                .filter(ws -> ws.getUser() == null)
                .findFirst()
                .ifPresent(ws -> ws.setUser(user));

        islandRepository.save(freeIsland);
    }
}
