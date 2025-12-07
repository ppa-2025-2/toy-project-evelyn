package com.example.demo.controller.dto;

import jakarta.validation.constraints.NotNull;

public record NewAllocateWorkstationDTO(
    @NotNull(message = "O userId não pode ser nulo")
    int userId
) {
}
