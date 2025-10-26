package com.example.demo.controller.dto;

/*
 * -- C -> Mother of All Languages
 * -- Turing Complete Language
 * -- LINGUAGEM DECLARATIVA (linguagem de pedidos)
 * CREATE TABLE users (
 *      name VARCHAR(20) NOT NULL CHECK LEN(name) >= 3 
 * )
 */

import jakarta.validation.constraints.NotBlank;

public record UpdateTicketDTO(
        @NotBlank(message = "O status é obrigatório")
        String status
)  {

}
