package com.example.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record NewWorkstationDTO(
    @NotBlank
    String specs
) {
}
