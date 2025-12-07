package com.example.demo.controller.dto;

import java.util.List;

/*
 * -- C -> Mother of All Languages
 * -- Turing Complete Language
 * -- LINGUAGEM DECLARATIVA (linguagem de pedidos)
 * CREATE TABLE users (
 *      name VARCHAR(20) NOT NULL CHECK LEN(name) >= 3 
 * )
 */

import com.example.demo.repository.entity.Island;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewIslandDTO(
    @NotNull(message = "O disposition não pode ser nulo")
    Island.Disposition disposition,
    @NotNull(message = "A descrição não pode ser nulo")
    String description,
    @NotEmpty(message = "As workstations não podem ser vazias")
    List<@Valid NewWorkstationDTO> workstations
)  {

}
